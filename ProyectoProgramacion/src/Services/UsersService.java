package Services;

import Models.User;
import static Utilities.Validations.ValidateUser.isPassword;
import static Utilities.Validations.ValidateUser.isUserName;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.digest.DigestUtils;

public class UsersService {

    private final String table = "users";
    private final String[] colums = {"user_name", "permissions", "user_password"};

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
     *
     * @param user Toma un objeto tipo User y con sus atributos hace las
     * validaciones necesarias.
     * @return Retorna un valor booleano indicando el acceso. True acceso
     * concedido, False acceso denegado.
     * @throws java.sql.SQLException Controla los errores tipo SQL que se
     * pudieran dar por la validación de datos.
     */
    public boolean login(User user) throws SQLException {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();
        PreparedStatement ps;
        ResultSet rs;

        String query = "SELECT user_name, user_password, permissions FROM " + this.table + " WHERE user_name = ?";

        try {

            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (user.getUserPassword().equals(rs.getString(2))) {

                    user.setPermissions(rs.getInt(3));
                    connectionDB.closeConnectionDB();
                    return true;

                } else {

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

    /**
     * Valida que el objeto tipo Patient no tenga sus atributos vacíos.
     *
     * @param user Toma un objeto de tipo User para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si el objeto está
     * completamente vacío o no. True equivale al objeto completamente vacío,
     * False equivale al objeto por lo menos con un atributo lleno.
     */
    public boolean validateAllDataIncomplete(User user) {

        boolean allDataIncomplete = (user.getUserName().equals("")
                && user.getUserPassword().equals(""));

        return allDataIncomplete;

    }

    /**
     * Valida que el objeto tipo User no tenga uno o más atributos vacíos.
     *
     * @param user Toma un objeto de tipo User para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si el objeto tiene uno o
     * más atributos vacíos. True equivale a uno o más atributos del objeto
     * están vacíos, False equivale al objeto con sus atributos llenos.
     */
    public boolean validateDataByData(User user) {

        boolean dataByDataIncomplete = (user.getUserName().equals("")
                || user.getUserPassword().equals(""));

        return dataByDataIncomplete;

    }

    /**
     * Valida que los tipos de los atributos sean los requeridos por el
     * programa.
     *
     * @param user Toma un objeto de tipo User para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si los atributos del
     * objeto cumplen con los tipos requeridos. True equivale a todos los
     * valores son los tipos requeridos por el programa, False uno o mas datos
     * no son los tipos requeridos por el programa.
     */
    public boolean validateDataTypes(User user) {

        boolean correctDataType = (isUserName(user.getUserName())
                && isPassword(user.getUserPassword()));

        return correctDataType;

    }

    /**
     * Realiza el ingreso de los atributos de un objeto tipo User en la tabla
     * users.
     *
     * @param user Toma los atributos del objeto tipo User para ingresarlos en
     * la respectiva tabla.
     * @return Retorna un valor booleano dependiendo de la conclusión del
     * ingreso de la información. True el ingreso de los datos termino
     * correctamente, False el ingreso de los datos no se concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por el ingreso de información a la base de datos.
     */
    public boolean insertUser(User user) throws SQLException {

        String query = "INSERT INTO " + this.table + " (user_name, "
                + "user_password, permissions) VALUES (?,?,?)";
        String encryptedPassword = DigestUtils.md5Hex(user.getUserPassword());

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();
        PreparedStatement ps;

        try {

            ps = connection.prepareStatement(query);

            ps.setString(1, user.getUserName());
            ps.setString(2, encryptedPassword);
            ps.setInt(3, user.getPermissions());

            int recordsAdded = ps.executeUpdate();

            if (recordsAdded > 0) {
                JOptionPane.showMessageDialog(null, "Usuario agregado con "
                        + "éxito.");
            } else {

                JOptionPane.showMessageDialog(null, "Usuario no agregado.");
                return false;

            }

            connectionDB.closeConnectionDB();
            return true;

        } catch (SQLException e) {

            if (e.getSQLState().equals("23000")) {

                connectionDB.closeConnectionDB();
                JOptionPane.showMessageDialog(null, "Nombre de usuario ya en "
                        + "uso.");
                return false;

            } else {

                connectionDB.closeConnectionDB();
                JOptionPane.showMessageDialog(null, e);
                return false;

            }

        }

    }

    /**
     * Realiza la actualización de los datos de un usuario.
     *
     * @param user Toma los atributos del objeto tipo User para hacer la
     * actualización de los datos dependiendo del user_name.
     * @return Retorna un valor booleano dependiendo de la conclusión de la
     * actualización de la información. True la actualización de los datos
     * terminó correctamente, False la actualización de los datos no se
     * concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por la actualización de la información a la base de datos.
     */
    public boolean updateData(User user) throws SQLException {

        String query = "UPDATE " + this.table + " SET user_name = ?, "
                + "user_password = ?, permissions = ? WHERE user_name = ?";
        String encryptedPassword = DigestUtils.md5Hex(user.getUserPassword());

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();
        PreparedStatement ps;

        try {

            ps = connection.prepareStatement(query);

            ps.setString(1, user.getUserName());
            ps.setString(2, encryptedPassword);
            ps.setInt(3, user.getPermissions());
            ps.setString(4, user.getUserName());

            int recordsUpdated = ps.executeUpdate();

            if (recordsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Registro modificado con "
                        + "éxito.");
            } else {

                JOptionPane.showMessageDialog(null, "Registro modificado sin "
                        + "éxito.");
                connectionDB.closeConnectionDB();
                return false;

            }

            connectionDB.closeConnectionDB();
            return true;

        } catch (HeadlessException | SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);
            return false;

        }

    }

    /**
     * Realiza la eliminación de un registro de la tabla users.
     *
     * @param user Toma el atributo userName del objeto user para realizar la
     * eliminación del registro en la tabla. El registro a eliminar depende del
     * valor del atributo tomado.
     * @return Retorna un valor booleano dependiendo de la conclusión de la
     * eliminación del registro. True la eliminación del registro terminó
     * correctamente, False la eliminación del registro no se concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por la eliminación del registro de la base de datos.
     */
    public boolean deleteUser(User user) throws SQLException {

        String query = "DELETE FROM " + this.table + " WHERE user_name = ?";

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();
        PreparedStatement ps;

        try {

            ps = connection.prepareStatement(query);

            ps.setString(1, user.getUserName());

            int recordsDeleted = ps.executeUpdate();

            if (recordsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado con "
                        + "éxito");
            } else {

                JOptionPane.showMessageDialog(null, "Registro eliminado sin "
                        + "éxito.");
                connectionDB.closeConnectionDB();
                return false;

            }

            connectionDB.closeConnectionDB();
            return true;

        } catch (HeadlessException | SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);
            return false;

        }

    }

    /**
     * Muestra toda la información de la tabla, con la ayuda del objeto Java
     * tipo DefaultTableModel.
     *
     * @return Retorna un objeto DefaultTableModel con las columnas de la tabla
     * users de la base de datos y las filas obtenidas en la consulta SQL.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public DefaultTableModel showInformation() throws SQLException {

        String[] colums = {"Usuarios", "Permisos"};
        String[] registry = new String[2];
        DefaultTableModel model = new DefaultTableModel(null, colums);
        String query = "SELECT user_name,  permissions FROM " + this.table;

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection;
        PreparedStatement ps;
        ResultSet rs;

        try {

            connection = connectionDB.getConnectionDB();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                for (int i = 0; i < colums.length; i++) {

                    if (i == 0) {
                        registry[i] = rs.getString(this.colums[i]);
                    } else {

                        String permissions = rs.getString(this.colums[i]);

                        if (permissions.equals("1")) {
                            registry[i] = "Si";
                        } else {
                            registry[i] = "No";
                        }

                    }

                }

                model.addRow(registry);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base "
                    + "de datos.");
        }

        connectionDB.closeConnectionDB();
        return model;

    }

}
