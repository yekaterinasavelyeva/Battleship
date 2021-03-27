package com.example.Battleship;

import com.example.Battleship.model.Game;
import com.example.Battleship.model.GameManager;
import com.example.Battleship.model.GameStatus;
import com.example.Battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FinishServlet", urlPatterns = "/finish")
public class FinishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        restartTheGame(request, response);
    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        if (player.hasShipsLeft()) {
            openWinner(request, response);
        } else {
            openLooser(request, response);
        }
    }

    private void restartTheGame(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        player.reset();
        var manager = (GameManager) request.getServletContext().getAttribute(GameManager.ATTR);
        var game = manager.join(player);
        request.getSession().setAttribute(Player.ATTR, player);
        request.getSession().setAttribute(Game.ATTR, game);
        response.sendRedirect("registration");
    }

    private void openLooser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/finish-looser.jsp").forward(request, response);
    }

    private void openWinner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/finish-winner.jsp").forward(request, response);
    }
}
