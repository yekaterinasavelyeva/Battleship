package com.example.Battleship;

import com.example.Battleship.model.Game;
import com.example.Battleship.model.GameManager;
import com.example.Battleship.model.GameStatus;
import com.example.Battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var playerName = request.getParameter("playerName");
        if (playerName == null || playerName.isBlank() || playerName.strip().length() < 3) {
            request.setAttribute("isPlayerNameIncorrect", true);
            doRegistration(request, response);
        } else {
            var player = new Player(playerName);
            var manager = (GameManager) request.getServletContext().getAttribute(GameManager.ATTR);
            var game = manager.join(player);
            request.getSession().setAttribute(Player.ATTR, player);
            request.getSession().setAttribute(Game.ATTR, game);
            openNext(request, response);
        }

    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        if (game == null) {
            doRegistration(request, response);
        } else if (game.getStatus() == GameStatus.INCOMPLETE) {
            openRegistrationAwait(request, response);
        } else {
            openPlacement(request, response);
        }
     }

    private void openPlacement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("placement");
    }

    private void openRegistrationAwait(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration-await.jsp").forward(request, response);
    }

    private void doRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
}
