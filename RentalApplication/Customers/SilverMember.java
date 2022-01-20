package Customers;
//This class is used to define SilverMember Constructor
//Methods and overrides findDiscount method.
public class SilverMember extends Customer implements ICommercial{
	
	public SilverMember(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double findDiscount() {
		double discount = 0.2;
		return discount;
	}

}
