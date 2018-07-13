package com.kalah.game;

import com.kalah.utils.GameStatus;

public class Game {

	private Player blue;
	private Player orange;
	private int scoreBlue = 0;
	private int scoreOrange = 0;
	private Player winner = null;

	public Player getBlue() {
		return blue;
	}

	public void setBlue(Player blue) {
		this.blue = blue;
	}

	public Player getOrange() {
		return orange;
	}

	public void setOrange(Player orange) {
		this.orange = orange;
	}

	public int getScoreBlue() {
		return scoreBlue;
	}

	public void setScoreBlue(int scoreBlue) {
		this.scoreBlue = scoreBlue;
	}

	public int getScoreOrange() {
		return scoreOrange;
	}

	public void setScoreOrange(int scoreOrange) {
		this.scoreOrange = scoreOrange;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public void init() {
		this.blue = new Player("blue");
		this.orange = new Player("orange");
		this.scoreBlue = 0;
		this.scoreOrange = 0;
		this.winner = null;
	}

	public void buttonClicked() {
		System.out.println("button clicked");
	}

	public GameStatus playMove(String color, int pitNumber) {
		if (color.equals("blue")) {
			this.blue.setSelectedPit(pitNumber);
			return this.blue.playMove(orange);
		} else {
			this.orange.playMove(blue);
			this.orange.setSelectedPit(pitNumber);
			return this.orange.playMove(blue);
		}
	}

	public void calcuateFinalScore() {
		this.scoreBlue = this.blue.getFinalScore();
		this.scoreOrange = this.orange.getFinalScore();
		if (this.scoreBlue > this.scoreOrange)
			this.winner = this.blue;
		else
			this.winner = this.orange;
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.init();
		g.playMove("blue", 2);
	}

}
