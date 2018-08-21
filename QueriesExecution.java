package javamysqlconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueriesExecution {
    private Connection connection;
    private PreparedStatement statement = null;
    MysqlQueries runQuery = new MysqlQueries();

    public QueriesExecution() {
        String host = "jdbc:mysql://localhost:3306/";
        String dbName = "StoreFront";
        String mysqlURL = host + dbName;
        String userId = "root";
        String password = "user123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(mysqlURL, userId, password);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<ResultSetSelectQuery> selectQuery(int userId) {
        ArrayList<ResultSetSelectQuery> listOfResult = new ArrayList<ResultSetSelectQuery>();
        try {
            statement = connection.prepareStatement(runQuery.getQueryForUser());
            statement.setInt(1, userId);
            statement.setString(2, "Shipped");
            ResultSet rs = statement.executeQuery();
            ResultSetSelectQuery query;
            while (rs.next()) {
                query = new ResultSetSelectQuery(rs.getInt("OrderId"), rs.getDate("OrderDate"), rs.getInt("TotalPrice"));
                listOfResult.add(query);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOfResult;
    }

    public int insertQuery(ArrayList<Image> listOfData) {
        int[] result = {};
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(runQuery.getQueryForImageInsert());
            for (int i = 0; i < listOfData.size(); i++) {
                statement.setInt(1, listOfData.get(i).getId());
                statement.setString(2, listOfData.get(i).getName());
                statement.addBatch();
            }
            result = statement.executeBatch();
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result.length;
    }

    public int deleteQuery() {
        int deleted = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(runQuery.getQueryForDeleteProduct());
            deleted = statement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (deleted == 0) {
            return 0;
        } else {
            return deleted;
        }
    }

    public int countChild(int id, int count, ArrayList<ResultSetDisplayQuery> listOfResult) {
        for (int i = 0; i < listOfResult.size(); i++) {
            if (listOfResult.get(i).getParentId() == id) {
                count++;
                countChild(id, count, listOfResult);
            }
        }
        return count;
    }

    public ArrayList<Image> displayQuery() {
        ArrayList<ResultSetDisplayQuery> listOfResult = new ArrayList<ResultSetDisplayQuery>();
        ArrayList<Image> list = new ArrayList<Image>();
        try {
            statement = connection.prepareStatement(runQuery.getQueryForUser());
            ResultSet rs = statement.executeQuery();
            ResultSetDisplayQuery query;
            while (rs.next()) {
                query = new ResultSetDisplayQuery(rs.getInt("CategoryId"), rs.getInt("ParentId"), rs.getString("CategoryName"));
                listOfResult.add(query);
            }
            for (int i = 0; i < listOfResult.size(); i++) {
                if (listOfResult.get(i).getParentId() == 0) {
                    int count = countChild(listOfResult.get(i).getCategoryId(), 0, listOfResult);
                    list.add(new Image(count, listOfResult.get(i).getCategoryName()));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
