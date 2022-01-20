package Car;

public class Car { //This class is used to define cars' instance variables, constructor method,
	private double base_price; //getter and setter methods. Additionally, it has a method to calculate ratio according 
	private double modelyear; // to its model year.
	private String model;
	public Car(double modelyear, String model,double base_price) { //Constructor Method---
		super();
		this.modelyear = modelyear;
		this.model = model;
		this.base_price = base_price;
	}
	public double getModelyear() {  //Getter and Setter Methods-- 
		return modelyear;
	}
	public String getModel() {
		return model;
	}
	public double getBasePrice() {
		return base_price;
	}
	public double calculateRatio() { //This method is used to calculate ratio according to its model year.
		if(this.modelyear >= 2022) {
			return 1;
		}
		else if(this.modelyear >= 2020 && this.modelyear <= 2021) {
			return 0.95;
		}
		else if(this.modelyear <= 2019 && this.modelyear >= 2017) {
			return 0.9;
		}
		else {
			return 0;
		}
	}
	
	
}
