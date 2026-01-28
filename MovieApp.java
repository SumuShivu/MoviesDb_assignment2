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
        }
        
   
    }

