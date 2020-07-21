/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Models.Patient;
import Services.PatientsService;
import static Utilities.ValidateForm.manipulateString;
import WindowsBackground.CustomPanel;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

/**
 * @author JD101
 */
public class PatientModify extends javax.swing.JFrame {

    //  Variables and Objects
    //  ------------------------------------------------------------------------
    private PatientSearch formPatientSearch;
    private Patient patient;
    //  ------------------------------------------------------------------------

    /**
     * Creates new form PatientModify
     */
    public PatientModify() {
        initComponents();
    }

    /**
     * Crea un nuevo formulario PatientModify.
     *
     * @param formPatientSearch Recibe un formulario de tipo PatientSearch para
     * hacer a PatientModify una ventana tipo modal.
     * @param patient Recibe este tipo de valor para hacer un uso más eficiente
     * de la información.
     * @throws java.text.ParseException
     */
    public PatientModify(PatientSearch formPatientSearch, Patient patient) throws ParseException {

        this.formPatientSearch = formPatientSearch;
        this.formPatientSearch.setEnabled(false);
        this.patient = patient;

        initComponents();
        lockComponents();
        dataAllocation();
        textFieldNamePatient.requestFocus();
        setLocationRelativeTo(formPatientSearch);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new CustomPanel("/Images/PatientModify/backgroundBelow.png");
        jPanel2 = new CustomPanel("/Images/PatientModify/background.png");
        labelIdPatient = new javax.swing.JLabel();
        textFieldIdPatient = new javax.swing.JTextField();
        labelNamePatient = new javax.swing.JLabel();
        textFieldNamePatient = new javax.swing.JTextField();
        labelFirstLastName = new javax.swing.JLabel();
        textFieldFirstLastName = new javax.swing.JTextField();
        labelSecondLastName = new javax.swing.JLabel();
        textFieldSecondLastName = new javax.swing.JTextField();
        labelNationality = new javax.swing.JLabel();
        labelBirthdate = new javax.swing.JLabel();
        dateChooserBirthdate = new com.toedter.calendar.JDateChooser();
        labelTestDay = new javax.swing.JLabel();
        dateChooserTestDay = new com.toedter.calendar.JDateChooser();
        labelTestStatus = new javax.swing.JLabel();
        comboBoxTestStatus = new javax.swing.JComboBox<>();
        labelPhoneNumber = new javax.swing.JLabel();
        textFieldPhoneNumber = new javax.swing.JTextField();
        labelAddress = new javax.swing.JLabel();
        textFieldAddress = new javax.swing.JTextField();
        labelObservations = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservations = new javax.swing.JTextArea();
        buttonModify = new javax.swing.JButton();
        comboBoxNationality = new javax.swing.JComboBox<>();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Paciente");
        setPreferredSize(new java.awt.Dimension(555, 640));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(540, 610));

        jPanel2.setPreferredSize(new java.awt.Dimension(480, 550));
        jPanel2.setRequestFocusEnabled(false);

        labelIdPatient.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelIdPatient.setText("Número de cédula:");

        textFieldIdPatient.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldIdPatient.setToolTipText("");
        textFieldIdPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIdPatientActionPerformed(evt);
            }
        });

        labelNamePatient.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelNamePatient.setText("Nombre:");

        textFieldNamePatient.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldNamePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNamePatientActionPerformed(evt);
            }
        });

        labelFirstLastName.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelFirstLastName.setText("Primer apellido:");

        textFieldFirstLastName.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFirstLastNameActionPerformed(evt);
            }
        });

        labelSecondLastName.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelSecondLastName.setText("Segundo apellido:");

        textFieldSecondLastName.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSecondLastNameActionPerformed(evt);
            }
        });

        labelNationality.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelNationality.setText("Nacionalidad: ");

        labelBirthdate.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelBirthdate.setText("Fecha de nacimiento:");

        dateChooserBirthdate.setDateFormatString("yyyy/MM/dd");
        dateChooserBirthdate.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        labelTestDay.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelTestDay.setText("Día de la prueba:");

        dateChooserTestDay.setDateFormatString("yyyy/MM/dd");
        dateChooserTestDay.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        labelTestStatus.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelTestStatus.setText("Estado de la prueba:");

        comboBoxTestStatus.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        comboBoxTestStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Negativo", "Positivo", "Recuperado" }));
        comboBoxTestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTestStatusActionPerformed(evt);
            }
        });

        labelPhoneNumber.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelPhoneNumber.setText("Número de télefono:");

        textFieldPhoneNumber.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneNumberActionPerformed(evt);
            }
        });

        labelAddress.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelAddress.setText("Dirección:");

        textFieldAddress.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAddressActionPerformed(evt);
            }
        });

        labelObservations.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelObservations.setText("Observaciones:");

        textAreaObservations.setColumns(20);
        textAreaObservations.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textAreaObservations.setLineWrap(true);
        textAreaObservations.setRows(5);
        jScrollPane1.setViewportView(textAreaObservations);

        buttonModify.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        buttonModify.setForeground(new java.awt.Color(255, 255, 255));
        buttonModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientModify/buttonModify.png"))); // NOI18N
        buttonModify.setText("Aceptar");
        buttonModify.setBorder(null);
        buttonModify.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonModify.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientModify/buttonModifyRollOver.png"))); // NOI18N
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        comboBoxNationality.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        comboBoxNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bisáu", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa", "República del Congo", "República Democrática del Congo", "República Dominicana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" }));

        buttonCancel.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientModify/buttonCancel.png"))); // NOI18N
        buttonCancel.setText("Cancelar");
        buttonCancel.setBorder(null);
        buttonCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PatientModify/buttonCancelRollOver.png"))); // NOI18N
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAddress)
                        .addComponent(labelObservations)
                        .addComponent(labelTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTestStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelFirstLastName)
                    .addComponent(labelSecondLastName)
                    .addComponent(labelNationality)
                    .addComponent(labelBirthdate)
                    .addComponent(labelIdPatient)
                    .addComponent(labelNamePatient))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textFieldNamePatient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldSecondLastName)
                                    .addComponent(textFieldFirstLastName)
                                    .addComponent(dateChooserBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxNationality, javax.swing.GroupLayout.Alignment.TRAILING, 0, 257, Short.MAX_VALUE))
                                .addComponent(textFieldIdPatient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonModify)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCancel))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxTestStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldIdPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNamePatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamePatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFirstLastName)
                    .addComponent(textFieldFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSecondLastName)
                    .addComponent(textFieldSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNationality)
                    .addComponent(comboBoxNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBirthdate)
                    .addComponent(dateChooserBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTestDay)
                    .addComponent(dateChooserTestDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTestStatus)
                    .addComponent(comboBoxTestStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhoneNumber)
                    .addComponent(textFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress)
                    .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelObservations)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonModify))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  Own Code
    //  ------------------------------------------------------------------------
    /**
     * Bloquea el editor de fecha para que no pueda ser editado por teclado.
     */
    private void lockComponents() {

        textFieldIdPatient.setEditable(false);
        ((JTextFieldDateEditor) dateChooserBirthdate.getDateEditor()).setEnabled(false);
        ((JTextFieldDateEditor) dateChooserTestDay.getDateEditor()).setEnabled(false);

    }

    /**
     * Toma la información de un objeto tipo Patient y la coloca en los
     * componentes de la ventana.
     *
     * @throws ParseException Controla los errores al hacer la conversión de un
     * objeto tipo String a uno tipo Date.
     */
    private void dataAllocation() throws ParseException {

        textFieldIdPatient.setText(this.patient.getIdPatient());
        textFieldNamePatient.setText(this.patient.getNamePatient());
        textFieldFirstLastName.setText(this.patient.getFirstLastName());
        textFieldSecondLastName.setText(this.patient.getSecondLastName());

        int indexComboBoxNationality = 0;
        for (int i = 0; i < (comboBoxNationality.getItemCount() - 1); i++) {

            if (this.patient.getNationality().equals(comboBoxNationality.getItemAt(i))) {
                indexComboBoxNationality = i;
            }

        }

        comboBoxNationality.setSelectedIndex(indexComboBoxNationality);
        Date dateBirthdate = new SimpleDateFormat("yyy-MM-dd").parse(this.patient.getBirthdate());
        dateChooserBirthdate.setDate(dateBirthdate);
        Date dateTestDay = new SimpleDateFormat("yyy-MM-dd").parse(this.patient.getTestDay());
        dateChooserTestDay.setDate(dateTestDay);

        int indexComboBoxTestStatus = 0;
        for (int i = 0; i < comboBoxTestStatus.getItemCount(); i++) {

            if (this.patient.getTestStatus().equals(comboBoxTestStatus.getItemAt(i))) {
                indexComboBoxTestStatus = i;
            }

        }

        comboBoxTestStatus.setSelectedIndex(indexComboBoxTestStatus);
        textFieldPhoneNumber.setText(this.patient.getPhoneNumber());
        textFieldAddress.setText(this.patient.getAddress());
        textAreaObservations.setText(this.patient.getObservations());

    }

    /**
     * Crea un objeto de tipo Patient para rellenar los atributos de este con
     * los datos extraídos de los componentes del formulario.
     *
     * @return Retorna un objeto de tipo Patient con todos los atributos
     * completos y manipulados.
     */
    private Patient getPatientData() {

        Patient patientData = new Patient();

        patientData.setIdPatient(textFieldIdPatient.getText().trim());
        patientData.setNamePatient(manipulateString(textFieldNamePatient.getText()));
        patientData.setFirstLastName(manipulateString(textFieldFirstLastName.getText()));
        patientData.setSecondLastName(manipulateString(textFieldSecondLastName.getText()));
        patientData.setNationality(comboBoxNationality.getSelectedItem().toString());
        patientData.setBirthdate(((JTextComponent) dateChooserBirthdate.getDateEditor().getUiComponent()).getText());
        patientData.setTestDay(((JTextComponent) dateChooserTestDay.getDateEditor().getUiComponent()).getText());
        patientData.setTestStatus(comboBoxTestStatus.getSelectedItem().toString());
        patientData.setPhoneNumber(textFieldPhoneNumber.getText().trim());
        patientData.setAddress(manipulateString(textFieldAddress.getText()));
        patientData.setObservations(manipulateString(textAreaObservations.getText()));

        return patientData;

    }

    /**
     * Crea un objeto de tipo Patient, luego obtiene los datos para rellenar al
     * objeto, realiza las comprobaciones necesarias para hacer la actualización
     * del registro, si todos los datos están completos y son del tipo adecuado
     * de procede a realizar la actualización del registro, al finalizar se
     * cierra el formulario.
     *
     * @throws SQLException Controla los errores tipo SQL que se pudieran dar
     * por la actualización del registro de la base de datos.
     */
    private void updatePatient() throws SQLException {

        PatientsService patientsService = new PatientsService();
        Patient patientModification = getPatientData();

        if (patientsService.validateAllDataIncomplete(patientModification)) {

            JOptionPane.showMessageDialog(null, "Todos los campos requeridos por "
                    + "el formulario están vacíos, rellénelos y vuelva a intentar "
                    + "ingresar al paciente.");

        } else if (patientsService.validateDataByData(patientModification)) {

            JOptionPane.showMessageDialog(null, "Uno o más campos requeridos "
                    + "por el formulario están vacíos, rellénelos y vuelva a "
                    + "intentar ingresar al paciente.");

        } else if (!patientsService.validateDataTypes(patientModification)) {

            JOptionPane.showMessageDialog(null, "Uno o más tipos de datos no son "
                    + "los solicitados por el formulario, revíselos y vuelva a "
                    + "intentar ingresar al paciente.");

        } else {

            if (patientsService.updateData(patientModification)) {

                this.dispose();

            }

        }

    }

    /**
     * Habilita y da el focus a la ventana de buscar paciente al cerrar esta
     * ventana.
     *
     * @param evt
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        this.formPatientSearch.setEnabled(true);
        this.formPatientSearch.requestFocus();

    }//GEN-LAST:event_formWindowClosed

    private void textFieldIdPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIdPatientActionPerformed
        textFieldNamePatient.requestFocus();
    }//GEN-LAST:event_textFieldIdPatientActionPerformed

    private void textFieldNamePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNamePatientActionPerformed
        textFieldNamePatient.transferFocus();
    }//GEN-LAST:event_textFieldNamePatientActionPerformed

    private void textFieldFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstLastNameActionPerformed
        textFieldFirstLastName.transferFocus();
    }//GEN-LAST:event_textFieldFirstLastNameActionPerformed

    private void textFieldSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSecondLastNameActionPerformed
        textFieldSecondLastName.transferFocus();
    }//GEN-LAST:event_textFieldSecondLastNameActionPerformed

    private void comboBoxTestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTestStatusActionPerformed
        comboBoxTestStatus.transferFocus();
    }//GEN-LAST:event_comboBoxTestStatusActionPerformed

    private void textFieldPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneNumberActionPerformed
        textFieldPhoneNumber.transferFocus();
    }//GEN-LAST:event_textFieldPhoneNumberActionPerformed

    private void textFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAddressActionPerformed
        textFieldAddress.transferFocus();
    }//GEN-LAST:event_textFieldAddressActionPerformed

    /**
     * Llama al método updatePatient() al presionar el botón.
     *
     * @param evt
     */
    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed

        try {
            updatePatient();
        } catch (SQLException ex) {
            Logger.getLogger(PatientModify.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonModifyActionPerformed

    /**
     * Cierra el formulario al presionar el botón de cancelar.
     *
     * @param evt
     */
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed
    //  ------------------------------------------------------------------------

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientModify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonModify;
    private javax.swing.JComboBox<String> comboBoxNationality;
    private javax.swing.JComboBox<String> comboBoxTestStatus;
    private com.toedter.calendar.JDateChooser dateChooserBirthdate;
    private com.toedter.calendar.JDateChooser dateChooserTestDay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTextArea textAreaObservations;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldFirstLastName;
    private javax.swing.JTextField textFieldIdPatient;
    private javax.swing.JTextField textFieldNamePatient;
    private javax.swing.JTextField textFieldPhoneNumber;
    private javax.swing.JTextField textFieldSecondLastName;
    // End of variables declaration//GEN-END:variables
}
