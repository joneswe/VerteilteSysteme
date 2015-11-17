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

        if("Hinzufügen".equals(buttonName)){
            if(!(newCategoryName.isEmpty())) {
                categoryManager.saveCategory(newCategoryName);
                setCategoryList(categoryManager.getCategoryList());

                addActionMessage(getText("admin.category_saved"));

            }else{
                addActionError(getText("admin.category_empty"));
            }
        }
        if("Löschen".equals(buttonName)){
            categoryManager.deleteCategoryById(categoryName);
            setCategoryList(categoryManager.getCategoryList());

            addActionMessage(getText("admin.category_deleted"));
        }

        return "success";
    }

    @Override
    public void validate() {
        CategoryManager categoryManager = new CategoryManager();
        setCategoryList(categoryManager.getCategoryList());
        System.out.println(categoryName);
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
}
