package br.ufrn.realtime.elevator.model;

public class Destination {

	/*@ spec_public */ private int elevator;
	/*@ spec_public */ private int floor;
	/*@ spec_public */ private boolean up;

	/*@ requires elevator > 0 && floor >= 0;
        ensures getElevator() == elevator;
        ensures getFloor() == floor;
        ensures isUp() == up;
	 */
	public Destination(int elevator, int floor, boolean up) {
		this.elevator = elevator;
		this.floor = floor;
		this.up = up;
	}

	/*@ pure */ public int getElevator() {
		return elevator;
	}

	/*@ requires elevator > 0;
	    ensures getElevator() == elevator;
	 */
	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	/*@ pure */ public int getFloor() {
		return floor;
	}

	/*@ requires floor >= 0;
	    ensures getFloor() == floor;
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}

	/*@ pure */ public boolean isUp() {
		return up;
	}

	//@ ensures isUp() == up;
	public void setUp(boolean up) {
		this.up = up;
	}

}
