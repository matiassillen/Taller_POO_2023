package VentanasGUI;

import Model.Controladora;
import Model.DiagnosticoClinico;
import Model.Paciente;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa una ventana de la interfaz gráfica de usuario que
 * permite ver los diagnosticos clinicos de un paciente como tambien cargar
 * nuevos.
 *
 * @author yairc
 */
public class VerDiagnosticoClinico extends javax.swing.JFrame {

    private Controladora control;
    private Paciente paciente;

    /**
     * Constructor de la clase VerDiagnosticoClinico
     *
     * @param control
     * @param paciente
     */
    public VerDiagnosticoClinico(Controladora control, Paciente paciente) {
        initComponents();
        this.control = control;
        this.paciente = paciente;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDiagnosticoCli = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JLabel();
        txbTitulo = new javax.swing.JTextField();
        txbDescripcion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlbCrear = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbVolver = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDiagnosticoCli.setBackground(new java.awt.Color(255, 255, 255));
        tablaDiagnosticoCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaDiagnosticoCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDiagnosticoCli);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1160, 326));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Diagnósticos Clínicos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 411, 46));

        txtTitulo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo.setText("Título");
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 92, -1));

        txtDescripcion.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setText("Descripción");
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        txbTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txbTitulo.setActionCommand("<Not Set>");
        txbTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbTitulo.setCaretColor(new java.awt.Color(0, 0, 0));
        txbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 310, -1));

        txbDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txbDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txbDescripcion.setActionCommand("<Not Set>");
        txbDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbDescripcion.setCaretColor(new java.awt.Color(0, 0, 0));
        txbDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 670, 70));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jlbCrear.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        jlbCrear.setForeground(new java.awt.Color(0, 0, 0));
        jlbCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCrear.setText("Crear Nuevo");
        jlbCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbCrearMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbCrear)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 540, 120, 30));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jlbVolver.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sl_021921_40900_13.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 590));

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
     * Método que se ejecuta cuando se abre la ventana. Llama al método para
     * cargar la tabla de diagnostico clinico.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void jlbCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCrearMouseClicked
        try {
            // Obtenemos el título y la descripción seleccionados en los campos de texto correspondientes
            String titulo = this.txbTitulo.getText();
            String descripcion = this.txbDescripcion.getText();
            if (titulo == null || titulo.isEmpty() || descripcion == null || descripcion.isEmpty()) {
                this.control.mostrarMensaje("No se ingreso titulo o descripcion", "Error", "Error");
            } else {
                // Intentamos cargar un nuevo diagnóstico clínico con el título y la descripción proporcionados
                this.control.cargarNuevoDiagClinico(paciente, titulo, descripcion);
                // Si se carga correctamente, mostramos un mensaje de éxito
                String mensaje = "Cargado Correctamente";
                String info = "infor";
                //Recargamos la tabla
                this.cargarTabla();
                // Limpiamos los campos de texto
                this.txbTitulo.setText("");
                this.txbDescripcion.setText("");
                //Mostramos mensaje de cnfirmación
                this.control.mostrarMensaje(mensaje, info, titulo);
            }
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje de error
            String info = "error";
            this.control.mostrarMensaje("Se ingreso descripcion o titulo no valido", "Error", "Error");
        }
    }//GEN-LAST:event_jlbCrearMouseClicked

    private void jlbVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseClicked
        // Creamos una nueva instancia de la ventana DatosDePaciente
        DatosDePaciente histCli = new DatosDePaciente(control, paciente);
        // Hacemos visible la ventana
        histCli.setVisible(true);
        // Centramos la ventana en la pantalla
        histCli.setLocationRelativeTo(null);
        // Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_jlbVolverMouseClicked

    private void jlbCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCrearMouseEntered
        jlbCrear.setForeground(Color.white);
    }//GEN-LAST:event_jlbCrearMouseEntered

    private void jlbCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCrearMouseExited
        jlbCrear.setForeground(Color.black);
    }//GEN-LAST:event_jlbCrearMouseExited

    private void jlbVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseEntered
        jlbVolver.setForeground(Color.white);
    }//GEN-LAST:event_jlbVolverMouseEntered

    private void jlbVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseExited
        jlbVolver.setForeground(Color.black);
    }//GEN-LAST:event_jlbVolverMouseExited
    /**
     * Este método carga datos en la tabla. Obtiene una lista de diagnósticos
     * clínicos del paciente y añade cada diagnóstico a la tabla.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void cargarTabla() {
        try {
            // Crea un nuevo modelo de tabla
            DefaultTableModel modeloTabla = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Todas las celdas son falsas, es decir, no editables.
                    return false;
                }
            };
            
            String titutlos[] = {"Id", "Fecha", "Hora", "Nombre", "Descripcion", "Medico num Mat", "Medico Apellido"};
            modeloTabla.setColumnIdentifiers(titutlos);
            // Obtenemos la lista de diagnósticos clínicos del paciente
            List<DiagnosticoClinico> listDiag = this.control.traerDiagnosticoClinico(paciente);
            if (listDiag != null) {
                // Si la lista de diagnósticos clínicos no es nula, recorremos la lista
                for (DiagnosticoClinico res : listDiag) {
                    // Creamos un objeto con los datos del diagnóstico clínico
                    Object[] objeto = {res.getId(), res.getFecha(), res.getHora(), res.getNombreDiagnostico(), res.getDescripcion(), res.getMedico().getNumMat(), res.getMedico().getApellido()};

                    // Añadimos el objeto a la tabla
                    modeloTabla.addRow(objeto);
                }
            }
            // Establecemos el modelo de la tabla
            tablaDiagnosticoCli.setModel(modeloTabla);
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbCrear;
    private javax.swing.JLabel jlbVolver;
    private javax.swing.JTable tablaDiagnosticoCli;
    private javax.swing.JTextField txbDescripcion;
    private javax.swing.JTextField txbTitulo;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
