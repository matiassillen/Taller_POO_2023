package VentanasGUI;

import Model.AdministradorDeSistema;
import Model.Controladora;
import java.awt.Color;

public class BuscarUsuario extends javax.swing.JFrame {

    AdministradorDeSistema administrador;
    Controladora control;

    /**
     * Creates new form BuscarUsuario
     *
     * Este constructor tiene dos parámetros: administrador y control. Estos
     * parámetros se utilizan para inicializar los campos de la clase.
     *
     * El primer parámetro, administrador, es un objeto de la clase
     * AdministradorDeSistema. El segundo parámetro, control, es un objeto de la
     * clase Controladora.
     *
     * Este constructor inicializa los campos de la clase y llama al método
     * initComponents para inicializar los componentes de la interfaz gráfica.
     *
     * @param administrador
     * @param control
     */
    public BuscarUsuario(AdministradorDeSistema administrador, Controladora control) {
        this.administrador = administrador;
        this.control = control;
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
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarUsuario = new javax.swing.JTextArea();
        jlbVolver = new javax.swing.JLabel();
        jlbLimpiar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 294));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DNI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 280, 30));

        txtDni.setBackground(new java.awt.Color(255, 255, 255));
        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDni.setForeground(new java.awt.Color(204, 204, 204));
        txtDni.setText("Ingresar dni");
        txtDni.setBorder(null);
        txtDni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDniMousePressed(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, 10));

        jPanel3.setBackground(new java.awt.Color(149, 210, 255));

        btnBuscarr.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnBuscarr.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarr.setText("Buscar");
        btnBuscarr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarrMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarr, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarr, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, 30));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(149, 210, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMostrarUsuario.setEditable(false);
        txtMostrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtMostrarUsuario.setColumns(20);
        txtMostrarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMostrarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtMostrarUsuario.setRows(5);
        jScrollPane1.setViewportView(txtMostrarUsuario);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, -1));

        jlbVolver.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbVolver.setForeground(new java.awt.Color(0, 0, 0));
        jlbVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVolver.setText("Volver");
        jlbVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbVolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbVolverMouseExited(evt);
            }
        });
        jPanel5.add(jlbVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 90, 30));

        jlbLimpiar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jlbLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLimpiar.setText("Limpiar");
        jlbLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbLimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbLimpiarMouseExited(evt);
            }
        });
        jPanel5.add(jlbLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 90, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 410, 300));

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

    private void jlbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLimpiarMouseClicked
        txtDni.setText("");
        txtMostrarUsuario.setText("");
    }//GEN-LAST:event_jlbLimpiarMouseClicked

    private void jlbVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlbVolverMouseClicked

    private void jlbVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseEntered
        jlbVolver.setForeground(Color.white);
    }//GEN-LAST:event_jlbVolverMouseEntered

    private void jlbLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLimpiarMouseEntered
        jlbLimpiar.setForeground(Color.white);
    }//GEN-LAST:event_jlbLimpiarMouseEntered

    private void txtDniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDniMousePressed
        if(txtDni.getText().equalsIgnoreCase("Ingresar dni")){
            txtDni.setText("");
            txtDni.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDniMousePressed

    private void btnBuscarrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarrMouseClicked
        String documento = txtDni.getText();
        String usuario;

        if (documento.length() != 8) {

            txtDni.setText("");
            control.mostrarMensaje("DNI no valido", "Error", "Error");

        } else {

            int dni = Integer.parseInt(txtDni.getText());
            usuario = control.mostrarUsuario(administrador.buscarUsuario(dni));
            txtMostrarUsuario.setText(usuario);

        }
                     
    }//GEN-LAST:event_btnBuscarrMouseClicked

    private void btnBuscarrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarrMouseExited
        btnBuscarr.setForeground(Color.black);
    }//GEN-LAST:event_btnBuscarrMouseExited

    private void btnBuscarrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarrMouseEntered
        btnBuscarr.setForeground(Color.white);
    }//GEN-LAST:event_btnBuscarrMouseEntered

    private void jlbVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseExited
        jlbVolver.setForeground(Color.black);
    }//GEN-LAST:event_jlbVolverMouseExited

    private void jlbLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLimpiarMouseExited
        jlbLimpiar.setForeground(Color.black);
    }//GEN-LAST:event_jlbLimpiarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscarr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbLimpiar;
    private javax.swing.JLabel jlbVolver;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextArea txtMostrarUsuario;
    // End of variables declaration//GEN-END:variables

}
