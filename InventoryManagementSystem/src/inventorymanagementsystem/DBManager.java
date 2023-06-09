package inventorymanagementsystem;

import java.sql.*;

public class DBManager {

    private static DBManager instance = null;
    private Connection connection;
    private Statement statement;
    private static final String URL = "jdbc:derby:InventoryDB;create=true";

    private DBManager() {
        establishConnection();
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public void establishConnection() {
        if (this.connection == null) {
            try {
                connection = DriverManager.getConnection(URL, "", "");
                statement = connection.createStatement();
                System.out.println(URL + " Connected Successfully ....");
                createTables();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void createTables() {
        try {

            if (!tableExists("PRODUCT")) {
                statement.execute("CREATE TABLE PRODUCT(NAME VARCHAR(35), PRICE DOUBLE PRECISION, WEIGHT DOUBLE PRECISION, QUANTITY INTEGER)");
                connection.commit();
                System.out.println("PRODUCT table created");
            } else {
                System.out.println("PRODUCT table already exists");
            }

            if (!tableExists("APP_USER")) {
                statement.execute("CREATE TABLE APP_USER(USERNAME VARCHAR(20), PASSWORD VARCHAR(20))");
                connection.commit();
                System.out.println("APP_USER table created");
            } else {
                System.out.println("APP_USER table already exists");
            }
        } catch (SQLException ex) {
            System.out.println("SQL exception: " + ex.getMessage());
            System.out.println("Tables already created.");
        }
    }

    public boolean tableExists(String tableName) {
        try {
            DatabaseMetaData dbm = connection.getMetaData();

            ResultSet tables = dbm.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()) {
                // Table exists
                return true;
            } else {
                // Table does not exist
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("SQL exception: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
