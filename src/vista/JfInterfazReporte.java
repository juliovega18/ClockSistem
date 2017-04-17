/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlReporte;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class JfInterfazReporte extends javax.swing.JInternalFrame {

    ControlReporte reporteC = new ControlReporte();
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
    Vector idGrupos = new Vector();
    Vector claveSalon = new Vector();
    Vector idMaestro = new Vector();

    public JfInterfazReporte() {
        initComponents();
        obtenerSalon();
        obtenerGrupo();
        obtenerMaestros();
        mostrarDatos("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JpBotones = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        JpOpcion = new javax.swing.JPanel();
        cbxMaestro = new javax.swing.JComboBox<>();
        cbxGrupo = new javax.swing.JComboBox<>();
        cbxSalon = new javax.swing.JComboBox<>();
        lbMaestro = new javax.swing.JLabel();
        lbGrupo = new javax.swing.JLabel();
        lbSalon = new javax.swing.JLabel();
        JpTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbReporte = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Generar Reporte");

        JpBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnConsultar.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-icono-3813-32.png"))); // NOI18N
        btnConsultar.setText("Buscar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-cancelar-icono-4935-32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir-icono-5119-32.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBotonesLayout = new javax.swing.GroupLayout(JpBotones);
        JpBotones.setLayout(JpBotonesLayout);
        JpBotonesLayout.setHorizontalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImprimir)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        JpBotonesLayout.setVerticalGroup(
            JpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBotonesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpOpcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione una opción"));
        JpOpcion.setFont(new java.awt.Font("Broadway", 0, 14)); // NOI18N

        cbxMaestro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaestroActionPerformed(evt);
            }
        });

        cbxGrupo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrupoActionPerformed(evt);
            }
        });

        cbxSalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbMaestro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMaestro.setText("Maestro");

        lbGrupo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbGrupo.setText("Grupo");

        lbSalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSalon.setText("Salon");

        javax.swing.GroupLayout JpOpcionLayout = new javax.swing.GroupLayout(JpOpcion);
        JpOpcion.setLayout(JpOpcionLayout);
        JpOpcionLayout.setHorizontalGroup(
            JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpOpcionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaestro)
                    .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbSalon)
                        .addComponent(lbGrupo)))
                .addGap(18, 18, 18)
                .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbxMaestro, javax.swing.GroupLayout.Alignment.LEADING, 0, 152, Short.MAX_VALUE)
                    .addComponent(cbxGrupo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxSalon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        JpOpcionLayout.setVerticalGroup(
            JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpOpcionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaestro))
                .addGap(18, 18, 18)
                .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGrupo))
                .addGap(18, 18, 18)
                .addGroup(JpOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSalon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));

        tbReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReporteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbReporte);

        javax.swing.GroupLayout JpTablaLayout = new javax.swing.GroupLayout(JpTabla);
        JpTabla.setLayout(JpTablaLayout);
        JpTablaLayout.setHorizontalGroup(
            JpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        JpTablaLayout.setVerticalGroup(
            JpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(JpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JpOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JpOpcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(JpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void habilitar() {
        cbxGrupo.setEnabled(true);
        cbxSalon.setEnabled(true);
        cbxMaestro.setEnabled(true);
    }

    public void mostrarDatos(String buscar) {

        modelo1 = reporteC.mostrarDatos(buscar);
        tbReporte.setModel(modelo1);
        tbReporte.getColumnModel().getColumn(0).setMaxWidth(0);
        tbReporte.getColumnModel().getColumn(0).setMinWidth(0);
        tbReporte.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void mostrarDatos2(String buscar) {

        modelo2 = reporteC.mostrarDatos2(buscar);
        tbReporte.setModel(modelo2);
        tbReporte.getColumnModel().getColumn(0).setMaxWidth(0);
        tbReporte.getColumnModel().getColumn(0).setMinWidth(0);
        tbReporte.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void mostrarDatos3(String buscar) {

        modelo3 = reporteC.mostrarDatos3(buscar);
        tbReporte.setModel(modelo3);
        tbReporte.getColumnModel().getColumn(0).setMaxWidth(0);
        tbReporte.getColumnModel().getColumn(0).setMinWidth(0);
        tbReporte.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void limpiarCampos() {

        cbxMaestro.setSelectedIndex(0);
        cbxGrupo.setSelectedIndex(0);
        cbxSalon.setSelectedIndex(0);

    }

    public void obtenerMaestros() {

        cbxMaestro.removeAllItems();/*para limpiar  el  combobox*/
        idMaestro.removeAllElements();
        cbxMaestro.addItem("Selecciona Maestro");

        try {
            ResultSet rs = reporteC.cargaComboMaestro();
            while (rs.next()) {

                cbxMaestro.addItem(rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ");//  consulta  id  traer
                idMaestro.add(rs.getString("NumeroEmpleado"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JfInterfazReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerGrupo() {
        cbxGrupo.removeAllItems();
        idGrupos.removeAllElements();
        cbxGrupo.addItem("Selecciona Grupo");

        try {
            ResultSet rs = reporteC.cargaComboGrupo();
            while (rs.next()) {

                cbxGrupo.addItem(rs.getString("NumGrupo") + " ");
                idGrupos.add(rs.getString("NumGrupo"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JfInterfazReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Método  que obtiene los   salon*/
    private void obtenerSalon() {
        cbxSalon.removeAllItems();
        claveSalon.removeAllElements();
        cbxSalon.addItem("Selecciona Salon");

        try {
            ResultSet rs = reporteC.cargaComboSalon();
            while (rs.next()) {

                cbxSalon.addItem(rs.getString("NumSalon") + " ");
                claveSalon.add(rs.getString("NumSalon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JfInterfazReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        habilitar();
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tbReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReporteMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbReporteMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        if (cbxMaestro.getSelectedIndex() == 0 && cbxGrupo.getSelectedIndex() == 0 && cbxSalon.getSelectedIndex() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar una opción");

        }
        if (cbxMaestro.getSelectedIndex() != 0) {
            Object numEmpleado = this.idMaestro.get(cbxMaestro.getSelectedIndex() - 1).toString();
            mostrarDatos((String) numEmpleado);
            cbxGrupo.setEnabled(false);
            cbxSalon.setEnabled(false);

        }
        if (cbxGrupo.getSelectedIndex() != 0) {
            Object grupo = this.idGrupos.get(cbxGrupo.getSelectedIndex() - 1).toString();
            mostrarDatos2((String) grupo);
            cbxMaestro.setEnabled(false);
            cbxSalon.setEnabled(false);
        }
        if (cbxSalon.getSelectedIndex() != 0) {
            Object salon = this.claveSalon.get(cbxSalon.getSelectedIndex() - 1).toString();
            mostrarDatos3((String) salon);
            cbxGrupo.setEnabled(false);
            cbxMaestro.setEnabled(false);
        }

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        try {
            //Mensaje de encabezado
            MessageFormat headerFormat = new MessageFormat("impresion de la Tabla");
            //Mensaje en el pie de pagina
            MessageFormat footerFormat = new MessageFormat("ContreSpace");
            //Imprimir JTable
            tbReporte.print(JTable.PrintMode.NORMAL, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            Logger.getLogger(JfInterfazReporte.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cbxMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaestroActionPerformed
        // TODO add your handling code here:
//       cbxSalon.setEnabled(false);
//         cbxGrupo.setEnabled(false);
    }//GEN-LAST:event_cbxMaestroActionPerformed

    private void cbxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGrupoActionPerformed
        // TODO add your handling code here:
//        cbxSalon.setEnabled(false);
//         cbxMaestro.setEnabled(false);
    }//GEN-LAST:event_cbxGrupoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JfInterfazReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JfInterfazReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JfInterfazReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JfInterfazReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JfInterfazReporte().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpBotones;
    private javax.swing.JPanel JpOpcion;
    private javax.swing.JPanel JpTabla;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cbxGrupo;
    private javax.swing.JComboBox<String> cbxMaestro;
    private javax.swing.JComboBox<String> cbxSalon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbMaestro;
    private javax.swing.JLabel lbSalon;
    private javax.swing.JTable tbReporte;
    // End of variables declaration//GEN-END:variables
}
