package vista;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import logica.LogicaMatricula;
import modelo.Matricula;

public class FrmMantenimientoMatricula extends javax.swing.JFrame implements ImantenimientoCallback {

    public static boolean editar;
    public static String id;
    public static String nombreCurso;
    public static String dni;
    public static String nombreAlumno;
    public static String idBuscar;
    public static String dniBuscar;
    private DefaultTableModel modelo;
    String[] titulos = {"ID. CURSO", "NOMBRE CURSO", "DNI ALUMNO", "NOMBRE ALUMNO"};

    /**
     * Creates new form FrmMantinimientoMatricula
     */
    public FrmMantenimientoMatricula() {
        initComponents();
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };
        tblListado.setModel(modelo);
    }

    public void mostrar() {

        this.setTitle("Mantenimiento Matriculas");
        this.setLocationRelativeTo(null);
        btnBaja.setEnabled(false);
        txtDni.setText("");
        txtId.setText("");
        this.setVisible(true);
        TableColumnModel columnModel = tblListado.getColumnModel();
        tblListado.setComponentPopupMenu(contextual);
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getTableHeader().setReorderingAllowed(false);

        try {
            List<LogicaMatricula.MatriculasListado> tMatriculasListado = new ArrayList<>();
            LogicaMatricula.listadoMatriculas(tMatriculasListado);
            for (LogicaMatricula.MatriculasListado ml : tMatriculasListado) {
                modelo.addRow(new String[]{ml.getDni(), ml.getNombre(), Integer.toString(ml.getId()), ml.getTitulo()});
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this,
                    "Error listado matriculas",
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 540));
        setMinimumSize(new java.awt.Dimension(790, 540));
        setSize(new java.awt.Dimension(790, 540));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Id. Curso");

        jLabel2.setText("DNI. Alumno");

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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAlta)
                                .addGap(18, 18, 18)
                                .addComponent(btnBaja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni)
                            .addComponent(txtId))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (evt.getSource() == btnLimpiar) {
            txtDni.setText("");
            txtId.setText("");
        } else {
            buscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        frameAnyadir();
        comprobarDatos();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        frameBaja();
        comprobarDatos();
    }//GEN-LAST:event_btnBajaActionPerformed

    private void tblListadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMousePressed
        comprobarDatos();
    }//GEN-LAST:event_tblListadoMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        tblListado.isEditing();
    }//GEN-LAST:event_formMouseClicked

    private void anyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadirActionPerformed
        frameAnyadir();
        comprobarDatos();
    }//GEN-LAST:event_anyadirActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        frameBaja();
        comprobarDatos();
    }//GEN-LAST:event_bajaActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (FrmEdicionCurso.mantenimiento) {
                if (evt.getSource() == txtId) {
                    txtDni.requestFocus();
                }else if(evt.getSource() == txtDni){
                    btnLimpiar.requestFocus();
                    btnLimpiar.doClick();
                }else if(evt.getSource()==btnLimpiar){
                    btnBuscar.requestFocus();
                } else {
                    btnCancelar.requestFocus();
                    btnCancelar.doClick();
                }
            }else{
                if (evt.getSource() == txtId) {
                    txtDni.requestFocus();
                }else if(evt.getSource() == txtDni){
                    btnLimpiar.requestFocus();
                    btnLimpiar.doClick();
                }else if(evt.getSource()==btnLimpiar){
                    btnBuscar.requestFocus();
                } else {
                    btnCancelar.requestFocus();
                    btnCancelar.doClick();
                }
            }
        }
    }//GEN-LAST:event_txtKeyPressed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }

    private void comprobarDatos() {
        if (tblListado.getSelectedRows().length > 0) {
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(true);
        }else{
            btnAlta.setEnabled(true);
            btnBaja.setEnabled(false); 
        }
    }

    public void frameAnyadir() {
        btnAlta.setEnabled(false);
        editar = false;
        FrmEdicionMatricula panelPM = new FrmEdicionMatricula();
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
                Matricula m = new Matricula();

                m.setDniAlumno((String) modelo.getValueAt(tblListado.getSelectedRow(), 0));
                m.setIdCurso(Integer.parseInt((String) modelo.getValueAt(tblListado.getSelectedRow(), 1)));

                LogicaMatricula.bajaMatricula(m);
                JOptionPane.showConfirmDialog(this,
                        "Baja Matricula Correcta",
                        this.getName(),
                        JOptionPane.PLAIN_MESSAGE);
                modelo.removeRow(tblListado.getSelectedRow());
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(this,
                        "Baja matricula Incorrecta",
                        this.getName(),
                        JOptionPane.ERROR_MESSAGE);
            }
            comprobarDatos();
        }
    }

    private void buscar() {
        try {
            dniBuscar = txtDni.getText();
            idBuscar = txtId.getText();
            modelo.setRowCount(0);
            tblListado.setModel(modelo);
            List<LogicaMatricula.MatriculasListado> tMatriculasListado = new ArrayList<>();
            LogicaMatricula.buscar(tMatriculasListado);
            List<LogicaMatricula.MatriculasListado> tMatriculas = new ArrayList<>();
            LogicaMatricula.listadoMatriculas(tMatriculas);
            for (LogicaMatricula.MatriculasListado ml : tMatriculas) {
                modelo.addRow(new String[]{ml.getDni(), ml.getNombre(), Integer.toString(ml.getId()), ml.getTitulo()});
            }
            txtDni.setText("");
            txtId.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error busqueda matriculas",
                    this.getName(),
                    JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(FrmMantenimientoMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimientoMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMantenimientoMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem anyadir;
    private javax.swing.JMenuItem baja;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPopupMenu contextual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    @Override
    public void alctualizaMto() {
        txtDni.setText("");
        txtId.setText("");
        buscar();
    }

}
