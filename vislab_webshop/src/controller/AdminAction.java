package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;

import java.util.List;

/**
 * Created by Tim on 17.11.2015.
 */
public class AdminAction extends ActionSupport {

    private List<String> categoryList;

    public String execute() throws Exception {

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
}
