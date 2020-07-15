package Services;

import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {
    
    private final String tabla = "users";

    //  Constructors
    /**
     * Constructor vacio.
     */
    public UsersService() {
    }
    
    //  Methods
    /**
     * Evalúa los atributos del objeto tipo User con los datos de la tabla users 
     * de la base de datos para dar acceso o no al programa.
     * @param user
     * Toma un objeto tipo User y con sus atributos hace las validaciones 
     * necesarias.
     * @return 
     * Retorna un valor booleano indicando el acceso. True acceso concedido, 
     * False acceso denegado.
     * @throws java.sql.SQLException
     * Controla los errores tipo SQL que se pudieran dar por la validación de 
     * datos.
     */
    public boolean login(User user) throws SQLException {
    
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT user_name, user_password, permissions FROM " + this.tabla + " WHERE user_name = ?";
        
        try {
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                if (user.getUserPassword().equals(rs.getString(2))) {
                    
                    user.setPermissions(rs.getInt(3));
                    connectionDB.closeConnectionDB();
                    return true;
                    
                }else{
                
                    connectionDB.closeConnectionDB();
                    return false;
                    
                }
                
            }
            
            connectionDB.closeConnectionDB();
            return false;
            
        } catch (SQLException e) {
            connectionDB.closeConnectionDB();
            return false;
        }
        
    
    }
    
}
