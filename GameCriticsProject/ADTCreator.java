import java.util.ArrayList;
import java.util.List;
/* This class is used to create movies to watch and games to play that day. 
 * Here, the j parameter is evaluated in days.*/
public class ADTCreator {
	public static ArrayList<Content> createObjects(){ //In there all objects are created an added in list.
		ArrayList<String> myarraylist = FileIO.FileReader("C://Users//X550V//Desktop//homework3//contents.csv");
		ArrayList<Content> contentlist = new ArrayList<>();
		for(int i = 0;i < myarraylist.size();i++) {
			String[] line = myarraylist.get(i).split(",");
			try {
				if(line[1].equals("0")) {
					double arrivaldays = Double.parseDouble(line[0]);
					double number = Double.parseDouble(line[1]);
					String name = line[2];
					double year = Double.parseDouble(line[3]);
					double duration = Double.parseDouble(line[4]);
					double averageRating = Double.parseDouble(line[5]);
					Content movie = new Movie(arrivaldays,number,name,averageRating,duration,year);
					contentlist.add(movie);
					
					
				}
				else if(line[1].equals("1")) {
					double arrivaldays = Double.parseDouble(line[0]);
					double number = Double.parseDouble(line[1]);
					String name = line[2];
					Double evalutiontime = Double.parseDouble(line[3]);
					Double averageRating = Double.parseDouble(line[4]);
					Content IndefiniteGame = new IndefiniteGames(arrivaldays,number,name,averageRating,evalutiontime);
					contentlist.add(IndefiniteGame);
					
				}
				else if(line[1].equals("2")) {
					double arrivaldays = Double.parseDouble(line[0]);
					double number = Double.parseDouble(line[1]);
					String name = line[2];
					double storyDuration = Double.parseDouble(line[3]);
					double averageRating = Double.parseDouble(line[4]);
					Content storygame = new StoryGame(arrivaldays,number,name,averageRating,storyDuration);
					contentlist.add(storygame);
					
				}
				else if(line[1].equals("3")) {
					double arrivaldays = Double.parseDouble(line[0]);
					double number = Double.parseDouble(line[1]);
					String name = line[2];
					double matchDuration = Double.parseDouble(line[3]);
					double averageRating = Double.parseDouble(line[4]);
					Content casualgame = new CasualGame(arrivaldays,number,name,averageRating,matchDuration);
					contentlist.add(casualgame);
				}	
			}catch(ArrayIndexOutOfBoundsException e) {
				return contentlist;
			}
	}
		return contentlist;
	
	}
	public static ArrayList<Movie> createMovieList(int j) {
		ArrayList<Content> contentlist = createObjects();
		ArrayList<Movie> moviestowatch = new ArrayList<>();
		for(int i = 0;i < contentlist.size();i++) {
			if(contentlist.get(i).getArrivalDay() == j) {
				if(contentlist.get(i).getNumber() == 0) {
					Movie movie = (Movie)contentlist.get(i);
					moviestowatch.add(movie);
				}
			}
		}
		return moviestowatch;
	}
	public static ArrayList<IGame> createGameList(int j){
		ArrayList<Content> contentlist = createObjects();
		ArrayList<IGame> gamestowatch = new ArrayList<>();
		for(int i = 0;i < contentlist.size();i++) {
			if(contentlist.get(i).getNumber() == 1 || contentlist.get(i).getNumber() == 2 || 
					contentlist.get(i).getNumber() == 3) {
				if(contentlist.get(i).getArrivalDay() == j) {
					IGame game = (IGame)contentlist.get(i);
					gamestowatch.add(game);
				}
			}
		}
		return gamestowatch;
	}
	public static CriticQueue<MovieCritic> createMovieCriticQueue() {
		CriticQueue<MovieCritic> moviecriticQueue = new CriticQueue<>();
		moviecriticQueue.enqueue(new MovieCritic(0.1,1));
		moviecriticQueue.enqueue(new MovieCritic(-0.2,2));
		moviecriticQueue.enqueue(new MovieCritic(0.3,3));
		
		return moviecriticQueue;

	}
	public static CriticQueue<GameCritic> createGameCriticQueue(){
		CriticQueue<GameCritic> gamecriticQueue = new CriticQueue<>();
		GameCritic critic1 = new GameCritic(5,1);
		gamecriticQueue.enqueue(critic1);
		gamecriticQueue.enqueue(new GameCritic(9,2));
		gamecriticQueue.enqueue(new GameCritic(-3,3));
		gamecriticQueue.enqueue(new GameCritic(2,4));
		gamecriticQueue.enqueue(new GameCritic(-7,5));
		return gamecriticQueue;
	}
}
