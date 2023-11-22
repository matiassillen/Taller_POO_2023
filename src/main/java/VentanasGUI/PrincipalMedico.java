package VentanasGUI;

import Model.Controladora;
import Model.Rol;
import java.awt.Color;
import java.util.List;

/**
 * Esta clase representa una ventana de la interfaz gráfica de usuario que
 * permite seleccionar entre Gestionar Pacientes y Hacer Triage segun el rol del
 * mismo.
 *
 * @author yairc
 */
public class PrincipalMedico extends javax.swing.JFrame {

    Controladora control;

    /**
     * Constructor de PrincipalMedico
     *
     * @param control
     */
    public PrincipalMedico(Controladora control) {
        initComponents();
        this.control = control;
        identificarRol();
        
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
        jlbHacerTriage = new javax.swing.JLabel();
        jlbGestionPaciente = new javax.swing.JLabel();
        jlbMiUsu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jlbCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbHacerTriage.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jlbHacerTriage.setForeground(new java.awt.Color(0, 0, 0));
        jlbHacerTriage.setText("Hacer Triage");
        jlbHacerTriage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbHacerTriage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHacerTriageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbHacerTriageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbHacerTriageMouseExited(evt);
            }
        });
        jPanel1.add(jlbHacerTriage, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, -1, -1));

        jlbGestionPaciente.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jlbGestionPaciente.setForeground(new java.awt.Color(0, 0, 0));
        jlbGestionPaciente.setText("Gestion de Pacientes");
        jlbGestionPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbGestionPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbGestionPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbGestionPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbGestionPacienteMouseExited(evt);
            }
        });
        jPanel1.add(jlbGestionPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jlbMiUsu.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jlbMiUsu.setForeground(new java.awt.Color(0, 0, 0));
        jlbMiUsu.setText("Mi Usuario");
        jlbMiUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbMiUsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbMiUsuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbMiUsuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbMiUsuMouseExited(evt);
            }
        });
        jPanel1.add(jlbMiUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gestión Médica");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 250, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 250, 10));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMedico.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 380));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medico (1).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 250, 20));

        jlbCerrar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jlbCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jlbCerrar.setText("Cerrar sesión");
        jlbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseExited(evt);
            }
        });
        jPanel1.add(jlbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbGestionPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGestionPacienteMouseClicked
        // Creamos una nueva instancia de la ventana GestionDePacientes
        GestionDePacientes tomarP = new GestionDePacientes(control);
        // Hacemos visible la ventana
        tomarP.setVisible(true);
        // Centramos la ventana en la pantalla
        tomarP.setLocationRelativeTo(null);
        // Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_jlbGestionPacienteMouseClicked

    private void jlbHacerTriageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHacerTriageMouseClicked
        // Creamos una nueva instancia de la ventana EsperaTriage
        EsperaTriage hacerT = new EsperaTriage(control);
        // Hacemos visible la ventana
        hacerT.setVisible(true);
        // Centramos la ventana en la pantalla
        hacerT.setLocationRelativeTo(null);
        // Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_jlbHacerTriageMouseClicked

    private void jlbMiUsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMiUsuMouseClicked
        // Creamos una nueva instancia de la ventana MiUsuario
        MiUsuario miUsu = new MiUsuario(control);
        // Hacemos visible la ventana
        miUsu.setVisible(true);
        // Centramos la ventana en la pantalla
        miUsu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlbMiUsuMouseClicked

    private void jlbGestionPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGestionPacienteMouseEntered
        jlbGestionPaciente.setForeground(Color.cyan);
    }//GEN-LAST:event_jlbGestionPacienteMouseEntered

    private void jlbGestionPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGestionPacienteMouseExited
        jlbGestionPaciente.setForeground(Color.black);
    }//GEN-LAST:event_jlbGestionPacienteMouseExited

    private void jlbHacerTriageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHacerTriageMouseEntered
        jlbHacerTriage.setForeground(Color.cyan);
    }//GEN-LAST:event_jlbHacerTriageMouseEntered

    private void jlbHacerTriageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHacerTriageMouseExited
        jlbHacerTriage.setForeground(Color.black);
    }//GEN-LAST:event_jlbHacerTriageMouseExited

    private void jlbMiUsuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMiUsuMouseEntered
        jlbMiUsu.setForeground(Color.cyan);
    }//GEN-LAST:event_jlbMiUsuMouseEntered

    private void jlbMiUsuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMiUsuMouseExited
        jlbMiUsu.setForeground(Color.black);
    }//GEN-LAST:event_jlbMiUsuMouseExited

    private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
        GuiLogin pantallaLogin = new GuiLogin();
        pantallaLogin.setVisible(true);
        pantallaLogin.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jlbCerrarMouseClicked

    private void jlbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseEntered
        jlbCerrar.setForeground(Color.cyan);
    }//GEN-LAST:event_jlbCerrarMouseEntered

    private void jlbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseExited
        jlbCerrar.setForeground(Color.black);
    }//GEN-LAST:event_jlbCerrarMouseExited

    /**
     * Este método identifica el rol del usuario y habilita los botones
     * correspondientes en la interfaz. Recorre la lista de roles del usuario y
     * habilita los botones de 'Gestión de Paciente' y 'Hacer Triage' según
     * corresponda.
     */
    private void identificarRol() {
        jlbGestionPaciente.setEnabled(false);
        jlbHacerTriage.setEnabled(false);
        try {
            // Obtenemos la lista de roles del usuario
            List<Rol> roles = this.control.getUsu().getRol();

            // Recorremos la lista de roles
            for (Rol rol : roles) {
                // Obtenemos el nombre del rol
                String nombreRol = rol.getNombre();

                // Según el nombre del rol, habilitamos los botones correspondientes
                switch (nombreRol) {
                    case "Medico - Atencion" -> {
                        // Si el rol es 'Medico - Atencion', habilitamos el botón 'GestioDePaciente' y deshabilitamos el botón 'HacerTriage'
                        jlbGestionPaciente.setEnabled(true);
                        jlbHacerTriage.setEnabled(false);
                    }
                    case "Medico - Triagiador" -> {
                        // Si el rol es 'Medico - Triage', deshabilitamos el botón 'GestioDePaciente' y habilitamos el botón 'HacerTriage'
                        jlbGestionPaciente.setEnabled(false);
                        jlbHacerTriage.setEnabled(true);
                    }
                    case "Licenciado en Enfermeria" -> {
                        // Si el rol es 'Licenciado en Enfermeria', deshabilitamos el botón 'GestioDePaciente' y habilitamos el botón 'HacerTriage'
                        jlbGestionPaciente.setEnabled(false);
                        jlbHacerTriage.setEnabled(true);
                    }
                    default -> {
                        // Si el rol es cualquier otro, habilitamos ambos botones
                        jlbGestionPaciente.setEnabled(true);
                        jlbHacerTriage.setEnabled(true);
                    }
                }
            }
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JLabel jlbGestionPaciente;
    private javax.swing.JLabel jlbHacerTriage;
    private javax.swing.JLabel jlbMiUsu;
    // End of variables declaration//GEN-END:variables
}
