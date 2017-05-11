/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlAsignarMateria;
import Controlador.ControlMaestro;
import Controlador.ControlMateria;
import Modelo.EntidadAsignarMateria;
import Modelo.EntidadMaestro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class InterfazAsignarMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfazAsignarMateria
     */
    
    EntidadMaestro modelMaestro=new EntidadMaestro();
    ControlMaestro controlMaestro=new ControlMaestro();
    ControlMateria controlMateria=new ControlMateria();
    EntidadAsignarMateria modeloAsignar=new EntidadAsignarMateria();
    ControlAsignarMateria controlAsigMateria=new ControlAsignarMateria();
    
    DefaultListModel modelo;
    DefaultTableModel ModeloTabla;
    String datos[]=null;
    String recibe[]=null;
    String lista[]=null;
    
    
    public InterfazAsignarMateria() {
      
        try {
            initComponents();
            modelo=new DefaultListModel();
            Lista.setModel(modelo);
            mostrarMaestro();
            mostrarMateria();
            inhabilitar();
            iniciar();
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciar(){
        NumeroEmpleado.setText("");
        NombreMaestro.setText("");
        HorasAsignadas.setText("");
    }
    
    public void mostrarMaestro() throws SQLException{
        cbxMaestro.removeAllItems();
        cbxMaestro.addItem("Selecciona Maestro");

        ResultSet rs = controlMaestro.consultarMaestroGeneral();
        while(rs.next()){
            cbxMaestro.addItem(rs.getString("NumeroEmpleado")+"-"+rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ");

            }
        
    }
    public void mostrarMateria() throws SQLException{
        modelo.addElement("");

        ResultSet rs = controlMateria.consultarMateriaGeneral();
        while(rs.next()){
            modelo.addElement(rs.getString("ClaveMateria")+"-"+rs.getString("NombreMateria"));

            }      
    }
    //PBI5:HU13:05 muestra los datos del maestro
    public void mostrarDatosMaestroGeneral(int bus){
        
        try {
            String cadenarecibe=controlMaestro.consultarMaestroEspecifico(bus);
            recibe=cadenarecibe.split(",");
            String numeroemp=recibe[0].trim();
            String nombreCompleto=recibe[1].trim()+" "+recibe[2].trim()+" "+recibe[3].trim();
            String horasAsig=recibe[4].trim();
            NumeroEmpleado.setText(numeroemp);
            NombreMaestro.setText(nombreCompleto);
            HorasAsignadas.setText(horasAsig);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void inhabilitar(){
        btnAgregar.setEnabled(false);
        btnQuitar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    public void habilitar(){
        btnAgregar.setEnabled(true);
        btnQuitar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cbxMaestro.setEnabled(false);
        btnAceptar.setEnabled(false);
    }
    public void habilitarLimpiar(){
        btnAgregar.setEnabled(false);
        btnQuitar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cbxMaestro.setEnabled(true);
        btnAceptar.setEnabled(true);
        cbxMaestro.setSelectedItem("Selecciona Maestro");
        iniciar();
    }
    //PBI5:HU13:06 Muestra la materias que se asigno al maestro
    void mostrarEspecificoTabla(){
        try {
            String buscar=NumeroEmpleado.getText();
            int bus=Integer.parseInt(buscar);
            ModeloTabla=controlAsigMateria.consultarMateriaTabla(bus);
            tbMateria.setModel(ModeloTabla);
            tbMateria.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbMateria.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbMateria.getColumnModel().getColumn(2).setPreferredWidth(90);
            

        
        } catch (SQLException ex) {
            Logger.getLogger(JfInterfazMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void clear_tabla(){
        for(int i=0;i<tbMateria.getRowCount();i++){
            ModeloTabla.removeRow(i);
            i-=1;
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMateria = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NumeroEmpleado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreMaestro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HorasAsignadas = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnQuitar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbxMaestro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Asignar Materia");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Materias Asignadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        tbMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clave", "Nombre Materia", "Horas x Semana"
            }
        ));
        jScrollPane1.setViewportView(tbMateria);
        if (tbMateria.getColumnModel().getColumnCount() > 0) {
            tbMateria.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbMateria.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbMateria.getColumnModel().getColumn(2).setPreferredWidth(90);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos Maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel2.setText("Numero de Empleado");

        NumeroEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NumeroEmpleado.setText("E1");

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel3.setText("Nombre del Maestro");

        NombreMaestro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NombreMaestro.setText("E2");

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel4.setText("Horas Asignadas");

        HorasAsignadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HorasAsignadas.setText("E3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(NumeroEmpleado)
                    .addComponent(jLabel3)
                    .addComponent(NombreMaestro)
                    .addComponent(jLabel4)
                    .addComponent(HorasAsignadas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NombreMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HorasAsignadas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnQuitar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnQuitar.setText("Eliminar");
        btnQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitarMouseClicked(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnCancelar.setText("Limpiar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Seleccione Maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        cbxMaestro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxMaestro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Maestro" }));
        cbxMaestro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMaestroItemStateChanged(evt);
            }
        });
        cbxMaestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxMaestroMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel5.setText("Numero de Empleado");

        btnAceptar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(105, 105, 105)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbxMaestro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbxMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Materias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        Lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(Lista);

        btnAgregar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMaestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxMaestroMouseClicked

    }//GEN-LAST:event_cbxMaestroMouseClicked

    private void cbxMaestroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMaestroItemStateChanged

    }//GEN-LAST:event_cbxMaestroItemStateChanged

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        
        int seleccionado=cbxMaestro.getSelectedIndex();
        String maestroSeleccion=(String) cbxMaestro.getItemAt(seleccionado);
        
        if(maestroSeleccion.equalsIgnoreCase("Selecciona Maestro")){
            JOptionPane.showMessageDialog(null, "Selecciona un maestro");
        }
        else{
            datos=maestroSeleccion.split("-");
            String numeroEmpleado=datos[0].trim();
            int numeroEm=Integer.parseInt(numeroEmpleado);
            
            //llama al metodos PBI5:HU13:05 muestra los datos del maestro
            mostrarDatosMaestroGeneral(numeroEm);
            //llama al metodo PBI5:HU13:06 Muestra la materias que se asigno al maestro
            mostrarEspecificoTabla();
            habilitar();
        }
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        Lista.setSelectedValue(null, false);
        habilitarLimpiar();
        clear_tabla();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked
//  PBI5:HU13:01 Evento Se debe asignar una materia
    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
 
        // PBI5:HU13:03 valida si selecciona la materia para asignar
        int n=Lista.getSelectedIndex();
        if(n<1){
            JOptionPane.showMessageDialog(null, "Seleccione una materia para Agregar");
        
        }
        else
        {
            String valor=Lista.getSelectedValue().toString();
            String numEmpl=NumeroEmpleado.getText();
            lista=valor.split("-");
            String clave=lista[0].trim();
            int claveAgregar=Integer.parseInt(clave);
            int numEmpleadoAgregar=Integer.parseInt(numEmpl);
            String reci=controlAsigMateria.consultaGeneralAsignarMateria(claveAgregar, numEmpleadoAgregar);
            
            
            //PBI5:HU13:04 valida si ya tiene asignada la materia
            if(reci.equalsIgnoreCase(""))
            {
                modeloAsignar.setNumeroEmpleado(numEmpleadoAgregar);
                modeloAsignar.setClaveMateria(claveAgregar);
                controlAsigMateria.registrarAsignarMateria(modeloAsignar);
                //PBI5:HU13:06 Muestra la materias que se asigno al maestro
                mostrarEspecificoTabla();
            }else{
                JOptionPane.showMessageDialog(null, "ya tiene asignada la materia");
            }
        }
    }//GEN-LAST:event_btnAgregarMouseClicked
    // PBI5:HU14:01 Evento que manda a eliminar la materia asignada al maestro
    private void btnQuitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarMouseClicked

            // TODO add your handling code here:
            
            String clave="";
            int fila=tbMateria.getSelectedRow();
            //PBI:HU14:03 Valida si se seleccionó materia para eliminar 
            if(fila<0){
                JOptionPane.showMessageDialog(null, "Seleccione materia a eliminar");
            }
            else{
                clave=tbMateria.getValueAt(fila, 0).toString();
                int claveMa=Integer.parseInt(clave);
                int confirmacion =JOptionPane.showConfirmDialog(null,"Seguro deseas eliminar","Clave Materia: "+clave,JOptionPane.YES_NO_OPTION);
                if(confirmacion==0){
                    modeloAsignar.setClaveMateria(claveMa);
                    controlAsigMateria.eliminarAsignarMateria(modeloAsignar);
                    
                    //PBI5:HU13:06 Muestra la materias que se asigno al maestro
                    mostrarEspecificoTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Se Cancelo La Eliminacion");
                }
            }    
    }//GEN-LAST:event_btnQuitarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void ListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaValueChanged
        // TODO add your handling code here:
//        int n=
    }//GEN-LAST:event_ListaValueChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HorasAsignadas;
    private javax.swing.JList<String> Lista;
    private javax.swing.JLabel NombreMaestro;
    private javax.swing.JLabel NumeroEmpleado;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxMaestro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbMateria;
    // End of variables declaration//GEN-END:variables
}
