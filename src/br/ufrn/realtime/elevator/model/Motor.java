package br.ufrn.realtime.elevator.model;

import br.ufrn.realtime.elevator.view.Main;

public class Motor implements IMotor {
	
	private boolean up;
	private boolean stopped;
	
	public Motor(int elevator) {
		if (elevator == 1) {
			Main.getInstance().updateLampDirection(1, true, true);
		} else {
			Main.getInstance().updateLampDirection(2, true, true);
		}
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
		if (elevator == 1) {
			Main.getInstance().updateLampDirection(1, false, true);
		} else {
			Main.getInstance().updateLampDirection(2, false, true);
		}
		up = true;
	}

	@Override
	public void down(int elevator) {
		if (elevator == 1) {
			Main.getInstance().updateLampDirection(1, true, false);
		} else {
			Main.getInstance().updateLampDirection(2, true, false);
		}
		up = false;
	}
	
	@Override
	public void stop(int elevator) {
		if (elevator == 1) {
			Main.getInstance().updateLampDirection(1, true, true);
		} else {
			Main.getInstance().updateLampDirection(2, true, true);
		}
		stopped = true;
	}
	
}
