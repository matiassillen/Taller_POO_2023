/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;
import Model.FuncionarioGeneral;
import static java.lang.String.valueOf;
/**
 *
 * @author Usuario
 */
public class MiUsuario extends javax.swing.JFrame {
    FuncionarioGeneral UsuarioRegistrado;
    /**
     * Creates new form MiUsuario
     */
    public MiUsuario(FuncionarioGeneral funcionarioGral) {
        UsuarioRegistrado = funcionarioGral;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtApellido2 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JLabel();
        txtDni2 = new javax.swing.JLabel();
        txtFechaN = new javax.swing.JLabel();
        txtEstado2 = new javax.swing.JLabel();
        txtTelF2 = new javax.swing.JLabel();
        txtTelC2 = new javax.swing.JLabel();
        txtCorreo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mi Usuario");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 80, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 180, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 50, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estado civil:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 170, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefono fijo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 120, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Telefono celular:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 160, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo electronico:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 170, 30));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setLabel("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 30));

        txtApellido2.setBackground(new java.awt.Color(204, 204, 204));
        txtApellido2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellido2.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido2.setOpaque(true);
        jPanel1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 210, 30));

        txtNombre2.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre2.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre2.setOpaque(true);
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 210, 30));

        txtDni2.setBackground(new java.awt.Color(204, 204, 204));
        txtDni2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni2.setForeground(new java.awt.Color(0, 0, 0));
        txtDni2.setOpaque(true);
        jPanel1.add(txtDni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 210, 30));

        txtFechaN.setBackground(new java.awt.Color(204, 204, 204));
        txtFechaN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFechaN.setForeground(new java.awt.Color(0, 0, 0));
        txtFechaN.setOpaque(true);
        jPanel1.add(txtFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 210, 30));

        txtEstado2.setBackground(new java.awt.Color(204, 204, 204));
        txtEstado2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEstado2.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado2.setOpaque(true);
        jPanel1.add(txtEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 210, 30));

        txtTelF2.setBackground(new java.awt.Color(204, 204, 204));
        txtTelF2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelF2.setForeground(new java.awt.Color(0, 0, 0));
        txtTelF2.setOpaque(true);
        jPanel1.add(txtTelF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 210, 30));

        txtTelC2.setBackground(new java.awt.Color(204, 204, 204));
        txtTelC2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelC2.setForeground(new java.awt.Color(0, 0, 0));
        txtTelC2.setOpaque(true);
        jPanel1.add(txtTelC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 210, 30));

        txtCorreo2.setBackground(new java.awt.Color(204, 204, 204));
        txtCorreo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreo2.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo2.setOpaque(true);
        jPanel1.add(txtCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 210, 30));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setMuestra(UsuarioRegistrado);
    }//GEN-LAST:event_formWindowOpened
    
    private void setMuestra(FuncionarioGeneral fun) {
        txtNombre2.setText(fun.getNombre());    
        txtApellido2.setText(fun.getApellido());
        txtCorreo2.setText(fun.getCorreoE());
        txtDni2.setText(String.valueOf(fun.getDni()));
        txtEstado2.setText(fun.getEstadoCivil());
        txtFechaN.setText(fun.getFechaDeNac());
        txtTelC2.setText(fun.getTelefonoFijo());
        txtTelF2.setText(fun.getTelefonoCel());
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel txtApellido2;
    private javax.swing.JLabel txtCorreo2;
    private javax.swing.JLabel txtDni2;
    private javax.swing.JLabel txtEstado2;
    private javax.swing.JLabel txtFechaN;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JLabel txtTelC2;
    private javax.swing.JLabel txtTelF2;
    // End of variables declaration//GEN-END:variables
}
