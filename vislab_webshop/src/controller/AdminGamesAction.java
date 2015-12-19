package controller;

import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Game;

import java.util.Map;


public class AdminGamesAction {

    private Map<Integer, Game> gamesList;

    public String execute() throws Exception {

        //set gamesList to show it in admin_panel_games.jsp
        GameManager gameManager = new GameManager();
        gamesList = gameManager.getGamesList();
        return "success";
    }

    public Map<Integer, Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(Map<Integer, Game> gamesList) {
        this.gamesList = gamesList;
    }
}
