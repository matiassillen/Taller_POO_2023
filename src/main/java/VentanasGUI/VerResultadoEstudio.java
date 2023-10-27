package VentanasGUI;

import Model.Controladora;
import Model.Paciente;
import Model.ResultadoEstudio;
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
        jPanel2 = new javax.swing.JPanel();
        txtResultEst = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txbTitulo = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JLabel();
        txbDescripcion = new javax.swing.JTextField();
        btnCargarRestEstu = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        txtResultEst.setBackground(new java.awt.Color(0, 204, 204));
        txtResultEst.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtResultEst.setForeground(new java.awt.Color(0, 0, 0));
        txtResultEst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResultEst.setText("Resultados de Estudios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtResultEst, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(txtResultEst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txbTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txbTitulo.setActionCommand("<Not Set>");
        txbTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbTitulo.setCaretColor(new java.awt.Color(0, 0, 0));
        txbTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo.setText("Titulo");

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setText("Descripcion");

        txbDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txbDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txbDescripcion.setActionCommand("<Not Set>");
        txbDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txbDescripcion.setCaretColor(new java.awt.Color(0, 0, 0));
        txbDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnCargarRestEstu.setBackground(new java.awt.Color(0, 204, 153));
        btnCargarRestEstu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCargarRestEstu.setForeground(new java.awt.Color(0, 0, 0));
        btnCargarRestEstu.setText("Crear Nuevo ");
        btnCargarRestEstu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCargarRestEstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarRestEstuActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(51, 153, 255));
        btnVolver.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCargarRestEstu)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTitulo)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion)
                            .addComponent(txbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarRestEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Este método se ejecuta cuando se hace clic en el botón btnVolver. Cierra
     * la ventana actual y abre una nueva instancia de la ventana
     * DatosDePaciente.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Creamos una nueva instancia de la ventana DatosDePaciente
        DatosDePaciente histCli = new DatosDePaciente(control, paciente);
        // Hacemos visible la ventana
        histCli.setVisible(true);
        // Centramos la ventana en la pantalla
        histCli.setLocationRelativeTo(null);
        // Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Este método se ejecuta cuando se abre la ventana. Llama al método
     * cargarTabla para llenar la tabla con datos.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened
    /**
     * Este método se ejecuta cuando se hace clic en el botón btnCargarRestEstu.
     * Obtiene el título y la descripción seleccionados en los campos de texto
     * correspondientes, intenta cargar un nuevo resultado de estudio con el
     * título y la descripción proporcionados, y muestra un mensaje de éxito o
     * error según corresponda.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnCargarRestEstuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarRestEstuActionPerformed
        try {
            // Obtenemos el título y la descripción seleccionados en los campos de texto correspondientes
            String titulo = this.txbTitulo.getSelectedText();
            String descripcion = this.txbDescripcion.getSelectedText();
            // Intentamos cargar un nuevo resultado de estudio con el título y la descripción proporcionados
            this.control.cargarNuevoResEstudio(paciente, titulo, descripcion);
            // Si se carga correctamente, mostramos un mensaje de éxito
            String mensaje = "Cargado Correctamente";
            String info = "infor";
            this.control.mostrarMensaje(mensaje, info, titulo);
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje de error
            String info = "error";
            this.control.mostrarMensaje("No se ingreso titulo o descripcion", info, "Error");
        }
    }//GEN-LAST:event_btnCargarRestEstuActionPerformed
    /**
     * Este método carga datos en la tabla. Debe implementarse para definir qué
     * datos se cargarán en la tabla.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void cargarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        // Definimos los títulos de las columnas de la tabla
        String titutlos[] = {"Id", "Fecha", "Hora", "Nombre"};
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
                Object[] objeto = {res.getId(), res.getFecha(), res.getHora(), res.getNombre()};
                // Añadimos el objeto a la tabla
                modeloTabla.addRow(objeto);
            }
        }
        // Establecemos el modelo de la tabla
        tablaResultEstudios.setModel(modeloTabla);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarRestEstu;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultEstudios;
    private javax.swing.JTextField txbDescripcion;
    private javax.swing.JTextField txbTitulo;
    private javax.swing.JLabel txtDescripcion;
    private javax.swing.JLabel txtResultEst;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
