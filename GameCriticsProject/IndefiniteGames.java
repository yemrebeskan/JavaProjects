
public class IndefiniteGames extends Content implements IGame,IComparable{//This is the class where we create and classify IndefiniteGame data.
	private double evalutaiontime;			//--> Instance variables
	private double rating;
	private double shouldplaytime;
	public IndefiniteGames(double arrivalDay, double number, String name, double averageRating, double evalutaiontime) {//Constructor method
		super(arrivalDay, number, name, averageRating);
		this.evalutaiontime = evalutaiontime;
	}
	//Getter and Setter methods;
	public double getShouldplaytime() {
		return shouldplaytime;
	}

	public void setShouldplaytime(double shouldplaytime) {
		this.shouldplaytime = shouldplaytime;
	}

	public double getEvalutaiontime() {
		return evalutaiontime;
	}

	public void setEvalutaiontime(double evalutaiontime) {
		this.evalutaiontime = evalutaiontime;
	}
	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public void displayinfo() {//This method used to check IndefiniteGame data's attributes.
		System.out.println(getName() + ", " + getRating());
	}

	@Override
	public int compareTo(Object other) {//This method used to check if the current game comes before the other game lexicographically.
		if(other instanceof Content) {
			Content othergame = (Content)other;
			return getName().compareTo(othergame.getName());
		}
		return 0;
	}
	
}

