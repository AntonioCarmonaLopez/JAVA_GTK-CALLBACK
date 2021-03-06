package vista;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import logica.LogicaProfesor;
import modelo.Profesor;

public class FrmMantenimientoProfesores extends javax.swing.JFrame implements ImantenimientoCallback {

    public static boolean editar, mToProfesor;
    public static String dni;
    public static String nombre;
    public static String dniBuscar;
    public static String nombreBuscar;
    private DefaultTableModel modelo;
    private ImantenimientoCallback imc;
    String[] titulos = {"DNI", "NOMBRE"};

    /**
     * Creates new form FrmMantenimientoProfesores
     */
    public FrmMantenimientoProfesores() {
        initComponents();
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        tblListado.setModel(modelo);
    }

    public void mostrar(ImantenimientoCallback imc) {
        //se configura el listener
        this.imc = imc;

        this.setLocationRelativeTo(null);

        if (FrmEdicionCurso.mantenimiento) {
            this.setTitle("Buscar Profesor");
            btnAceptar.setEnabled(false);
            btnAceptar.setVisible(true);
            btnBaja.setVisible(false);
            btnEdicion.setVisible(false);
            btnAlta.setVisible(false);
        } else {
            this.setTitle("Mantenimiento Profesores");
            this.setLocationRelativeTo(null);
            btnAceptar.setEnabled(false);
            btnBaja.setEnabled(false);
            btnEdicion.setEnabled(false);
            txtDni.setText("");
            txtNombre.setText("");
        }
        this.setVisible(true);
        TableColumnModel columnModel = tblListado.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(300);
        tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getTableHeader().setReorderingAllowed(false);

        List<Profesor> tProfesores = new ArrayList<>();
        try {
            LogicaProfesor.listadoProfesores(tProfesores);
            for (Profesor p : tProfesores) {
                modelo.addRow(new String[]{p.getDni(), p.getNombre()});
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this,
                    "Error listado profesores",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * txtNombre.getText();* This method is called from within the constructor
     * to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contextual = new javax.swing.JPopupMenu();
        anyadir = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        baja = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnAlta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnEdicion = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        anyadir.setText("Alta");
        anyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyadirActionPerformed(evt);
            }
        });
        contextual.add(anyadir);

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        contextual.add(edit);

        baja.setText("Baja");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        contextual.add(baja);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 540));
        setMinimumSize(new java.awt.Dimension(790, 540));
        setName("Mantenimiento Profesores"); // NOI18N
        setPreferredSize(new java.awt.Dimension(790, 540));
        setSize(new java.awt.Dimension(790, 540));

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblListado.setComponentPopupMenu(contextual);
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListadoMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionActionPerformed(evt);
            }
        });
        btnAlta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionActionPerformed(evt);
            }
        });
        btnBaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnEdicion.setText("Editar");
        btnEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionActionPerformed(evt);
            }
        });
        btnEdicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlta)
                        .addGap(18, 18, 18)
                        .addComponent(btnBaja)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja)
                    .addComponent(btnEdicion)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }

    private void comprobarDatos() {
        if (tblListado.getSelectedRows().length > 0) {
            btnAlta.setEnabled(false);
            btnEdicion.setEnabled(true);
            btnBaja.setEnabled(true);
            btnAceptar.setEnabled(true);
        } else {
            btnAlta.setEnabled(true);
            btnEdicion.setEnabled(false);
            btnBaja.setEnabled(false);
            btnAceptar.setEnabled(false);
        }
    }

    public void frameAnyadir() {
        btnAlta.setEnabled(false);
        editar = false;
        FrmEdicionProfesor panelPM = new FrmEdicionProfesor();
        panelPM.setSize(790, 540);
        panelPM.setVisible(false);
        panelPM.mostrar(this);
        comprobarDatos();
    }

    public void frameEditar() {
        btnEdicion.setEnabled(false);
        editar = true;
        dni = (String) modelo.getValueAt(tblListado.getSelectedRow(), 0);
        nombre = (String) modelo.getValueAt(tblListado.getSelectedRow(), 1);
        FrmEdicionProfesor panelPM = new FrmEdicionProfesor();
        panelPM.setSize(790, 540);
        panelPM.setVisible(false);
        panelPM.mostrar(this);
        comprobarDatos();
    }

    private void frameBaja() {
        if (JOptionPane.showConfirmDialog(this,
                "¿Realmente desea borrar el profesor seleccionado?",
                this.getName(),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {

            try {
                Profesor p = new Profesor();

                p.setDni((String) modelo.getValueAt(tblListado.getSelectedRow(), 0));

                LogicaProfesor.bajaProfesor(p);
                JOptionPane.showMessageDialog(this,
                        "Baja Profesor Correcta",
                        this.getName(),
                        JOptionPane.PLAIN_MESSAGE);
                modelo.removeRow(tblListado.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Baja Profesor Inorrecta",
                        this.getName(),
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        comprobarDatos();
    }

    private void EdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdicionActionPerformed
        if (tblListado.getSelectedRows().length < 0) {
            JOptionPane.showMessageDialog(this,
                    "No se ha seleccionado ninguna fila",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
            this.getRootPane().getContentPane().remove(this);
        } else {
            btnEdicion.setEnabled(true);
        }
        if (evt.getSource() == btnAlta) {
            frameAnyadir();
            btnAlta.setEnabled(true);
        } else if (evt.getSource() == btnEdicion) {
            frameEditar();
        } else if (evt.getSource() == btnBaja) {
            if (tblListado.getSelectedRows().length < 0) {
                JOptionPane.showMessageDialog(this,
                        "No se ha seleccionado ninguna fila",
                        this.getName(),
                        JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
                this.getRootPane().getContentPane().remove(this);
            } else {
                frameBaja();
                btnEdicion.setEnabled(true);
            }
        }
    }//GEN-LAST:event_EdicionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (evt.getSource() == btnLimpiar) {
            txtDni.setText("");
            txtNombre.setText("");
        } else {
            buscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void buscar() {
        try {
            dniBuscar = txtDni.getText();
            nombreBuscar = txtNombre.getText();
            modelo.setRowCount(0);
            tblListado.setModel(modelo);
            List<Profesor> tProfesores = new ArrayList<>();
            LogicaProfesor.buscar(tProfesores);
            for (Profesor p : tProfesores) {
                modelo.addRow(new String[]{p.getDni(), p.getNombre()});
            }
            txtDni.setText("");
            txtNombre.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error busqueda profesores",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tblListadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMousePressed
        comprobarDatos();
    }//GEN-LAST:event_tblListadoMousePressed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        tblListado.isEditing();
    }//GEN-LAST:event_tblListadoMouseClicked

    private void anyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadirActionPerformed
        frameAnyadir();
        comprobarDatos();
    }//GEN-LAST:event_anyadirActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        frameEditar();
        comprobarDatos();
    }//GEN-LAST:event_editActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        frameBaja();
        comprobarDatos();
    }//GEN-LAST:event_bajaActionPerformed


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        dni = (String) modelo.getValueAt(tblListado.getSelectedRow(), 0);
        nombre = (String) modelo.getValueAt(tblListado.getSelectedRow(), 1);
        imc.actualizarCurso();

        mToProfesor = true;
        imc.actualizarMatricula();

        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (FrmEdicionCurso.mantenimiento) {
                if (evt.getSource() == txtDni) {
                    txtNombre.requestFocus();
                } else if (evt.getSource() == txtNombre) {
                    btnLimpiar.requestFocus();
                    btnLimpiar.doClick();
                } else if (evt.getSource() == btnLimpiar) {
                    btnBuscar.requestFocus();
                } else if (evt.getSource() == btnBuscar) {
                    btnAceptar.requestFocus();
                    btnAceptar.doClick();
                } else {
                    btnCancelar.requestFocus();
                    btnCancelar.doClick();
                }
            } else {
                if (evt.getSource() == txtDni) {
                    txtNombre.requestFocus();
                } else if (evt.getSource() == txtNombre) {
                    btnLimpiar.requestFocus();
                    btnLimpiar.doClick();
                } else if (evt.getSource() == btnLimpiar) {
                    btnBuscar.requestFocus();
                } else if (evt.getSource() == btnBuscar) {
                    btnAceptar.requestFocus();
                    btnAceptar.doClick();
                } else {
                    btnCancelar.requestFocus();
                    btnCancelar.doClick();
                }
            }
        }
    }//GEN-LAST:event_txtKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMantenimientoProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem anyadir;
    private javax.swing.JMenuItem baja;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEdicion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPopupMenu contextual;
    private javax.swing.JMenuItem edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void alctualizaMto() {
        txtDni.setText("");
        txtNombre.setText("");
        buscar();
    }

    void mostrar() {
        this.setLocationRelativeTo(null);

        if (FrmEdicionCurso.mantenimiento) {
            this.setTitle("Buscar Profesor");
            btnAceptar.setVisible(true);
            btnAceptar.setEnabled(false);
            btnBaja.setVisible(false);
            btnEdicion.setVisible(false);
            btnAlta.setVisible(false);
        } else {
            this.setTitle("Mantenimiento Profesores");
            this.setLocationRelativeTo(null);
            btnBaja.setEnabled(false);
            btnEdicion.setEnabled(false);
            btnAceptar.setVisible(false);
            txtDni.setText("");
            txtNombre.setText("");
        }
        this.setVisible(true);
        TableColumnModel columnModel = tblListado.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(300);
        tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getTableHeader().setReorderingAllowed(false);

        List<Profesor> tProfesores = new ArrayList<>();
        try {
            LogicaProfesor.listadoProfesores(tProfesores);
            for (Profesor p : tProfesores) {
                modelo.addRow(new String[]{p.getDni(), p.getNombre()});
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this,
                    "Error listado profesores",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
