package Services;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDB {

    private static Connection connectionDB;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/";
    private static final String dataBase = "prueba_proyecto_programacion_db";
    private static final String user = "root";
    private static final String password = "password";

    public ConnectionDB() {
    
        connectionDB = null;
        
        try {
            
            Class.forName(driver);
            connectionDB = (Connection) DriverManager.getConnection(url + dataBase, user, password);
            
            if (connectionDB != null) {
                System.out.println("Conexión establecida.");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
        
    }
    
    //  Este método nos retorna la conexión.
    public Connection getConnectionDB() {

        return connectionDB;

    }

    //  Con este método nos desconectamos de la base de datos.
    public void closeConnectionDB() throws SQLException {

        connectionDB.close();
        connectionDB = null;

        if (connectionDB == null) {
            System.out.println("Conexión terminada.");
        }

    }

}
