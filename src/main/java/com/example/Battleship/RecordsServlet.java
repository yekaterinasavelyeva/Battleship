package com.example.Battleship;

import com.example.Battleship.db.DatabaseUtil;
import com.example.Battleship.model.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "RecordsServlet", urlPatterns = "/records")
public class RecordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Record> records = DatabaseUtil.getRecords().stream()
               .sorted((o1, o2) -> Long.compare(o2.getPoints(), o1.getPoints()))
               .collect(Collectors.toList());

        request.setAttribute("records", records);
        request.getRequestDispatcher("WEB-INF/records.jsp").forward(request, response);
    }

}
