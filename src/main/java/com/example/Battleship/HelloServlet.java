package com.example.Battleship;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var out = resp.getWriter();

        var name = "name";
        var userName = req.getParameter(name);
        if (userName == null || userName.isBlank()) {
            userName = "World";
        }
        out.println(String.format("Hello, %s!", userName));
        req.setAttribute("name", userName);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}
