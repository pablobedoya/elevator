package br.ufrn.realtime.elevator.controller;

public class Scheduler {

	public int selectElevator(int floor, boolean up) {
		int distance1stElevator = 0;
		int distance2ndElevator = 0;

		if (floor >= ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor()) {
			distance1stElevator = floor - ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor();
		} else {
			distance1stElevator = ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() - floor;
		}

		if (floor >= ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor()) {
			distance2ndElevator = floor - ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor();
		} else {
			distance2ndElevator = ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor() - floor;
		}

		if ((distance1stElevator <= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() < floor) && (ElevatorController.getInstance().getMotor1stElevator().isUp() == up)) {
			return 1;
		} else if ((!ElevatorController.getInstance().getMotor1stElevator().isStopped()) && (ElevatorController.getInstance().getMotor2ndElevator().isStopped())) {
			return 2;
		} else if ((ElevatorController.getInstance().getMotor1stElevator().isStopped()) && (!ElevatorController.getInstance().getMotor2ndElevator().isStopped())) {
			return 1;
		} else if ((distance1stElevator <= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() > floor) && (ElevatorController.getInstance().getMotor1stElevator().isUp() == up)) {
			return 1;
		} else if ((distance1stElevator >= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() < floor) && (ElevatorController.getInstance().getMotor1stElevator().isUp() == up)) {
			return 2;
		} else if ((distance1stElevator >= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() > floor) && (ElevatorController.getInstance().getMotor1stElevator().isUp() == up)) {
			return 2;
		} else if ((distance1stElevator <= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() > floor) && (!ElevatorController.getInstance().getMotor1stElevator().isUp()) && ElevatorController.getInstance().getMotor2ndElevator().isStopped()) {
			return 2;
		} else if ((distance1stElevator >= distance2ndElevator) && (ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor() > floor) && (!ElevatorController.getInstance().getMotor2ndElevator().isUp()) && ElevatorController.getInstance().getMotor1stElevator().isStopped()) {
			return 1;
		} else if (distance1stElevator <= distance2ndElevator) {
			return 1;
		} else {
			return 2;
		}
	}

}
