package Customers;
//This class is used to define IndividualCustomer's constructor method 
//It is inherited from Customer class.
public class IndividualCustomer extends Customer{
	private boolean isMember;
	public IndividualCustomer(String id) { 
		super(id);
		if(super.getId() instanceof String) {
			String a = (String)super.getId();
			if(a.startsWith("M")) { //This block of code checks if the current IndividalCustomer has membership
				this.isMember = true;
			}
			else {
				this.isMember = false;
			}
		}

		// TODO Auto-generated constructor stub
	}
	public boolean isMember() {
		return isMember;
	}
	@Override
	public double findDiscount() { //This method is used to find discount.
		double discount = 0;
		if(isMember) {
			discount = 0.1;
		}
		return discount;
	}
	
}
