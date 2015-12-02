package br.ufrn.realtime.elevator.controller;

import br.ufrn.realtime.elevator.model.ArrivalSensor;
import br.ufrn.realtime.elevator.model.Motor;

public class ElevatorController {

	private ElevatorStatusAndPlan statusAndPlan1stElevator = null;
	private ElevatorStatusAndPlan statusAndPlan2ndElevator = null;
	
	private Motor motor1stElevator = null;
	private Motor motor2ndElevator = null;
	
	private ArrivalSensor arrivalSensor1stElevator = null;
	private ArrivalSensor arrivalSensor2ndElevator = null;
	
	private Motion motion1stElevator = null;
	private Motion motion2ndElevator = null;
	
	private Scheduler scheduler = null;
	
	private Thread thread1stElevator = null;
	private Thread thread2ndElevator = null;
	
	private static ElevatorController ec = null;
	
	public ElevatorController() {
		statusAndPlan1stElevator = new ElevatorStatusAndPlan();
		statusAndPlan2ndElevator = new ElevatorStatusAndPlan();
		
		motor1stElevator = new Motor(1);
		motor2ndElevator = new Motor(2);
		
		arrivalSensor1stElevator = new ArrivalSensor(1);
		Thread threadArrivalSensor1stElevator = new Thread(arrivalSensor1stElevator);
		threadArrivalSensor1stElevator.start();
		arrivalSensor2ndElevator = new ArrivalSensor(2);
		Thread threadArrivalSensor2ndElevator = new Thread(arrivalSensor2ndElevator);
		threadArrivalSensor2ndElevator.start();
		
		motion1stElevator = new Motion(1);
		motion2ndElevator = new Motion(2);
		
		thread1stElevator = new Thread(motion1stElevator);
		thread1stElevator.start();
		thread2ndElevator = new Thread(motion2ndElevator);
		thread2ndElevator.start();
		
		scheduler = new Scheduler();
	}
	
	public static ElevatorController getInstance() {
		if (ec == null) {
			ec = new ElevatorController();
		}
		
		return ec;
	}
	
	public ElevatorStatusAndPlan getStatusAndPlan1stElevator() {
		return statusAndPlan1stElevator;
	}

	public ElevatorStatusAndPlan getStatusAndPlan2ndElevator() {
		return statusAndPlan2ndElevator;
	}

	public Motor getMotor1stElevator() {
		return motor1stElevator;
	}

	public Motor getMotor2ndElevator() {
		return motor2ndElevator;
	}

	public ArrivalSensor getArrivalSensor1stElevator() {
		return arrivalSensor1stElevator;
	}

	public ArrivalSensor getArrivalSensor2ndElevator() {
		return arrivalSensor2ndElevator;
	}

	public Motion getMotion1stElevator() {
		return motion1stElevator;
	}

	public Motion getMotion2ndElevator() {
		return motion2ndElevator;
	}

	public boolean requestElevator(int floor, boolean up) {
		if (arrivalSensor1stElevator.getCurrentFloor() != floor && arrivalSensor2ndElevator.getCurrentFloor() != floor) {
			if (scheduler.selectElevator(floor, up) == 1) {
				statusAndPlan1stElevator.update(1, floor, up);
				return true;
			} else {
				statusAndPlan2ndElevator.update(2, floor, up);
				return true;							
			}
		}
		
		return false;
	}
	
	public boolean selectDirection(int elevator, int floor) {
		if (elevator == 1) {
			if (arrivalSensor1stElevator.getCurrentFloor() > floor) {
				return false; // down
			} else {
				return true; // up
			}
		} else {
			if (arrivalSensor2ndElevator.getCurrentFloor() > floor) {
				return false; // down
			} else {
				return true; // up
			}
		}
	}
	
	public void selectDestination(int elevator, int floor) {
		if (elevator == 1) {
			statusAndPlan1stElevator.update(elevator, floor, selectDirection(elevator, floor));
		} else {
			statusAndPlan2ndElevator.update(elevator, floor, selectDirection(elevator, floor));
		}
	}
	
}
