package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CategoryManager;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 17.11.2015.
 */
public class CategoryAction extends ActionSupport implements SessionAware {

    private List<String> categoryList;
    private String categoryName;
    private String newCategoryName;
    private String buttonName;

    private Map<String, Object> session;


    public String execute() throws Exception {
        CategoryManager categoryManager = new CategoryManager();

        //check, which button was pressed
        if ("Hinzufügen".equals(buttonName)) {
            //check, if input is empty
            if (!(newCategoryName.isEmpty())) {
                //check, if specified category already exists
                if (categoryList.contains(newCategoryName)) {
                    addActionError(getText("admin.category_exists"));
                } else {
                    //if all checks are passed, save new categoryName on database and refresh categoryList
                    categoryManager.saveCategory(newCategoryName);
                    setCategoryList(categoryManager.getCategoryList());

                    addActionMessage(getText("admin.category_saved"));
                }
            } else {
                addActionError(getText("admin.category_empty"));
            }
        }

        if ("Löschen".equals(buttonName)) {
            //delete specified category
            categoryManager.deleteCategoryById(categoryName);
            setCategoryList(categoryManager.getCategoryList());

            addActionMessage(getText("admin.category_deleted"));
        }

        if ("Bearbeiten".equals(buttonName)) {
            //go to next action CategoryEditAction
            return "edit";
        }

        return "success";
    }

    @Override
    public void validate() {
        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());
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

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
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

    public String edit() throws Exception {
        return "success";
    }
}
