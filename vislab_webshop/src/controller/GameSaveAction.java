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
public class GameSaveAction extends ActionSupport implements SessionAware {
    private Game game;
    private List<String> categoryList;
    private String categoryName;

    private Map<String, Object> session;


    public String execute() {

        //update the categoryList
        CategoryManager categoryManager = new CategoryManager();
        categoryList = categoryManager.getCategoryList();


        return "success";
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
