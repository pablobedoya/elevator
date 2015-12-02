package br.ufrn.realtime.elevator.model;

public interface IArrivalSensor extends Runnable {

	public void activeSensor(int elevator);
	
}
