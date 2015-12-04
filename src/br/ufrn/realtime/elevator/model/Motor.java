package br.ufrn.realtime.elevator.model;

import br.ufrn.realtime.elevator.view.Main;

public class Motor implements IMotor {
	
	private boolean up;
	private boolean stopped;
	
	public Motor(int elevator) {
		Main.getInstance().updateLampDirection(elevator, true, true);
		stopped = true;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isStopped() {
		return stopped;
	}

	@Override
	public void up(int elevator) {
		Main.getInstance().updateLampDirection(elevator, false, true);
		up = true;
	}

	@Override
	public void down(int elevator) {
		Main.getInstance().updateLampDirection(elevator, true, false);
		up = false;
	}
	
	@Override
	public void stop(int elevator) {
		Main.getInstance().updateLampDirection(elevator, true, true);
		stopped = true;
	}
	
}
