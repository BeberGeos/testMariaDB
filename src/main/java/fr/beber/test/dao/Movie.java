package fr.beber.test.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * Class faisant référence à la table movie sur mariaDB.
 *
 * @author BLafage
 * @date 20/06/2014
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "director")
    private String director;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private int year;

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie(String director, String title, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}