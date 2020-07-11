package Services;

import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {
    
    private final String tabla = "users";

    //  Constructors
    public UsersService() {
    }
    
    //  Methods
    public boolean login(User user) {
    
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
            return false;
        }
        
    
    }
    
}
