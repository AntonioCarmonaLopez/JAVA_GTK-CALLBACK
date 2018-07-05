package vista;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import logica.LogicaCurso;
import logica.LogicaProfesor;
import modelo.Curso;
import modelo.Profesor;

public class FrmEdicionCurso extends javax.swing.JFrame implements ImantenimientoCallback {

    private ImantenimientoCallback imc;
    private DefaultComboBoxModel<String> modelo;
    public static boolean mantenimiento;

    /**
     * Creates new form FrmEdicionCurso
     */
    public FrmEdicionCurso() {
        initComponents();
    }

    public void mostrar(ImantenimientoCallback imc) {

        this.setLocationRelativeTo(null);
        txtId.setText("");
        txtNombre.setText("");
        txtHoras.setText("");
        txtDniProfesor.setText("");
        txtFechaIni.setText("");
        txtFechaFin.setText("");
        modelo = new DefaultComboBoxModel<String>();
        cmbEstado.setModel(modelo);

        for (Curso.ESTADOCURSO estado : Curso.ESTADOCURSO.values()) {
            modelo.addElement(estado.toString());
        }

        //se configura el listener
        this.imc = imc;

        txtNomPro.setEditable(false);
        txtNomPro.setBackground(Color.lightGray);
        if (!FrmMantenimientoCurso.editar) {
            this.setName("Alta Curso");
            this.setTitle("Alta Curso");
        } else {
            this.setName("Editar Curso");
            this.setTitle("Editar Curso");
            this.txtId.setEditable(false);
            this.txtId.setBackground(Color.lightGray);
            txtId.setText(Integer.toString(FrmMantenimientoCurso.id));
            txtNombre.setText(FrmMantenimientoCurso.nombre);
            txtHoras.setText(Double.toString(FrmMantenimientoCurso.horas));
            txtDniProfesor.setText(FrmMantenimientoCurso.dniProfesor);
            txtFechaIni.setText(FrmMantenimientoCurso.fechaIni);
            txtFechaFin.setText(FrmMantenimientoCurso.fechaFin);
            if (FrmMantenimientoCurso.modalidad == 'O') {
                rdbOnLine.isSelected();
            } else {
                rdbPresencial.isSelected();
            }

            if (FrmMantenimientoCurso.estado.equalsIgnoreCase("programado")) {
                cmbEstado.setSelectedItem("Programado");
            } else if (FrmMantenimientoCurso.estado.equalsIgnoreCase("Realizándose")) {
                cmbEstado.setSelectedItem("Realizándose");
            } else {
                cmbEstado.setSelectedItem("Finalizado");
            }
        }
        this.setVisible(true);
    }

    private boolean datosObligatorios() {
        return txtNombre.getText().isEmpty();
    }

    private void comprobarDatos() {
        if (datosObligatorios()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDniProfesor = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        rdbPresencial = new javax.swing.JRadioButton();
        rdbOnLine = new javax.swing.JRadioButton();
        txtHoras = new javax.swing.JFormattedTextField();
        txtNombre = new javax.swing.JFormattedTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFechaIni = new javax.swing.JFormattedTextField();
        txtNombre2 = new javax.swing.JFormattedTextField();
        txtFechaFin = new javax.swing.JFormattedTextField();
        txtNomPro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 540));
        setMinimumSize(new java.awt.Dimension(790, 540));
        setPreferredSize(new java.awt.Dimension(790, 540));
        setSize(new java.awt.Dimension(790, 540));

        jLabel1.setText("id Curso");

        jLabel2.setText("Nombre Curso");

        jLabel3.setText("Horas Curso");

        jLabel4.setText("DNI Profesor");

        jLabel5.setText("Fecha Inicio");

        jLabel6.setText("Fecha Fin");

        jLabel7.setText("Modalidad");

        jLabel8.setText("Estado");

        txtDniProfesor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniProfesorFocusLost(evt);
            }
        });
        txtDniProfesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rdbPresencial.setText("Presencial");
        rdbPresencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        rdbOnLine.setText("OnLine");

        txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        txtFechaIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtFechaFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtHoras)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(39, 39, 39)
                        .addComponent(txtFechaIni))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(54, 54, 54)
                        .addComponent(txtFechaFin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(47, 47, 47)
                                .addComponent(rdbPresencial)
                                .addGap(18, 18, 18)
                                .addComponent(rdbOnLine))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(txtDniProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(txtNombre2)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDniProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdbPresencial)
                    .addComponent(rdbOnLine))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        if (!FrmMantenimientoCurso.editar) {
            if (evt.getSource() == btnAceptar) {
                if (datosObligatorios()) {
                    JOptionPane.showMessageDialog(this,
                            "Faltan Datos Obligatorios",
                            this.getName(),
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {

                    Curso c = new Curso();

                    c.setId(Integer.parseInt(txtId.getText()));

                    c.setTitulo(txtNombre.getText());

                    if (!txtHoras.getText().isEmpty()) {
                        c.setHoras(Double.parseDouble(txtHoras.getText()));
                    }

                    c.setDniProfesor(txtDniProfesor.getText().equals("") ? null : txtDniProfesor.getText());

                    c.setFecIniString(txtFechaIni.getText().equals("") ? null : txtFechaIni.getText());
                    c.setFecFinString(txtFechaFin.getText().equals("") ? null : txtFechaFin.getText());

                    if (rdbOnLine.isSelected()) {
                        c.setModalidad('O');
                    } else if (rdbPresencial.isSelected()) {
                        c.setModalidad('P');
                    }

                    if (cmbEstado.getSelectedItem().equals("Programado")) {
                        c.setEstado(Curso.ESTADOCURSO.Programado);
                    } else if (cmbEstado.getSelectedItem().equals("Realizándose")) {
                        c.setEstado(Curso.ESTADOCURSO.Realizándose);
                    } else {
                        c.setEstado(Curso.ESTADOCURSO.Finalizado);
                    }

                    LogicaCurso.altaCurso(c);

                    JOptionPane.showConfirmDialog(this,
                            "Alta Curso Correcta",
                            this.getName(),
                            JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this,
                            "Alta Curso Incorrecta",
                            this.getName(),
                            JOptionPane.ERROR_MESSAGE);
                }
                this.setVisible(false);
                this.getRootPane().getContentPane().remove(this);
            }
        } else {

            if (evt.getSource() == btnAceptar) {
                if (datosObligatorios()) {
                    JOptionPane.showMessageDialog(this,
                            "Faltan Datos Obligatorios",
                            this.getName(),
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {

                    Curso c = new Curso();
                    c.setId(Integer.parseInt(txtId.getText()));
                    c.setTitulo(txtNombre.getText());

                    if (!txtHoras.getText().isEmpty()) {
                        c.setHoras(Double.parseDouble(txtHoras.getText()));
                    }

                    c.setDniProfesor(txtDniProfesor.getText()
                    );

                    if (!txtFechaIni.getText().isEmpty()) {
                        c.setFecIniString(txtFechaIni.getText());
                    }
                    if (!txtFechaFin.getText().isEmpty()) {
                        c.setFecFinString(txtFechaFin.getText());
                    }

                    if (rdbOnLine.isSelected()) {
                        c.setModalidad('O');
                    } else if (rdbPresencial.isSelected()) {
                        c.setModalidad('P');
                    }
                    if (cmbEstado.getSelectedItem().equals("Programado")) {
                        c.setEstado(Curso.ESTADOCURSO.Programado);
                    } else if (cmbEstado.getSelectedItem().equals("Realizándose")) {
                        c.setEstado(Curso.ESTADOCURSO.Realizándose);
                    } else {
                        c.setEstado(Curso.ESTADOCURSO.Finalizado);
                    }

                    LogicaCurso.actualizaCurso(c);

                    JOptionPane.showMessageDialog(this,
                            "Curso Actualizado",
                            this.getName(),
                            JOptionPane.PLAIN_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this,
                            "Actualizacion Incorrecta",
                            this.getName(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        imc.alctualizaMto();
        btnAceptar.setEnabled(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mantenimiento = true;
        FrmMantenimientoProfesores frameMP = new FrmMantenimientoProfesores();
        frameMP.setSize(790, 540);
        frameMP.setVisible(false);
        frameMP.mostrar(this);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (evt.getSource() == txtId) {
                txtNombre.requestFocus();
            } else if (evt.getSource() == txtNombre) {
                txtHoras.requestFocus();
            } else if (evt.getSource() == txtHoras) {
                txtDniProfesor.requestFocus();
            } else if (evt.getSource() == txtDniProfesor) {
                Profesor p = new Profesor();
                try {
                    getProfesor(p);
                    txtFechaIni.requestFocus();
                } catch (Exception e) {
                    e.getMessage();
                }
            } else if (evt.getSource() == txtFechaIni) {
                txtFechaFin.requestFocus();

            } else if (evt.getSource() == txtFechaIni) {
                btnAceptar.requestFocus();
                btnAceptar.doClick();
            } else {
                btnCancelar.requestFocus();
                btnCancelar.doClick();
            }
        }
    }//GEN-LAST:event_txtKeyPressed

    private void txtDniProfesorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniProfesorFocusLost
        Profesor p = new Profesor();
        try {
            getProfesor(p);
            txtFechaIni.requestFocus();
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_txtDniProfesorFocusLost

    public void getProfesor(Profesor p) throws Exception {
        p.setDni(txtDniProfesor.getText());
        LogicaProfesor.getProfesor(p);
        txtNomPro.setText(p.getNombre());
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
            java.util.logging.Logger.getLogger(FrmEdicionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEdicionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEdicionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEdicionCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEdicionCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rdbOnLine;
    private javax.swing.JRadioButton rdbPresencial;
    private javax.swing.JTextField txtDniProfesor;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaIni;
    private javax.swing.JFormattedTextField txtHoras;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomPro;
    private javax.swing.JFormattedTextField txtNombre;
    private javax.swing.JFormattedTextField txtNombre2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarCurso() {

        txtDniProfesor.setText(FrmMantenimientoProfesores.dni);
        txtNomPro.setText(FrmMantenimientoProfesores.nombre);
    }
}
