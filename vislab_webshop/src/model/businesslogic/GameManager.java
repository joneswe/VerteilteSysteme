package model.businesslogic;

import model.database.Game;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.*;

public class GameManager {

    public Map<Integer, Game> getGamesList() {
        Map<Integer, Game> gamesList = new HashMap<>();

        String hql = "from Game G ORDER BY G.category.name ASC, G.title ASC ";

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Game> games = session.createQuery(hql).list();
        session.getTransaction().commit();

        for (Game game : games) {
            gamesList.put(game.getId(), game);
        }
        return gamesList;
    }

    public Game getGameById(String id) {
        int idInt = Integer.valueOf(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Game game = session.get(Game.class, idInt);
        session.getTransaction().commit();
        return game;
    }

    public Game getGameById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Game game = session.get(Game.class, id);
        session.getTransaction().commit();
        return game;
    }

    public void deleteGameById(String id) {
        int idInt = Integer.valueOf(id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Game game = session.load(Game.class, idInt);
        session.delete(game);
        session.getTransaction().commit();
    }

    public void saveOrUpdateGame(Game game) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(game);
        session.getTransaction().commit();
    }
}
