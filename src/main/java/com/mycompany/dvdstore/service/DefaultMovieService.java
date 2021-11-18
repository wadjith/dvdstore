package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieServiceInterface {
    @Autowired
    private MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public Movie registerMovie(Movie movie) {
        return movieRepositoryInterface.save(movie);
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepositoryInterface.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie = movieRepositoryInterface.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie = optionalMovie.get();
        //Initialize proxys
        movie.getMainActor().getFirstName();
        movie.getReviews().forEach(review -> {
            review.getMark();
            review.setMovie(null);
        });
        //

        return movie;
    }
}
