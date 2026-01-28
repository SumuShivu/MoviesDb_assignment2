package service;

import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class MovieService {

    private Map<Integer, Movie> movies;
    private Map<Integer, Actor> actors;
    private Map<Integer, Director> directors;

    public MovieService(Map<Integer, Movie> movies,
                        Map<Integer, Actor> actors,
                        Map<Integer, Director> directors) {
        this.movies = movies;
        this.actors = actors;
        this.directors = directors;
    }
public void getMovieInfo(int input) {
    Movie movie = movies.get(input);

    if (movie == null) {
        System.out.println("Movie not found");
        return;
    }

    System.out.println(movie);
    System.out.println("Director: " + directors.get(movie.getDirectorId()).getName());

    System.out.println("Actors:");
    for (int id : movie.getActorIds()) {
        System.out.println(" - " + actors.get(id).getName());
    }
}

public void top10RatedMovies() {
        movies.values().stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    public void moviesByDirector(String name) {
    Optional<Director> directorOpt = directors.values().stream()
            .filter(d -> d.getName().trim().equalsIgnoreCase(name.trim()))
            .findFirst();

    if (directorOpt.isEmpty()) {
        System.out.println("Director not found");
        return;
    }

    Director d = directorOpt.get();

    boolean found = false;
    for (Movie m : movies.values()) {
        if (m.getDirectorId() == d.getDirectorId()) {
            System.out.println(m);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No movies found for this director");
    }
}

  public void moviesByGenre(String genre) {
        movies.values().stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .forEach(System.out::println);
    }

      public void moviesByYear(int year) {
        movies.values().stream()
                .filter(m -> m.getReleaseYear() == year)
                .forEach(System.out::println);
    }

      public void deleteMovie(int movieId) {
        movies.remove(movieId);
        System.out.println("Movie deleted");
    }

    public void sortByReleaseYear() {
        movies.values().stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear))
                .limit(15)
                .forEach(System.out::println);
    }

    public void top5Directors() {
        Map<Integer, Long> count =
                movies.values().stream()
                        .collect(Collectors.groupingBy(
                                Movie::getDirectorId, Collectors.counting()));

                                 count.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(e ->
                        System.out.println(
                                directors.get(e.getKey()).getName() + " : " + e.getValue()));
    }

     public void actorWithMostMovies() {
        Map<Integer, Long> count = new HashMap<>();

        for (Movie m : movies.values()) {
            for (int a : m.getActorIds()) {
                count.put(a, count.getOrDefault(a, 0L) + 1);
            }
        }

        count.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println(
                                actors.get(e.getKey()).getName() + " : " + e.getValue()));
    }

     public void youngestActorMovies() {
        LocalDate ref = LocalDate.of(2025, 2, 10);

        Actor youngest = actors.values().stream()
                .max(Comparator.comparing(Actor::getDob))
                .orElse(null);

        if (youngest == null) return;

        System.out.println("Youngest Actor: " + youngest.getName());
        System.out.println("Age: " + youngest.getAge(ref));

        movies.values().stream()
                .filter(m -> m.getActorIds().contains(youngest.getActorId()))
                .forEach(System.out::println);
    }
}
