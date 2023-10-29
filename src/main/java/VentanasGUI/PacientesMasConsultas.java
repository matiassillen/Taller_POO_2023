/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

import Model.Consulta;
import Model.Controladora;
import Model.Medico;
import Model.Paciente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class PacientesMasConsultas extends javax.swing.JFrame {
    Controladora controlP;
    /**
     * Creates new form CantPacientesAtendidos
     */
    public PacientesMasConsultas(Controladora control) {
        initComponents();
        this.controlP = control;
        txtAdvertencia.setVisible(false);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        txtAdvertencia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Primera Fecha:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Segunda Fecha:");

        btnConsultar.setBackground(new java.awt.Color(149, 210, 255));
        btnConsultar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMouseClicked(evt);
            }
        });

        tablaPacientes.setBackground(new java.awt.Color(255, 255, 255));
        tablaPacientes.setForeground(new java.awt.Color(0, 0, 0));
        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPacientes.setShowGrid(true);
        jScrollPane1.setViewportView(tablaPacientes);

        txtAdvertencia.setBackground(new java.awt.Color(255, 153, 153));
        txtAdvertencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAdvertencia.setForeground(new java.awt.Color(0, 0, 0));
        txtAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAdvertencia.setText("Ingresar fecha");
        txtAdvertencia.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(txtAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 540, 340));

        jPanel3.setBackground(new java.awt.Color(149, 210, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Pacientes con más Consultas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel6)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        btnVolver.setBackground(new java.awt.Color(149, 210, 255));
        btnVolver.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 97, 35));

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
     * Vuelve a la pantalla de gestor
     * @param evt 
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Ejecuta la logica y muestra los pacientes que mas consultaron en un rango de fechas
     * @param evt 
     */
    private void btnConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseClicked
        
        boolean estado = false;
        Calendar fechaOne = jDateChooser1.getCalendar();
        Calendar fechaTwo = jDateChooser2.getCalendar();
        
        LocalDate fecha1;
        LocalDate fecha2;
        
        if (fechaOne == null){
            txtAdvertencia.setVisible(true);
        }
        else{
            estado = true;
        }
        
        if (estado){
            int diaOne = fechaOne.get(Calendar.DATE);
            int mesOne = fechaOne.get(Calendar.MONTH);
            int anioOne = fechaOne.get(Calendar.YEAR);

            fecha1 = LocalDate.of(anioOne,mesOne,diaOne);
            
            if (fechaTwo == null){
                fecha2 = LocalDate.now();
            }
            else {
                int diaTwo = fechaTwo.get(Calendar.DATE);
                int mesTwo = fechaTwo.get(Calendar.MONTH);
                int anioTwo = fechaTwo.get(Calendar.YEAR);
                fecha2= LocalDate.of(anioTwo,mesTwo,diaTwo);
            }
            
            if(fecha1.isBefore(fecha2)){
                JOptionPane.showMessageDialog(
                    null,
                    "La segunda fecha no puede ser posterior a la primera.", 
                    "Error",  
                    JOptionPane.ERROR_MESSAGE  
                );
                }
                ArrayList<Consulta> listaConsulta = controlP.filtraFechas(fecha1, fecha2);
                if (!listaConsulta.isEmpty()) {
                    try {
                    this.cargarPacientes(fecha2, fecha2);
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Error en llamada a funcion, contactar area de Sistemas", 
                            "Error",  
                            JOptionPane.ERROR_MESSAGE  
                    );
                    } 
                }
                else {
                    JOptionPane.showMessageDialog(
                    null,
                    "Lista de consultas vacia", 
                    "Error",  
                    JOptionPane.ERROR_MESSAGE  
                    );
                }
        }
    }//GEN-LAST:event_btnConsultarMouseClicked

    /**
     * Logica que carga los datos de los pacientes en la tabla
     * @param fechaOne
     * @param fechaTwo 
     */
    private void cargarPacientes(LocalDate fechaOne, LocalDate fechaTwo){
              
        DefaultTableModel modeloTabla = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
       
        String titulos[] = {"Apellido", "Nombre", "Numero de consultas"};
        modeloTabla.setColumnIdentifiers(titulos);
        ArrayList<Consulta> listaFiltrada = this.controlP.filtraFechas(fechaOne, fechaTwo);
        ArrayList<Paciente> listaPacientes = this.controlP.listaPacientesMasAtendidos(listaFiltrada);
        ArrayList<String> cantidadOcurrencias = this.controlP.cantidadDeAtenciones(listaFiltrada, listaPacientes);
        
        if (listaPacientes.get(0) != null) {
            for (int repeticion = 0; repeticion < 3; repeticion++) {
                
       
                Object[] objeto = {listaPacientes.get(repeticion).getApellido(), listaPacientes.get(repeticion).getNombre(), cantidadOcurrencias.get(repeticion)};

                modeloTabla.addRow(objeto);
            }
        }
        else {
                Object[] objeto = {"Sin datos", "SinDatos", "0"};
                modeloTabla.addRow(objeto);
        }
        tablaPacientes.setModel(modeloTabla);
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVolver;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JLabel txtAdvertencia;
    // End of variables declaration//GEN-END:variables
}
