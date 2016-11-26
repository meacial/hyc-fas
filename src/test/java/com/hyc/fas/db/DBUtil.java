package com.hyc.fas.db;

import java.sql.*;

/**
 * TODO
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/26 18:48
 */
public class DBUtil {

    private final static String url = "jdbc:mysql://localhost:3306/hyc_db?useSSL=false";
    private final static String username = "meacial";
    private final static String password = "meacial";

    private final static String driverClass = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    public final static PreparedStatement getStatement(Connection connection,String sql) throws SQLException {
        return connection.prepareStatement(url);
    }

    public final static ResultSet getResultSet(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }


    public final static void close(Object object) {
        if (object != null) {
            try {
                if (object instanceof ResultSet) {
                    ((ResultSet) object).close();
                } else if (object instanceof Statement) {
                    ((Statement) object).close();;
                } else if (object instanceof Connection) {
                    ((Connection) object).close();
                } else {
                    object = null;
                    System.err.println(object + " , could not closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                object = null;
            }
        }
    }
}
