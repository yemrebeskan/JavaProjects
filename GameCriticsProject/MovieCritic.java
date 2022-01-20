
public class MovieCritic extends Critic implements IComparable{
	private int number;
	private Movie movie;
	private boolean isFinished = false;
	public MovieCritic(double opinions, int number) {
		super(opinions);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public double calculateTime() { //calculate the movie's computation time
		double time = movie.getDuration() / 60;
		this.isFinished = true;
		return time;
	}
	public Movie getUpdatedMovie() { //values the rating of the movie.
		movie.setRating(calculate_Rate());
		return movie;
	}
	
	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	//calculate rating
	@Override
	public double calculate_Rate() {
		double rating = movie.getAverageRating() + ((movie.getDuration() - 150) * 0.01) - ((
				2021 - movie.getYear()) * 0.01) + super.getOpinions();
		return rating;
	}
	/*compares with computation time of other critic */
	/* Polymorphism */
	@Override
	public int compareTo(Object other) {
		try {
			if(other instanceof MovieCritic) {
				MovieCritic otherCritic = (MovieCritic)other;
				if(calculateTime() > otherCritic.calculateTime()) {
					return 1;
				}
				else if(calculateTime() == otherCritic.calculateTime()) {
					return 0;
				}
				else if(calculateTime() < otherCritic.calculateTime()) {
					return -1;
				}
			}
			
		}catch(NullPointerException e) {
			return 1;
		}
		return 1;
	}

	
	
}
