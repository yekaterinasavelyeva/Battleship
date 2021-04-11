package com.example.Battleship.db;

import com.example.Battleship.model.Player;
import com.example.Battleship.model.Record;

import javax.servlet.ServletException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    public static void saveWinnerResult(Player player) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:~/Battleship", "sa", "");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO RECORDS (NAME, POINTS) VALUES(?, ?)"
        )) {

            statement.setString(1, player.getName());
            statement.setLong(2, player.shipsLeft());
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static List<Record> getRecords() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:~/Battleship", "sa", "");
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM records");
        ) {

            System.out.println("Result set is ready!");
            List<Record> records = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("ID");
                System.out.println(id);
                String name = rs.getString("NAME");
                System.out.println(name);
                long points = rs.getLong("POINTS");
                System.out.println(points);

                Record record = new Record(id, name, points);
                records.add(record);
            }
          return records;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
