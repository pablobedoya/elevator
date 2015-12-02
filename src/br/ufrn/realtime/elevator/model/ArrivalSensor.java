package br.ufrn.realtime.elevator.model;

import java.awt.Color;

import br.ufrn.realtime.elevator.view.Main;

public class ArrivalSensor implements IArrivalSensor {

	private int elevator;
	private int currentFloor;

	public ArrivalSensor(int elevator) {
		this.elevator = elevator;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int elevator, int currentFloor) {
		this.currentFloor = currentFloor;
		if (elevator == 1) {
			Main.getInstance().update1stElevatorPosition(currentFloor);
		} else {
			Main.getInstance().update2ndElevatorPosition(currentFloor);
		}
	}
	
	public void run() {
		try {
			for (;;) {
				if (elevator == 1) {
					Main.getInstance().setLabelSensor1stElevator(Color.GREEN);
					Thread.sleep(1000);
					activeSensor(1);
					Thread.sleep(1000);
				} else {
					Main.getInstance().setLabelSensor2ndElevator(Color.GREEN);
					Thread.sleep(1000);
					activeSensor(2);
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void activeSensor(int elevator) {
		if (elevator == 1) {
			Main.getInstance().setLabelSensor1stElevator(Color.RED);
		} else {
			Main.getInstance().setLabelSensor2ndElevator(Color.RED);
		}
	}

}
