package br.ufrn.realtime.elevator.model;

public interface IMotor {

	public void up(int elevator);
	public void down(int elevator);
	public void stop(int elevator);
	
}
