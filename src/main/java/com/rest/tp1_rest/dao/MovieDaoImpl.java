/*
package com.rest.tp1_rest.dao;

import com.rest.tp1_rest.model.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Component
public class MovieDaoImpl implements MovieDao{
    public static List<Movie> movies = new ArrayList<>();

    static {
        movies.add(new Movie(1, "The Shawshank Redemption", 1994));
        movies.add(new Movie(2, "The Godfather", 1972));
        movies.add(new Movie(3, "The Godfather: Part II", 1974));
        movies.add(new Movie(4, "The Dark Knight", 2008));
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Movie findById(int id) {
        for (Movie movie : movies){
            if (movie.getId() == id){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie save(Movie movie) {
        movies.add(movie);
        return movie;
    }
}
*/
