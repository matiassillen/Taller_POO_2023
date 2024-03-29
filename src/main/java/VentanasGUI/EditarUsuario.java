/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

import Model.AdministradorDeSistema;
import Model.Controladora;
import Model.Rol;
import Model.Usuario;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author Matías Sillen Ríos
 */
public class EditarUsuario extends javax.swing.JFrame {

    Controladora control;
    long idUsuario;
    AdministradorDeSistema administrador;
    Usuario usuario;
    Administrador admin;

    /**
     * Creates new form EditarUsuario
     *
     * Este constructor tiene tres parámetros: administrador, control e
     * idUsuario. Estos parámetros se utilizan para inicializar los campos de la
     * clase.
     *
     * El primer parámetro, administrador, es un objeto de la clase
     * AdministradorDeSistema. El segundo parámetro, control, es un objeto de la
     * clase Controladora. El tercer parámetro, idUsuario, es un número entero
     * largo que se utiliza para identificar al usuario.
     *
     * Este constructor inicializa los campos de la clase y llama al método
     * initComponents para inicializar los componentes de la interfaz gráfica.
     *
     * @param administrador
     * @param control
     * @param idUsuario
     */
    public EditarUsuario(AdministradorDeSistema administrador, Controladora control, long idUsuario) {
        this.administrador = administrador;
        control = new Controladora();
        this.idUsuario = idUsuario;
        this.control = new Controladora();
        admin = new Administrador(control);
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
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        cmbRol = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbGuardar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nombre Usuario");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Contraseña");

        txtNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 14)); // NOI18N
        txtNombreUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreUsuario.setText("Ingresar nombre de usuario");
        txtNombreUsuario.setBorder(null);
        txtNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreUsuarioMousePressed(evt);
            }
        });
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContrasenia.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasenia.setText("********");
        txtContrasenia.setBorder(null);
        txtContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseniaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 421, -1, -1));

        cmbRol.setBackground(new java.awt.Color(255, 255, 255));
        cmbRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbRol.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 300, -1));

        jLabel13.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Rol");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Editar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(149, 210, 255));

        jlbGuardar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jlbGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        jlbGuardar.setText("Guardar");
        jlbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 130, 40));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 403, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * El método formWindowOpened se ejecuta cuando se abre la ventana. Este
     * método carga la información del usuario correspondiente a idUsuario y
     * muestra su información en los campos de texto txtNombreUsuario y
     * txtContrasenia. Además, carga los roles disponibles en un menú
     * desplegable cmbRol para que el usuario pueda seleccionar un rol.
     * Finalmente, selecciona el rol del usuario y lo marca en el menú
     * desplegable.
     */

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        usuario = control.traerUsuario(idUsuario);

        txtNombreUsuario.setText(usuario.getNomUsuario());
        txtContrasenia.setText(usuario.getPassw());

        cmbRol.setSelectedItem(usuario.getRol());
        //cargar roles de forma genérica
        List<Rol> listaRoles = control.traerRoles();

        if (listaRoles != null) {
            for (Rol rol : listaRoles) {
                cmbRol.addItem(rol.getNombre());
            }
        }

        //Marcar/Selecionar el rol del usuario
        String rol = usuario.getRol().getFirst().getNombre();

        int cantidadItems = cmbRol.getItemCount();

        for (int i = 0; i < cantidadItems; i++) {
            if (String.valueOf(cmbRol.getItemAt(i)).equalsIgnoreCase(rol)) {
                cmbRol.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void jlbGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGuardarMouseClicked
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        String rolUsu = (String) cmbRol.getSelectedItem();

        administrador.editarUsuario(usuario, nombreUsuario, contrasenia, rolUsu);

        //Avisar al administrador que se borro correctamente
        control.mostrarMensaje("Se editó el usuario conrrectamente", "info", "Edición correcta");
        admin.recargarTablaUsuarios();
        this.dispose();
    }//GEN-LAST:event_jlbGuardarMouseClicked

    private void jlbGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGuardarMouseEntered
        jlbGuardar.setForeground(Color.white);
    }//GEN-LAST:event_jlbGuardarMouseEntered

    private void jlbGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGuardarMouseExited
        jlbGuardar.setForeground(Color.black);
    }//GEN-LAST:event_jlbGuardarMouseExited

    private void txtNombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreUsuarioMousePressed
        if(txtNombreUsuario.getText().equalsIgnoreCase("Ingresar nombre de usuario")){
            txtNombreUsuario.setText("");
            txtNombreUsuario.setForeground(Color.black);
        }
        if(String.valueOf(txtContrasenia.getPassword()).isEmpty()){
            txtContrasenia.setText("********");
            txtContrasenia.setForeground (new Color(204,204,204));
        }
    }//GEN-LAST:event_txtNombreUsuarioMousePressed

    private void txtContraseniaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseniaMousePressed
        if(String.valueOf(txtContrasenia.getPassword()).equalsIgnoreCase("********")){
            txtContrasenia.setText("");
            txtContrasenia.setForeground(Color.black);
        }
        if(txtNombreUsuario.getText().isEmpty()){
            txtNombreUsuario.setText("Ingresar nombre de usuario");
            txtNombreUsuario.setForeground (new Color(204,204,204));
        }
    }//GEN-LAST:event_txtContraseniaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbGuardar;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
