import java.util.ArrayList;
public class ContentRatingCompanySimulator {
	public static void main(String[] args) {
		ArrayList<Movie> movielist = ADTCreator.createMovieList(1); //created first day movies
		ArrayList<IGame> gamelist = ADTCreator.createGameList(1); //created first day games
		CriticQueue<MovieCritic> moviecritics = ADTCreator.createMovieCriticQueue(); //created queue
		CriticQueue<GameCritic> gamecritics = ADTCreator.createGameCriticQueue(); //created game
		Company company = new Company(movielist,gamelist,moviecritics,gamecritics);
		
		company.output();
		
	}
}
