package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import logica.LogicaCurso;
import modelo.Curso;

public class FrmMantenimientoCurso extends javax.swing.JFrame implements ImantenimientoCallback {

    private ImantenimientoCallback imc;
    public static boolean editar, mToCurso;
    public static int id;
    public static String nombre, fechaIni, fechaFin, dniProfesor;
    public static Double horas;
    public static char modalidad;
    public static String estado;
    public static String idBuscar;
    public static String nombreBuscar;
    private DefaultTableModel modelo;
    String[] titulos = {"ID", "NOMBRE", "HORAS", "DNI PROFESOR",
        "FECHA INICIO", "FECHA FIN", "MODALIDAD", "ESTADO"};

    /**
     * Creates new form FrmMantenimientoCurso
     */
    public FrmMantenimientoCurso() {
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

        txtId.setText("");
        txtNombre.setText("");
        this.setLocationRelativeTo(null);
        if (FrmEdicionCurso.mantenimiento) {
            this.setTitle("Buscar Cursos");

            btnAlta.setVisible(false);
            btnBaja.setVisible(false);
            btnEditar.setVisible(false);
            btnAceptar.setVisible(true);
            btnAceptar.setEnabled(false);
        } else {
            this.setTitle("Mantenimiento Cursos");
            btnBaja.setEnabled(false);
            btnEditar.setEnabled(false);
            btnAceptar.setVisible(false);
        }
        this.setVisible(true);
        TableColumnModel columnModel = tblListado.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(200);
        tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getTableHeader().setReorderingAllowed(false);

        List<Curso> tCursos = new ArrayList<>();
        try {
            LogicaCurso.listadoCursos(tCursos);
            for (Curso c : tCursos) {
                modelo.addRow(new String[]{Integer.toString(c.getId()), c.getTitulo(), Double.toString(c.getHoras()),
                    c.getDniProfesor(), c.getFecIniString(), c.getFecFinString(),
                    String.valueOf(c.getModalidad()), c.getEstadoString()});
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this,
                    "Error listado Cursos",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contextual = new javax.swing.JPopupMenu();
        anyadir = new javax.swing.JMenuItem();
        baja = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        anyadir.setText("Alta");
        anyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyadirActionPerformed(evt);
            }
        });
        contextual.add(anyadir);

        baja.setText("Baja");
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        contextual.add(baja);

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        contextual.add(edit);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(790, 540));
        setSize(new java.awt.Dimension(790, 540));

        jLabel1.setText("ID Curso");

        jLabel2.setText("Nombre Curso");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        btnLimpiar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
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
                btnAltaActionPerformed(evt);
            }
        });
        btnAlta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnBaja.setText("Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });
        btnBaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlta)
                        .addGap(18, 18, 18)
                        .addComponent(btnBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId)
                                    .addComponent(txtNombre))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(61, 61, 61)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        if (evt.getSource() == btnLimpiar) {
            txtId.setText("");
            txtNombre.setText("");
        } else {
            buscar();
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void tblListadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMousePressed
        comprobarDatos();
    }//GEN-LAST:event_tblListadoMousePressed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        tblListado.isEditing();
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        frameAnyadir();
        comprobarDatos();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        frameBaja();
        comprobarDatos();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        frameEditar();
        comprobarDatos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void anyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadirActionPerformed
        frameAnyadir();
        comprobarDatos();
    }//GEN-LAST:event_anyadirActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        frameBaja();
        comprobarDatos();
    }//GEN-LAST:event_bajaActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        frameEditar();
        comprobarDatos();
    }//GEN-LAST:event_editActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (FrmEdicionCurso.mantenimiento) {
                if (evt.getSource() == txtId) {
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
                if (evt.getSource() == txtId) {
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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        id = Integer.parseInt(modelo.getValueAt(tblListado.getSelectedRow(), 0).toString());
        nombre = (String) modelo.getValueAt(tblListado.getSelectedRow(), 1);
        mToCurso = true;
        imc.actualizarMatricula();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void buscar() {
        try {
            idBuscar = txtId.getText();
            nombreBuscar = txtNombre.getText();
            modelo.setRowCount(0);
            tblListado.setModel(modelo);
            List<Curso> tCursos = new ArrayList<>();
            LogicaCurso.buscar(tCursos);

            for (Curso c : tCursos) {
                modelo.addRow(new String[]{Integer.toString(c.getId()), c.getTitulo(), Double.toString(c.getHoras()),
                    c.getDniProfesor(), c.getFecIniString(), c.getFecFinString(),
                    String.valueOf(c.getModalidad()), c.getEstadoString()});
            }
            txtId.setText("");
            txtNombre.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error busqueda Cursos",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }

    private void comprobarDatos() {
        if (tblListado.getSelectedRows().length > 0) {
            btnAlta.setEnabled(false);
            btnEditar.setEnabled(true);
            btnBaja.setEnabled(true);
            btnAceptar.setEnabled(true);
        }
    }

    public void frameAnyadir() {
        btnAlta.setEnabled(false);
        editar = false;
        FrmEdicionCurso panelPM = new FrmEdicionCurso();
        panelPM.setSize(790, 540);
        panelPM.setVisible(false);
        panelPM.mostrar(this);
    }

    public void frameEditar() {
        btnEditar.setEnabled(false);
        editar = true;
        id = (Integer.parseInt((String) modelo.getValueAt(tblListado.getSelectedRow(), 0)));
        nombre = (String) modelo.getValueAt(tblListado.getSelectedRow(), 1);
        String hora = (String) modelo.getValueAt(tblListado.getSelectedRow(), 2);
        horas = (Double.parseDouble(hora));
        dniProfesor = (String) modelo.getValueAt(tblListado.getSelectedRow(), 3);
        fechaIni = (String) modelo.getValueAt(tblListado.getSelectedRow(), 4);
        fechaFin = (String) modelo.getValueAt(tblListado.getSelectedRow(), 5);
        modalidad = modelo.getValueAt(tblListado.getSelectedRow(), 6).toString().charAt(0);
        estado = (String) modelo.getValueAt(tblListado.getSelectedRow(), 7);
        FrmEdicionCurso panelPM = new FrmEdicionCurso();
        panelPM.setSize(790, 540);
        panelPM.setVisible(false);
        panelPM.mostrar(this);
    }

    private void frameBaja() {
        if (JOptionPane.showConfirmDialog(this,
                "¿Realmente desea borrar el profesor seleccionado?",
                this.getName(),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {

            try {
                Curso c = new Curso();

                c.setId(Integer.parseInt((String) modelo.getValueAt(tblListado.getSelectedRow(), 0)));

                LogicaCurso.bajaCurso(c);
                JOptionPane.showMessageDialog(this,
                        "Baja Cuso Correcta",
                        this.getName(),
                        JOptionPane.PLAIN_MESSAGE);
                modelo.removeRow(tblListado.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Baja Curso Inorrecta",
                        this.getName(),
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        comprobarDatos();
    }

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {
        comprobarDatos();
    }

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
            java.util.logging.Logger.getLogger(FrmMantenimientoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMantenimientoCurso().setVisible(true);
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPopupMenu contextual;
    private javax.swing.JMenuItem edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void alctualizaMto() {
        txtId.setText("");
        txtNombre.setText("");
        buscar();
    }

    void mostrar() {
        this.setTitle("Mantenimiento Cursos");
        this.setLocationRelativeTo(null);
        btnBaja.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAceptar.setVisible(false);
        txtId.setText("");
        txtNombre.setText("");
        this.setVisible(true);
        TableColumnModel columnModel = tblListado.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(200);
        tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getTableHeader().setReorderingAllowed(false);

        List<Curso> tCursos = new ArrayList<>();
        try {
            LogicaCurso.listadoCursos(tCursos);
            for (Curso c : tCursos) {
                modelo.addRow(new String[]{Integer.toString(c.getId()), c.getTitulo(), Double.toString(c.getHoras()),
                    c.getDniProfesor(), c.getFecIniString(), c.getFecFinString(),
                    String.valueOf(c.getModalidad()), c.getEstadoString()});
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this,
                    "Error listado Cursos",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
