package com.example.demo;

import java.util.ArrayList;

public class CarController {
	
	private ArrayList<Car> list;

	public CarController() {
		super();
		list = new ArrayList<Car>();
	}

	public Car get(int index) {
		return list.get(index);
	}
	
	public Car create() {
		Car car = new Car();
		car.setColor("blue");
		car.setType("Truck");
		car.setDisplacement(1500);
		car.setSpeed(60);
		list.add(car);
		return car;
	}
	
	public Car update(int index, Car car) {
		list.set(index, car);
		return car;
	}
	
	public Car delete(int index) {
		return list.remove(index);
	}
	
	public ArrayList<Car> list() {
		return list;
	}
}
