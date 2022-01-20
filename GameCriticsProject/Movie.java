
public class Movie extends Content implements IComparable{//This is the class where we create and classify Movie data.
	private double duration;
	private double year;
	private double rating;
	public Movie(double arrivalDay, double number, String name, double averageRating, double duration,double year) {//Constructor method
		super(arrivalDay, number, name, averageRating);
		this.duration = duration;
		this.year = year;
	}
	//Getter and setter methods;
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	
	public double getRating() {
		return rating;
	}

	@Override
	public int compareTo(Object other) {//This method used to check if the current movie comes before the other movie lexicographically.
		if(other instanceof Movie) {
			Movie otherMovie = (Movie) other;
			return super.getName().compareTo(otherMovie.getName());
		}
		return 0;
		
	}

	@Override
	public void displayinfo() {//This method used to check Movie data's attributes.
		System.out.println(getName() + " " + getYear() + ", " + getRating());	
	}
	
	
}
