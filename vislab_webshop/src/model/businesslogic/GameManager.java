package model.businesslogic;

import model.database.Game;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by Tim on 15.11.2015.
 */
public class GameManager {

    public Map<Integer, Game> getGamesList(){
        Map<Integer, Game> gamesList = new HashMap<>();

        String hql ="from Game G ORDER BY G.category.name ASC, G.title ASC ";

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Game> games = session.createQuery(hql).list();
        session.getTransaction().commit();

        for(Game game: games){
            gamesList.put(game.getId(), game);
        }


       return gamesList;
    }

    public Game getGameByPrimaryKey(String primaryKey){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String hql="from Game G WHERE G.title ='Battlefront'";
        List<Game> list = session.createQuery(hql).list();


        session.getTransaction().commit();
        return list.get(0);
    }
}
