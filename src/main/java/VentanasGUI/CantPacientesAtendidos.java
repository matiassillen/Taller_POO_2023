/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

import Model.Controladora;
import Model.Paciente;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @
 */
public class CantPacientesAtendidos extends javax.swing.JFrame {
    Controladora controlP;
    /**
     * Creates new form CantPacientesAtendidos
     */
    public CantPacientesAtendidos(Controladora control) {
        initComponents();
        this.controlP = control;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEdad1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEdad2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtAdvertenciaOne = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jlbConsu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlbVolver = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Edades");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Desde:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtEdad1.setBackground(new java.awt.Color(255, 255, 255));
        txtEdad1.setForeground(new java.awt.Color(0, 0, 0));
        txtEdad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEdad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdad1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 88, 28));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Hasta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        txtEdad2.setBackground(new java.awt.Color(255, 255, 255));
        txtEdad2.setForeground(new java.awt.Color(0, 0, 0));
        txtEdad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEdad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdad2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 88, 28));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(" Cantidad de pacientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Primera Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 151, -1));

        jLabel5.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Segunda Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 151, -1));

        jLabel8.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fechas de atención");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jSeparator1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 309, 11));

        jSeparator2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 309, 10));

        txtAdvertenciaOne.setBackground(new java.awt.Color(255, 255, 255));
        txtAdvertenciaOne.setForeground(new java.awt.Color(255, 51, 51));
        txtAdvertenciaOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Advertencia.png"))); // NOI18N
        txtAdvertenciaOne.setText("Ingresar solo números enteros");
        txtAdvertenciaOne.setOpaque(true);
        jPanel1.add(txtAdvertenciaOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 200, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad de pacientes");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 208, 20));

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCantidad.setOpaque(true);
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 96, 29));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 483, 170, 10));

        jPanel3.setBackground(new java.awt.Color(149, 210, 255));

        jlbConsu.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbConsu.setForeground(new java.awt.Color(0, 0, 0));
        jlbConsu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbConsu.setText("Consultar");
        jlbConsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbConsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbConsuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbConsuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbConsuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbConsu, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbConsu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 110, 40));

        jPanel4.setBackground(new java.awt.Color(149, 210, 255));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 110, 30));

        jLabel9.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("atendidos por edad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/resumen-difuminar-hospital-clinica-interior (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 470, 500));

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

    
    
    private void txtEdad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdad1ActionPerformed

    private void txtEdad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdad2ActionPerformed

    private void jlbConsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbConsuMouseClicked
        Integer edadOne = 0;
        Integer edadTwo = 0;
        // estado es un booleano para controlar que se ejecute o no parte del codigo de forma innecesaria
        // en este caso no ejecuto codigo si hay algun error
        boolean estado;
        
        try {
            edadOne = Integer.parseInt(txtEdad1.getText());
            edadTwo = Integer.parseInt(txtEdad2.getText());
                    
            if (edadOne > edadTwo) {
                Integer aux = edadTwo;
                edadTwo = edadOne;
                edadOne = aux;
            }
            if (edadOne < 0) {
                edadOne = edadOne*(-1);
            }
            if (edadTwo < 0) {
                edadTwo = edadTwo*(-1);
            }
            
            estado = true;
        }
        catch(Exception e) {
            txtAdvertenciaOne.setVisible(true);
            estado = false;
        }
        
        Calendar fechaOne = jDateChooser1.getCalendar();
        Calendar fechaTwo = jDateChooser2.getCalendar();
        
        int diaOne = fechaOne.get(Calendar.DATE);
        int mesOne = fechaOne.get(Calendar.MONTH);
        int anioOne = fechaOne.get(Calendar.YEAR);
        
        int diaTwo = fechaTwo.get(Calendar.DATE);
        int mesTwo = fechaTwo.get(Calendar.MONTH);
        int anioTwo = fechaTwo.get(Calendar.YEAR);
        
        LocalDate fecha1= LocalDate.of(anioOne,mesOne,diaOne);
        LocalDate fecha2= LocalDate.of(anioTwo,mesTwo,diaTwo);
                
        if(estado){
            if(fecha1.isBefore(fecha2)){
                JOptionPane.showMessageDialog(
                    null,
                    "La segunda fecha no puede ser posterior a la primera.", 
                    "Error",  
                    JOptionPane.ERROR_MESSAGE  
                );
            }else{

                String resultadoCant = this.controlP.contadorPacientesEdad(edadOne, edadTwo, fecha1, fecha2);
                txtCantidad.setText(resultadoCant);
            }
        }
    }//GEN-LAST:event_jlbConsuMouseClicked

    private void jlbVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlbVolverMouseClicked

    private void jlbConsuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbConsuMouseEntered
        jlbConsu.setForeground(Color.white);
    }//GEN-LAST:event_jlbConsuMouseEntered

    private void jlbConsuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbConsuMouseExited
        jlbConsu.setForeground(Color.black);
    }//GEN-LAST:event_jlbConsuMouseExited

    private void jlbVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseEntered
        jlbVolver.setForeground(Color.white);
    }//GEN-LAST:event_jlbVolverMouseEntered

    private void jlbVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseExited
        jlbVolver.setForeground(Color.black);
    }//GEN-LAST:event_jlbVolverMouseExited

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlbConsu;
    private javax.swing.JLabel jlbVolver;
    private javax.swing.JLabel txtAdvertenciaOne;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JTextField txtEdad1;
    private javax.swing.JTextField txtEdad2;
    // End of variables declaration//GEN-END:variables
}
