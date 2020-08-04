package Services;

import Models.Patient;
import static Utilities.Validations.ValidateForm.isDigit;
import static Utilities.Validations.ValidateForm.isLastname;
import static Utilities.Validations.ValidateForm.isNames;
import static Utilities.Validations.ValidateForm.isNationality;
import static Utilities.Validations.ValidateForm.isPhoneNumber;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author JD101
 *
 * Su función es ser la representación de la tabla patients de la base de datos.
 */
public class PatientsService {

    private final String table = "patients";
    private final String[] columsDBTable = {"id_patient", "name_patient",
        "first_lastname_patient", "second_lastname_patient", "nationality_patient",
        "birthdate_patient", "testday_patient", "teststatus_patient", "phonenumber_patient",
        "address_patient", "observations_patient"};

    //  Constructor
    /**
     * Constructor vacio
     */
    public PatientsService() {
    }

    //  Methods
    /**
     * Valida que el objeto tipo Patient no tenga sus atributos vacíos.
     *
     * @param patient Toma un objeto de tipo Patient para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si el objeto está
     * completamente vacío o no. True equivale al objeto completamente vacío,
     * False equivale al objeto por lo menos con un atributo lleno.
     */
    public boolean validateAllDataIncomplete(Patient patient) {

        boolean allDataIncomplete = (patient.getId().equals(""))
                && (patient.getName().equals(""))
                && (patient.getFirstLastName().equals(""))
                && (patient.getSecondLastName().equals(""))
                && (patient.getNationality().equals(""))
                && (patient.getBirthdate().equals(""))
                && (patient.getTestDay().equals(""))
                && (patient.getPhoneNumber().equals(""))
                && (patient.getAddress().equals(""));

        return allDataIncomplete;

    }

    /**
     * Valida que el objeto tipo Patient no tenga uno o más atributos vacíos.
     *
     * @param patient Toma un objeto de tipo Patient para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si el objeto tiene uno o
     * más atributos vacíos. True equivale a uno o más atributos del objeto
     * están vacíos, False equivale al objeto con sus atributos llenos.
     */
    public boolean validateDataByData(Patient patient) {

        boolean allDataIncomplete = (patient.getId().equals(""))
                || (patient.getName().equals(""))
                || (patient.getFirstLastName().equals(""))
                || (patient.getSecondLastName().equals(""))
                || (patient.getNationality().equals(""))
                || (patient.getBirthdate().equals(""))
                || (patient.getTestDay().equals(""))
                || (patient.getPhoneNumber().equals(""))
                || (patient.getAddress().equals(""));

        return allDataIncomplete;
    }

    /**
     * Valida que los tipos de los atributos sean los requeridos por el
     * programa.
     *
     * @param patient Toma un objeto de tipo Patient para hacer las validaciones
     * respectivas.
     * @return Retorna un valor booleano para verificar si los atributos del
     * objeto cumplen con los tipos requeridos. True equivale a todos los
     * valores son los tipos requeridos por el programa, False uno o mas datos
     * no son los tipos requeridos por el programa.
     */
    public boolean validateDataTypes(Patient patient) {

        boolean correctDataTypes = isDigit(patient.getId())
                && isNames(patient.getName())
                && isLastname(patient.getFirstLastName())
                && isLastname(patient.getSecondLastName())
                && isNationality(patient.getNationality())
                && isPhoneNumber(patient.getPhoneNumber());

        return correctDataTypes;

    }

    /**
     * Realiza el ingreso de los datos en la tabla patients.
     *
     * @param patient Toma los atributos del objeto tipo Patient para
     * ingresarlos en la respectiva tabla.
     * @return Retorna un valor booleano dependiendo de la conclusión del
     * ingreso de la información. True el ingreso de los datos termino
     * correctamente, False el ingreso de los datos no se concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por el ingreso de información a la base de datos.
     */
    public boolean insertData(Patient patient) throws SQLException {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        try {

            PreparedStatement ps;

            ps = connection.prepareStatement("INSERT INTO " + this.table
                    + " (id_patient, name_patient, first_lastname_patient, second_lastname_patient, "
                    + "nationality_patient, birthdate_patient, testday_patient, "
                    + "teststatus_patient, phonenumber_patient, address_patient, "
                    + "observations_patient) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getFirstLastName());
            ps.setString(4, patient.getSecondLastName());
            ps.setString(5, patient.getNationality());
            ps.setString(6, patient.getBirthdate());
            ps.setString(7, patient.getTestDay());
            ps.setString(8, patient.getTestStatus());
            ps.setString(9, patient.getPhoneNumber());
            ps.setString(10, patient.getAddress());
            ps.setString(11, patient.getObservations());

            int recordsAdded = ps.executeUpdate();

            if (recordsAdded > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito.");
            } else {

                JOptionPane.showMessageDialog(null, "Registro guardado sin "
                        + "éxito.");
                connectionDB.closeConnectionDB();
                return false;
            }

            connectionDB.closeConnectionDB();
            return true;

        } catch (SQLException e) {

            if (e.getSQLState().equals("23000")) {

                connectionDB.closeConnectionDB();
                JOptionPane.showMessageDialog(null, "La cédula pertenece a otro "
                        + "paciente. Revísela y vuelva a intentar ingresar al "
                        + "paciente.");
                return false;

            } else {

                connectionDB.closeConnectionDB();
                JOptionPane.showMessageDialog(null, e);
                return false;

            }

        }

    }

    /**
     * Muestra toda la información de la tabla, con la ayuda del objeto Java
     * tipo DefaultTableModel.
     *
     * @return Retorna un objeto DefaultTableModel con las columnas de la tabla
     * patients de la base de datos y las filas obtenidas en la consulta SQL.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public DefaultTableModel showInformation() throws SQLException {

        String[] colums = {"Cédula", "Nombre", "P. Apellido", "S. Apellido", "Nacionalidad",
            "F. Nacimiento", "F. Prueba", "Estado Prueba", "Número", "Dirección",
            "Observaciones"};
        String[] registry = new String[11];
        DefaultTableModel model = new DefaultTableModel(null, colums);
        String query = "SELECT * FROM " + this.table;

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection;
        PreparedStatement ps;
        ResultSet rs;

        try {

            connection = connectionDB.getConnectionDB();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                for (int i = 0; i < this.columsDBTable.length; i++) {
                    registry[i] = rs.getString(this.columsDBTable[i]);
                }

                model.addRow(registry);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al connectar con la base de datos.");
        }

        connectionDB.closeConnectionDB();
        return model;

    }

    /**
     * Muestra toda la información de la tabla dependiendo de la columna y el
     * texto a buscar, con objeto Java tipo DefaultTableModel.
     *
     * @param colum Es la columna donde se va a buscar el texto a buscar.
     * @param searchText Es el texto a buscar en la columna.
     * @return Retorna un objeto DefaultTableModel con la columna ingresada de
     * la tabla patients de la base de datos y las filas obtenidas en la
     * consulta SQL.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public DefaultTableModel showInformationBy(String colum, String searchText) throws SQLException {

        String[] colums = {"Cédula", "Nombre", "P. Apellido", "S. Apellido", "Nacionalidad",
            "F. Nacimiento", "F. Prueba", "Estado Prueba", "Número", "Dirección",
            "Observaciones"};
        String[] registry = new String[11];

        DefaultTableModel model = new DefaultTableModel(null, colums);

        String query = "SELECT * FROM " + this.table + " WHERE  " + colum + " LIKE \'%" + searchText + "%\'";

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection;
        PreparedStatement ps;
        ResultSet rs;

        try {

            connection = connectionDB.getConnectionDB();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                for (int i = 0; i < this.columsDBTable.length; i++) {
                    registry[i] = rs.getString(this.columsDBTable[i]);
                }

                model.addRow(registry);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al connectar con la base de datos.");
        }

        connectionDB.closeConnectionDB();
        return model;

    }

    /**
     * Realiza la actualización de los datos de un paciente.
     *
     * @param patient Toma los atributos del objeto tipo Patient para hacer la
     * actualización de los datos dependiendo del id_patient.
     * @return Retorna un valor booleano dependiendo de la conclusión de la
     * actualización de la información. True la actualización de los datos
     * terminó correctamente, False la actualización de los datos no se
     * concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por la actualización de la información a la base de datos.
     */
    public boolean updateData(Patient patient) throws SQLException {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        try {

            PreparedStatement ps;

            ps = connection.prepareStatement("UPDATE " + this.table + " SET "
                    + "id_patient = ?, name_patient = ?, "
                    + "first_lastname_patient = ?, second_lastname_patient = ?, "
                    + "nationality_patient = ?, birthdate_patient = ?, "
                    + "testday_patient = ?, teststatus_patient = ?, "
                    + "phonenumber_patient = ?, address_patient = ?, "
                    + "observations_patient = ? WHERE id_patient = ?");

            ps.setString(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getFirstLastName());
            ps.setString(4, patient.getSecondLastName());
            ps.setString(5, patient.getNationality());
            ps.setString(6, patient.getBirthdate());
            ps.setString(7, patient.getTestDay());
            ps.setString(8, patient.getTestStatus());
            ps.setString(9, patient.getPhoneNumber());
            ps.setString(10, patient.getAddress());
            ps.setString(11, patient.getObservations());
            ps.setString(12, patient.getId());

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
     * Realiza la eliminación de un registro de la tabla patients.
     *
     * @param patient Toma el atributo id del objeto patient para realizar la
     * eliminación del registro en la tabla. El registro a eliminar depende del
     * valor del atributo tomado.
     * @return Retorna un valor booleano dependiendo de la conclusión de la
     * eliminación del registro. True la eliminación del registro terminó
     * correctamente, False la eliminación del registro no se concretó.
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por la eliminación del registro de la base de datos.
     */
    public boolean deletePatient(Patient patient) throws SQLException {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        try {

            PreparedStatement ps;

            ps = connection.prepareStatement("DELETE FROM " + this.table
                    + " WHERE id_patient = ?");

            ps.setString(1, patient.getId());

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
     * Hace una consulta para saber el total de pacientes registrados en la base
     * de datos.
     *
     * @return Retorna un objeto tipo String con la cantidad obtenida de la
     * consulta.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public String getTotalPatients() throws SQLException {

        String query = "SELECT COUNT(id_patient) FROM " + this.table;
        String queryResult = null;

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                queryResult = rs.getString(1);
            }

            connectionDB.closeConnectionDB();

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

        }

        return queryResult;

    }

    /**
     * Hace una consulta para saber la cantidad de un estado de prueba
     * específico.
     *
     * @param status Recibe un objeto de tipo String que va a contener el estado
     * a buscar.
     * @return Retorna un objeto tipo String con la cantidad obtenida de la
     * consulta.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public String getTotalPatientsByStatus(String status) throws SQLException {

        String query = "SELECT COUNT(teststatus_patient) FROM " + this.table
                + " WHERE teststatus_patient = \"" + status + "\"";
        String queryResult = null;

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                queryResult = rs.getString(1);
            }

            connectionDB.closeConnectionDB();

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

        }

        return queryResult;

    }

    /**
     * Hace una consulta para obtener el total de los estados de pruebas
     * agrupado por estado de prueba.
     *
     * @return Retorna un objeto de tipo ArrayList, en el primer índice esta el
     * total pruebas negativas, en el segundo el total de pruebas pendientes, en
     * el tercer el total de pruebas prositivas, en el cuarto el total de
     * recuperados
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public ArrayList<String> getTotalPatientsAllStatus() throws SQLException {

        String query = "SELECT COUNT(teststatus_patient) FROM " + this.table
                + " GROUP BY teststatus_patient";
        ArrayList<String> queryResults = new ArrayList<>();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                queryResults.add(rs.getString(1));
            }

            connectionDB.closeConnectionDB();

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

        }

        return queryResults;

    }

    /**
     * Hace una consulta para obtener el total de los pacientes nacionales y
     * extranjeros.
     *
     * @return Retorna un objeto de tipo ArrayList, en el primer índice esta el
     * total de nacionales y en el segundo el total de extranjeros.
     * @throws SQLException Controla los errores de tipo SQL que se pudieran dar
     * por la consulta de información a la base de datos.
     */
    public ArrayList<Integer> getTotalNationalForeign() throws SQLException {

        String query = "SELECT COUNT(if(nationality_patient = \"Costa Rica\", "
                + "1, NULL)),  COUNT(if(nationality_patient != \"Costa Rica\", "
                + "1, NULL)) FROM " + this.table;
        ArrayList<Integer> queryResults = new ArrayList<>();

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnectionDB();

        PreparedStatement ps;
        ResultSet rs;

        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                queryResults.add(rs.getInt(1));
                queryResults.add(rs.getInt(2));

            }

            connectionDB.closeConnectionDB();

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

        }

        return queryResults;

    }

}
