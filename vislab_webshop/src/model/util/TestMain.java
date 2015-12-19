package model.util;

import model.businesslogic.CategoryManager;
import model.businesslogic.GameManager;

public class TestMain {

    public static void main(String[] args) {

        GameManager gameManager = new GameManager();
        System.out.println(gameManager.getGameById("1").getTitle());
    }
}
