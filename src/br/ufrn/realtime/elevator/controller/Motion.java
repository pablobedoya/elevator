package br.ufrn.realtime.elevator.controller;

import java.awt.Color;

import br.ufrn.realtime.elevator.view.Main;

public class Motion implements Runnable {

	private int elevator;
	private int destination;

	public Motion(int elevator) {
		this.elevator = elevator;
		destination = -1;
	}
	
	@Override
	public void run() {
		try {
			for (;;) {
				Thread.sleep(1000);
				if (elevator == 1) {
					verifyDestination(1);
					motion(1);
				} else {
					verifyDestination(2);
					motion(2);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void verifyDestination(int elevator) {
		if (elevator == 1) {
			if (ElevatorController.getInstance().getStatusAndPlan1stElevator().getDestinations().size() > 0) {
				destination = ElevatorController.getInstance().getStatusAndPlan1stElevator().getDestinations().get(0).getFloor();
			} else {
				ElevatorController.getInstance().getMotor1stElevator().stop(1);
				destination = -1;
			}
		} else {
			if (ElevatorController.getInstance().getStatusAndPlan2ndElevator().getDestinations().size() > 0) {
				destination = ElevatorController.getInstance().getStatusAndPlan2ndElevator().getDestinations().get(0).getFloor();
			} else {
				ElevatorController.getInstance().getMotor2ndElevator().stop(2);
				destination = -1;
			}
		}
	}
	
	private void motion(int elevator) throws InterruptedException {
		if (elevator == 1) {
			int current = ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor();
			
			/*if (current == 4) {
				ElevatorController.getInstance().getMotor1stElevator().down(1);
			} else {
				if (current == 0) {
					ElevatorController.getInstance().getMotor1stElevator().up(1);
				}
			}*/
			
			boolean up = ElevatorController.getInstance().getMotor1stElevator().isUp();
			
			if (ElevatorController.getInstance().getStatusAndPlan1stElevator().arrived(1, current, up)) {
				Main.getInstance().updateLightDestination1stElevator(current);
				Main.getInstance().updateLightFloorRequestElevator(current, up);
				Main.getInstance().setLabelOpenDoor1stElevator(Color.BLUE);
				Thread.sleep(1000);
				verifyDestination(1);
			} else {
				if (ElevatorController.getInstance().getStatusAndPlan1stElevator().getDestinations().size() == 1) {
					if (ElevatorController.getInstance().getStatusAndPlan1stElevator().arrived(1, current, !up)) {
						ElevatorController.getInstance().getMotor1stElevator().stop(1);
						Main.getInstance().updateLightDestination1stElevator(current);
						Main.getInstance().updateLightFloorRequestElevator(current, !up);
						Main.getInstance().setLabelOpenDoor1stElevator(Color.BLUE);
						Thread.sleep(1000);
						verifyDestination(1);
					}
				}
			}
			if (destination != -1) {
				if (current == 4) {
					ElevatorController.getInstance().getMotor1stElevator().down(1);
				} else {
					if (current == 0) {
						ElevatorController.getInstance().getMotor1stElevator().up(1);
					}
				}
				if (destination > ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor()) {
					ElevatorController.getInstance().getMotor1stElevator().up(1);
					Main.getInstance().turnOffLight1stElevator(ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor());
					ElevatorController.getInstance().getArrivalSensor1stElevator().setCurrentFloor(1, ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() + 1);
					Main.getInstance().setLabelOpenDoor1stElevator(Color.RED);
				} else {
					ElevatorController.getInstance().getMotor1stElevator().down(1);
					Main.getInstance().turnOffLight1stElevator(ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor());
					ElevatorController.getInstance().getArrivalSensor1stElevator().setCurrentFloor(1, ElevatorController.getInstance().getArrivalSensor1stElevator().getCurrentFloor() - 1);
					Main.getInstance().setLabelOpenDoor1stElevator(Color.RED);
				}
			} else {
				ElevatorController.getInstance().getMotor1stElevator().stop(1);
				Main.getInstance().setLabelOpenDoor1stElevator(Color.BLUE);
				Thread.sleep(1000);
			}
		} else {
			int current = ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor();
			
			boolean up = ElevatorController.getInstance().getMotor2ndElevator().isUp();
			
			if (ElevatorController.getInstance().getStatusAndPlan2ndElevator().arrived(2, current, up)) {
				Main.getInstance().updateLightDestination2ndElevator(current);
				Main.getInstance().updateLightFloorRequestElevator(current, up);
				Main.getInstance().setLabelOpenDoor2ndElevator(Color.BLUE);
				Thread.sleep(1000);
				verifyDestination(2);
			} else {
				if (ElevatorController.getInstance().getStatusAndPlan2ndElevator().getDestinations().size() == 1) {
					if (ElevatorController.getInstance().getStatusAndPlan2ndElevator().arrived(2, current, !up)) {
						ElevatorController.getInstance().getMotor2ndElevator().stop(2);
						Main.getInstance().updateLightDestination2ndElevator(current);
						Main.getInstance().updateLightFloorRequestElevator(current, !up);
						Main.getInstance().setLabelOpenDoor2ndElevator(Color.BLUE);
						Thread.sleep(1000);
						verifyDestination(2);
					}
				}
			}
			if (destination != -1) {
				if (current == 4) {
					ElevatorController.getInstance().getMotor2ndElevator().down(2);
				} else {
					if (current == 0) {
						ElevatorController.getInstance().getMotor2ndElevator().up(2);
					}
				}
				if (destination > ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor()) {
					ElevatorController.getInstance().getMotor2ndElevator().up(2);
					Main.getInstance().turnOffLight2ndElevator(ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor());
					ElevatorController.getInstance().getArrivalSensor2ndElevator().setCurrentFloor(2, ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor() + 1);
					Main.getInstance().setLabelOpenDoor2ndElevator(Color.RED);
				} else {
					ElevatorController.getInstance().getMotor2ndElevator().down(2);
					Main.getInstance().turnOffLight2ndElevator(ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor());
					ElevatorController.getInstance().getArrivalSensor2ndElevator().setCurrentFloor(2, ElevatorController.getInstance().getArrivalSensor2ndElevator().getCurrentFloor() - 1);
					Main.getInstance().setLabelOpenDoor2ndElevator(Color.RED);
				}
			} else {
				ElevatorController.getInstance().getMotor2ndElevator().stop(2);
				Main.getInstance().setLabelOpenDoor2ndElevator(Color.BLUE);
				Thread.sleep(1000);
			}
		}
	}

}
