package br.ufrn.realtime.elevator.model;

public class Destination {

	private int elevator;
	private int floor;
	private boolean up;

	public Destination(int elevator, int floor, boolean up) {
		this.elevator = elevator;
		this.floor = floor;
		this.up = up;
	}

	public int getElevator() {
		return elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

}
