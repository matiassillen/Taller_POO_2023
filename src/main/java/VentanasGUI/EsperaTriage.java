package VentanasGUI;

import Model.Consulta;
import Model.Controladora;
import Model.Paciente;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa una ventana de la interfaz gráfica de usuario que
 * permite ver los pacientes que estan esperando ser triageados y
 * seleccionarlos.
 *
 * @author yairc
 */
public class EsperaTriage extends javax.swing.JFrame {
    
    private Controladora control;
    private int idConsulta;

    /**
     * Constructor de la clase EsperaTriage
     *
     * @param control
     */
    public EsperaTriage(Controladora control) {
        initComponents();
        this.control = control;
        this.idConsulta = -1;
        this.cargartablaEnEspera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEnEspera = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jlbSelecionar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbVolver = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEnEspera.setBackground(new java.awt.Color(255, 255, 255));
        tablaEnEspera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEnEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEnEsperaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaEnEspera);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 719, 218));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jlbSelecionar.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbSelecionar.setForeground(new java.awt.Color(0, 0, 0));
        jlbSelecionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSelecionar.setText("Seleccionar");
        jlbSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbSelecionarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbSelecionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbSelecionarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 110, 40));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jlbVolver.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        jlbVolver.setForeground(new java.awt.Color(0, 0, 0));
        jlbVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbVolver.setText("Volver");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 110, 40));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pacientes en Espera Triage");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11948.jpg"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que se ejecuta cuando se hace clic en el botón Seleccionar
     * Paciente. Si se ha seleccionado un paciente, se crea una nueva instancia
     * de HacerTriage y se desecha la actual. Si no se ha seleccionado un
     * paciente, se muestra un mensaje de error.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnSeleccionarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPacienteActionPerformed
        // Comprueba si se ha seleccionado un paciente
        if (this.idConsulta != -1) {
            // Si se ha seleccionado un paciente, crea una nueva instancia de HacerTriage
            HacerTriage hacerT = new HacerTriage(control, idConsulta);
            // Hace visible la nueva instancia de HacerTriage
            hacerT.setVisible(true);
            // Centra la nueva instancia de HacerTriage en la pantalla
            hacerT.setLocationRelativeTo(null);
            // Cierra la ventana actual
            this.dispose();
        } else {
            // Si no se ha seleccionado un paciente, muestra un mensaje de error
            this.control.mostrarMensaje("No se selecciono ningun paciente", "Error", "Error");
        }
    }//GEN-LAST:event_btnSeleccionarPacienteActionPerformed
    /**
     * Método que se ejecuta cuando se hace clic en la tabla En Espera. Si se ha
     * seleccionado una fila, busca al paciente por DNI y habilita el botón
     * Seleccionar Paciente.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void tablaEnEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEnEsperaMouseClicked
        try {
            // Comprueba si la tabla tiene filas
            if (tablaEnEspera.getRowCount() > 0) {
                // Comprueba si se ha seleccionado una fila
                if (tablaEnEspera.getSelectedRow() != -1) {
                    // Obtiene el id de la consulta
                    int row = tablaEnEspera.getSelectedRow();
                    String idConsu = tablaEnEspera.getModel().getValueAt(row, 0).toString();
                    this.idConsulta = Integer.parseInt(idConsu);
                    // Habilita el botón Seleccionar Paciente
                    jlbSelecionar.setEnabled(true);
                }
            }
        } catch (Exception e) {
            // Imprime el mensaje de error si ocurre una excepción
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_tablaEnEsperaMouseClicked

   /**
     * Método que se ejecuta cuando se abre la ventana. Llama al método para
     * cargar la tabla En Espera.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Cuando se abre la ventana, carga la tabla En Espera
        this.cargartablaEnEspera();
    }//GEN-LAST:event_formWindowOpened

    private void jlbSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbSelecionarMouseClicked
        // Comprueba si se ha seleccionado un paciente
        if (this.idConsulta != -1) {
            // Si se ha seleccionado un paciente, crea una nueva instancia de HacerTriage
            HacerTriage hacerT = new HacerTriage(control, idConsulta);
            // Hace visible la nueva instancia de HacerTriage
            hacerT.setVisible(true);
            // Centra la nueva instancia de HacerTriage en la pantalla
            hacerT.setLocationRelativeTo(null);
            // Cierra la ventana actual
            this.dispose();
        } else {
            // Si no se ha seleccionado un paciente, muestra un mensaje de error
            this.control.mostrarMensaje("No se selecciono ningun paciente", "Error", "Error");
        }
    }//GEN-LAST:event_jlbSelecionarMouseClicked

    private void jlbVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseClicked
        // Crea una nueva instancia de PrincipalMedico
        PrincipalMedico ppalMedico = new PrincipalMedico(control);
        // Hace visible la nueva instancia de PrincipalMedico
        ppalMedico.setVisible(true);
        // Centra la nueva instancia de PrincipalMedico en la pantalla
        ppalMedico.setLocationRelativeTo(null);
        // Cierra la ventana actual
        this.dispose();
    }//GEN-LAST:event_jlbVolverMouseClicked

    private void jlbSelecionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbSelecionarMouseEntered
        jlbSelecionar.setForeground(Color.white);
    }//GEN-LAST:event_jlbSelecionarMouseEntered

    private void jlbSelecionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbSelecionarMouseExited
        jlbSelecionar.setForeground(Color.black);
    }//GEN-LAST:event_jlbSelecionarMouseExited

    private void jlbVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseEntered
        jlbVolver.setForeground(Color.white);
    }//GEN-LAST:event_jlbVolverMouseEntered

    private void jlbVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbVolverMouseExited
        jlbVolver.setForeground(Color.black);
    }//GEN-LAST:event_jlbVolverMouseExited
    /**
     * Método para cargar la tabla En Espera con los pacientes en espera. Crea
     * un nuevo modelo de tabla y lo llena con los datos de los pacientes en
     * espera.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void cargartablaEnEspera() {
        try {
            // Crea un nuevo modelo de tabla
            DefaultTableModel modeloTabla = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Todas las celdas son falsas, es decir, no editables.
                    return false;
                }
            };
            String titutlos[] = {"id Consulta", "Motivo Consulta","Hora", "Fecha"};
            modeloTabla.setColumnIdentifiers(titutlos);
            // Obtiene la lista de pacientes en espera
            List<Consulta> consultas = control.traerPacientesEnEspera();
            if (consultas != null) {
                // Para cada consulta en la lista, añade una fila a la tabla con los datos del paciente y el motivo de consulta
                for (Consulta consu : consultas) {
                    Object[] objeto = {consu.getId(), consu.getMotivo(), consu.getHora(), consu.getFecha()};
                    modeloTabla.addRow(objeto);
                }
            }
            // Establece el modelo de la tabla con el nuevo modelo lleno de datos
            tablaEnEspera.setModel(modeloTabla);
        } catch (Exception e) {
            // Imprime el mensaje de error si ocurre una excepción
            System.out.println("Error: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbSelecionar;
    private javax.swing.JLabel jlbVolver;
    private javax.swing.JTable tablaEnEspera;
    // End of variables declaration//GEN-END:variables
}
