/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;
import Model.Controladora;
import Model.Rol;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Agus
 */
public class GuiLogin extends javax.swing.JFrame {
    Controladora verif = new Controladora();
    /**
     * Creates new form Login
     */
    public GuiLogin() {
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

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        buttonSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Iniciar sesion");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Contraseña:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 210, 147, 34));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Usuario:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 127, 147, 34));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUsuario.setCaretColor(new java.awt.Color(0, 0, 0));
        txtUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtUsuario.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtUsuario.setSelectionColor(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 127, 174, 34));

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        txtContrasenia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtContrasenia.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtContrasenia.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel4.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 174, 34));

        buttonSesion.setBackground(new java.awt.Color(102, 204, 255));
        buttonSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonSesion.setForeground(new java.awt.Color(0, 0, 0));
        buttonSesion.setText("Iniciar sesion");
        buttonSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSesion.setInheritsPopupMenu(true);
        buttonSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSesionMouseClicked(evt);
            }
        });
        jPanel4.add(buttonSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 282, 174, 37));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    * Al cliquear el boton de iniciar sesion se ejecuta toda la comprobacion y seleccion de ventana
    */
    private void buttonSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSesionMouseClicked
        String usern = txtUsuario.getText();
        String passw = String.valueOf(txtContrasenia.getPassword());
        Usuario resultado = verif.validar(usern, passw);
        
        if (resultado != null) {
            verif.setUsu(resultado);
            
            List<Rol> rolUser = resultado.getRol();
            
            ArrayList<String> funcionarioSalud = new ArrayList<String>();
            String[] listaRoles = {"Medico - Atencion ", "Medico - Triagiador", "Medico - Atencion - Triagiador", "Licenciado en Enfermeria"};
            
            for (String agregarRol : listaRoles){
                funcionarioSalud.add(agregarRol);
            }
            if (funcionarioSalud.contains(rolUser.get(0).getNombre())) {
                PrincipalMedico pantallaSalud = new PrincipalMedico(verif);
                pantallaSalud.setVisible(true);
                pantallaSalud.setLocationRelativeTo(null);
                this.dispose();    
            }
            
            switch (rolUser.get(0).getNombre()) {
//                case "Gestor":
//                    Gestor pantallaGestion = new Gestor(verif);
//                    pantallaGestion.setVisible(true);
//                    pantallaGestion.setLocationRelativeTo(null);
//                    this.dispose();
//                    break;
//                
//                case "Recepcionista":
//                    BuscarPaciente pantallaRecepcion = new BuscarPaciente(verif);
//                    pantallaRecepcion.setVisible(true);
//                    pantallaRecepcion.setLocationRelativeTo(null);
//                    this.dispose();                    
//                    break;
//                
//                case "Administrador de Sistema":
//                    Administrador pantallaAdmin = new Administrador(verif);
//                    pantallaAdmin.setVisible(true);
//                    pantallaAdmin.setLocationRelativeTo(null);
//                    this.dispose();
//                    break;
                
                default:
                    break;
                }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Usuario no Encontrado");
        
        }
    }//GEN-LAST:event_buttonSesionMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
