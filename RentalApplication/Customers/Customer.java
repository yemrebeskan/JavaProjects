package Customers;
//This class is used to define Customer's instance variables, Constructor method and
public abstract class Customer<T> {
	private T id;
	public Customer(T id) {
		super();
		this.id = id;	
	}
	
	public T getId() {
		return id;
	}
	//contains a abstract method to find discount.
	public abstract double findDiscount();
	
	
}
