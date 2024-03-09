package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;

import java.util.*;

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    private MovieJpaRepository movieJpaRepository;

    @Override
    public ArrayList<Movie> getMovies() {
        List<Movie> getMovies = movieJpaRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(getMovies);
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        try {
            return movieJpaRepository.findById(movieId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieJpaRepository.save(movie);
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie updatedMovie = movieJpaRepository.findById(movieId).get();

            if (updatedMovie.getMovieName() != null) {
                updatedMovie.setMovieName(movie.getMovieName());
            }
            if (updatedMovie.getLeadActor() != null) {
                updatedMovie.setLeadActor(movie.getLeadActor());
            }

            movieJpaRepository.save(updatedMovie);
            return updatedMovie;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            movieJpaRepository.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}