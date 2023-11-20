/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;
import Model.Controladora;
import Model.FuncionarioGeneral;
import Model.Usuario;
import java.awt.Color;
import static java.lang.String.valueOf;
/**
 *
 * @author
 */
public class MiUsuario extends javax.swing.JFrame {
    int xMouse;
    int yMouse;
    private FuncionarioGeneral usuarioRegistrado;
    private Controladora user;
    /**
     * Creates new form MiUsuario
     * @param user Es el usuario que ingreso en la aplicacion 
     */
    public MiUsuario(Controladora user) {
        this.user = user;
        this.usuarioRegistrado = user.getUsu().getFuncionarioGeneral();
        initComponents();
        this.setMuestra();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JLabel();
        txtDni2 = new javax.swing.JLabel();
        txtFechaN = new javax.swing.JLabel();
        txtEstado2 = new javax.swing.JLabel();
        txtTelF2 = new javax.swing.JLabel();
        txtTelC2 = new javax.swing.JLabel();
        txtCorreo2 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JLabel();
        txtIdNum = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 490));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 60, 30));

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 70, 30));

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 150, 30));

        jLabel5.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 30, 30));

        jLabel6.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado civil:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 100, 30));

        jLabel7.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefono fijo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 110, 30));

        jLabel8.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Telefono celular:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 130, 30));

        jLabel9.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo electronico:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 30));

        txtApellido2.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellido2.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido2.setOpaque(true);
        jPanel1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 170, 30));

        txtNombre2.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre2.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre2.setOpaque(true);
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, 30));

        txtDni2.setBackground(new java.awt.Color(255, 255, 255));
        txtDni2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni2.setForeground(new java.awt.Color(0, 0, 0));
        txtDni2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDni2.setOpaque(true);
        jPanel1.add(txtDni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 170, 30));

        txtFechaN.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFechaN.setForeground(new java.awt.Color(0, 0, 0));
        txtFechaN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFechaN.setOpaque(true);
        jPanel1.add(txtFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 170, 30));

        txtEstado2.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado2.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEstado2.setOpaque(true);
        jPanel1.add(txtEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 170, 30));

        txtTelF2.setBackground(new java.awt.Color(255, 255, 255));
        txtTelF2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelF2.setForeground(new java.awt.Color(0, 0, 0));
        txtTelF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTelF2.setOpaque(true);
        jPanel1.add(txtTelF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 170, 30));

        txtTelC2.setBackground(new java.awt.Color(255, 255, 255));
        txtTelC2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelC2.setForeground(new java.awt.Color(0, 0, 0));
        txtTelC2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTelC2.setOpaque(true);
        jPanel1.add(txtTelC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 170, 30));

        txtCorreo2.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo2.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo2.setOpaque(true);
        jPanel1.add(txtCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 170, 30));

        txtIdUser.setBackground(new java.awt.Color(255, 255, 255));
        txtIdUser.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtIdUser.setForeground(new java.awt.Color(255, 255, 255));
        txtIdUser.setText("Id de Usuario:");
        jPanel1.add(txtIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 140, 40));

        txtIdNum.setBackground(new java.awt.Color(255, 255, 255));
        txtIdNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIdNum.setForeground(new java.awt.Color(0, 0, 0));
        txtIdNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtIdNum.setOpaque(true);
        jPanel1.add(txtIdNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 150, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/istockphoto-818149276-170667a.jpg"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));

        txtSalir.setBackground(new java.awt.Color(255, 255, 255));
        txtSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSalir.setForeground(new java.awt.Color(0, 0, 0));
        txtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalir.setText("X");
        txtSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318)
                .addComponent(jLabel12)
                .addGap(0, 404, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mi Usuario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

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
     
    /**
     * Carga los datos del usuario en pantalla al abrir la ventana
     * @param evt 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setMuestra();
    }//GEN-LAST:event_formWindowOpened

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void txtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseExited
        txtSalir.setForeground(Color.black);
    }//GEN-LAST:event_txtSalirMouseExited

    private void txtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseEntered
        txtSalir.setForeground(Color.red);
    }//GEN-LAST:event_txtSalirMouseEntered

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_txtSalirMouseClicked
    
    /**
     * Prepara los datos del usuario para ser visualizados
     */
    private void setMuestra() {
        txtNombre2.setText(usuarioRegistrado.getNombre());    
        txtApellido2.setText(usuarioRegistrado.getApellido());
        txtCorreo2.setText(usuarioRegistrado.getCorreoE());
        txtDni2.setText(String.valueOf(usuarioRegistrado.getDni()));
        txtEstado2.setText(usuarioRegistrado.getEstadoCivil());
        txtFechaN.setText(usuarioRegistrado.getFechaDeNac());
        txtTelC2.setText(usuarioRegistrado.getTelefonoFijo());
        txtTelF2.setText(usuarioRegistrado.getTelefonoCel());
        txtIdNum.setText(String.valueOf(user.getUsu().getId()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtApellido2;
    private javax.swing.JLabel txtCorreo2;
    private javax.swing.JLabel txtDni2;
    private javax.swing.JLabel txtEstado2;
    private javax.swing.JLabel txtFechaN;
    private javax.swing.JLabel txtIdNum;
    private javax.swing.JLabel txtIdUser;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JLabel txtSalir;
    private javax.swing.JLabel txtTelC2;
    private javax.swing.JLabel txtTelF2;
    // End of variables declaration//GEN-END:variables
}
