package com.example.Battleship.model;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        var manager = new GameManager();
        sce.getServletContext().setAttribute(GameManager.ATTR, manager);
        System.out.println("Battleship started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Battleship stopped");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("--- SESSION DESTROYED ---");
        var mgr = (GameManager) se.getSession().getServletContext().getAttribute(GameManager.ATTR);
        var game = (Game) se.getSession().getAttribute(Game.ATTR);
        var player = (Player) se.getSession().getAttribute(Player.ATTR);

        if (game == null || player == null) {
            return;
        }
        mgr.surrender(game, player);
    }
}
