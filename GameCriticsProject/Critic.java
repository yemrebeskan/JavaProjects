
public abstract class Critic {   //Base class which we will derive new game and movie critics from it.
	private double opinions;
	public Critic(double opinions) {
		this.opinions = opinions;
	}
	
	public double getOpinions() {
		return opinions;
	}

	public void setOpinions(double opinions) {
		this.opinions = opinions;
	}
	public abstract double calculateTime();			//abstract methods
	public abstract double calculate_Rate();
}
