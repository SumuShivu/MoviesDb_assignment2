import service.MovieService;
import util.CSVLoader;



public class MovieApp {
    public static void main(String[] args) throws Exception {

        MovieService service = new MovieService(
                CSVLoader.loadMovies("data/movies.csv"),
                CSVLoader.loadActors("data/actors.csv"),
                CSVLoader.loadDirectors("data/directors.csv")
        );

        service.getMovieInfo(1025);

service.top10RatedMovies();

System.out.println("Movies by Director Tony Moreno:");
service.moviesByDirector("Tony Moreno");

System.out.println("Movies in Genre Action:");
service.moviesByGenre("Action");

System.out.println("Movies released in Year 2020:");
service.moviesByYear(2020);
       
service.deleteMovie(1);
service.getMovieInfo(1);
        
service.sortByReleaseYear();

System.out.println("Top 5 Directors with most movies:");
service.top5Directors();


System.out.println("The actor with most movies is:");
service.actorWithMostMovies();

        System.out.println("Youngest Actor's Movies:");
        service.youngestActorMovies();
}
    }

