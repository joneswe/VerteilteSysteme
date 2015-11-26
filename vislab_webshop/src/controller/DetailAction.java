package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.GameManager;
import model.database.Game;

public class DetailAction extends ActionSupport {

    private int gameId;
    private Game game;

    public String execute() {

        //set game by gameId to show the right game
        GameManager manager = new GameManager();
        game = manager.getGameById(gameId);

        return "success";
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
