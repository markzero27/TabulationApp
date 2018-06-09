package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

        private static final String SQLCON = "jdbc:sqlite:TabSysDB.sqlite";

        public static Connection getConnection() throws SQLException{
            try{
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection(SQLCON);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
}
