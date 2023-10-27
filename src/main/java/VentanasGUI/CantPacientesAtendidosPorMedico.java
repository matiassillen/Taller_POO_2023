
package VentanasGUI;

import Model.Controladora;
import Model.FuncionarioGeneral;
import Model.Medico;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class CantPacientesAtendidosPorMedico extends javax.swing.JFrame {
    public Controladora controlPA;
    /**
     * Creates new form CantPacientesAtendidos
     * @param control es la controladora que se pasa entre ventanas
     */
    public CantPacientesAtendidosPorMedico(Controladora control) {
        initComponents();
        this.controlPA = control;
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
        jPanel3 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        txtTitle2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtFecha1 = new javax.swing.JLabel();
        txtFecha2 = new javax.swing.JLabel();
        btnCargarDatos = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        txtResultado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCargaId = new javax.swing.JTextField();
        txtAdvertencia = new javax.swing.JLabel();
        txtAdvertencia2 = new javax.swing.JLabel();
        txtAdvertencia3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        txtTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle.setText("Cantidad de pacientes");

        txtTitle2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTitle2.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle2.setText("atendidos por médico");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTitle2)
                    .addComponent(txtTitle))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle2)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 120));

        btnVolver.setBackground(new java.awt.Color(0, 204, 204));
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtFecha1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFecha1.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha1.setText("Primer Fecha:");

        txtFecha2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFecha2.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha2.setText("Segunda Fecha:");

        btnCargarDatos.setBackground(new java.awt.Color(0, 204, 255));
        btnCargarDatos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCargarDatos.setForeground(new java.awt.Color(0, 0, 0));
        btnCargarDatos.setText("Cargar Datos");
        btnCargarDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        txtResultado.setBackground(new java.awt.Color(153, 255, 153));
        txtResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(0, 0, 0));
        txtResultado.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Resultado:");

        tablaMedicos.setBackground(new java.awt.Color(204, 204, 204));
        tablaMedicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaMedicos.setForeground(new java.awt.Color(204, 204, 204));
        tablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMedicos.setShowGrid(true);
        jScrollPane1.setViewportView(tablaMedicos);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Id:");

        txtCargaId.setBackground(new java.awt.Color(255, 255, 255));
        txtCargaId.setForeground(new java.awt.Color(0, 0, 0));
        txtCargaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargaIdActionPerformed(evt);
            }
        });

        txtAdvertencia.setBackground(new java.awt.Color(255, 153, 153));
        txtAdvertencia.setForeground(new java.awt.Color(0, 0, 0));
        txtAdvertencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAdvertencia.setText("Ingrese solo numeros enteros");
        txtAdvertencia.setOpaque(true);

        txtAdvertencia2.setBackground(new java.awt.Color(255, 153, 153));
        txtAdvertencia2.setForeground(new java.awt.Color(0, 0, 0));
        txtAdvertencia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAdvertencia2.setText("Ingresar Id");
        txtAdvertencia2.setOpaque(true);

        txtAdvertencia3.setBackground(new java.awt.Color(255, 102, 102));
        txtAdvertencia3.setForeground(new java.awt.Color(0, 0, 0));
        txtAdvertencia3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtAdvertencia3.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFecha2)
                                .addComponent(txtFecha1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtCargaId))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAdvertencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAdvertencia3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha2)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtAdvertencia3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdvertencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 560, 380));

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
     * Comprueba los campos cargados por el usuario y llama a los metodos
     * que filtran y buscan la cantidad de pacientes atendidos 
     * por un medico en un rango de fechas
     * @param evt 
     */
    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        boolean estado = false;
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
        Integer pruebaId = null;
        try {
            pruebaId = Integer.parseInt(this.txtCargaId.getText());
            
            if (pruebaId != null && pruebaId > 0) {
                estado = true;
            }
            else {
                txtAdvertencia2.setVisible(true);
            }
        }
        catch (Exception e){
            txtAdvertencia.setVisible(true);
            estado = false;
        }
        try {
            if (estado) {
                String resultado = controlPA.pacientesPorMedico(fecha1, fecha2, pruebaId);
                txtResultado.setText(resultado);
            }
        }
        catch (Exception e) {
            txtAdvertencia3.setText("FatalError \n No se pudo completar la peticion \n Comuniquese con el area de Sistemas");
            txtAdvertencia.setVisible(true);
        }

    }//GEN-LAST:event_btnCargarDatosActionPerformed

    
    private void txtCargaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargaIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargaIdActionPerformed

    /**
     * Carga una tabla con los medicos y prepara advertencias para los campos
     * @param evt 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtAdvertencia.setVisible(false);
        txtAdvertencia2.setVisible(false);
        txtAdvertencia3.setVisible(false);
        this.cargarMedicos();
        
        
    }//GEN-LAST:event_formWindowOpened
    
    /**
     * Contiene la logica para que la GUI muestre los datos de los medicos
     */
    private void cargarMedicos(){
      
        DefaultTableModel modeloTabla = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };
       
        String titulos[] = {"Nombre", "Apellido", "Numero Matricula", "Id"};
        modeloTabla.setColumnIdentifiers(titulos);

        List<Medico> listaMedicos = controlPA.traerMedicos();

        if (listaMedicos != null) {

            for (Medico medicoAux : listaMedicos) {
                
                Object[] objeto = {medicoAux.getNombre(), medicoAux.getApellido(), medicoAux.getNumMat(), medicoAux.getId()};

                modeloTabla.addRow(objeto);
            }
        }
        tablaMedicos.setModel(modeloTabla);
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDatos;
    private javax.swing.JButton btnVolver;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMedicos;
    private javax.swing.JLabel txtAdvertencia;
    private javax.swing.JLabel txtAdvertencia2;
    private javax.swing.JLabel txtAdvertencia3;
    private javax.swing.JTextField txtCargaId;
    private javax.swing.JLabel txtFecha1;
    private javax.swing.JLabel txtFecha2;
    private javax.swing.JLabel txtResultado;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtTitle2;
    // End of variables declaration//GEN-END:variables
}
