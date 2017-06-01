/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julve
 */
public class JfInterfazPrincipal extends javax.swing.JFrame {

    public JfInterfazPrincipal() {
        initComponents();

        this.setExtendedState(JfInterfazPrincipal.MAXIMIZED_BOTH);

//        pnldatos.add(hora); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem9 = new javax.swing.JMenuItem();
        jdpEscritorio = new javax.swing.JDesktopPane();
        JpOpciones = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lbOpciones = new javax.swing.JLabel();
        JpRepostes = new javax.swing.JPanel();
        lbResportes = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JpHorario = new javax.swing.JPanel();
        lbHorario = new javax.swing.JLabel();
        btnHorario = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JpCatalogo = new javax.swing.JPanel();
        btnMaterias = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        lbCatalologo = new javax.swing.JLabel();
        btnGrupos = new javax.swing.JButton();
        btnSalones = new javax.swing.JButton();

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ClockSystem V1.0");

        jdpEscritorio.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1241, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        JpOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        lbOpciones.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOpciones.setText("Opciones");
        lbOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout JpOpcionesLayout = new javax.swing.GroupLayout(JpOpciones);
        JpOpciones.setLayout(JpOpcionesLayout);
        JpOpcionesLayout.setHorizontalGroup(
            JpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpOpcionesLayout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpOpcionesLayout.setVerticalGroup(
            JpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpOpcionesLayout.createSequentialGroup()
                .addComponent(lbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JpRepostes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbResportes.setBackground(new java.awt.Color(204, 204, 204));
        lbResportes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbResportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbResportes.setText("Reporte por:");
        lbResportes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jButton1.setText("Reportes");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpRepostesLayout = new javax.swing.GroupLayout(JpRepostes);
        JpRepostes.setLayout(JpRepostesLayout);
        JpRepostesLayout.setHorizontalGroup(
            JpRepostesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpRepostesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpRepostesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpRepostesLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpRepostesLayout.setVerticalGroup(
            JpRepostesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpRepostesLayout.createSequentialGroup()
                .addComponent(lbResportes, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        JpHorario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbHorario.setBackground(new java.awt.Color(204, 204, 204));
        lbHorario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHorario.setText("Horario");
        lbHorario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnHorario.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnHorario.setText("Horario");
        btnHorario.setToolTipText("Generar Horario");
        btnHorario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHorario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnHorario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHorarioMouseClicked(evt);
            }
        });
        btnHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorarioActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jButton2.setText("Asignar Materias");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Dispo. Maestro");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpHorarioLayout = new javax.swing.GroupLayout(JpHorario);
        JpHorario.setLayout(JpHorarioLayout);
        JpHorarioLayout.setHorizontalGroup(
            JpHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpHorarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpHorarioLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpHorarioLayout.setVerticalGroup(
            JpHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpHorarioLayout.createSequentialGroup()
                .addComponent(lbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        JpCatalogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMaterias.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnMaterias.setText("Materias");
        btnMaterias.setToolTipText("Materias");
        btnMaterias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMaterias.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMaterias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
            }
        });

        btnMaestros.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnMaestros.setText("Maestros");
        btnMaestros.setToolTipText("Maestros");
        btnMaestros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMaestros.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnMaestros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestrosActionPerformed(evt);
            }
        });

        lbCatalologo.setBackground(new java.awt.Color(204, 204, 204));
        lbCatalologo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCatalologo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCatalologo.setText("Catalogo");
        lbCatalologo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGrupos.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnGrupos.setText("Grupos");
        btnGrupos.setToolTipText("Grupo");
        btnGrupos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrupos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnGrupos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGruposMouseClicked(evt);
            }
        });

        btnSalones.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnSalones.setText("Salones");
        btnSalones.setToolTipText("salon");
        btnSalones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalones.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSalones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalonesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JpCatalogoLayout = new javax.swing.GroupLayout(JpCatalogo);
        JpCatalogo.setLayout(JpCatalogoLayout);
        JpCatalogoLayout.setHorizontalGroup(
            JpCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCatalologo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpCatalogoLayout.createSequentialGroup()
                        .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalones, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpCatalogoLayout.setVerticalGroup(
            JpCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpCatalogoLayout.createSequentialGroup()
                .addComponent(lbCatalologo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMaestros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JpCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpRepostes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jdpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JpRepostes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        JfInterfazMaestro Maestro = new JfInterfazMaestro();
        Maestro.setVisible(true);
        jdpEscritorio.add(Maestro);
//        lbImagen.setVisible(true);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        JfInterfazMateria Materia = new JfInterfazMateria();
        Materia.setVisible(true);
        jdpEscritorio.add(Materia);
//        lbImagen.setVisible(true);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        JfInterfazGrupo Grupo = new JfInterfazGrupo();
        Grupo.setVisible(true);
        jdpEscritorio.add(Grupo);
//        lbImagen.setVisible(true);
    }//GEN-LAST:event_btnGruposMouseClicked

    private void btnSalonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalonesMouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        InterfazSalon Salon = new InterfazSalon();
        Salon.setVisible(true);
        jdpEscritorio.add(Salon);
//        lbImagen.setVisible(true);
    }//GEN-LAST:event_btnSalonesMouseClicked

    private void btnHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        InterfazAsignarHorario Horario = null;
        Horario = new InterfazAsignarHorario();
        Horario.setVisible(true);
        jdpEscritorio.add(Horario);
//        lbImagen.setVisible(true);
    }//GEN-LAST:event_btnHorarioMouseClicked

    private void btnHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHorarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        JfInterfazReporte reporte = null;
        reporte = new JfInterfazReporte();
        reporte.setVisible(true);
        jdpEscritorio.add(reporte);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        InterfazAsignarMateria AsignarMateria = null;
        AsignarMateria = new InterfazAsignarMateria();
        AsignarMateria.setVisible(true);
        jdpEscritorio.add(AsignarMateria);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.jdpEscritorio.removeAll();
        this.jdpEscritorio.repaint();
        InterfazAsignarDisponibilidad AsignarDisponibilidad = null;
        AsignarDisponibilidad = new InterfazAsignarDisponibilidad();
        AsignarDisponibilidad.setVisible(true);
        jdpEscritorio.add(AsignarDisponibilidad);
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(JfInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfInterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfInterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpCatalogo;
    private javax.swing.JPanel JpHorario;
    private javax.swing.JPanel JpOpciones;
    private javax.swing.JPanel JpRepostes;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JLabel lbCatalologo;
    private javax.swing.JLabel lbHorario;
    private javax.swing.JLabel lbOpciones;
    private javax.swing.JLabel lbResportes;
    // End of variables declaration//GEN-END:variables
}
