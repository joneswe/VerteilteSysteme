package model.database;

import javax.persistence.*;

/**
 * Created by Tim on 14.11.2015.
 */
@Entity
@Table(name="GAME")
public class Game implements java.io.Serializable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JoinColumn(name="category")
    private Category category;

    @Column(name="price")
    private int price;

    @Column(name="isAdult")
    private boolean isAdult;

    @Column(name="description")
    private String description;

    @Column(name="url")
    private String url;

    public Game(){

    }

    public Game(String title, Category category, int price, boolean isAdult, String description, String url) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.isAdult = isAdult;
        this.description = description;
        this.url = url;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" + this.title + ", " + this.price + "}";
    }
}
