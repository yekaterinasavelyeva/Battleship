package com.example.Battleship;

import com.example.Battleship.model.Game;
import com.example.Battleship.model.GameStatus;
import com.example.Battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TurnServlet", urlPatterns = "/turn")
public class TurnServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        if (game.getCurrentPlayer() == player) {
            var addr = request.getParameter("addr");
            game.fire(addr);
        } else {
            response.sendError(400);
            return;
        }

        openNext(request, response);
    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        var player = (Player) request.getSession().getAttribute(Player.ATTR);
        if (game.getStatus() == GameStatus.FINISHED) {
            openFinish(request, response);
        } else if (game.getCurrentPlayer() == player) {
            openTurn(request, response);
        } else {
            openTurnAwait(request, response);
        }
    }

    private void openTurn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/turn.jsp").forward(request, response);
    }

    private void openTurnAwait(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/turn-await.jsp").forward(request, response);
    }

    private void openFinish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("finish");
    }
}
