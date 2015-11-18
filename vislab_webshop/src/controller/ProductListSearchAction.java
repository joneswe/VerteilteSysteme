package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Customer;
import model.database.Game;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 16.11.2015.
 */
public class ProductListSearchAction extends ActionSupport implements SessionAware {

    private int priceMin = 0;
    private int priceMax = 0;
    private String categoryFilter = null;
    private String textSearch = null;
    private boolean isAdult;
    private String firstname;
    private String lastname;
    private boolean isAdmin;
    private Map<String, Object> session;

    private Map<Integer, Game> gamesList;
    private List<String> categoryList;

    public String execute() throws Exception {

        if(categoryFilter == null && textSearch == null && isAdult == false && priceMin == 0 && priceMax == 0) {
            return "input";
        }else{
            filterList();
            return "success";
        }

    }

    @Override
    public void validate() {
        Customer customer = ((Customer)session.get("user"));
        firstname = customer.getFirstname();
        lastname = customer.getLastname();
        isAdmin = customer.isAdmin();

        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());

        GameManager gameManager = new GameManager();
        setGamesList(gameManager.getGamesList());
    }

    /**
     * filter the gamesList with all constraints that have been set
     */
    private void filterList() {
        Map<Integer, Game> tmpMap = new HashMap<>();

        if (this.textSearch == null) {
            for (Map.Entry<Integer, Game> entry : getGamesList().entrySet()) {
                if (entry.getValue().getTitle().toLowerCase().contains(this.textSearch)) {
                    tmpMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.gamesList.clear();
            this.gamesList.putAll(tmpMap);
            tmpMap.clear();
        }

        if (this.categoryFilter != null) {
            List<String> categoryFilterList = Arrays.asList(this.categoryFilter.split("\\s*,\\s*"));

            for (Map.Entry<Integer, Game> entry : getGamesList().entrySet()) {
                if (categoryFilterList.contains((entry.getValue().getCategory().getName()))) {
                    tmpMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.gamesList.clear();
            this.gamesList.putAll(tmpMap);
            tmpMap.clear();
        }

        if (this.isAdult) {
            for (Map.Entry<Integer, Game> entry : getGamesList().entrySet()) {
                if (entry.getValue().isAdult()) {
                    tmpMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.gamesList.clear();
            this.gamesList.putAll(tmpMap);
            tmpMap.clear();
        }

        if (this.priceMax != 0) {
            for (Map.Entry<Integer, Game> entry : getGamesList().entrySet()) {
                if (entry.getValue().getPrice() >= this.priceMin && entry.getValue().getPrice() <= this.priceMax) {
                    tmpMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.gamesList.clear();
            this.gamesList.putAll(tmpMap);
            tmpMap.clear();
        }
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    public String getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
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
