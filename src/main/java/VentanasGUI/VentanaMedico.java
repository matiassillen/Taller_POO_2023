/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IGU;

/**
 *
 * @author yairc
 */
public class VentanaMedico extends javax.swing.JFrame {

    /**
     * Creates new form Medico
     */
    public VentanaMedico() {
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
        txtHacerTriage = new javax.swing.JButton();
        txtVerResultEstudios = new javax.swing.JButton();
        txtTomarPaciente = new javax.swing.JButton();
        txtverHistClinica = new javax.swing.JButton();
        txtAsignarBox = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHacerTriage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHacerTriage.setText("Hacer Triage");
        txtHacerTriage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHacerTriageActionPerformed(evt);
            }
        });

        txtVerResultEstudios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtVerResultEstudios.setText("Ver Resultados de Estudios");

        txtTomarPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTomarPaciente.setText("Tomar Paciente");

        txtverHistClinica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtverHistClinica.setText("Ver Historia Clínica");

        txtAsignarBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAsignarBox.setText("Asignar box");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAsignarBox)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtverHistClinica)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtHacerTriage)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtVerResultEstudios)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(txtTomarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTomarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtHacerTriage)
                .addGap(18, 18, 18)
                .addComponent(txtVerResultEstudios)
                .addGap(18, 18, 18)
                .addComponent(txtverHistClinica)
                .addGap(18, 18, 18)
                .addComponent(txtAsignarBox)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 260, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHacerTriageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHacerTriageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHacerTriageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton txtAsignarBox;
    private javax.swing.JButton txtHacerTriage;
    private javax.swing.JButton txtTomarPaciente;
    private javax.swing.JButton txtVerResultEstudios;
    private javax.swing.JButton txtverHistClinica;
    // End of variables declaration//GEN-END:variables
}
