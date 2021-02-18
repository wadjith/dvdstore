package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static List<Movie> movies = new ArrayList<>();
    private static long id;

    public Movie add(Movie movie) {
        movie.setId(++id);
        movies.add(movie);
        System.out.println("The movie "+movie.getId()+"- "+movie.getTitle()+" has been added.");
        return movie;
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(Long id) {
        return movies.stream().filter(m -> m.getId()==id).findFirst().get();
    }
}
