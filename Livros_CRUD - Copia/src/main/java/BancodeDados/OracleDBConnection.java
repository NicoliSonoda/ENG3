package BancodeDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnection {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USER = "app";
    private static final String PASSWORD = "App123";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");


            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer conexão!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do Oracle não encontrado!");
            e.printStackTrace();
        }

        return connection;
    }
}
