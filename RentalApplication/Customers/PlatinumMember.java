package Customers;
//This class is used to define PlatinumMember Constructor, Methods and overrides findDiscount method.
public class PlatinumMember extends Customer implements ICommercial{

	public PlatinumMember(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double findDiscount() {
		double discount = 0.3;
		return discount;
	}

}
