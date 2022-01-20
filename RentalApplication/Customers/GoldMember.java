package Customers;
//This class is used to define GoldMember Constructor, Methods and overrides findDiscount method.
public class GoldMember extends Customer implements ICommercial{

	public GoldMember(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double findDiscount() {
		double discount = 0.25;
		return discount;
	}

}
