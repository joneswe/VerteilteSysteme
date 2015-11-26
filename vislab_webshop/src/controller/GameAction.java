package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Game;
import org.apache.struts2.interceptor.SessionAware;

import java.awt.*;
import java.util.*;

/**
 * Created by Tim on 18.11.2015.
 */
public class GameAction extends ActionSupport implements SessionAware {

    private Game game;
    private String id;
    private String buttonName;
    private Map<Integer, Game> gamesList;

    private Map<String, Object> session;

    public String execute() {
        GameManager manager = new GameManager();

        if ("Löschen".equals(buttonName)) {
            //delete game with the id of the game which was chosen in the droplist
            manager.deleteGameById(id);
            setGamesList(manager.getGamesList());
            addActionMessage(getText("admin.game_deleted"));
        }

        if ("Bearbeiten".equals(buttonName)) {
            //continue with GameEditAction
            return "edit";
        }

        if ("Hinzufügen".equals(buttonName)) {
            //continue with GameSaveAction
            return "add";
        }


        return "success";
    }

    @Override
    public void validate() {
        GameManager gameManager = new GameManager();
        setGamesList(gameManager.getGamesList());
    }


    public Game getGame() {
        return game;
    }

    public void setGameName(Game game) {
        this.game = game;
    }


    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Map<Integer, Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(Map<Integer, Game> gamesList) {
        this.gamesList = gamesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
