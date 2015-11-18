package model.businesslogic;

import model.database.Category;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 16.11.2015.
 */
public class CategoryManager {

    public List<String> getCategoryList(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        String hql ="from Category C ORDER BY C.name ASC";
        session.beginTransaction();
        List<Category> categories = session.createQuery(hql).list();
        session.getTransaction().commit();

        List<String> categoryList = new ArrayList<>();
        for (Category category : categories) {
            categoryList.add(category.getName());
        }

        return categoryList;
    }

    public void saveCategory(String name){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Category category = new Category(name);
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    public void deleteCategoryById(String id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = (Category)session.load(Category.class,id);
        session.delete(category);
        session.getTransaction().commit();
    }

    public void updateCategory(String id, String newId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql="update Category C set name = :newId where name = :id ";
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setString("newId", newId);
        query.setString("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
