/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

/**
 *
 * @author trapo
 */
public class gestionHospital extends javax.swing.JFrame {

    /**
     * Creates new form gestionHospital
     */
    public gestionHospital() {
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
        btnCantPacienteMedico = new javax.swing.JButton();
        btnCantPaciente = new javax.swing.JButton();
        btnPacienteMasConsulta = new javax.swing.JButton();
        btnMedicoMasPaciente = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCantTriage = new javax.swing.JButton();
        btnTriageCambiado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCantPacienteMedico.setBackground(new java.awt.Color(100, 196, 244));
        btnCantPacienteMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCantPacienteMedico.setForeground(new java.awt.Color(0, 0, 0));
        btnCantPacienteMedico.setText("Cant. de Pacientes Atendidos Por Médico");
        btnCantPacienteMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantPacienteMedicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCantPacienteMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 300, 40));

        btnCantPaciente.setBackground(new java.awt.Color(100, 196, 244));
        btnCantPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCantPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnCantPaciente.setText("Cant. Pacientes Atendidos");
        btnCantPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCantPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 300, 40));

        btnPacienteMasConsulta.setBackground(new java.awt.Color(100, 196, 244));
        btnPacienteMasConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPacienteMasConsulta.setForeground(new java.awt.Color(0, 0, 0));
        btnPacienteMasConsulta.setText("Paciente con más Consultas");
        btnPacienteMasConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteMasConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPacienteMasConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 300, 40));

        btnMedicoMasPaciente.setBackground(new java.awt.Color(100, 196, 244));
        btnMedicoMasPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMedicoMasPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnMedicoMasPaciente.setText("Médico con más Pacientes");
        btnMedicoMasPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoMasPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnMedicoMasPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 300, 40));

        btnSalir.setBackground(new java.awt.Color(100, 196, 244));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        btnCantTriage.setBackground(new java.awt.Color(100, 196, 244));
        btnCantTriage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCantTriage.setForeground(new java.awt.Color(0, 0, 0));
        btnCantTriage.setText("Cant. de Triage y Color");
        jPanel1.add(btnCantTriage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 300, 40));

        btnTriageCambiado.setBackground(new java.awt.Color(100, 196, 244));
        btnTriageCambiado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTriageCambiado.setForeground(new java.awt.Color(0, 0, 0));
        btnTriageCambiado.setText("Triage Cambiados");
        jPanel1.add(btnTriageCambiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 300, 40));

        jPanel2.setBackground(new java.awt.Color(100, 196, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestores Hospitalarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCantPacienteMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantPacienteMedicoActionPerformed
        CantPacientesAtendidosPorMedico cantMedico = new CantPacientesAtendidosPorMedico();
        cantMedico.setVisible(true);
        cantMedico.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnCantPacienteMedicoActionPerformed

    private void btnCantPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantPacienteActionPerformed
        
        CantPacientesAtendidos cantPaciente = new CantPacientesAtendidos();
        cantPaciente.setVisible(true);
        cantPaciente.setLocationRelativeTo(null);
        this.dispose();     
    }//GEN-LAST:event_btnCantPacienteActionPerformed

    private void btnPacienteMasConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteMasConsultaActionPerformed
        PacientesMasConsultas masConsulta = new PacientesMasConsultas();
        masConsulta.setVisible(true);
        masConsulta.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_btnPacienteMasConsultaActionPerformed

    private void btnMedicoMasPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicoMasPacienteActionPerformed
        MedicoMasPacientes masPaciente = new MedicoMasPacientes();
        masPaciente.setVisible(true);
        masPaciente.setLocationRelativeTo(null);
        this.dispose(); 
    }//GEN-LAST:event_btnMedicoMasPacienteActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCantPaciente;
    private javax.swing.JButton btnCantPacienteMedico;
    private javax.swing.JButton btnCantTriage;
    private javax.swing.JButton btnMedicoMasPaciente;
    private javax.swing.JButton btnPacienteMasConsulta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTriageCambiado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
