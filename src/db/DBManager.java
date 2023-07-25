package db;

import moduls.Item;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/G115-jdbc",
                    "postgres",
                    "postgresql");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next());
            Item item = new Item();
            item.setId(resultSet.getLong("id"));
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("description"));
            item.setPrice(resultSet.getDouble("price"));
            items.add(item);



        } catch (Exception e){
            e.printStackTrace();
        }
return items;
    }
}


