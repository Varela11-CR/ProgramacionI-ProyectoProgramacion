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

public class PatientsService {

    private final String table = "patients";
    private final String[] columsDBTable = {"id_patient", "name_patient",
        "first_lastname_patient", "second_lastname_patient", "nationality_patient",
        "birthdate_patient", "testday_patient", "teststatus_patient", "phonenumber_patient",
        "address_patient", "observations_patient"};

    //  Constructor
    public PatientsService() {
    }

    //  Methods
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

    public boolean validateDataTypes(Patient patient) {

        boolean correctDataTypes = isDigit(patient.getIdPatient())
                && isNames(patient.getNamePatient())
                && isLastname(patient.getFirstLastName())
                && isLastname(patient.getSecondLastName())
                && isLastname(patient.getNationality())
                && isPhoneNumber(patient.getPhoneNumber());

        return correctDataTypes;

    }

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
