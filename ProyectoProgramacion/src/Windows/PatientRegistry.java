package Windows;

import Models.Patient;
import Services.PatientsService;
import static Utilities.ValidateForm.manipulateString;
import WindowsBackground.PatientRegistry.PatientRegistryBackgroundAbove;
import WindowsBackground.PatientRegistry.PatientRegistryBackgroundBelow;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author JD101
 */
public class PatientRegistry extends javax.swing.JFrame {

    //  Variables & Objects
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    /**
     * Creates new form PatientRegistry
     */
    public PatientRegistry() {
        initComponents();
        setLocationRelativeTo(null);
        cleanComponents();
        lockComponents();
        lockDateEditor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new PatientRegistryBackgroundBelow();
        jPanel2 = new javax.swing.JPanel();
        patientRegistryLabel = new javax.swing.JLabel();
        jPanel1 = new PatientRegistryBackgroundAbove();
        labelIdPatient = new javax.swing.JLabel();
        labelNamePatient = new javax.swing.JLabel();
        labelFirstLastName = new javax.swing.JLabel();
        labelSecondLastName = new javax.swing.JLabel();
        labelNationality = new javax.swing.JLabel();
        labelBirthdate = new javax.swing.JLabel();
        labelTestDay = new javax.swing.JLabel();
        labelTestStatus = new javax.swing.JLabel();
        labelPhoneNumber = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        labelObservations = new javax.swing.JLabel();
        textFieldIdPatient = new javax.swing.JTextField();
        textFieldNamePatient = new javax.swing.JTextField();
        textFieldFirstLastName = new javax.swing.JTextField();
        textFieldSecondLastName = new javax.swing.JTextField();
        textFieldNationality = new javax.swing.JTextField();
        textFieldPhoneNumber = new javax.swing.JTextField();
        textFieldAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservations = new javax.swing.JTextArea();
        comboBoxTestStatus = new javax.swing.JComboBox<>();
        dateChooserBirthdate = new com.toedter.calendar.JDateChooser();
        dateChooserTestDay = new com.toedter.calendar.JDateChooser();
        buttonAdd = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 700));
        setPreferredSize(new java.awt.Dimension(820, 700));
        setResizable(false);

        jPanel3.setPreferredSize(new java.awt.Dimension(815, 690));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 75));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        patientRegistryLabel.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        patientRegistryLabel.setForeground(new java.awt.Color(0, 0, 0));
        patientRegistryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientRegistryLabel.setText("Registro de Pacientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(patientRegistryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(patientRegistryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 610));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 590));

        labelIdPatient.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelIdPatient.setText("Número de cédula:");

        labelNamePatient.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelNamePatient.setText("Nombre:");

        labelFirstLastName.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelFirstLastName.setText("Primer apellido:");

        labelSecondLastName.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelSecondLastName.setText("Segundo apellido:");

        labelNationality.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelNationality.setText("Nacionalidad: ");

        labelBirthdate.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelBirthdate.setText("Fecha de nacimiento:");

        labelTestDay.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelTestDay.setText("Día de la prueba:");

        labelTestStatus.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelTestStatus.setText("Estado de la prueba:");

        labelPhoneNumber.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelPhoneNumber.setText("Número de télefono:");

        labelAddress.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelAddress.setText("Dirección:");

        labelObservations.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelObservations.setText("Observaciones:");

        textFieldIdPatient.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldIdPatient.setToolTipText("");
        textFieldIdPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIdPatientActionPerformed(evt);
            }
        });

        textFieldNamePatient.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldNamePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNamePatientActionPerformed(evt);
            }
        });

        textFieldFirstLastName.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFirstLastNameActionPerformed(evt);
            }
        });

        textFieldSecondLastName.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSecondLastNameActionPerformed(evt);
            }
        });

        textFieldNationality.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNationalityActionPerformed(evt);
            }
        });

        textFieldPhoneNumber.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneNumberActionPerformed(evt);
            }
        });

        textFieldAddress.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddressActionPerformed(evt);
            }
        });

        textAreaObservations.setColumns(20);
        textAreaObservations.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textAreaObservations.setLineWrap(true);
        textAreaObservations.setRows(5);
        jScrollPane1.setViewportView(textAreaObservations);

        comboBoxTestStatus.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        comboBoxTestStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Negativo", "Positivo", "Recuperado" }));
        comboBoxTestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTestStatusActionPerformed(evt);
            }
        });

        dateChooserBirthdate.setDateFormatString("yyyy/MM/dd");
        dateChooserBirthdate.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        dateChooserTestDay.setDateFormatString("yyyy/MM/dd");
        dateChooserTestDay.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        buttonAdd.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(255, 255, 255));
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonAdd.png"))); // NOI18N
        buttonAdd.setText("Agregar");
        buttonAdd.setBorder(null);
        buttonAdd.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonAddDisabledIcon.png"))); // NOI18N
        buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonAddRollOver.png"))); // NOI18N
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonCancel.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonCancel.png"))); // NOI18N
        buttonCancel.setText("Cancelar");
        buttonCancel.setBorder(null);
        buttonCancel.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonCancelDisabledIcon.png"))); // NOI18N
        buttonCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonCancelRollOver.png"))); // NOI18N
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonNew.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        buttonNew.setForeground(new java.awt.Color(255, 255, 255));
        buttonNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonNew.png"))); // NOI18N
        buttonNew.setText("Nuevo");
        buttonNew.setBorder(null);
        buttonNew.setBorderPainted(false);
        buttonNew.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonNewDisabledIcon.png"))); // NOI18N
        buttonNew.setFocusPainted(false);
        buttonNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNew.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientRegistry/buttonNewRollOver.png"))); // NOI18N
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAddress)
                        .addComponent(labelObservations)
                        .addComponent(labelTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTestStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelIdPatient)
                    .addComponent(labelNamePatient)
                    .addComponent(labelFirstLastName)
                    .addComponent(labelSecondLastName)
                    .addComponent(labelNationality)
                    .addComponent(labelBirthdate))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldSecondLastName)
                                .addComponent(textFieldFirstLastName)
                                .addComponent(textFieldNamePatient)
                                .addComponent(textFieldIdPatient)
                                .addComponent(dateChooserBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldNationality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonAdd)
                                .addGap(24, 24, 24)
                                .addComponent(buttonCancel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxTestStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdPatient)
                    .addComponent(textFieldIdPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNamePatient)
                    .addComponent(textFieldNamePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFirstLastName)
                    .addComponent(textFieldFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSecondLastName)
                    .addComponent(textFieldSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNationality)
                    .addComponent(textFieldNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBirthdate)
                    .addComponent(dateChooserBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTestDay)
                    .addComponent(dateChooserTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTestStatus)
                    .addComponent(comboBoxTestStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhoneNumber)
                    .addComponent(textFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObservations)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAdd)
                        .addComponent(buttonNew)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  Own Code
    //  ------------------------------------------------------------------------
    private void cleanComponents() {

        textFieldIdPatient.setText("");
        textFieldNamePatient.setText("");
        textFieldFirstLastName.setText("");
        textFieldSecondLastName.setText("");
        textFieldNationality.setText("");
        dateChooserBirthdate.setCalendar(null);
        dateChooserTestDay.setCalendar(null);
        comboBoxTestStatus.setSelectedIndex(0);
        textFieldPhoneNumber.setText("");
        textFieldAddress.setText("");
        textAreaObservations.setText("");

    }

    private void unlockComponents() {

        textFieldIdPatient.setEnabled(true);
        textFieldNamePatient.setEnabled(true);
        textFieldFirstLastName.setEnabled(true);
        textFieldSecondLastName.setEnabled(true);
        textFieldNationality.setEnabled(true);
        dateChooserBirthdate.setEnabled(true);
        dateChooserTestDay.setEnabled(true);
        comboBoxTestStatus.setEnabled(true);
        textFieldPhoneNumber.setEnabled(true);
        textFieldAddress.setEnabled(true);
        textAreaObservations.setEnabled(true);
        buttonAdd.setEnabled(true);
        buttonCancel.setEnabled(true);
        buttonNew.setEnabled(false);

    }

    private void lockComponents() {

        textFieldIdPatient.setEnabled(false);
        textFieldNamePatient.setEnabled(false);
        textFieldFirstLastName.setEnabled(false);
        textFieldSecondLastName.setEnabled(false);
        textFieldNationality.setEnabled(false);
        dateChooserBirthdate.setEnabled(false);
        dateChooserTestDay.setEnabled(false);
        comboBoxTestStatus.setEnabled(false);
        textFieldPhoneNumber.setEnabled(false);
        textFieldAddress.setEnabled(false);
        textAreaObservations.setEnabled(false);
        buttonAdd.setEnabled(false);
        buttonCancel.setEnabled(false);
        buttonNew.setEnabled(true);

    }

    private void lockDateEditor() {

        ((JTextFieldDateEditor) dateChooserBirthdate.getDateEditor()).setEnabled(false);
        ((JTextFieldDateEditor) dateChooserTestDay.getDateEditor()).setEnabled(false);

    }

    private void insertPatients() throws SQLException, UnsupportedEncodingException {

        PatientsService patientsService = new PatientsService();
        Patient patient = new Patient();

        patient.setIdPatient(textFieldIdPatient.getText().trim());
        patient.setNamePatient(manipulateString(textFieldNamePatient.getText()));
        patient.setFirstLastName(manipulateString(textFieldFirstLastName.getText()));
        patient.setSecondLastName(manipulateString(textFieldSecondLastName.getText()));
        patient.setNationality(manipulateString(textFieldNationality.getText()));
        patient.setBirthdate(((JTextComponent) dateChooserBirthdate.getDateEditor().getUiComponent()).getText());
        patient.setTestDay(((JTextComponent) dateChooserTestDay.getDateEditor().getUiComponent()).getText());
        patient.setTestStatus(comboBoxTestStatus.getSelectedItem().toString());
        patient.setPhoneNumber(textFieldPhoneNumber.getText().trim());
        patient.setAddress(manipulateString(textFieldAddress.getText()));
        patient.setObservations(manipulateString(textAreaObservations.getText()));

        if (patientsService.validateAllDataIncomplete(patient)) {

            JOptionPane.showMessageDialog(null, "Todos los campos requeridos por "
                    + "el formulario están vacíos, rellénelos y vuelva a intentar "
                    + "ingresar al paciente.");

        } else if (patientsService.validateDataByData(patient)) {

            JOptionPane.showMessageDialog(null, "Uno o más campos requeridos "
                    + "por el formulario están vacíos, rellénelos y vuelva a "
                    + "intentar ingresar al paciente.");

        } else if (!patientsService.validateDataTypes(patient)) {

            JOptionPane.showMessageDialog(null, "Uno o más tipos de datos no son "
                    + "los solicitados por el formulario, revíselos y vuelva a "
                    + "intentar ingresar al paciente.");

        } else {

            if (patientsService.insertData(patient)) {

                cleanComponents();
                lockComponents();

            }

        }

    }

    private void textFieldIdPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIdPatientActionPerformed
        textFieldNamePatient.requestFocus();
    }//GEN-LAST:event_textFieldIdPatientActionPerformed

    private void textFieldNamePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNamePatientActionPerformed
        textFieldNamePatient.transferFocus();
    }//GEN-LAST:event_textFieldNamePatientActionPerformed

    private void textFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddressActionPerformed
        textFieldAddress.transferFocus();
    }//GEN-LAST:event_textFieldAddressActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed

        try {
            insertPatients();
        } catch (SQLException | UnsupportedEncodingException ex) {
            Logger.getLogger(PatientRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed

        unlockComponents();
        textFieldIdPatient.requestFocus();
        lockDateEditor();

    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed

        cleanComponents();
        lockComponents();

    }//GEN-LAST:event_buttonCancelActionPerformed

    private void textFieldFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstLastNameActionPerformed
        textFieldFirstLastName.transferFocus();
    }//GEN-LAST:event_textFieldFirstLastNameActionPerformed

    private void textFieldSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSecondLastNameActionPerformed
        textFieldSecondLastName.transferFocus();
    }//GEN-LAST:event_textFieldSecondLastNameActionPerformed

    private void textFieldNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNationalityActionPerformed
        textFieldNationality.transferFocus();
    }//GEN-LAST:event_textFieldNationalityActionPerformed

    private void comboBoxTestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTestStatusActionPerformed
        comboBoxTestStatus.transferFocus();
    }//GEN-LAST:event_comboBoxTestStatusActionPerformed

    private void textFieldPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneNumberActionPerformed
        textFieldPhoneNumber.transferFocus();
    }//GEN-LAST:event_textFieldPhoneNumberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            UIManager.setLookAndFeel(new FlatIntelliJLaf());

        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PatientRegistry().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonNew;
    private javax.swing.JComboBox<String> comboBoxTestStatus;
    private com.toedter.calendar.JDateChooser dateChooserBirthdate;
    private com.toedter.calendar.JDateChooser dateChooserTestDay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelBirthdate;
    private javax.swing.JLabel labelFirstLastName;
    private javax.swing.JLabel labelIdPatient;
    private javax.swing.JLabel labelNamePatient;
    private javax.swing.JLabel labelNationality;
    private javax.swing.JLabel labelObservations;
    private javax.swing.JLabel labelPhoneNumber;
    private javax.swing.JLabel labelSecondLastName;
    private javax.swing.JLabel labelTestDay;
    private javax.swing.JLabel labelTestStatus;
    private javax.swing.JLabel patientRegistryLabel;
    private javax.swing.JTextArea textAreaObservations;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldFirstLastName;
    private javax.swing.JTextField textFieldIdPatient;
    private javax.swing.JTextField textFieldNamePatient;
    private javax.swing.JTextField textFieldNationality;
    private javax.swing.JTextField textFieldPhoneNumber;
    private javax.swing.JTextField textFieldSecondLastName;
    // End of variables declaration//GEN-END:variables
}
