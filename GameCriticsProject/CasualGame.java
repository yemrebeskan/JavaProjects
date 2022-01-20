
public class CasualGame extends Content implements IGame,IComparable{ //This is the class where we create and classify CasualGame data.
	private double matchDuration;			//-->Instance variables
	private double rating;
	private double shouldplaytime;
	public CasualGame(double arrivalDay, double number, String name, double averageRating, double matchDuration) {//Constructor method
		super(arrivalDay, number, name, averageRating);
		this.matchDuration = matchDuration;
		shouldplaytime = matchDuration * 3;
	}
	//Getter and Setter methods;
	public double getShouldplaytime() {
		return shouldplaytime;
	}

	public void setShouldplaytime(double shouldplaytime) {
		this.shouldplaytime = shouldplaytime;
	}

	public double getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(double matchDuration) {
		this.matchDuration = matchDuration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public void displayinfo() {//This method used to check CasualGame data's attributes.
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