package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Game;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 18.11.2015.
 */
public class GameEditAction extends ActionSupport implements SessionAware {
    private String id;
    private Game game;
    private List<String> categoryList;
    private String categoryName;

    private Map<String, Object> session;


    public String execute() {

        GameManager gameManager = new GameManager();
        game = gameManager.getGameById(id);

        CategoryManager categoryManager = new CategoryManager();
        categoryList = categoryManager.getCategoryList();

        //save id in session to access it later in editGame()
        session.put("id", id);

        return "success";
    }

    public String editGame() {

        GameManager gameManager = new GameManager();
        //set id the same as the game that will be updated (in the case of saving, there's no id in the session)
        if (session.get("id") != null) {
            game.setId(Integer.valueOf((String) session.get("id")));
            session.remove("id");
        }
        gameManager.saveOrUpdateGame(game);

        return "success";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
