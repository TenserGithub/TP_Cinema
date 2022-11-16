package com.rest.tp1_rest.model;
import java.io.Serializable;

public record Cinema(int id, String name, String town, String country) implements Serializable {
    public Cinema() {
        this(0, null, null, null);
    }

  /*private int id;
    private String name;
    private String town;
    private String country;

    public Cinema() {
    }



  public Cinema(int id, String name, String town, String country) {
    this.id = id;
    this.name = name;
    this.town = town;
    this.country = country;
  }

  @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name +
                ", town='" + town +
                ", country='" + country +
                '}';
    }*/}
