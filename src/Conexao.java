import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    
    private static final String URL = "jdbc:mysql://localhost:3306/peqsystem";
    private static final String USUARIO = "root";
    private static final String SENHA = System.getenv("DB_PASSWORD"); // pega do ambiente

    public static Connection conectar() throws SQLException {
        if (SENHA == null) {
            throw new RuntimeException("A senha do banco não foi configurada na variável de ambiente DB_PASSWORD");
        }
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
