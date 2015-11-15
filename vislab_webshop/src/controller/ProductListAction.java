package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.GameManager;
import model.database.Game;

import java.util.List;

/**
 * Created by Tim on 15.11.2015.
 */
public class ProductListAction extends ActionSupport {

    private List<Game> gamesList;
    private String firstname ="hi";
    private String lastname="ne";

    public String execute() throws Exception {

        GameManager gameManager = new GameManager();
        this.gamesList = gameManager.getGameList();

        System.out.println(this.gamesList);

        return SUCCESS;
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
