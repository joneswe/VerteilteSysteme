package model.businesslogic;

import model.database.Category;
import model.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 16.11.2015.
 */
public class CategoryManager {

    public List<String> getCategoryList(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql ="from Category C ORDER BY C.name ASC";

        List<Category> categories = session.createQuery(hql).list();
        session.getTransaction().commit();

        List<String> categoryList = new ArrayList<>();
        for (Category category : categories) {
            categoryList.add(category.getName());
        }

        return categoryList;
    }
}
