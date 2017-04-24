/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlSalon;
import Modelo.EntidadSalon;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class JfInterfazSalon extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfazSalon1
     */
    
    EntidadSalon modelSalon=new EntidadSalon();
    ControlSalon controlSalon=new ControlSalon();
    int salon=0;
    String imagen="";
    
    DefaultTableModel Modelo1;
    
    public JfInterfazSalon() {
        this.setLocation(380,20);
        this.setTitle("Control de Salon");
        initComponents();
        mostrar("");
        inhabilitar();
    }
    
    void inhabilitar(){
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        txtNumeroSalon.setText("");
        txtNumeroSalon.setEnabled(true);
        btnRegistrar.setText("Registrar");
     
    }
    
    void habilitar(){
        
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnRegistrar.setEnabled(false);
        txtNumeroSalon.setEnabled(false);
        btnRegistrar.setText("Registrar");
        
    }
    
    void habilitarModificar(){
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        txtNumeroSalon.setEnabled(true);
        btnRegistrar.setText("Guardar Cambios");
        

    }
    
   
    
    void mostrar(String buscar){
        try {
        
            Modelo1=controlSalon.consultarSalon(buscar);
            tbSalon.setModel(Modelo1);
            

        
        } catch (SQLException ex) {
            Logger.getLogger(JfInterfazMaestro.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbNumeroSalon = new javax.swing.JLabel();
        txtNumeroSalon = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lbBuscarSalon = new javax.swing.JLabel();
        txtBuscarSalon = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalon = new javax.swing.JTable();
        btnBuscarSalon = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Detalle Salon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 0, 18))); // NOI18N

        lbNumeroSalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNumeroSalon.setText("Numero de Salon");

        txtNumeroSalon.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        txtNumeroSalon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroSalonKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNumeroSalon)
                .addGap(18, 18, 18)
                .addComponent(txtNumeroSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumeroSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Consulta Salon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT", 1, 18))); // NOI18N

        lbBuscarSalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBuscarSalon.setText("Numero de Salon");

        txtBuscarSalon.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        txtBuscarSalon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarSalonKeyTyped(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Salones"));

        tbSalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Numero Salon"
            }
        ));
        tbSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSalon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscarSalon.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        btnBuscarSalon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-icono-3813-32.png"))); // NOI18N
        btnBuscarSalon.setText("Buscar");
        btnBuscarSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarSalonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBuscarSalon)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarSalon)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarSalon))
                .addGap(33, 33, 33))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir-de-mi-perfil-icono-3964-32.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        // TODO add your handling code here:
        String Salon=txtNumeroSalon.getText();
        
        
        String boton=btnRegistrar.getText();
//        HU01 Debe validar campos vacíos
         if(Salon.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Ingrese nombre o número de Salon");
        }
        else{
            int numSalon=Integer.parseInt(Salon);
            
            if(boton.equalsIgnoreCase("Registrar")){
                modelSalon.setNumeroSalon(numSalon);
//               HU01 Debo registrar un salón
                controlSalon.RegistrarSalon(modelSalon);
                mostrar("");
                inhabilitar();
            }
            if(boton.equalsIgnoreCase("Guardar cambios")){
                modelSalon.setNumeroSalon(salon);
                
                int salonEncontrado = 0;
            
                try {
//                  HU02  Debe  validar si el salón tiene un horario  asignado  antes de modificar
                    salonEncontrado = controlSalon.consultarSalonTieneHorario(salon);
                } catch (SQLException ex) {
                    Logger.getLogger(JfInterfazSalon.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                if (salonEncontrado == salon) {
                    JOptionPane.showMessageDialog(rootPane, "EL SALON " + salonEncontrado + " NO SE PUEDE MODIFICAR, TIENE UN HORARIO ASIGNADO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else {
                    
//                 HU02 Debo poder modificar un salón existente
                controlSalon.modificarSalon(modelSalon,salon);
                salon=0;
                mostrar("");
                inhabilitar();
                
            }
        }}

        
        
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void tbSalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalonMouseClicked
      
        habilitar();
        
        int fila=tbSalon.rowAtPoint(evt.getPoint());
        

        txtNumeroSalon.setText(tbSalon.getValueAt(fila, 0).toString());
        salon=Integer.parseInt(txtNumeroSalon.getText());

        
    }//GEN-LAST:event_tbSalonMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        habilitarModificar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
     
        String numEliminar=txtNumeroSalon.getText();
        int numEli=Integer.parseInt(numEliminar);
        
        JOptionPane.showMessageDialog(null, "Resultado "+numEli);
        
        modelSalon.setNumeroSalon(numEli);
        
         int salonEncontrado = 0;
            
                try {
//                    HU03 Debe validar si  tiene un horario  asignado antes de eliminar
                    salonEncontrado = controlSalon.consultarSalonTieneHorario(salon);
                } catch (SQLException ex) {
                    Logger.getLogger(JfInterfazSalon.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                if (salonEncontrado == salon) {
                    JOptionPane.showMessageDialog(rootPane, "EL SALON " + salonEncontrado + " NO SE PUEDE ELIMINAR, TIENE UN HORARIO ASIGNADO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else {
//                HU03 Debe poder eliminar un salón
        controlSalon.eliminarSalon(modelSalon);
        mostrar("");
        inhabilitar();
        
            } 
        
        
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void txtNumeroSalonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSalonKeyTyped
//         HU01 Ingreso letras  en campo salón
        char k= evt.getKeyChar();
        if(Character.isLetter(k)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNumeroSalonKeyTyped

    private void btnBuscarSalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarSalonMouseClicked
        // TODO add your handling code here:
//        String sal;
//        String nomma;
//        String sma;
//        String canth;
//        String mensaj[]=null;
        String seleccionHoras="";
        try {
         
            String buscar=txtBuscarSalon.getText();
            if(buscar.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Campo vacio ingrese numero de Grupo a Buscar","Inane warning",JOptionPane.WARNING_MESSAGE);
                
            }else{
                mostrar(buscar);
                String mensaje="";
//            HU01 Debo consultar al menos un numero de  salon
                mensaje = controlSalon.consultarSalonEspecifico(buscar);
                if(mensaje.equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null,"El grupo no se encuentra registrado","Inane warning",JOptionPane.WARNING_MESSAGE);
                    txtBuscarSalon.setText("");
                mostrar("");
                }else{
                    habilitar();
                    txtNumeroSalon.setText(mensaje);
                    txtBuscarSalon.setText("");
                    
                }
                
                
            }
            
            
                
                
            } catch (SQLException ex) {
                Logger.getLogger(JfInterfazMateria.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnBuscarSalonMouseClicked

    private void txtBuscarSalonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarSalonKeyTyped
        // TODO add your handling code here:
        char k= evt.getKeyChar();
        if(Character.isLetter(k)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "No se puede ingresar Letras", "Error Datos", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String buscar1=txtBuscarSalon.getText();
        
            mostrar(buscar1);
            
        }
        
    }//GEN-LAST:event_txtBuscarSalonKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        inhabilitar();
    }//GEN-LAST:event_btnCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarSalon;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBuscarSalon;
    private javax.swing.JLabel lbNumeroSalon;
    private javax.swing.JTable tbSalon;
    private javax.swing.JTextField txtBuscarSalon;
    private javax.swing.JTextField txtNumeroSalon;
    // End of variables declaration//GEN-END:variables
}
