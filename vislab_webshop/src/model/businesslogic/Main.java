package model.businesslogic;

import model.database.Customer;

/**
 * Created by Tim on 13.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        GameManager mngr = new GameManager();
        System.out.println(mngr.getGameList().get(0).toString());


    }
}
