package com.rest.tp1_rest.web.controller;

import com.rest.tp1_rest.dao.MovieDao;
import com.rest.tp1_rest.model.Cinema;
import com.rest.tp1_rest.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @Autowired

    private CircuitBreakerFactory circuitBreakerFactory;


    private MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping("/movies")

    public Iterable<Movie> listeDesMovies() {
        return movieDao.findAll();
    }

    @GetMapping("/movies/{id}")

    public Movie afficherUnMovie(@PathVariable int id) {
        return movieDao.findById(id).orElseThrow();

    }

    @DeleteMapping("/movies/{id}")

    public void supprimerUnMovie(@PathVariable int id) {
        movieDao.deleteById(id);
    }

    @PostMapping("/movies")

    public void ajouterUnMovie(@RequestBody Movie movie) {
        movieDao.save(movie);
    }



    //create a get request to get all cinema from another rest api
    @GetMapping("/cinemas")
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cinema");
        return circuitBreaker.run(() -> {
            RestTemplate restTemplate = new RestTemplate();
            List<Cinema> response = Arrays.stream(restTemplate.getForEntity("http://localhost:8000/api/cinemas", Cinema[].class).getBody()).toList();
            return ResponseEntity.ok(response);
        }, throwable -> {
            System.out.println(throwable.getMessage());
            return ResponseEntity.ok(new ArrayList<>());
        });
    }

    @GetMapping("/cinemas/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable int id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cinema");
        return circuitBreaker.run(() -> {
            RestTemplate restTemplate = new RestTemplate();
            Cinema response = restTemplate.getForEntity("http://localhost:8000/api/cinema/" + id, Cinema.class).getBody();
            return ResponseEntity.ok(response);
        }, throwable -> {
            System.out.println(throwable.getMessage());
            return ResponseEntity.ok(new Cinema());
        });
    }

    @GetMapping("/movie/{id}/cinema")
    public Movie getCinemaForMovie(@PathVariable int id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cinema");
        Movie movie = movieDao.findById(id).orElseThrow();
        int cineId = movie.getFirstProjectionCinema();
        return circuitBreaker.run(() -> {
            RestTemplate restTemplate = new RestTemplate();
            Cinema cinema = restTemplate.getForEntity("http://localhost:8000/api/cinema/" + cineId, Cinema.class).getBody();
            movie.setCinema(cinema);
            return movie;
        }, throwable -> {
            System.out.println(throwable.getMessage());
            return movie;
        });
    }






    /*@GetMapping(value = "/movie/1/firstprojectioncinema")
    public Cinema getFirstProjectionCinemaPerMovie(){
        //get the cinema of the first projection of the movie 1
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("default");
        return circuitBreaker.run(() -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Cinema> response = restTemplate.getForEntity("http://localhost:8000/api/cinema/1", Cinema.class);
            return response.getBody();
        }, throwable -> new Cinema());
*/
    //use circuit breaker to call the external API
        //CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        //String url = "http://localhost:8000/api/cinema/1";

        //RestTemplate restTemplate = new RestTemplate();
        //return circuitBreaker.run(() -> restTemplate.getForObject(url, Cinema.class), throwable -> new Cinema());

        /*RestTemplate restTemplate = new RestTemplate();
        String cinemaResourceUrl
                = "http://localhost:8000/api/cinema/1";
        ResponseEntity<Cinema> response
                = restTemplate.getForEntity(cinemaResourceUrl, Cinema.class);
        Cinema cinema = response.getBody();
        return cinema ;
        }   */



}









