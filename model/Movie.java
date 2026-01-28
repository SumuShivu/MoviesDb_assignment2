package model;

import java.util.List;

public class Movie {
    private int movieId;
    private String title;
    private int releaseYear;
    private String genre;
    private double rating;
    private int directorId;
    private List<Integer> actorIds;
    

    public Movie(int movieId, String title, int releaseYear, String genre,
                 double rating, int directorId,
                 List<Integer> actorIds ) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.actorIds = actorIds;
        this.directorId = directorId;
    }

    public int getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public int getReleaseYear() { return releaseYear; }
    public double getRating() { return rating; }
    public String getGenre() { return genre; }
    public List<Integer> getActorIds() { return actorIds; }
    public int getDirectorId() { return directorId; }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie ID: " + movieId +
                ", Title: " + title +
                ", Year: " + releaseYear +
                ", Rating: " + rating +
                ", Genre: " + genre;
    }
}
