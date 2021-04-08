package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static List<Movie> movies = new ArrayList<>();
    private static long id;

    public Movie save(Movie movie) {
        movie.setId(++id);
        movies.add(movie);
        System.out.println("The movie "+movie.getId()+"- "+movie.getTitle()+" has been added.");
        return movie;
    }

    /*
    @Override
    public List<Movie> list() {
        return movies;
    }
     */

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long id) {

        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
