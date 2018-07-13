package com.kalah.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

public class PitTest {

	Pit fixture = new Pit();

	@Test
	public void testInitialNumberOfStones() {
		assertEquals(0, fixture.getNumberOfStones());
	}

	@Test
	public void testAddStone() {
		fixture.addStone();
		assertEquals("number of stones do not match after adding", 1, fixture.getNumberOfStones());
	}
	
	@Test
	public void testRemoveStone() {
		fixture.removeStone();
		assertEquals("number of stones do not match after adding", -1, fixture.getNumberOfStones());
	}

	@Test
	public void testSelectPit() {
		fixture.emptyPit();
		assertEquals("number of stones do not match after removing", 0, fixture.getNumberOfStones());
	}

	@Test
	public void testIsEmpty() {
		fixture.emptyPit();
		assertTrue(fixture.isEmpty());
	}

}
