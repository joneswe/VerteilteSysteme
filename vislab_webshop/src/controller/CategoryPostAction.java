package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class CategoryPostAction extends ActionSupport implements SessionAware {
    String categoryName;
    String newCategoryName;
    private Map<String, Object> session;


    public String execute() {
        //grab specified category and new name from session to update it
        categoryName = (String) session.get("cat");
        newCategoryName = (String) session.get("newCat");

        CategoryManager categoryManager = new CategoryManager();

        categoryManager.updateCategory(this.categoryName, this.newCategoryName);

        return "success";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNewCategoryName() {
        return newCategoryName;
    }

    public void setNewCategoryName(String newCategoryName) {
        this.newCategoryName = newCategoryName;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
