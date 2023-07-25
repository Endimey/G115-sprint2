//package db;
//
//
//import servlets.Items;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBitems {
//   private static Connection connection;
//
//   static {
//       try {
//           Class.forName("org.postgresql.Driver ");
//           connection = DriverManager.getConnection(
//                   "jdbc:postgresql://localhost:5432/G115-jdbc",
//                   "postgres",
//                   "postgresql");
//       } catch (Exception e){
//           e.printStackTrace();
//       }
//   }
//public static List<Items> getItems (){
//       List<Items> items = new ArrayList<>();
//
//       try {
//           PreparedStatement statement = connection.prepareStatement(
//                   "select * from items");
//           ResultSet resultSet = statement.executeQuery();
//           while (resultSet.next()) {
//               Items items = new Items();
//               items.setId(resultSet.getLong("id"));
//               items.setName(resultSet.getString("name"));
//               items.setDescription(resultSet.getString("description"));
//               items.setPrice(resultSet.getDouble("price"));
//               items.add(items);
//
//           }
//           statement.close();
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//        return items;
//    }
//
//}
