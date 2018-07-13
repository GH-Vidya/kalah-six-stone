package com.kalah.game;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.kalah.pojos.Pit;
import com.kalah.utils.GameStatus;

public class PlayerTest {

	Player fixture = new Player("blue");
	Player opponent = new Player("orange");

	@Test
	public void testInitialization() {
		List<Pit> pits = fixture.getPits();
		int total = 0;
		for (Pit pit : pits) {
			total += pit.getNumberOfStones();
		}
		assertEquals("total number of stones are not correct", 36, total);
	}
	
	@Test
	public void testGetOppositePit() {
		int oppositePitNumber = fixture.getOppositePit(1);
		assertEquals("oppositePitNumber not correct", 6, oppositePitNumber);

		oppositePitNumber = fixture.getOppositePit(2);
		assertEquals("oppositePitNumber not correct", 5, oppositePitNumber);

		oppositePitNumber = fixture.getOppositePit(3);
		assertEquals("oppositePitNumber not correct", 4, oppositePitNumber);

		oppositePitNumber = fixture.getOppositePit(4);
		assertEquals("oppositePitNumber not correct", 3, oppositePitNumber);

		oppositePitNumber = fixture.getOppositePit(5);
		assertEquals("oppositePitNumber not correct", 2, oppositePitNumber);

		oppositePitNumber = fixture.getOppositePit(6);
		assertEquals("oppositePitNumber not correct", 1, oppositePitNumber);
	}
	
	@Test
	public void testPlayMoveLastStoneInHouse() {
		fixture.setSelectedPit(1);
		GameStatus status = fixture.playMove(opponent);
		assertEquals("move with last stone in house not working", GameStatus.PLAY_AGAIN, status);
	}
	
	@Test
	public void testPlayMoveEmptyPitSelected() {
		fixture.setSelectedPit(1);
		GameStatus status = fixture.playMove(opponent);
		fixture.setSelectedPit(1);
		status = fixture.playMove(opponent);
		assertEquals("move with last stone in house not working", GameStatus.EMPTY_PIT, status);
	}
	
	@Test
	public void testPlayMoveNextPlayer() {
		fixture.setSelectedPit(2);
		GameStatus status = fixture.playMove(opponent);
		assertEquals("move with last stone in house not working", GameStatus.NEXT_PLAYER, status);
	}
}
