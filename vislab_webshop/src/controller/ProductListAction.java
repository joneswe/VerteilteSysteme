package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Game;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 15.11.2015.
 */
public class ProductListAction extends ActionSupport {

    private Map<Integer, Game> gamesList;
    private String firstname ="test";
    private String lastname="test";
    private List<String> categoryList;

    public String execute() throws Exception {
        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());

        GameManager gameManager = new GameManager();
        setGamesList(gameManager.getGamesList());



        return SUCCESS;
    }

    public Map<Integer, Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(Map<Integer, Game> gamesList) {
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

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
}
