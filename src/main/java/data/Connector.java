package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/chbu?user=chbu&password=tIp1POywlKKdZaQuVR3V1");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return connection;
    }
}
