package com.example.Battleship;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRegistration(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var playerName = request.getParameter("playerName");
        if(playerName == null || playerName.isBlank() || playerName.strip().length() < 3) {
            request.setAttribute("isPlayerNameIncorrect", true);
            doRegistration(request, response);
        }
        response.getWriter().println("REGISTERED");
    }

    private void doRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
}
