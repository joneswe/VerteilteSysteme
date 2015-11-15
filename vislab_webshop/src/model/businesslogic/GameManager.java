package model.businesslogic;

import model.database.Game;
import model.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 15.11.2015.
 */
public class GameManager {

    public List<Game> getGameList(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql ="from Game G ORDER BY G.genre ASC, G.title ASC ";

        List<Game> games = session.createQuery(hql).list();
        session.getTransaction().commit();

       return games;
    }
}
