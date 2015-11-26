package controller;

import com.opensymphony.xwork2.ActionSupport;
import interceptor.SecureAction;
import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;
import model.database.Game;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 17.11.2015.
 */
public class AdminCategoriesAction extends ActionSupport implements SecureAction {

    private List<String> categoryList;

    public String execute() throws Exception {

        //set categoryList to show it in admin_panel_categories.jsp
        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());

        return "success";
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String requiresRole() {
        return "admin";
    }
}
