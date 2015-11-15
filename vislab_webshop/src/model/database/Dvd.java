package model.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tim on 14.11.2015.
 */
@Entity
@Table(name="DVD")
public class Dvd implements java.io.Serializable{

    @Id
    @Column(name="titel", nullable=false)
    private String titel;

    @Column(name="genre")
    private String genre;

    @Column(name="preis")
    private double preis;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
