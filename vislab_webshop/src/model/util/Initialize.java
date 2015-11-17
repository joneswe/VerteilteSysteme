package model.util;

import model.database.Category;
import model.database.Customer;
import model.database.Game;
import model.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 13.11.2015.
 */
public class Initialize {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Category action = new Category("Action");
        Category shooter = new Category("Shooter");
        Category roleplay = new Category("Roleplay");
        Category sports = new Category("Sports");

//        session.beginTransaction();
//        session.save(action);
//        session.save(shooter);
//        session.save(roleplay);
//        session.save(sports);
//        session.getTransaction().commit();


        List<Game> games = new ArrayList<>();
        games.add(new Game("Battlefront", shooter, 70, true, "nice game", null));
        games.add(new Game("Need for Speed", sports, 70, false, "nice game", null));
        games.add(new Game("Grand Theft Auto V", action, 70, true, "nice game", null));
        games.add(new Game("Fifa 16", sports, 60, false, "nice game", null));
        games.add(new Game("Fallout 4", roleplay, 80, true, "nice game", null));
        games.add(new Game("The Witcher 3", roleplay, 50, true, "nice game", null));
        games.add(new Game("Skyrim", roleplay, 20, false, "nice game", null));
        games.add(new Game("Call of Duty Black Ops 3", shooter, 70, true, "nice game", null));


        session.beginTransaction();
        for (Game game: games){
            session.save(game);
        }
        session.getTransaction().commit();
    }
}
