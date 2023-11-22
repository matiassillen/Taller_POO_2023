package VentanasGUI;

import Model.Box;
import Model.Controladora;
import Model.Paciente;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase representa una ventana de la interfaz gráfica de usuario que
 * permite ver los pacientes en box del medico, tomar nuevos pacientes, darlos
 * de alta los existentes, y ver sus datos medicos
 *
 * @author yairc
 */
public class GestionDePacientes extends javax.swing.JFrame {

    Controladora control;
    Paciente pacienteSeleccionado;
    String idBox;
    private boolean bandera;

    /**
     * Constructor de la clase TomarPaciente
     *
     * @param control
     */
    public GestionDePacientes(Controladora control) {
        initComponents();
        this.control = control;
        btnDatosMedicos.setEnabled(false);
        btnDarDeAlta.setEnabled(false);

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
        btnVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTituloPrincipal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBoxAtendidos = new javax.swing.JTable();
        txtTitulo2 = new javax.swing.JLabel();
        btnDarDeAlta = new javax.swing.JButton();
        txbDiagnosticoConsulta = new javax.swing.JTextField();
        btnDatosMedicos = new javax.swing.JButton();
        btnNuevoPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnVolver.setBackground(new java.awt.Color(149, 210, 255));
        btnVolver.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(149, 210, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        txtTituloPrincipal.setBackground(new java.awt.Color(0, 153, 153));
        txtTituloPrincipal.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 24)); // NOI18N
        txtTituloPrincipal.setForeground(new java.awt.Color(0, 0, 0));
        txtTituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTituloPrincipal.setText("Gestión de Pacientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        tablaBoxAtendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaBoxAtendidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBoxAtendidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBoxAtendidos);

        txtTitulo2.setBackground(new java.awt.Color(0, 153, 153));
        txtTitulo2.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 18)); // NOI18N
        txtTitulo2.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo2.setText("Pacientes en Box");

        btnDarDeAlta.setBackground(new java.awt.Color(149, 210, 255));
        btnDarDeAlta.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnDarDeAlta.setForeground(new java.awt.Color(0, 0, 0));
        btnDarDeAlta.setText("Dar de alta");
        btnDarDeAlta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeAltaActionPerformed(evt);
            }
        });

        txbDiagnosticoConsulta.setText("Ingrese diagnostico de la consulta antes ");
        txbDiagnosticoConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txbDiagnosticoConsultaMouseClicked(evt);
            }
        });

        btnDatosMedicos.setBackground(new java.awt.Color(149, 210, 255));
        btnDatosMedicos.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnDatosMedicos.setForeground(new java.awt.Color(0, 0, 0));
        btnDatosMedicos.setText("Datos Medicos");
        btnDatosMedicos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDatosMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosMedicosActionPerformed(evt);
            }
        });

        btnNuevoPaciente.setBackground(new java.awt.Color(149, 210, 255));
        btnNuevoPaciente.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 1, 14)); // NOI18N
        btnNuevoPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevoPaciente.setText("Nuevo Paciente");
        btnNuevoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtTitulo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevoPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDatosMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txbDiagnosticoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDarDeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addContainerGap(18, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitulo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnDatosMedicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDarDeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbDiagnosticoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Este método se activa cuando se hace clic en el botón btnVolver. Crea una
     * nueva instancia de la clase PrincipalMedico, la hace visible y la centra
     * en la pantalla. Cierra la instancia actual.
     *
     * @param evt El evento de acción que ocurrió.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Creamos una nueva instancia de la ventana PrincipalMedico
        PrincipalMedico princM = new PrincipalMedico(control);
        // Hacemos visible la ventana
        princM.setVisible(true);
        // Centramos la ventana en la pantalla
        princM.setLocationRelativeTo(null);
        // Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Este método se activa cuando se abre la ventana. Llama al método
     * cargarTabla().
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // Llamamos al método cargarTablaBoxAtendidos para llenar la tabla con datos
            cargarTablaBoxAtendidos();
        } catch (Exception e) {
            // Si ocurre un error, mostramos un mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened
    /**
     * Este método se activa cuando se hace clic en la tabla de pacientes
     * atendidos. Verifica si la tabla tiene filas y si se seleccionó una fila.
     * Si se seleccionó una fila, intenta obtener el id del box y el paciente en
     * el box. Si se encuentra el paciente, se establece como el paciente
     * seleccionado y se habilitan los botones para dar de alta y ver datos
     * médicos.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void tablaBoxAtendidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBoxAtendidosMouseClicked
        // Verifica si la tabla tiene filas
        if (tablaBoxAtendidos.getRowCount() > 0) {
            // Verifica si se seleccionó una fila
            if (tablaBoxAtendidos.getSelectedRow() != -1) {
                try {
                    // Obtiene el número de fila seleccionado
                    int row = tablaBoxAtendidos.getSelectedRow();
                    // Intenta obtener el id del box de la fila seleccionada
                    this.idBox = tablaBoxAtendidos.getModel().getValueAt(row, 0).toString();
                    // Intenta obtener el paciente en el box usando el id del box
                    Paciente p = this.control.traerPacienteEnElBox(idBox);
                    // Si se encuentra el paciente, se establece como el paciente seleccionado
                    this.pacienteSeleccionado = p;
                    // Habilita los botones para dar de alta y ver datos médicos
                    btnDarDeAlta.setEnabled(true);
                    btnDatosMedicos.setEnabled(true);
                } catch (Exception e) {
                    // Imprime cualquier error que ocurra durante la ejecución del código anterior
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_tablaBoxAtendidosMouseClicked
    /**
     * Este método se activa cuando se hace clic en el botón para dar de alta a
     * un paciente. Lee el diagnóstico de la consulta ingresado por el médico y
     * llama al método terminarConsulta para dar de alta al paciente.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeAltaActionPerformed
        try {
            String diagnostico = this.txbDiagnosticoConsulta.getText();
            //Comprueba que se haya cargado un diagnostico de consulta
            if (diagnostico.isEmpty()||diagnostico == null) {
                this.control.mostrarMensaje("No se ingreso titulo o descripcion", "Error", "Error");
            } else {

                //Llama al metodo terminarConsulta que da de alta el paciente pasandole el diagnostico
                //y el id del box donde se encuentra el paciente
                this.control.terminarConsulta(diagnostico, idBox);
                //Recargamos la tabla
                this.cargarTablaBoxAtendidos();
                // Limpiamos los campos de texto
                this.txbDiagnosticoConsulta.setText("");

                //Mostramos mensaje de confirmación
                this.control.mostrarMensaje("Paciente dado de alta", "info", "info");

            }
        } catch (Exception e) {
            // y muestra un mensaje que dice que no se ingreso un diagnostico de consulta valido
            control.mostrarMensaje("No ingreso un diagnostico de consulta valido", "Error", "Error");

        }

    }//GEN-LAST:event_btnDarDeAltaActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón para ver los datos
     * médicos de un paciente. Si se seleciono un paciente crea una nueva
     * instancia de DatosDePaciente y la muestra, luego cierra la ventana
     * actual, de lo contrario muestra un mensaje de error
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnDatosMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosMedicosActionPerformed
        // Comprobamos que se haya seleccionado u paciente
        if (pacienteSeleccionado != null) {
            // Creamos una nueva instancia de la ventana DatosDePaciente
            DatosDePaciente datosP = new DatosDePaciente(control, pacienteSeleccionado);
            // Hacemos visible la ventana
            datosP.setVisible(true);
            // Centramos la ventana en la pantalla
            datosP.setLocationRelativeTo(null);
            // Cerramos la ventana actual
            this.dispose();
        } else {
            //Si no se selecciono ninguno muestra un mensaje de error
            control.mostrarMensaje("No selecciono ningun paciente", "Error", "Error");
        }
    }//GEN-LAST:event_btnDatosMedicosActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón para agregar un
     * nuevo paciente. Crea una nueva instancia de AsignarBox y la muestra,
     * luego cierra la ventana actual.
     *
     * @param evt El evento de ventana que ocurrió.
     */
    private void btnNuevoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPacienteActionPerformed
        if (bandera) {
            // Creamos una nueva instancia de la ventana AsignarBox
            AsignarBox asigBox = new AsignarBox(control);
            // Hacemos visible la ventana
            asigBox.setVisible(true);
            // Centramos la ventana en la pantalla
            asigBox.setLocationRelativeTo(null);
            // Cerramos la ventana actual
            this.dispose();
        } else {
            control.mostrarMensaje("No puede tomar mas pacientes", "Error", "Error");
        }
    }//GEN-LAST:event_btnNuevoPacienteActionPerformed

    private void txbDiagnosticoConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txbDiagnosticoConsultaMouseClicked
        txbDiagnosticoConsulta.setText("");
    }//GEN-LAST:event_txbDiagnosticoConsultaMouseClicked

    /**
     * Este método carga los datos de los Box atendidos por el medico a una
     * tabla y settea la bandera
     */
    private void cargarTablaBoxAtendidos() {
        try {
            // Crea un nuevo modelo de tabla
            DefaultTableModel modeloTabla = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Todas las celdas son falsas, es decir, no editables.
                    return false;
                }
            };
            // Define los títulos de las columnas
            String titutlos[] = {"Box", "Dni", "Apellido"};
            // Establece los identificadores de columna en el modelo de tabla
            modeloTabla.setColumnIdentifiers(titutlos);
            // Obtiene una lista de boxes usando el controlador
            List<Box> boxes = this.control.TraerBoxDelMedico();
            int sum = 0;
            // Verifica si la lista de boxes no es nula
            if (boxes != null) {
                // Itera sobre cada box en la lista
                for (Box box : boxes) {
                    // Crea un objeto con los datos del box
                    Object[] objeto = {box.getId(), box.getConsulta().getPaciente().getDni(), box.getConsulta().getPaciente().getApellido()};
                    // Agrega el objeto a la tabla
                    modeloTabla.addRow(objeto);
                    sum += 1;
                }
                if (sum < 3) {
                    this.bandera = true;
                }
            }

            // Segun la cantidad de box que posee el medigo activa la bandera
            // posteriormente indica si puede tomar mas pacientes o no
            // Establece el modelo de la tabla
            tablaBoxAtendidos.setModel(modeloTabla);
        } catch (Exception e) {
            // Imprime cualquier error que ocurra durante la ejecución del código anterior
            control.mostrarMensaje("No posee pacientes en box", "Sin pacientes", "");
            this.bandera = true;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDarDeAlta;
    private javax.swing.JButton btnDatosMedicos;
    private javax.swing.JButton btnNuevoPaciente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBoxAtendidos;
    private javax.swing.JTextField txbDiagnosticoConsulta;
    private javax.swing.JLabel txtTitulo2;
    private javax.swing.JLabel txtTituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
