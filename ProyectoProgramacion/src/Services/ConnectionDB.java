package Services;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author JD101
 * 
 * Clase para realizar las conexiones a la base de datos.
 */
public class ConnectionDB {

    private static Connection connectionDB;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/";
    private static final String dataBase = "prueba_proyecto_programacion_db";
    private static final String user = "root";
    private static final String password = "password";

    /**
     * Constructor del objeto de tipo ConnectionDB.   Usa los atributos de la 
     * clase para establecer el driver, host, la base de datos, el usuario y la 
     * contraseña para conectarse a la base de datos. Indica por consola si la 
     * conexión fue exitosa o no.
     */
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
    
    /**
     * Obtiene el objeto ya inicializado para realizar los procesos en la base 
     * de datos.
     * @return 
     * Retorna un objeto de tipo Connection ya completamente instanciado listo 
     * para su uso.
     */
    public Connection getConnectionDB() {

        return connectionDB;

    }

    /**
     * Cierra la conexión con la base de datos. Indica por consola si la 
     * conexión fue terminada.
     * @throws SQLException 
     * Controla los errores de tipo SQL que se pudieran dar por el cierre de la 
     * conexión a la base de datos.
     */
    public void closeConnectionDB() throws SQLException {

        connectionDB.close();
        connectionDB = null;

        if (connectionDB == null) {
            System.out.println("Conexión terminada.");
        }

    }

}
