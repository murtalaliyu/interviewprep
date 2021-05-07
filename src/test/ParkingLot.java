package test;
import java.util.Stack;
import java.util.ArrayList;

class ParkingLot {
	private int capacity;
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Stack<Lot> occupiedLots = new Stack<Lot>();

	public Lot parkCar(Car car) {
		// base cases
		if (occupiedLots.size() == capacity || car == null) {
			return null;
		}

		// push to a lot
		occupiedLots.push(car);

		return occupiedLots.peek();
	}

	public Lot retrieveCar(Car car) {
		// base cases
		if (car == null) {
			return null;
		}
		
		for (Car c : cars) {
			if (c.getLicensePlate() == car.getLicensePlate()) {
				return 
			}
		}
	}
}

class Lot {
	private int id;

	// getters & setters
}

class Car {
	private int licensePlate;

	// getters & setters
	int getLicensePlate() {
		return this.licensePlate;
	}
}
