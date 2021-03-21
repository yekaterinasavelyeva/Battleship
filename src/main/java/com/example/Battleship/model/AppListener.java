package com.example.Battleship.model;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var manager = new GameManager();
        sce.getServletContext().setAttribute(GameManager.ATTR, manager);
        System.out.println("Battleship started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Battleship stopped");
    }
}
