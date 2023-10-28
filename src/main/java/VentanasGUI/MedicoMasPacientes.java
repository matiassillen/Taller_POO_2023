package VentanasGUI;

import Model.Controladora;
import Model.Medico;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase MedicoMasPacientes - GUI para buscar al médico con más pacientes en un rango de fechas.
 */
public class MedicoMasPacientes extends javax.swing.JFrame {
        // Atributos

    /**
     * Controladora que maneja la lógica del programa.
     */
    Controladora control;
    int xMouse;
    int yMouse;
// Constructor

    /**
     * Constructor de la clase MedicoMasPacientes.
     * @param control Controladora que maneja la lógica del programa.
     */
    public MedicoMasPacientes(Controladora control) {
        initComponents();
        this.control = control;
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jlbBuscar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medico (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Primer Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, -1));

        tablaMedico.setBackground(new java.awt.Color(149, 210, 255));
        tablaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMedico);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 489, 88));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Médico con más Paciente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

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
                .addContainerGap(899, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 31));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 150, -1));

        jLabel5.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Segunda Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 150, -1));

        jPanel4.setBackground(new java.awt.Color(149, 210, 255));

        jlbBuscar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jlbBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jlbBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBuscar.setText("Buscar");
        jlbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbBuscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
        // Código del evento para volver a la pantalla de gestión.
        Gestor pantallaGestion = new Gestor(this.control);
        pantallaGestion.setVisible(true);
        pantallaGestion.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_txtSalirMouseClicked

    private void txtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseEntered
        txtSalir.setForeground(Color.red);
    }//GEN-LAST:event_txtSalirMouseEntered

    private void txtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseExited
        txtSalir.setForeground(Color.black);
    }//GEN-LAST:event_txtSalirMouseExited

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jlbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbBuscarMouseClicked
         // Código del evento para buscar al médico con más pacientes en un rango de fechas.
        Calendar fechaOne = jDateChooser1.getCalendar();
        Calendar fechaTwo = jDateChooser2.getCalendar();
        
        int diaOne = fechaOne.get(Calendar.DATE);
        int medOne = fechaOne.get(Calendar.MONTH);
        int yearOne = fechaOne.get(Calendar.YEAR);
        
        int diaTwo = fechaTwo.get(Calendar.DATE);
        int mesTwo = fechaTwo.get(Calendar.MONTH);
        int anioTwo = fechaTwo.get(Calendar.YEAR);
        
        LocalDate fecha1= LocalDate.of(yearOne,medOne,diaOne);
        LocalDate fecha2= LocalDate.of(anioTwo,mesTwo,diaTwo);
        
        if(fecha2.isBefore(fecha1)){
        JOptionPane.showMessageDialog(
            null,
            "La segunda fecha no puede ser mayor que la primera.", 
            "Error",  
            JOptionPane.ERROR_MESSAGE  
        );
        }else{
                
       
 
         DefaultTableModel modeloTabla= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            
            }
        
        };
        String titulos []= {"Nombre","Apellido","Matricula",};
        modeloTabla.setColumnIdentifiers(titulos);
        Medico medi= control.medicoConMasPacientes(fecha1, fecha2);
        if(medi != null){
                Object[] objeto= {medi.getNombre(),medi.getApellido(),medi.getNumMat(),};
                modeloTabla.addRow(objeto);
            }
        
        
        
        tablaMedico.setModel(modeloTabla);
        }
    }//GEN-LAST:event_jlbBuscarMouseClicked

    private void jlbBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbBuscarMouseEntered
        jlbBuscar.setForeground(Color.white);
    }//GEN-LAST:event_jlbBuscarMouseEntered

    private void jlbBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbBuscarMouseExited
        jlbBuscar.setForeground(Color.black);
    }//GEN-LAST:event_jlbBuscarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSalir;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbBuscar;
    private javax.swing.JTable tablaMedico;
    private javax.swing.JLabel txtSalir;
    // End of variables declaration//GEN-END:variables


    
}
