

public abstract class Content { //This is the class that we use to construct contents.
	private double arrivalDay; //Later, these contents will be seperated to parts as movies and game types.
	private double number;
	private String name;
	private double averageRating;
	public Content(double arrivalDay,double number,String name,double averageRating) {//Constructor method for placing csv file's datas.
		this.arrivalDay = arrivalDay;
		this.name = name;
		this.number = number;
		this.averageRating = averageRating;				
	}															//---Getter and Setter methods---
	public double getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(double arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public abstract void displayinfo(); //This is the method that is used for checking the placements are correct or not.
}

