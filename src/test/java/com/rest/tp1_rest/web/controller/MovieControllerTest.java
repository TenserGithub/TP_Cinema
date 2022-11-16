package com.rest.tp1_rest.web.controller;

import com.rest.tp1_rest.model.Movie;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

class MovieControllerTest {

    @Test
    void TestGetFirstMovie() {
        RestAssured.get("http://localhost:8080/movies/1").
                then().
                assertThat().
                body("id", equalTo(1)).
                body("title", equalTo("The Shawshank Redemption")).
                body("years", equalTo(1994));
    }


    @Test
    void updateMovieBadFormat() {
        Movie movie = new Movie(1000, "test", 2000, 1);
        RestAssured.given()
                .contentType("application/json")
                .body(movie)
                .when()
                .put("http://localhost:8080/movies/1")
                .then()
                .statusCode(405);
    }







}