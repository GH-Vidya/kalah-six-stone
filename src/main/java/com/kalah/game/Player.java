package com.kalah.game;

import java.util.ArrayList;
import java.util.List;

import com.kalah.pojos.Pit;
import com.kalah.utils.GameConstants;
import com.kalah.utils.GameStatus;

public class Player {

	final int HOUSE = GameConstants.GAME_LEVEL + 1;

	private String color;

	private List<Pit> pits = new ArrayList<>();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Pit> getPits() {
		return this.pits;
	}

	public void setPits(final List<Pit> pits) {
		this.pits = pits;
	}

	public void setSelectedPit(int selectedPitNumber) {
		for (Pit pit : pits) {
			if (pit.getPitNumber() == selectedPitNumber)
				pit.setSelected(true);
		}
	}

	public Pit getPit(int pitNumber) {
		for (Pit pit : pits) {
			if (pit.getPitNumber() == pitNumber)
				return pit;
		}
		return null;
	}

	public int getOppositePit(int pitNumber) {
		return GameConstants.GAME_LEVEL - (pitNumber - 1);
	}

	public Player(String color) {
		this.color = color;
		Pit house = new Pit();
		house.setPitNumber(HOUSE);
		house.setNumberOfStones(0);
		pits.add(house);
		for (int i = 1; i <= GameConstants.GAME_LEVEL; i++) {
			Pit p = new Pit();
			p.setPitNumber(i);
			p.setNumberOfStones(GameConstants.GAME_LEVEL);
			pits.add(p);
		}
	}

	public GameStatus playMove(Player opponent) {

		// get stones count
		Pit selectedPit = getSelectedPit();

		if (selectedPit != null) {
			int stoneCount = selectedPit.getNumberOfStones();

			System.out.println("Initial Stone Count : " + stoneCount);

			if (stoneCount == 0)
				return GameStatus.EMPTY_PIT;

			if (selectedPit.getPitNumber() == HOUSE)
				return GameStatus.HOUSE_SELECTED;

			// make selected pit stone count 0
			selectedPit.emptyPit();

			int pitNumber = selectedPit.getPitNumber() + 1;

			// distribute to own pits
			while (stoneCount > 0) {
				while (stoneCount > 0 && pitNumber <= HOUSE) {
					Pit pit = getPit(pitNumber);

					if (stoneCount == 1 && pitNumber == HOUSE) {
						// handle last stone in Kalah
						this.addStone(pitNumber);
						return GameStatus.PLAY_AGAIN;
					} else if (stoneCount == 1 && pitNumber != HOUSE && pit.getNumberOfStones() == 0) {
						// handle last stone in empty pit
						this.addStone(HOUSE);
						int oppositePitNumber = getOppositePit(pitNumber);
						Pit oppositePit = opponent.getPit(oppositePitNumber);
						int oppositeNumberOfStone = oppositePit.getNumberOfStones();
						for (int i = 0; i < oppositeNumberOfStone; i++)
							this.addStone(HOUSE);
						oppositePit.setNumberOfStones(0);
					} else {
						this.addStone(pitNumber);
					}

					stoneCount--;
					pitNumber++;
				}

				// distribute to opponent pits
				pitNumber = 1;
				while (stoneCount > 0 && pitNumber <= HOUSE) {
					opponent.addStone(pitNumber);
					stoneCount--;
					pitNumber++;

					// Do not add to opponents house. Skip this one
					if (pitNumber == HOUSE)
						pitNumber++;
				}

				pitNumber = 1;
			}
		}

		if (isGameOver())
			return GameStatus.GAME_OVER;

		return GameStatus.NEXT_PLAYER;
	}

	private void addStone(int pitNumber) {
		for (Pit pit : pits) {
			if (pit.getPitNumber() == pitNumber)
				pit.addStone();
		}
	}

	private boolean isGameOver() {
		boolean gameOver = true;
		for (Pit pit : pits) {
			if (pit.getPitNumber() != HOUSE && pit.getNumberOfStones() > 0)
				gameOver = false;
		}
		return gameOver;
	}

	private Pit getSelectedPit() {
		for (Pit pit : pits) {
			if (pit.isSelected()) {
				pit.setSelected(false);
				return pit;
			}
		}
		return null;
	}

	public int getFinalScore() {
		int finalScore = 0;
		for (Pit pit : pits) {
			finalScore += pit.getNumberOfStones();
		}
		return finalScore;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Pit pit : pits) {
			sb.append(pit.getNumberOfStones() + ", ");
		}

		return sb.toString();
	}

}
