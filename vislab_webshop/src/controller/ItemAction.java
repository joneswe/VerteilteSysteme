package controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Tim on 14.11.2015.
 */
public class ItemAction extends ActionSupport {

    private String titel = null;
    private String genre = null;
    private double preis = 0;

    public String searchItem(){
        //search
        return "Hi";
    }

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
