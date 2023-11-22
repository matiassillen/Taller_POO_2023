package VentanasGUI;

import Model.Controladora;
import Model.Paciente;
import Model.ResultadoEstudio;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa una ventana de la interfaz gráfica de usuario que
 * permite ver los resultados de estudio de un paciente como tambien cargar
 * nuevos.
 *
 * @author yairc
 */
public class VerResultadoEstudio extends javax.swing.JFrame {

    private Controladora control;
    private Paciente paciente;

    /**
     * Constructor de la clase VerResultadoEstudio
     *
     * @param control
     * @param paciente
     */
    public VerResultadoEstudio(Controladora control, Paciente paciente) {
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
        tablaResultEstudios = new javax.swing.JTable();
        txtResultEst = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txbTitulo = new javax.swing.JTextField();
        txbDescripcion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlbCrear = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbVolver = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        tablaResultEstudios.setBackground(new java.awt.Color(255, 255, 255));
        tablaResultEstudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaResultEstudios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1230, 268));

        txtResultEst.setBackground(new java.awt.Color(0, 204, 204));
        txtResultEst.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        txtResultEst.setForeground(new java.awt.Color(0, 0, 0));
        txtResultEst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResultEst.setText("Resultados de Estudios");
        jPanel1.add(txtResultEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 450, 40));

        txtDescripcion.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setText("Descripción");
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        txtTitulo.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo.setText("Título");
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 92, -1));

        txbTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txbTitulo.setActionCommand("<Not Set>");
        txbTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbTitulo.setCaretColor(new java.awt.Color(0, 0, 0));
        txbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 500, 80));

        txbDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txbDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txbDescripcion.setActionCommand("<Not Set>");
        txbDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbDescripcion.setCaretColor(new java.awt.Color(0, 0, 0));
        txbDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 467, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jlbCrear.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
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
            .addComponent(jlbCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 510, 100, 30));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/—Slidesdocs—cartel médico hospital minimalista medicina_d8036fb245 (1).jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1270, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método se ejecuta cuando se abre la ventana. Llama al método
     * cargarTabla para llenar la tabla con datos.
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

                // Intentamos cargar un nuevo resultado de estudio con el título y la descripción proporcionados
                this.control.cargarNuevoResEstudio(paciente, titulo, descripcion);
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
            this.control.mostrarMensaje("Se ingreso un titulo o descripcion incorrectos", "Error", "Error");
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

    private void jlbVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseEntered
        jlbVolver.setForeground(Color.white);
    }//GEN-LAST:event_jlbVolverMouseEntered

    private void jlbVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseExited
        jlbVolver.setForeground(Color.black);
    }//GEN-LAST:event_jlbVolverMouseExited

    private void jlbCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCrearMouseEntered
        jlbCrear.setForeground(Color.white);
    }//GEN-LAST:event_jlbCrearMouseEntered

    private void jlbCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCrearMouseExited
        jlbCrear.setForeground(Color.black);
    }//GEN-LAST:event_jlbCrearMouseExited
    /**
     * Este método carga datos en la tabla. Debe implementarse para definir qué
     * datos se cargarán en la tabla.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void cargarTabla() {
        // Crea un nuevo modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas son falsas, es decir, no editables.
                return false;
            }
        };
        // Definimos los títulos de las columnas de la tabla
        String titutlos[] = {"Id", "Fecha", "Hora", "Nombre", "Descripcion"};
        modeloTabla.setColumnIdentifiers(titutlos);
        List<ResultadoEstudio> listRes = null;
        try {
            // Intentamos obtener la lista de resultados de estudio del paciente
            listRes = this.control.TraerResultEstudio(paciente);
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje y terminamos el método
            String mensaje = "Error: " + e.getMessage();
            String info = "error";
            this.control.mostrarMensaje(mensaje, info, "No hay R.E.");
            return;
        }
        if (listRes != null) {
            // Si la lista de resultados de estudio no es nula, recorremos la lista
            for (ResultadoEstudio res : listRes) {
                // Creamos un objeto con los datos del resultado de estudio
                Object[] objeto = {res.getId(), res.getFecha(), res.getHora(), res.getNombre(), res.getInforme()};
                // Añadimos el objeto a la tabla
                modeloTabla.addRow(objeto);
            }
        }
        // Establecemos el modelo de la tabla
        tablaResultEstudios.setModel(modeloTabla);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbCrear;
    private javax.swing.JLabel jlbVolver;
    private javax.swing.JTable tablaResultEstudios;
    private javax.swing.JTextField txbDescripcion;
    private javax.swing.JTextField txbTitulo;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtResultEst;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
