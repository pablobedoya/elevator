package br.ufrn.realtime.elevator.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.realtime.elevator.model.Destination;

public class ElevatorStatusAndPlan {

	private List<Destination> destinations;

	public ElevatorStatusAndPlan() {
		destinations = new ArrayList<Destination>();
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	
	public boolean arrived(int elevator, int floor, boolean up) {
		for (int i = 0; i < destinations.size(); i++) {
			if(elevator == destinations.get(i).getElevator() && floor == destinations.get(i).getFloor() && up == destinations.get(i).isUp()) {
				destinations.remove(i);
				
				return true;
			}
		}
		
		return false;
	}
	
	public void update(int elevator, int floor, boolean up) {
		Destination destination = new Destination(elevator, floor, up);
		destinations.add(destination);
	}
	
}
