package com.kalah.pojos;

public class Pit {

	private boolean selected;

	private int pitNumber;

	private int numberOfStones;

	public int getPitNumber() {
		return pitNumber;
	}

	public void setPitNumber(final int pitNumber) {
		this.pitNumber = pitNumber;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	public int getNumberOfStones() {
		return numberOfStones;
	}
	
	public void setNumberOfStones(final int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}

	public void addStone() {
		numberOfStones++;
	}

	public void removeStone() {
		numberOfStones--;
	}

	public void emptyPit() {
		numberOfStones = 0;
	}

	public boolean isEmpty() {
		if (numberOfStones > 0)
			return false;
		return true;
	}

}
