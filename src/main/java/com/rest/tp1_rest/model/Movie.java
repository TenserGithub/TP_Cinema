package com.rest.tp1_rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Movie {
    @Id
    private int id;
    private String title;
    private int years;

    private int firstProjectionCinema;

    public void setId(int id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Transient
    private Cinema cinema;
    public Movie(int id, String title, int years, int firstProjectionCinema) {
        this.id = id;
        this.title = title;
        this.years = years;
        this.firstProjectionCinema = firstProjectionCinema;
    }

    public Movie() {

    }

/*
    public Movie(int id, String title, int years) {
        this.id = id;
        this.title = title;
        this.years = years;
    }

    public Movie() {

    }
*/
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

   public int getFirstProjectionCinema() {
        return firstProjectionCinema;
    }

 public void setFirstProjectionCinema(int id) {
        this.firstProjectionCinema = id;
    }


/*    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title +
                ", years='" + years +
                ", First projection cinema='" + firstProjectionCinema +
                '}';
    }
*/
@Override
public String toString() {
    return "Movie{" +
            "id=" + id +
            ", title='" + title +
            ", years='" + years +
            ", First projection cinema='" + firstProjectionCinema +
            '}';
}
}

