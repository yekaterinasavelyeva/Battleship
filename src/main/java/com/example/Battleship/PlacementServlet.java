package com.example.Battleship;

import com.example.Battleship.model.Game;
import com.example.Battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

@WebServlet(name = "PlacementServlet", urlPatterns = "/placement")
public class PlacementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var addresses = request.getParameterValues("addr");
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        player.getPlayerField().clear();
        if(addresses == null) {
            request.setAttribute("incorrectShipsPlacement", true);
            openPlacement(request, response);
            return;
        }
        player.setShips(Set.of(addresses));
        if(!player.isPlayerFieldValid()) {
            request.setAttribute("incorrectShipsPlacement", true);
            openPlacement(request, response);
            return;
        }
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        game.checkGameStart();
        openNext(request, response);
    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        Player opponent = game.opponentOf(player);
        if (!player.isPlayerFieldValid()) {
            openPlacement(request, response);
        } else if (opponent.isPlayerFieldValid()) {
            openTurn(request, response);
        } else{
            openPlacementAwait(request, response);
        }
     }

    private void openPlacement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/placement.jsp").forward(request, response);
    }

    private void openTurn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("turn");
    }

    private void openPlacementAwait(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/placement-await.jsp").forward(request, response);
    }
}
