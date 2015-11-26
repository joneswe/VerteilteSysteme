package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Customer;
import model.database.Game;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 15.11.2015.
 */
public class ProductListAction extends ActionSupport implements SessionAware {

    private Map<Integer, Game> gamesList;
    private String firstname;
    private String lastname;
    private boolean isAdmin;
    private List<String> categoryList;

    private Map<String, Object> session;

    public String execute() throws Exception {
        //get category list from categories on database to show in droplist
        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());

        //get game list from games on database to show all games available
        GameManager gameManager = new GameManager();
        setGamesList(gameManager.getGamesList());

        //get user from current session to show welcome text
        Customer customer = ((Customer) session.get("user"));
        firstname = customer.getFirstname();
        lastname = customer.getLastname();
        isAdmin = customer.isAdmin();

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
