import java.util.ArrayList;

public class Company {
	private ContentStack<Movie> movieStack = new ContentStack<>(); //movie stack
	private ContentStack<IGame> gameStack = new ContentStack<>();  //game stack
	private CriticQueue<MovieCritic> moviecriticQueue = new CriticQueue<>(); //movie critic queue
	private CriticQueue<GameCritic> gamecriticQueue = new CriticQueue<>();   //game critic queue
	private ArrayList<Movie> moviestoWatch = new ArrayList<>();    //movies to watch that day             
	private ArrayList<IGame> gamestoplay = new ArrayList<>();      //games  to play that day
	private ArrayList<IComparable> finishedmovieslist = new ArrayList<>(); //movies watched that day
	private ArrayList<IComparable> finishedgameslist = new ArrayList<>(); //games played that day
	private ArrayList<MovieCritic> inProcessmoviecritics = new ArrayList<>(); //movies in process by critics
	private ArrayList<GameCritic> inProcessgamecritics = new ArrayList<>(); //games in process by critics
	private ArrayList<IComparable> evaluatedmovies = new ArrayList<>();   //evaluated movies
	private ArrayList<IComparable> evaluatedgames = new ArrayList<>();	  //evaluated games	
	private int day;
	
	public Company(ArrayList<Movie> moviestoWatch, ArrayList<IGame> gamestoplay,
			CriticQueue<MovieCritic> moviecriticQueue, CriticQueue<GameCritic> gamecriticQueue) {
		super();
		this.moviestoWatch = moviestoWatch;
		this.gamestoplay = gamestoplay;
		this.moviecriticQueue = moviecriticQueue;
		this.gamecriticQueue = gamecriticQueue;
		this.day = 1;
	}

	public ContentStack<Movie> getMovieStack() {
		return movieStack;
	}


	public ContentStack<IGame> getGameStack() {
		return gameStack;
	}


	public CriticQueue<MovieCritic> getMoviecriticQueue() {
		return moviecriticQueue;
	}



	public void setMoviecriticQueue(CriticQueue<MovieCritic> moviecriticQueue) {
		this.moviecriticQueue = moviecriticQueue;
	}



	public CriticQueue<GameCritic> getGamecriticQueue() {
		return gamecriticQueue;
	}


	public void setGamecriticQueue(CriticQueue<GameCritic> gamecriticQueue) {
		this.gamecriticQueue = gamecriticQueue;
	}
	
	
	public void setGameStack(ContentStack<IGame> gameStack) {
		this.gameStack = gameStack;
	}

	public ArrayList<Movie> getMoviestoWatch() {
		return moviestoWatch;
	}

	public void setMoviestoWatch(ArrayList<Movie> moviestoWatch) {
		this.moviestoWatch = moviestoWatch;
	}

	public ArrayList<IGame> getGamestoplay() {
		return gamestoplay;
	}

	public void setGamestoplay(ArrayList<IGame> gamestoplay) {
		this.gamestoplay = gamestoplay;
	}

	public ArrayList<GameCritic> getInProcessgamecritics() {
		return inProcessgamecritics;
	}

	public void setInProcessgamecritics(ArrayList<GameCritic> inProcessgamecritics) {
		this.inProcessgamecritics = inProcessgamecritics;
	}

	/*
	The movies to be watched that day will come to the stack in order 
	and if there is a suitable critic in the queue, it will take the movie in that stack.
	*/
	
	public void attendMovieCritic() {
		int i = 0;   //movies to watch list's index
		while(true){
			try {
				if(i > 2) { //if there are more than two movies to watch in a day
					/*critics return back the queue who have finished and finished movie will be add 
					 * the evaluated movie list. */
					Sorter.sortArray(finishedmovieslist, finishedmovieslist.size()); //sorting
					MovieCritic criticmovie = (MovieCritic)finishedmovieslist.get(0); 
					finishedmovieslist.remove(finishedmovieslist.get(0));
					evaluatedmovies.add(criticmovie.getUpdatedMovie());
					moviecriticQueue.enqueue(criticmovie);
				}
				//movie is added to stack and critic comes from queue and takes it
				Movie movietoWatch = moviestoWatch.get(i);
				movieStack.push(movietoWatch);
				MovieCritic moviecritic = moviecriticQueue.dequeue();
				moviecritic.setMovie(movieStack.pop());
				displayMovieinfo(moviecritic);
				//added in process list
				inProcessmoviecritics.add(moviecritic);
				finishedmovieslist.add(moviecritic);
				inProcessmoviecritics.remove(moviecritic);
				i++;
			}catch(IndexOutOfBoundsException e) {
				break; //end of while
			}
			
		}
		/*At the end of the day, if there is a finished critic, it will be added to the queue. */
		Sorter.sortArray(finishedmovieslist, finishedmovieslist.size());
		int index = 0;
		while(!(finishedmovieslist.isEmpty())) {
		try {
			MovieCritic criticmovie = (MovieCritic)finishedmovieslist.get(index);
			finishedmovieslist.remove(index);
			evaluatedmovies.add(criticmovie.getUpdatedMovie());
			moviecriticQueue.enqueue(criticmovie);
		}catch(IndexOutOfBoundsException e) {
		}
	}
	}
	
	
	/*this method provides that if critic finishes the game the critic
	 *  will be added the finished games list and remove from in process list */
	
	
	private void controlinProcessgamecritics() {
		int index = 0;
		while(!(inProcessgamecritics.isEmpty())){
			try {
				GameCritic gamecrit = (GameCritic)inProcessgamecritics.get(index);
				gamecrit.calculateTime(); /*calculate time method provides isFinished or not */
				if(gamecrit.isFinished()) {
					finishedgameslist.add(gamecrit);
					inProcessgamecritics.remove(index);
				}
				else {
					index++;
				}
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
	}
	
	/*this method provides that updates the games in the finished games list and 
	 * adds them to the evaluated games list.Then critic returns back to the queue.*/
	
	
	private void controlfinishedgameslist() {
		Sorter.sortArray(finishedgameslist, finishedgameslist.size());
		while(!(finishedgameslist.isEmpty())) {
			try {
				GameCritic gamecrit = (GameCritic)finishedgameslist.get(0);
				IComparable agame = (IComparable)gamecrit.updateGame();
				evaluatedgames.add(agame);
				displayevaluatedGameInfo(gamecrit);
				gamecriticQueue.enqueue(gamecrit);
				finishedgameslist.remove(0);
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
	}
	
	
	/*Game critics can work 8 hours in a day so the beginning of the day every critics's work hour
	 * (who is on the process list) is updated */
	
	 private void updateGameCritics() {
		for(int i = 0;i < inProcessgamecritics.size();i++) {
			inProcessgamecritics.get(i).setCanWork(8);
		}
	} 
	 
	 /*
		The games to be played that day will come to the stack in order 
		and if there is a suitable critic in the queue, it will take the game in that stack.
		at the beginning of day if stack is not empty, the critic should take what's in the stack 
		*/
	 
	 
	public void attendGames() {
		if(inProcessgamecritics.size() > 0) { //update critics
			updateGameCritics();
		}
		controlinProcessgamecritics();
		controlfinishedgameslist();
		int i = 0;
		while(true){
			try {
				if(gamestoplay != null) { //for control 6.day
					IGame game = gamestoplay.get(i);
					GameCritic gamecrit = gamecriticQueue.dequeue();
					if(gameStack.isEmpty()) { //if stack is empty,the game is added.
						gameStack.push(game);
					}
					if(gamecrit == null) {
						//pass
					}
					else if(gamecrit != null){
						gamecrit.setGame(gameStack.pop()); //if stack is not empty critic should take that game
						displayworkingGameInfo(gamecrit);
						gamecrit.calculateTime();   //if time is right,control the game is finished or not.
						if(gamecrit.isFinished()) {
							finishedgameslist.add(gamecrit);
						}
						else {
							inProcessgamecritics.add(gamecrit);
						}
					}

					i++;
					/* If there are more than 5 games, the critic of one of 
					 * the finished ones is taken and another game assigned to that critic.*/
					if(i > 4) { 
						if(finishedgameslist.size() > 0) {
							Sorter.sortArray(finishedgameslist, finishedgameslist.size());
							GameCritic gamecritic = (GameCritic)finishedgameslist.get(0);
							IComparable agame = (IComparable)gamecritic.updateGame();
							evaluatedgames.add(agame);
							finishedgameslist.remove(0);
							displayevaluatedGameInfo(gamecritic);
							gamecriticQueue.enqueue(gamecritic);
						}
					}
				}
				else {
					break; //end of while
				}
				
				
			}catch(IndexOutOfBoundsException e) {
				break; //end of while
			}
		}
		controlfinishedgameslist(); 
		/*at the end of day,control finished
		 games and add the critics to the queue*/
	
	
	}
	
	/*output parts*/
	
	
	
	public static void displayMovieinfo(MovieCritic crit) {
 		System.out.println(crit.getNumber() + ". movie critic evaluated (" + crit.getMovie().getName() + ")");
 	}
	
	
	
	
	
	public static void displayworkingGameInfo(GameCritic crit) {
		Content game = (Content)crit.getGame();
		System.out.println(crit.getNumber() + ". game critic works on (" + game.getName() + ")");
	}
	
	
	
	
	
	public static void displayevaluatedGameInfo(GameCritic crit) {
		Content game = (Content)crit.getGame();
		System.out.println(crit.getNumber() + ". game critic evaluated (" + game.getName() + ")" );
	}
	
	
	
	
	
	public void outputevaluatedmovies() {
		Sorter.sortArray(evaluatedmovies, evaluatedmovies.size());
		for(int i = 0;i < evaluatedmovies.size();i++) {
			Movie movie = (Movie)evaluatedmovies.get(i);
			System.out.println("#" + movie.getName() + (" (#") + (int)movie.getYear() +"), " + (int)movie.getRating());
		}
	}
	
	
	
	
	
	public void outputevaluatedgames() {
		Sorter.sortArray(evaluatedgames, evaluatedgames.size());
		for(int i = 0;i < evaluatedgames.size();i++) {
			if(evaluatedgames.get(i) instanceof CasualGame) {
				CasualGame game = (CasualGame)evaluatedgames.get(i);
				System.out.println("#" + game.getName() + ", " + (int)game.getRating());
			}
			else if(evaluatedgames.get(i) instanceof StoryGame) {
				StoryGame game = (StoryGame)evaluatedgames.get(i);
				System.out.println("#" + game.getName() + ", " + (int)game.getRating());
			}
			else if(evaluatedgames.get(i) instanceof IndefiniteGames) {
				IndefiniteGames game = (IndefiniteGames)evaluatedgames.get(i);
				System.out.println("#" + game.getName() + ", " + (int)game.getRating());
			}
		}
	}
	
	
	
	
	public void output() {
		System.out.println("1. day:");
		attendMovieCritic();
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("2.day:");
		setMoviestoWatch(ADTCreator.createMovieList(2)); //created second day movies
		setGamestoplay(ADTCreator.createGameList(2));	 //created second day games
		attendMovieCritic();
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("3.day");
		setMoviestoWatch(ADTCreator.createMovieList(3)); //created third day movies
		setGamestoplay(ADTCreator.createGameList(3));    //created third day games
		attendMovieCritic();
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("4.day");
		setMoviestoWatch(ADTCreator.createMovieList(4)); //created fourth day movies
		setGamestoplay(ADTCreator.createGameList(4));	 //created fourth day games
		attendMovieCritic();
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("5.day");
		setMoviestoWatch(ADTCreator.createMovieList(5)); //created fifth day movies
		setGamestoplay(ADTCreator.createGameList(5));    //created fifth day games
		attendMovieCritic();
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("6.day");                     //it is created for evaluated games in 6.day
		setGamestoplay(null);
		attendGames();
		System.out.println("************************************************************************************");
		System.out.println("Ratings:");
		outputevaluatedmovies();
		outputevaluatedgames();
	}
}
