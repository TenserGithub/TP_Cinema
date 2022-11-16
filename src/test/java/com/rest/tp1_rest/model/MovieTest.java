package com.rest.tp1_rest.model;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

        @org.junit.jupiter.api.Test
        void getId() {
            Movie movie = new Movie(1, "test", 2000, 1);
            assertEquals(1, movie.getId());
        }

        @org.junit.jupiter.api.Test
        void getTitle() {
            Movie movie = new Movie(1, "test", 2000, 1);
            assertEquals("test", movie.getTitle());
        }

        @org.junit.jupiter.api.Test
        void setTitle() {
            Movie movie = new Movie(1, "test", 2000, 1);
            movie.setTitle("test2");
            assertEquals("test2", movie.getTitle());
        }

        @org.junit.jupiter.api.Test
        void getYears() {
            Movie movie = new Movie(1, "test", 2000, 1);
            assertEquals(2000, movie.getYears());
        }

        @org.junit.jupiter.api.Test
        void setYears() {
            Movie movie = new Movie(1, "test", 2000, 1);
            movie.setYears(2001);
            assertEquals(2001, movie.getYears());
        }

        @org.junit.jupiter.api.Test
        void testToString() {
            Movie movie = new Movie(1, "test", 2000, 1);
            assertEquals("Movie{id=1, title=test, years=2000, firstProjectionCinema=1}", movie.toString());
        }

}