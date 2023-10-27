/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanasGUI;

import Model.AdministradorDeSistema;
import Model.Controladora;
import Model.FuncionarioGeneral;
import Model.Usuario;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matías Sillen Ríos
 */
public class Administrador extends javax.swing.JFrame {

    AdministradorDeSistema administrador;
    Controladora control;

    /**
     * Creates new form Administrador
     *
     * @param control
     *
     */
    public Administrador(Controladora control) {
        this.control = control;
        administrador = new AdministradorDeSistema(control);
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
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCrearUsuario = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnBorrarUsuario = new javax.swing.JButton();
        btnRecargarTablas = new javax.swing.JButton();
        btnMiUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFuncionariosEnGeneral = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnInfoAdministrativa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(100, 196, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Administrador del sistema");

        btnCerrarSesion.setBackground(new java.awt.Color(153, 204, 255));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(136, 40));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addGap(372, 372, 372)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnCrearUsuario.setBackground(new java.awt.Color(0, 204, 153));
        btnCrearUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setBackground(new java.awt.Color(0, 204, 153));
        btnBuscarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarUsuario.setText("Buscar Usuario");
        btnBuscarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnEditarUsuario.setBackground(new java.awt.Color(0, 204, 153));
        btnEditarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnEditarUsuario.setText("Editar Usuario");
        btnEditarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnBorrarUsuario.setBackground(new java.awt.Color(0, 204, 153));
        btnBorrarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBorrarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarUsuario.setText("Borrar Usuario");
        btnBorrarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBorrarUsuario.setPreferredSize(new java.awt.Dimension(136, 40));
        btnBorrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarUsuarioActionPerformed(evt);
            }
        });

        btnRecargarTablas.setBackground(new java.awt.Color(0, 204, 153));
        btnRecargarTablas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRecargarTablas.setForeground(new java.awt.Color(0, 0, 0));
        btnRecargarTablas.setText("Recargar Tablas");
        btnRecargarTablas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRecargarTablas.setPreferredSize(new java.awt.Dimension(136, 40));
        btnRecargarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarTablasActionPerformed(evt);
            }
        });

        btnMiUsuario.setBackground(new java.awt.Color(102, 204, 255));
        btnMiUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMiUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnMiUsuario.setText("Mi Usuario");
        btnMiUsuario.setBorder(null);
        btnMiUsuario.setPreferredSize(new java.awt.Dimension(136, 40));
        btnMiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(btnEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnRecargarTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnMiUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRecargarTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMiUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1015, 550));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Funcionarios en General");

        tablaFuncionariosEnGeneral.setBackground(new java.awt.Color(255, 255, 255));
        tablaFuncionariosEnGeneral.setForeground(new java.awt.Color(0, 0, 0));
        tablaFuncionariosEnGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFuncionariosEnGeneral.setPreferredSize(new java.awt.Dimension(30, 85));
        tablaFuncionariosEnGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFuncionariosEnGeneralMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFuncionariosEnGeneral);

        tablaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaUsuarios.setPreferredSize(new java.awt.Dimension(30, 85));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaUsuarios);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Usuarios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(jLabel2)
                        .addGap(0, 429, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        btnInfoAdministrativa.setBackground(new java.awt.Color(0, 204, 153));
        btnInfoAdministrativa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInfoAdministrativa.setForeground(new java.awt.Color(0, 0, 0));
        btnInfoAdministrativa.setText("Ver infromación administrativa");
        btnInfoAdministrativa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnInfoAdministrativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoAdministrativaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInfoAdministrativa, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInfoAdministrativa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
     * Método de acción que se llama cuando se hace clic en el botón “Buscar
     * Usuario”. Este método crea una nueva instancia de la clase BuscarUsuario
     * y la muestra en la pantalla. La instancia de la clase BuscarUsuario se
     * inicializa con los objetos administrador y control.
     */

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        BuscarUsuario pantalla2 = new BuscarUsuario(administrador, control);
        pantalla2.setVisible(true);
        pantalla2.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed
    /**
     * Es un método de acción que se llama cuando se hace clic en el botón
     * “Editar Usuario”. Este método comprueba si se ha seleccionado una fila en
     * la tabla de usuarios. Si se ha seleccionado una fila, se obtiene el ID
     * del usuario seleccionado y se crea una nueva instancia de la clase
     * EditarUsuario. La instancia de la clase EditarUsuario se inicializa con
     * los objetos administrador, control e id. Si no se ha seleccionado ninguna
     * fila, se muestra un mensaje de error.
     *
     */

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed

        /**
         * Comprobamos que la tabla Usuarios fue seleccionada
         */
        //Validar que la tabla tenga elementos
        if (tablaUsuarios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaUsuarios.getSelectedRow() != -1) {

                //Obtener la id del elemento a seleccionar
                long id = Integer.parseInt(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0)));

                //Llamo a la ventana EditarUsuario 
                EditarUsuario editar = new EditarUsuario(administrador, control, id);
                editar.setVisible(true);
                editar.setLocationRelativeTo(null);

            } else {
                control.mostrarMensaje("No selecciono ningún registro", "Error", "Error al editar");
            }
        } else {
            control.mostrarMensaje("La tabla esta vacía", "Error", "Error al editar");
        }


    }//GEN-LAST:event_btnEditarUsuarioActionPerformed
    /**
     * Es un método de acción que se llama cuando se hace clic en el botón
     * “Información Administrativa”. Este método crea una nueva instancia de la
     * clase InformacionAdministrativa y la muestra en la pantalla. La instancia
     * de la clase InformacionAdministrativa se inicializa con el objeto
     * control. Además, este método cierra la ventana actual.
     */

    private void btnInfoAdministrativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoAdministrativaActionPerformed
        InformacionAdministrativa pantalla5 = new InformacionAdministrativa(control);
        pantalla5.setVisible(true);
        pantalla5.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnInfoAdministrativaActionPerformed
    /**
     * es un método de acción que se llama cuando se hace clic en el botón
     * “Borrar Usuario”. Este método comprueba si se ha seleccionado una fila en
     * la tabla de usuarios. Si se ha seleccionado una fila, se obtiene el ID
     * del usuario seleccionado y se llama al método borrarUsuario(id) de la
     * instancia de la clase AdministradorDeSistema para eliminar el usuario de
     * la base de datos. Si no se ha seleccionado ninguna fila, se muestra un
     * mensaje de error.
     */

    private void btnBorrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarUsuarioActionPerformed

        /**
         * Comprobamos que la tabla Usuarios fue seleccionada
         */
        //Validar que la tabla tenga elementos
        if (tablaUsuarios.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaUsuarios.getSelectedRow() != -1) {

                //Obtener la id del elemento a seleccionar
                long id = Integer.parseInt(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0)));

                //Llamo al método borrar 
                administrador.borrarUsuario(id);

                //Avisar al administrador que se borro correctamente
                control.mostrarMensaje("Se borró el usuario conrrectamente", "info", "Eliminación correcta");

                cargarTablaFuncionariosEnGeneral();
                cargarTablaUsuarios();

            } else {
                control.mostrarMensaje("No selecciono ningún registro", "Error", "Error al borrar");
            }
        } else {
            control.mostrarMensaje("La tabla está vacía", "Error", "Error al borrar");
        }

    }//GEN-LAST:event_btnBorrarUsuarioActionPerformed
    /**
     * método que se llama cuando se abre la ventana. Este método carga los
     * datos de los funcionarios generales y los usuarios en las tablas
     * correspondientes. Además, deshabilita los botones “Crear Usuario”,
     * “Borrar Usuario” y “Editar Usuario”.
     */

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablaFuncionariosEnGeneral();
        cargarTablaUsuarios();
        btnCrearUsuario.setEnabled(false);
        btnBorrarUsuario.setEnabled(false);
        btnEditarUsuario.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened
    /**
     * El método se llama cuando se hace clic en una fila de la tabla de
     * funcionarios generales. Este método habilita el botón “Crear Usuario”,
     * deshabilita los botones “Borrar Usuario” y “Editar Usuario” y carga la
     * tabla de usuarios.
     */

    private void tablaFuncionariosEnGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFuncionariosEnGeneralMouseClicked
        btnCrearUsuario.setEnabled(true);
        btnBorrarUsuario.setEnabled(false);
        btnEditarUsuario.setEnabled(false);
        cargarTablaUsuarios();
    }//GEN-LAST:event_tablaFuncionariosEnGeneralMouseClicked
    /**
     * El método se llama cuando se hace clic en una fila de la tabla de
     * usuarios. Este método deshabilita el botón “Crear Usuario” y habilita los
     * botones “Borrar Usuario” y “Editar Usuario”. Además, carga la tabla de
     * funcionarios generales.
     */
    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        btnCrearUsuario.setEnabled(false);
        btnBorrarUsuario.setEnabled(true);
        btnEditarUsuario.setEnabled(true);
        cargarTablaFuncionariosEnGeneral();
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    /**
     * El método es un método de acción que se llama cuando se hace clic en el
     * botón “Crear Usuario”. Este método comprueba si se ha seleccionado una
     * fila en la tabla de funcionarios generales. Si se ha seleccionado una
     * fila, se obtiene el ID, nombre, apellido y DNI del funcionario general
     * seleccionado y se crea una nueva instancia de la clase CrearUsuario. La
     * instancia de la clase CrearUsuario se inicializa con los objetos
     * administrador, control, id, nombre, apellido y dni. Si no se ha
     * seleccionado ninguna fila, se muestra un mensaje de error.
     */

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        /**
         * Comprobamos que la tabla FuncionarioGeneral fue seleccionada
         */

        //Validar que la tabla tenga elementos
        if (tablaFuncionariosEnGeneral.getRowCount() > 0) {
            //Controlar que se haya seleccionado un elemento
            if (tablaFuncionariosEnGeneral.getSelectedRow() != -1) {

                //Obtener la id del elemento a seleccionar 
                long id = Integer.parseInt(String.valueOf(tablaFuncionariosEnGeneral.getValueAt(tablaFuncionariosEnGeneral.getSelectedRow(), 0)));
                String nombre = String.valueOf(tablaFuncionariosEnGeneral.getValueAt(tablaFuncionariosEnGeneral.getSelectedRow(), 1));
                String apellido = String.valueOf(tablaFuncionariosEnGeneral.getValueAt(tablaFuncionariosEnGeneral.getSelectedRow(), 2));
                int dni = Integer.parseInt(String.valueOf(tablaFuncionariosEnGeneral.getValueAt(tablaFuncionariosEnGeneral.getSelectedRow(), 4)));

                //Llamo a la ventana CrearUsuario 
                CrearUsuario pantalla1 = new CrearUsuario(administrador, control, id, nombre, apellido, dni);
                pantalla1.setVisible(true);
                pantalla1.setLocationRelativeTo(null);

            } else {
                control.mostrarMensaje("No selecciono ningún registro", "Error", "Error al crear");
            }
        } else {
            control.mostrarMensaje("La tabla está vacía", "Error", "Error al crear");
        }

    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    /**
     * El método es un método de acción que se llama cuando se hace clic en el
     * botón “Recargar Tablas”. Este método carga los datos de los funcionarios
     * generales y los usuarios en las tablas correspondientes.
     */

    private void btnRecargarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarTablasActionPerformed
        cargarTablaFuncionariosEnGeneral();
        cargarTablaUsuarios();
    }//GEN-LAST:event_btnRecargarTablasActionPerformed

    /**
     * Es un método de acción que se llama cuando se hace clic en el botón
     * “Cerrar Sesión”. Este método crea una nueva instancia de la clase
     * GuiLogin y la muestra en la pantalla. La instancia de la clase GuiLogin
     * se inicializa sin ningún argumento. Además, este método cierra la ventana
     * actual.
     */

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        GuiLogin inicio = new GuiLogin();
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * El método es un método de acción que se llama cuando se hace clic en el
     * botón “Mi Usuario”. Este método está actualmente comentado y no realiza
     * ninguna acción.
     */

    private void btnMiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiUsuarioActionPerformed
//        MiUsuario datos = new MiUsuario(control);
//        datos.setVisible(true);
//        datos.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnMiUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarUsuario;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnInfoAdministrativa;
    private javax.swing.JButton btnMiUsuario;
    private javax.swing.JButton btnRecargarTablas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablaFuncionariosEnGeneral;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables

    /**
     * El método llama al método privado cargarTablaFuncionariosEnGeneral para
     * actualizar la tabla de funcionarios generales.
     */
    public void recargarTablaFuncionariosEnGeneral() {
        cargarTablaFuncionariosEnGeneral();
    }

    /**
     * El método define el modelo que se utilizará para la tabla de funcionarios
     * generales. Luego, establece los nombres de las columnas y recupera la
     * lista de funcionarios generales de la base de datos. Si la lista no es
     * nula, se recorre la lista y se agregan los objetos a la tabla.
     * Finalmente, se establece el modelo de tabla en la tabla de funcionarios
     * generales.
     */
    private void cargarTablaFuncionariosEnGeneral() {
        //Definimos el modelo que queremos que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //Que fila y columna no sean editables
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        //Establecemos los nombres de las columnas
        String titulos[] = {"Id", "Nombre", "Apellido", "Fecha de nacimiento", "DNI", "Domicilio",
            "Teléfono Fíjo", "Teléfono Celular", "Correo Electrónico", "Estado Civil"};
        modeloTabla.setColumnIdentifiers(titulos);

        //Traer de la DB la lista de Funcionarios en General
        List<FuncionarioGeneral> listaFuncionariosEnGeneral = control.traerFuncionariosEnGeneral();

        if (listaFuncionariosEnGeneral != null) {

            for (FuncionarioGeneral funcionarioGeneral : listaFuncionariosEnGeneral) {
                Object[] objeto = {funcionarioGeneral.getId(), funcionarioGeneral.getNombre(), funcionarioGeneral.getApellido(), funcionarioGeneral.getFechaDeNac(),
                    funcionarioGeneral.getDni(), funcionarioGeneral.getDomicilio(), funcionarioGeneral.getTelefonoFijo(), funcionarioGeneral.getTelefonoCel(),
                    funcionarioGeneral.getCorreoE(), funcionarioGeneral.getEstadoCivil()};

                modeloTabla.addRow(objeto);
            }
        }

        tablaFuncionariosEnGeneral.setModel(modeloTabla);
    }

    /**
     * El método llama al método privado cargarTablaUsuarios para actualizar la
     * tabla de usuarios.
     */
    public void recargarTablaUsuarios() {
        cargarTablaUsuarios();
    }

    /**
     * El método define el modelo que se utilizará para la tabla de usuarios.
     * Luego, establece los nombres de las columnas y recupera la lista de
     * usuarios de la base de datos. Si la lista no es nula, se recorre la lista
     * y se agregan los objetos a la tabla. Finalmente, se establece el modelo
     * de tabla en la tabla de usuarios. Si se produce una excepción
     * NoSuchElementException, se muestra un mensaje de error.
     */
    private void cargarTablaUsuarios() {
        //Bloque try-catch para manejar la excepción "NoSuchElementException" 
        //que se produce cuando se intenta acceder a un elemento que no existe en una colección.    

        try {
            //Definimos el modelo que queremos que tenga la tabla
            DefaultTableModel modeloTabla = new DefaultTableModel() {

                //Que fila y columna no sean editables
                @Override
                public boolean isCellEditable(int row, int colum) {
                    return false;
                }
            };

            //Establecemos los nombres de las columnas
            String titulos[] = {"Id", "Nombre de Usuario", "Rol"};
            modeloTabla.setColumnIdentifiers(titulos);

            //Traer de la DB la lista de Gestores
            List<Usuario> listaUsuarios = control.traerUsuarios();

            if (listaUsuarios != null) {

                for (Usuario usu : listaUsuarios) {
                    Object[] objeto = {usu.getId(), usu.getNomUsuario(), usu.getRol().getFirst().getNombre()};

                    modeloTabla.addRow(objeto);
                }
            }

            tablaUsuarios.setModel(modeloTabla);
        } catch (NoSuchElementException e) {
            control.mostrarMensaje("Tabla de usuarios vacía", "Info", "Información");
        }

    }

}
