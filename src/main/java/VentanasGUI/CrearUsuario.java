/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

import Model.AdministradorDeSistema;
import Model.Controladora;
import Model.Rol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matías Sillen Ríos
 */
public class CrearUsuario extends javax.swing.JFrame {
    AdministradorDeSistema administrador = null;
    Controladora control;
    String nombre;
    String apellido;
    int dni;
    /**
     * Creates new form CrearUsuario
     * @param control
     * @param nombre
     * @param apellido
     * @param dni
     */
    public CrearUsuario(Controladora control, String nombre, String apellido, int dni) {
        administrador = new AdministradorDeSistema();
        this.control = control;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        cbTriagiador = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        cbTomarPaciente = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(100, 196, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Asignar Roles");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Rol:");

        cmbRol.setBackground(new java.awt.Color(255, 255, 255));
        cmbRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbRol.setForeground(new java.awt.Color(0, 0, 0));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gestor", "Recepcionista", "Medico", "Licenciado en Enfermeria", "Administrador de Sistema" }));

        cbTriagiador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTriagiador.setForeground(new java.awt.Color(0, 0, 0));
        cbTriagiador.setText("Triagiador");

        btnGuardar.setBackground(new java.awt.Color(100, 196, 244));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cbTomarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTomarPaciente.setForeground(new java.awt.Color(0, 0, 0));
        cbTomarPaciente.setText("Tomar Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTriagiador)
                    .addComponent(cbTomarPaciente)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(15, 15, 15)
                .addComponent(cbTomarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTriagiador)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        cbTomarPaciente.setSelected(false);
        cbTriagiador.setSelected(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String nombreUsaurio = nombre + "  " + apellido;

        String contrasenia = String.valueOf(dni);
        
        String rolUsu = String.valueOf(cmbRol.getSelectedItem());

        Rol rol = new Rol();
        rol.setNombre(rolUsu);

        List<Rol> roles = new ArrayList<>();
        
        roles.add(rol);

        if (rolUsu.equalsIgnoreCase("Medico")) {
            
            cbTomarPaciente.setSelected(true);
            cbTriagiador.setSelected(true);

            if (cbTomarPaciente.isSelected()) {
                
                rol.setNombre("Tomar Paciente");
                roles.add(rol);
            }

            if (cbTriagiador.isSelected()) {
                
                rol.setNombre("Triagiador");
                roles.add(rol);
            }
        }
            administrador.crearUsuario(nombreUsaurio, contrasenia, roles);

    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbTomarPaciente;
    private javax.swing.JCheckBox cbTriagiador;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
