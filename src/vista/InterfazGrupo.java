/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlGrupo;
import Modelo.EntidadGrupo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazGrupo extends javax.swing.JInternalFrame {

    EntidadGrupo modelGrupo = new EntidadGrupo();
    ControlGrupo controlGrupo = new ControlGrupo();
    int grupo = 0;

    String imagen = "";

    DefaultTableModel Modelo1;

    public InterfazGrupo() {
        this.setLocation(380, 20);
        this.setTitle("Control de Grupo");
        initComponents();
        mostrar("");
        inhabilitar();

    }

    void inhabilitar() {

        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        txtNumeroGrupo.setText("");
        txtNumeroGrupo.setEnabled(true);
        btnRegistrar.setText("Registrar");
        cbxSemestre.setSelectedIndex(0);

    }
//    HABILITA BOTONES

    void habilitar() {

        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnRegistrar.setEnabled(false);
        txtNumeroGrupo.setEnabled(false);
        btnRegistrar.setText("Registrar");
        
        
    }

    void habilitarModificar() {
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        txtNumeroGrupo.setEnabled(true);

        btnRegistrar.setText("Guardar Cambios");

    }
//                MUESTRA EN LA TABLA

    void mostrar(String buscar) {
        try {
//METODO  QUE MUESTRA LOS  DATOS  EN  LA TABLA
            Modelo1 = controlGrupo.ConsultarGrupo(buscar);
            tbGrupo.setModel(Modelo1);
            tbGrupo.getColumnModel().getColumn(0).setPreferredWidth(120);

        } catch (SQLException ex) {
//            Logger.getLogger(InterfazMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroGrupo = new javax.swing.JTextField();
        cbxSemestre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtGrupoBuscar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrupo = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Detalle Grupo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Número de Grupo");

        txtNumeroGrupo.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        txtNumeroGrupo.setToolTipText("Escribe número de grupo");
        txtNumeroGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroGrupoKeyTyped(evt);
            }
        });

        cbxSemestre.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        cbxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "1", "2", "3", "4", "5", "6" }));
        cbxSemestre.setToolTipText("");
        cbxSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSemestreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Semestre: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbxSemestre, 0, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegistrar.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptar-o-no-la-correcta-seleccione-aceptar-verde-si-icono-9162-32.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(102, 102, 102));
        btnModificar.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signatura-icono-8756-32.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuadrados-eliminar-icono-7310-32.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-cancelar-icono-4935-32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Consultar Grupo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Grupo Buscar");

        btnBuscar.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-icono-3813-32.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        txtGrupoBuscar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        txtGrupoBuscar.setToolTipText("Escribe número de  grupo");
        txtGrupoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGrupoBuscarKeyTyped(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Grupos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tbGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número de Grupo", "Semestre"
            }
        ));
        tbGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGrupo);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtGrupoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGrupoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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

    private void tbGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGrupoMouseClicked
       
        habilitar();
        
        int fila = tbGrupo.rowAtPoint(evt.getPoint());
        if (fila >= 0) {
//MUESTRA GRUPO EN LA TABLA
            txtNumeroGrupo.setText(tbGrupo.getValueAt(fila, 0).toString());
            grupo = Integer.parseInt(txtNumeroGrupo.getText());
            //MUESTRA   SEMESTRE EN  LA  TABLA
            cbxSemestre.setSelectedItem(tbGrupo.getValueAt(fila, 1).toString());

        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
    }//GEN-LAST:event_tbGrupoMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked

        try {

            String buscar = txtGrupoBuscar.getText();
            //VALIDA   CAMPO  VACÍO
            if (buscar.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Campo vacío ingrese numero de Grupo a Buscar");

            } else {
//                MUESTRA DATOS  EN LA TABLA
                mostrar(buscar);
                String mensaje = "";

                //CONSULTA UN  GRUPO  ESPECÍFICO
                mensaje = controlGrupo.consultarGrupoEspecifico(buscar);
                if (mensaje.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "El grupo no se encuentra registrado", "Inane warning", JOptionPane.WARNING_MESSAGE);
                    txtGrupoBuscar.setText("");
                    //   MUESTRA DATOS  EN LA TABLA
                    mostrar("");
                } else {

//                  SE DIVIDE EL MENSAJE EN PARTES PARA ENVIARLO A CAJA  DE TEXTO Y COMBOBOX
                    String[] mensaj = mensaje.split("-");
                    String num= mensaj[0].trim();
                    String sem = mensaj[1].trim();
                  
                    txtNumeroGrupo.setText(num);
                    cbxSemestre.setSelectedItem(sem);
                    //    HABILITA BOTONES
                    habilitar();
                    txtGrupoBuscar.setText("");
//                    cbxSemestre.setSelectedIndex(0);
                }

            }

        } catch (SQLException ex) {
//            Logger.getLogger(InterfazMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked

        String boton = btnRegistrar.getText();
        String Grupo = txtNumeroGrupo.getText();
//        int numGrupo = Integer.parseInt(Grupo);
        int semestre = cbxSemestre.getSelectedIndex();

        if (boton.equalsIgnoreCase("Registrar")) {
//           valida campos vacío
            if (txtNumeroGrupo.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingreso numero de grupo");
//           validar  campo  no  seleccionado
            } else{
            if (cbxSemestre.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar Semestre");

            } else {
                //AGREGA A MODELO LOS   DATOS
                int numGrupo = Integer.parseInt(Grupo);
                modelGrupo.setNumeroGrupo(numGrupo);
//                System.out.println("numGrupo" + numGrupo);
                modelGrupo.setSemestre(semestre);

                //   MÉTODO QUE REGISTRA UN GRUPO
                controlGrupo.registrarGrupo(modelGrupo);
//                MUESTRA DATOS EN LA TABLA
                mostrar("");
//                HABILITA BOTONES
                inhabilitar();

            }}}

        

        if (boton.equalsIgnoreCase("Guardar cambios")) {
//           VALIDA CAMPO VACÍO
            if (txtNumeroGrupo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar numero de grupo");
            } else{
//            VALIDA CAMPO  SELECCIONADO
            if (cbxSemestre.getSelectedIndex() == 0) {
                JOptionPane.showConfirmDialog(null, "Debes seleccionar Semestre");

            } else {

                int grupoEncontrado = 0;
//            System.out.println("grupoEncontrado " + grupoEncontrado);
                try {
//                MÉTODO QUE  VALIDA SI EL  GRUPO TIENE  UN GRUPO ASIGNADO PARA NO MODIFICARLO
                    grupoEncontrado = controlGrupo.consultarGrupoTieneHorario(grupo);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (grupoEncontrado == grupo) {
                    JOptionPane.showMessageDialog(rootPane, "EL GRUPO " + grupoEncontrado + " NO SE PUEDE MODIFICAR, TIENE UN HORARIO ASIGNADO", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
//          ASIGNA LOS  DATOS AL MODELO
                    int numGrupo = Integer.parseInt(Grupo);
                    modelGrupo.setNumeroGrupo(numGrupo);
                    modelGrupo.setSemestre(semestre);

//           MÉTODO QUE MODIFICA EL  GRUPO
                    System.out.println("grupo" + grupo);
                    controlGrupo.modificarGrupo(modelGrupo, grupo);
                    grupo = 0;
//                    MUESTRA  LOS DATOS  EN LA TABLA
                    mostrar("");
//                    HABILITA LOS BOTONES
                    inhabilitar();

                } 
            
            }    }   }          

        
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked

        habilitarModificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

//        String numEliminar = txtNumeroGrupo.getText();
//        
//
//        int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro deseas eliminar grupo", "Inane warning", JOptionPane.YES_NO_OPTION);
//
//        if (confirmacion == 0) {
//            int numEli = Integer.parseInt(numEliminar);
//            modelGrupo.setNumeroGrupo(numEli);
//
//            int grupoEncontrado = 0;
//            try {
////   MÉTODO QUE VALIDA SI EL  GRUPO TIENE  UN HORARIO ASIGNADO PARA NO MODIFICARLO O ELIMINARLO
//                grupoEncontrado = controlGrupo.consultarGrupoTieneHorario(grupo);
//            } catch (SQLException ex) {
//                Logger.getLogger(InterfazGrupo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (grupoEncontrado == grupo) {
//                JOptionPane.showMessageDialog(rootPane, "EL GRUPO " + grupoEncontrado + " NO SE PUEDE ELIMINAR, TIENE UN HORARIO ASIGNADO", "ERROR", JOptionPane.ERROR_MESSAGE);
//            } else {
////   MÉTODO PARA ELIMINAR UN GRUPO
//                controlGrupo.eliminarGrupo(modelGrupo);
////                MUESTRA DATOS  EN LA TABLA
//                mostrar("");
////                HABILITA  BOTONES 
//                inhabilitar();
//
//            }
//        }

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

        inhabilitar();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked

        this.setVisible(false);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void txtNumeroGrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroGrupoKeyTyped
        //validar ingreso de letras al campo numero de grupo
        char k = evt.getKeyChar();
        if (Character.isLetter(k)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNumeroGrupoKeyTyped

    private void txtGrupoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGrupoBuscarKeyTyped
        // validar ingreso de letras al campo numero de grupo
        char k = evt.getKeyChar();
        if (Character.isLetter(k)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtGrupoBuscarKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbxSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSemestreActionPerformed
        // TODO add your handling code here:
        cbxSemestre.requestFocus();
    }//GEN-LAST:event_cbxSemestreActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String numEliminar = txtNumeroGrupo.getText();
        

        int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro deseas eliminar grupo", "Inane warning", JOptionPane.YES_NO_OPTION);

        if (confirmacion == 0) {
            int numEli = Integer.parseInt(numEliminar);
            modelGrupo.setNumeroGrupo(numEli);

            int grupoEncontrado = 0;
            try {
//   MÉTODO QUE VALIDA SI EL  GRUPO TIENE  UN HORARIO ASIGNADO PARA NO MODIFICARLO O ELIMINARLO
                grupoEncontrado = controlGrupo.consultarGrupoTieneHorario(grupo);
            } catch (SQLException ex) {
                Logger.getLogger(InterfazGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (grupoEncontrado == grupo) {
                JOptionPane.showMessageDialog(rootPane, "EL GRUPO " + grupoEncontrado + " NO SE PUEDE ELIMINAR, TIENE UN HORARIO ASIGNADO", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
//   MÉTODO PARA ELIMINAR UN GRUPO
                controlGrupo.eliminarGrupo(modelGrupo);
//                MUESTRA DATOS  EN LA TABLA
                mostrar("");
//                HABILITA  BOTONES 
                inhabilitar();

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGrupo;
    private javax.swing.JTextField txtGrupoBuscar;
    private javax.swing.JTextField txtNumeroGrupo;
    // End of variables declaration//GEN-END:variables
}
