package Services;

import Models.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
    public void insertData(Patient patient) throws SQLException {

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

        } catch (SQLException e) {

            connectionDB.closeConnectionDB();
            JOptionPane.showMessageDialog(null, e);

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
