package Rental;

import Car.Car;
import Customers.Customer;
//This class is used to define CommercialRental constructor method and contains few methods.
public class CommercialRental extends Rental{
	private double price;
	private double rented_month;
	public CommercialRental(Customer customer, Car car,double rented_month) { //Constructor method--
		super(customer, car);
		this.rented_month = rented_month;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void calculatePrice() { //This method calculates the monthly rental price of the car.
		double price;
		price = super.getCar().getBasePrice() * super.getCar().calculateRatio();
		price = price - (price * super.getCustomer().findDiscount());
		price = price * 30 * getRented_month();
		updatePrice(price);
	}
	private void updatePrice(double price) {
		this.price = price;
	}
	public double getPrice() { //Returns the price
		return price;
	}
	
	public double getRented_month() { //Returns the rented month.
		return rented_month;
	}
	
}
