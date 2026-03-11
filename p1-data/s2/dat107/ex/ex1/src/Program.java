package src;

//import java.util.Properties;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {
    private static final String SCHEMA = "ex1";

    public static void main(String[] args) {
        conn();
        create();
        select();
        System.out.printf("  Found person: %s%n", selectById(1001));
        clean();
    }

    private static void conn() {
        System.out.println();
        System.out.println("TILKOBLING TIL DATABASE: ");
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.printf("Attempting connection to PostgreSQL server %s:%s.%n", DbInfo.HOST, DbInfo.PORT);
        try (Connection connection = DriverManager.getConnection(DbInfo.URL, DbInfo.USER, DbInfo.PASS)) {
            if (connection != null) {
                System.out.println("Connected to server successfully.");
            } else {
                System.out.println("Failed to make a connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    private static void create() {
        System.out.println();
        System.out.println("OPPRETTING AV TABELL OG INNSETTING AV RADER: ");
        System.out.println("- - - - - - - - - - - - - - - - -");
        try (Connection connection = DriverManager.getConnection(DbInfo.URL, DbInfo.USER, DbInfo.PASS);
             Statement statement = connection.createStatement()) {
            printExecute(statement, "DROP SCHEMA IF EXISTS " + SCHEMA + " CASCADE");
            printExecute(statement, "CREATE SCHEMA " + SCHEMA);
            printExecute(statement, "SET search_path TO " + SCHEMA);
            printExecute(statement, "CREATE TABLE person (id integer NOT NULL, navn VARCHAR(30) NOT NULL, PRIMARY KEY (id))");
            int rowsInserted = printExecuteUpdate(statement, "INSERT INTO person(id, navn) VALUES (1001, 'Per'), (1002, 'Atle'), (1003, 'Donald')");
            if (rowsInserted > 0) { System.out.printf("  %d rows inserted into person%n",rowsInserted); }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    private static void select() {
        System.out.println();
        System.out.println("UTVALGSSPØRRING: ");
        System.out.println("- - - - - - - - - - - - - - - - -");
        try (Connection connection = DriverManager.getConnection(DbInfo.URL, DbInfo.USER, DbInfo.PASS);
            Statement statement = connection.createStatement()) {
                printExecute(statement, "SET search_path TO " + SCHEMA);
                ResultSet resultSet = printExecuteQuery(statement, "SELECT * FROM person");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String navn = resultSet.getString("navn");
                    System.out.printf("  id: %d, navn: %s%n", id, navn);
                }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    private static Person selectById(int id) {
        System.out.println();
        System.out.println("UTVALGSSPØRRING MED RETURVERDI: ");
        System.out.println("- - - - - - - - - - - - - - - - -");
        try (Connection connection = DriverManager.getConnection(DbInfo.URL, DbInfo.USER, DbInfo.PASS);
            Statement statement = connection.createStatement()) {
                printExecute(statement, "SET search_path TO " + SCHEMA);
                ResultSet resultSet = printExecuteQuery(statement, "SELECT * FROM person WHERE id = " + id);
                if (resultSet.next()) {
                    int pId = resultSet.getInt("id");
                    String pNavn = resultSet.getString("navn");
                    System.out.printf("  id: %d, navn: %s%n", pId, pNavn);
                    return new Person(pId, pNavn);
                }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }
    
    public static void clean() {
        System.out.println();
        System.out.println("OPPRYDDING AV EKSEMPELTABELLER: ");
        System.out.println("- - - - - - - - - - - - - - - - -");
        try (Connection connection = DriverManager.getConnection(DbInfo.URL, DbInfo.USER, DbInfo.PASS);
             Statement statement = connection.createStatement()) {
            printExecute(statement, "DROP SCHEMA IF EXISTS " + SCHEMA + " CASCADE");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    private static int printExecuteUpdate(Statement statement, String query) throws SQLException {
        System.out.println(" "+query+";");
        return statement.executeUpdate(query);
    }
    
    private static boolean printExecute(Statement statement, String query) throws SQLException {
        System.out.println(" "+query+";");
        return statement.execute(query);
    }

    private static ResultSet printExecuteQuery(Statement statement, String query) throws SQLException {
        System.out.println(" "+query+";");
        return statement.executeQuery(query);
    }

}
