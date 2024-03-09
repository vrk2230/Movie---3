package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

import java.util.*;

@RestController
public class MovieController {

    @Autowired
    private MovieJpaService movieJpaService;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieJpaService.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return movieJpaService.getMovieById(movieId);
    }

    @PostMapping("movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieJpaService.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updatMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return movieJpaService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieJpaService.deleteMovie(movieId);
    }
}