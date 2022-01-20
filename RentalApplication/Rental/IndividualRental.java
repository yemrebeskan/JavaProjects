package Rental;

import Car.Car;
import Customers.Customer;
//This class is used to define CommercialRental constructor method and contains few methods.
public class IndividualRental extends Rental{
	private double price;
	private double rented_day;
	public IndividualRental(Customer customer, Car car,double rented_day) {
		super(customer, car);
		this.rented_day = rented_day;
		// TODO Auto-generated constructor stub
	}
	public double getPrice() { //Returns the price
		return price;
	}
	
	public void calculatePrice() { //This method calculates the daily rental price of the car.
		double price;
		price = super.getCar().getBasePrice() * super.getCar().calculateRatio();
		price = (price - (price * super.getCustomer().findDiscount()));
		price = price* getRented_day();
		updatePrice(price);
		
	}
	public double getRented_day() { //Returns the rented day.
		return rented_day;
	}
	private void updatePrice(double price) {
		this.price = price;
	}
	
	

}
