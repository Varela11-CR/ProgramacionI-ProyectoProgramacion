package Services;

import Models.Patient;
import static Utilities.ValidateForm.isDigit;
import static Utilities.ValidateForm.isLastname;
import static Utilities.ValidateForm.isNames;
import static Utilities.ValidateForm.isPhoneNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * @param patient
     * Toma un objeto de tipo Patient para hacer las validaciones respectivas.
     * @return 
     * Retorna un valor booleano para verificar si el objeto está completamente 
     * vacío o no. True equivale al objeto completamente vacío, False equivale 
     * al objeto por lo menos con un atributo lleno.
     */
    public boolean validateAllDataIncomplete(Patient patient) {

        boolean allDataIncomplete = (patient.getIdPatient().equals(""))
                && (patient.getNamePatient().equals(""))
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
     * @param patient
     * Toma un objeto de tipo Patient para hacer las validaciones respectivas.
     * @return 
     * Retorna un valor booleano para verificar si el objeto tiene uno o más 
     * atributos vacíos. True equivale a uno o más atributos del objeto están 
     * vacíos, False equivale al objeto con sus atributos llenos.
     */
    public boolean validateDataByData(Patient patient) {

        boolean allDataIncomplete = (patient.getIdPatient().equals(""))
                || (patient.getNamePatient().equals(""))
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
     * Valida que los tipos de los atributos sean los requeridos por el programa.
     * @param patient
     * Toma un objeto de tipo Patient para hacer las validaciones respectivas.
     * @return 
     * Retorna un valor booleano para verificar si los atributos del objeto 
     * cumplen con los tipos requeridos. True equivale a todos los valores son 
     * los tipos requeridos por el programa, False uno o mas datos no son los 
     * tipos requeridos por el programa.
     */
    public boolean validateDataTypes(Patient patient) {

        boolean correctDataTypes = isDigit(patient.getIdPatient())
                && isNames(patient.getNamePatient())
                && isLastname(patient.getFirstLastName())
                && isLastname(patient.getSecondLastName())
                && isLastname(patient.getNationality())
                && isPhoneNumber(patient.getPhoneNumber());

        return correctDataTypes;

    }

    /**
     * Realiza el ingreso de los datos en la tabla patients.
     * @param patient
     * Toma los atributos del objeto tipo Patient para ingresarlos en la 
     * respectiva tabla.
     * @return
     * Retorna un valor booleano dependiendo de la conclusión del ingreso de la 
     * información. True el ingreso de los datos termino correctamente, False el 
     * ingreso de los datos no se concretó. 
     * @throws SQLException 
     * Controla los errores tipo SQL que se pudieran dar por el ingreso de 
     * información a la base de datos.
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

            ps.setString(1, patient.getIdPatient());
            ps.setString(2, patient.getNamePatient());
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
     * Muestra toda la información de la tabla, con objeto Java tipo 
     * DefaultTableModel.
     * @return
     * Retorna un objeto DefaultTableModel con las columnas de la tabla patients 
     * de la base de datos y las filas obtenidas en la consulta SQL.
     * @throws SQLException 
     * Controla los errores de tipo SQL que se pudieran dar por la consulta de 
     * información a la base de datos.
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
     * @param colum
     * Es la columna donde se va a buscar el texto a buscar.
     * @param searchText
     * Es el texto a buscar en la columna.
     * @return
     * Retorna un objeto DefaultTableModel con la columna ingresada de la tabla 
     * patients de la base de datos y las filas obtenidas en la consulta SQL.
     * @throws SQLException 
     * Controla los errores de tipo SQL que se pudieran dar por la consulta de 
     * información a la base de datos.
     */
    public DefaultTableModel showInformationBy(String colum, String searchText) throws SQLException {

        String[] colums = {"Cédula", "Nombre", "P. Apellido", "S. Apellido", "Nacionalidad",
            "F. Nacimiento", "F. Prueba", "Estado Prueba", "Número", "Dirección",
            "Observaciones"};
        String[] registry = new String[11];

        DefaultTableModel model = new DefaultTableModel(null, colums);

        String query = "SELECT * FROM " + this.table + " WHERE  " + colum + " = \"" + searchText + "\"";

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

}
