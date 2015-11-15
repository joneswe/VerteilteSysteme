package model.database;

import javax.persistence.*;

/**
 * Created by Tim on 14.11.2015.
 */
@Entity
@Table(name="GAME")
public class Game implements java.io.Serializable{

    @Id @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="genre")
    private String genre;

    @Column(name="price")
    private double price;

    @Column(name="publisher")
    private String publisher;

    @Column(name="system")
    private String system;

    public Game(){

    }

    public Game(String title, String genre, double price, String publisher, String system) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publisher = publisher;
        this.system = system;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "{" + this.title + ", " + this.genre + ", " + this.publisher + ", " + this.price + "}";
    }
}
