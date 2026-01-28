package util;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

public class CSVLoader {

    public static Map<Integer, Movie> loadMovies(String path) throws Exception {
        Map<Integer, Movie> movies = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine(); // skip header

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            int id = Integer.parseInt(d[0]);
            String title = d[1];
            int year = Integer.parseInt(d[2]);
            String genre=d[3];
            double rating = Double.parseDouble(d[4]);
            int directorId=Integer.parseInt(d[5]);
            List<Integer> actorIds = new ArrayList<>();
            for (String a : d[6].split("\\|")) {
                actorIds.add(Integer.parseInt(a));
            }

            

            movies.put(id, new Movie(id, title, year, genre, rating, directorId, actorIds));
        }
        br.close();
        return movies;
    }

    public static Map<Integer, Actor> loadActors(String path) throws Exception {
        Map<Integer, Actor> actors = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            actors.put(
                    Integer.parseInt(d[0]),
                    new Actor(Integer.parseInt(d[0]), d[1], LocalDate.parse(d[2]))
            );
        }
        br.close();
        return actors;
    }

    public static Map<Integer, Director> loadDirectors(String path) throws Exception {
        Map<Integer, Director> directors = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            directors.put(
                    Integer.parseInt(d[0]),
                    new Director(Integer.parseInt(d[0]), d[1])
            );
        }
        br.close();
        return directors;
    }
}
