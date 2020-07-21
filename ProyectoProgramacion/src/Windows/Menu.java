/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Models.User;
import WindowsBackground.CustomPanel;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author JD101
 */
public class Menu extends javax.swing.JFrame {

    //  Variables and Objects
    //  ------------------------------------------------------------------------
    private User user;
    //  ------------------------------------------------------------------------

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Crea un nuevo formulario Menu.
     *
     * @param window Recibe un parámetro tipo JFrame para localizarse de acuerdo
     * a este.
     * @param user Recibe un parámetro de tipo User para mantener un control de
     * los permisos de usuario.
     */
    public Menu(JFrame window, User user) {

        initComponents();
        setLocationRelativeTo(window);

        this.user = user;

        if (this.user.getPermissions() != 1) {
            buttonUserRegistry.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new CustomPanel("/Images/Menu/backgroundBelow.png");
        jPanel2 = new CustomPanel("/Images/Menu/background.png");
        buttonPatientRegistry = new javax.swing.JButton();
        buttonStatistics = new javax.swing.JButton();
        buttonPatientSearch = new javax.swing.JButton();
        buttonUserRegistry = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setPreferredSize(new java.awt.Dimension(900, 627));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));

        buttonPatientRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/patientRegistry.png"))); // NOI18N
        buttonPatientRegistry.setBorder(null);
        buttonPatientRegistry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPatientRegistry.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/patientRegistryRollOver.png"))); // NOI18N
        buttonPatientRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPatientRegistryActionPerformed(evt);
            }
        });

        buttonStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/statistics.png"))); // NOI18N
        buttonStatistics.setBorder(null);
        buttonStatistics.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonStatistics.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/statisticsRollOver.png"))); // NOI18N

        buttonPatientSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/patientSearch.png"))); // NOI18N
        buttonPatientSearch.setBorder(null);
        buttonPatientSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPatientSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/searchSearchRollOver.png"))); // NOI18N
        buttonPatientSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPatientSearchActionPerformed(evt);
            }
        });

        buttonUserRegistry.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        buttonUserRegistry.setForeground(new java.awt.Color(255, 255, 255));
        buttonUserRegistry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/exit.png"))); // NOI18N
        buttonUserRegistry.setText("Usuarios");
        buttonUserRegistry.setBorder(null);
        buttonUserRegistry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonUserRegistry.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/exitRollOver.png"))); // NOI18N

        buttonExit.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/exit.png"))); // NOI18N
        buttonExit.setText("Salir");
        buttonExit.setBorder(null);
        buttonExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/exitRollOver.png"))); // NOI18N
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/logo.jpeg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(170, 130));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(buttonPatientRegistry)
                .addGap(18, 18, 18)
                .addComponent(buttonPatientSearch)
                .addGap(18, 18, 18)
                .addComponent(buttonStatistics)
                .addGap(120, 127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(buttonUserRegistry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonExit)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPatientSearch)
                    .addComponent(buttonStatistics)
                    .addComponent(buttonPatientRegistry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonExit)
                    .addComponent(buttonUserRegistry))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  Own Code
    //  ------------------------------------------------------------------------
    /**
     * Cierra el formulario y crea uno nuevo tipo PatientRegistry.
     *
     * @param evt
     */
    private void buttonPatientRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPatientRegistryActionPerformed

        this.dispose();

        PatientRegistry formPatientRegistry = new PatientRegistry(this, this.user);
        formPatientRegistry.setVisible(true);

    }//GEN-LAST:event_buttonPatientRegistryActionPerformed

    /**
     * Cierra el formulario y crea uno nuevo tipo PatientSearch.
     * @param evt 
     */
    private void buttonPatientSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPatientSearchActionPerformed

        this.dispose();

        try {
            PatientSearch formPatiPatientSearch = new PatientSearch(this, this.user);
            formPatiPatientSearch.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_buttonPatientSearchActionPerformed

    /**
     * Cierra el formulario y crea uno nuevo tipo Login.
     * @param evt 
     */
    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed

        this.dispose();

        Login formLogin = new Login(this);
        formLogin.setVisible(true);

    }//GEN-LAST:event_buttonExitActionPerformed
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

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPatientRegistry;
    private javax.swing.JButton buttonPatientSearch;
    private javax.swing.JButton buttonStatistics;
    private javax.swing.JButton buttonUserRegistry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
