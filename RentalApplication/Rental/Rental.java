package Rental;

import Car.Car;
import Customers.Customer;
//abstract class
public abstract class Rental {//This abstract class is used to  define instance variables, Rental constructor method and 
	//contains calculatePrice abstract method.
	private Customer customer; //This is a association relation.
	private Car car;
	private int code;
	public Rental(Customer customer, Car car) {
		super();
		this.customer = customer;
		this.car = car;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public Car getCar() {
		return car;
	}
	
	public abstract void calculatePrice();
}
