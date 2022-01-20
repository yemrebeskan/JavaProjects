
public class GameCritic extends Critic implements IComparable{
	private int number;
	private IGame game;
	private double canWork = 8; //work hour in a day
	private boolean isFinished = true; //control finish situation
	public GameCritic(double opinions, int number) {
		super(opinions);
		this.number = number;
	}

	public double getCanWork() {
		return canWork;
	}

	public void setCanWork(double canWork) {
		this.canWork = canWork;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
		this.isFinished = false;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	/*this method calculates the computational time and if time is 
	 * suitable, changes the finished situation.*/
	
	@Override
	public double calculateTime() {
		double time = 0;
		double shouldplaytime = 0;
		if(game instanceof CasualGame) {
			CasualGame thisgame = (CasualGame) game;
			shouldplaytime = thisgame.getShouldplaytime();
			if(shouldplaytime > this.canWork) { //the game will not end that day, but the game time will be shortened
				shouldplaytime = shouldplaytime - this.canWork;
				thisgame.setShouldplaytime(shouldplaytime);
			}
			else if(shouldplaytime <= this.canWork) { //the game will end that day
				time = shouldplaytime;
				this.isFinished = true; //critic's mission is completed
				this.canWork = this.canWork - time; //critic's work time will be reduced
			}
		}
		else if(game instanceof StoryGame) {
			StoryGame thisgame = (StoryGame) game;
			shouldplaytime = thisgame.getShouldplaytime();
			if(shouldplaytime > this.canWork) { //the game will not end that day, but the game time will be shortened
				shouldplaytime = shouldplaytime - this.canWork;
				thisgame.setShouldplaytime(shouldplaytime);
			}
			else if(shouldplaytime <= this.canWork) { //the game will end that day
				time = shouldplaytime;
				this.isFinished = true; //critic's mission is completed
				this.canWork = this.canWork - time;
			}
		}
		else if(game instanceof IndefiniteGames) {
			IndefiniteGames thisgame = (IndefiniteGames) game;
			if(this.canWork < 4) { //no matter what, critic should play for 4 hours nonstop
				this.isFinished = false;
			}
			else {
				time = 4;
				this.isFinished = true;
				this.canWork = this.canWork - time;
			}
			
		}
		return time;
	}
	/*values the rating of the game. */
	public IGame updateGame() {
		if(game instanceof CasualGame) {
			CasualGame thisgame = (CasualGame) game;
			thisgame.setRating(calculate_Rate());
			game = (IGame)thisgame;
		}
		else if(game instanceof StoryGame) {
			StoryGame thisgame = (StoryGame) game;
			thisgame.setRating(calculate_Rate());
			game = (IGame)thisgame;
		}
		else if(game instanceof IndefiniteGames) {
			IndefiniteGames thisgame = (IndefiniteGames) game;
			thisgame.setRating(calculate_Rate());
			game = (IGame)thisgame;
		}
		return game;
	}
	/*the rating is calculated according to the type of game*/
	@Override
	public double calculate_Rate() {
		double rating = 0;
		if(game instanceof CasualGame) {
			CasualGame thisgame = (CasualGame) game;
			rating = thisgame.getAverageRating() + ((thisgame.getMatchDuration() - 3) * 3) + super.getOpinions();
			return rating;
		}
		else if(game instanceof IndefiniteGames) {
			IndefiniteGames thisgame = (IndefiniteGames) game;
			rating = thisgame.getAverageRating() + ((10 - thisgame.getEvalutaiontime()) * 0.25) + super.getOpinions();
			return rating;
		}
		else if(game instanceof StoryGame) {
			StoryGame thisgame = (StoryGame) game;
			rating = thisgame.getAverageRating() + (thisgame.getStoryDuration() * 0.25) + super.getOpinions();
			return rating;
		}
		return rating;
	}
	/*compares with computation time of other critic*/
	@Override
	public int compareTo(Object other) {
		try {
			if(other instanceof GameCritic) {
				GameCritic otherCritic = (GameCritic)other;
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

	

