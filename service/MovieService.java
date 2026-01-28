package service;

import model.*;


import java.util.*;


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
}
