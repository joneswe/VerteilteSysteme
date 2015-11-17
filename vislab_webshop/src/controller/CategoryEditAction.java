package controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Tim on 17.11.2015.
 */
public class CategoryEditAction extends ActionSupport {

    String selectedCategory;
    String categoryName;

    public String execute(){
        System.out.println(categoryName);
        System.out.println(selectedCategory);

        return "success";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
