/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlDisponibilidad;
import Controlador.ControlHorasAsignacion;
import Controlador.ControlMaestro;
import Modelo.EntidadDisponibilidad;
import Modelo.EntidadHorasAsignacion;
import Modelo.EntidadMaestro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author julve
 */
public class InterfazAsignarDisponibilidad extends javax.swing.JInternalFrame {
    String datos[]=null;
    String recibe[]=null;
    String disponi[]=null;
    private String sSQL="";
    int horasRestante=0;

    /**
     * Creates new form InterfazAsignarDisponibilidad
     */
    ControlMaestro controlMaestro=new ControlMaestro();
    EntidadMaestro modeloMaestro=new EntidadMaestro();
    
    ControlDisponibilidad controlDisponibilidad=new ControlDisponibilidad();
    EntidadDisponibilidad modeloDisponibilidad=new EntidadDisponibilidad();
    
//    ControlHorasAsignacion controlhoras=new ControlHorasAsignacion();
//    EntidadHorasAsignacion entidadHoras=new EntidadHorasAsignacion();
    
    
    public InterfazAsignarDisponibilidad() {
        try {
            initComponents();
            mostrarMaestro();
            inhabilitar();
            iniciar();
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciar(){
        ET1.setText("");
        ET2.setText("");
        ET3.setText("");
        cbxMaestro.setEnabled(true);
        btnAceptar.setEnabled(true);
    }
    public void inhabilitarAceptar(){
       cbxMaestro.setEnabled(false);
        btnAceptar.setEnabled(false); 
    }
    public void habilitarAceptar(){
        cbxMaestro.setEnabled(false);
        btnAceptar.setEnabled(false);
//        cbxMaestro.
    }
    
    public void habilitar(){
        cbxMaestro.setEnabled(false);
        btnAceptar.setEnabled(false);
        CL1.setEnabled(true);CL2.setEnabled(true);CL3.setEnabled(true);CL4.setEnabled(true);CL5.setEnabled(true);CL6.setEnabled(true);CL7.setEnabled(true);
        CL8.setEnabled(true);CL9.setEnabled(true);CL10.setEnabled(true);CL11.setEnabled(true);CL12.setEnabled(true);CL13.setEnabled(true);CL14.setEnabled(true);
        
        CMA1.setEnabled(true);CMA2.setEnabled(true);CMA3.setEnabled(true);CMA4.setEnabled(true);CMA5.setEnabled(true);CMA6.setEnabled(true);CMA7.setEnabled(true);
        CMA8.setEnabled(true);CMA9.setEnabled(true);CMA10.setEnabled(true);CMA11.setEnabled(true);CMA12.setEnabled(true);CMA13.setEnabled(true);CMA14.setEnabled(true);
        
        CM1.setEnabled(true);CM2.setEnabled(true);CM3.setEnabled(true);CM4.setEnabled(true);CM5.setEnabled(true);CM6.setEnabled(true);CM7.setEnabled(true);
        CM8.setEnabled(true);CM9.setEnabled(true);CM10.setEnabled(true);CM11.setEnabled(true);CM12.setEnabled(true);CM13.setEnabled(true);CM14.setEnabled(true);
        
        CJ1.setEnabled(true);CJ2.setEnabled(true);CJ3.setEnabled(true);CJ4.setEnabled(true);CJ5.setEnabled(true);CJ6.setEnabled(true);CJ7.setEnabled(true);
        CJ8.setEnabled(true);CJ9.setEnabled(true);CJ10.setEnabled(true);CJ11.setEnabled(true);CJ12.setEnabled(true);CJ13.setEnabled(true);CJ14.setEnabled(true);
        
        CV1.setEnabled(true);CV2.setEnabled(true);CV3.setEnabled(true);CV4.setEnabled(true);CV5.setEnabled(true);CV6.setEnabled(true);CV7.setEnabled(true);
        CV8.setEnabled(true);CV9.setEnabled(true);CV10.setEnabled(true);CV11.setEnabled(true);CV12.setEnabled(true);CV13.setEnabled(true);CV14.setEnabled(true);
        
        
    }
    public void inhabilitar(){
        CL1.setEnabled(false);CL2.setEnabled(false);CL3.setEnabled(false);CL4.setEnabled(false);CL5.setEnabled(false);CL6.setEnabled(false);CL7.setEnabled(false);
        CL8.setEnabled(false);CL9.setEnabled(false);CL10.setEnabled(false);CL11.setEnabled(false);CL12.setEnabled(false);CL13.setEnabled(false);CL14.setEnabled(false);
        
        CMA1.setEnabled(false);CMA2.setEnabled(false);CMA3.setEnabled(false);CMA4.setEnabled(false);CMA5.setEnabled(false);CMA6.setEnabled(false);CMA7.setEnabled(false);
        CMA8.setEnabled(false);CMA9.setEnabled(false);CMA10.setEnabled(false);CMA11.setEnabled(false);CMA12.setEnabled(false);CMA13.setEnabled(false);CMA14.setEnabled(false);
        
        CM1.setEnabled(false);CM2.setEnabled(false);CM3.setEnabled(false);CM4.setEnabled(false);CM5.setEnabled(false);CM6.setEnabled(false);CM7.setEnabled(false);
        CM8.setEnabled(false);CM9.setEnabled(false);CM10.setEnabled(false);CM11.setEnabled(false);CM12.setEnabled(false);CM13.setEnabled(false);CM14.setEnabled(false);
        
        CJ1.setEnabled(false);CJ2.setEnabled(false);CJ3.setEnabled(false);CJ4.setEnabled(false);CJ5.setEnabled(false);CJ6.setEnabled(false);CJ7.setEnabled(false);
        CJ8.setEnabled(false);CJ9.setEnabled(false);CJ10.setEnabled(false);CJ11.setEnabled(false);CJ12.setEnabled(false);CJ13.setEnabled(false);CJ14.setEnabled(false);
        
        CV1.setEnabled(false);CV2.setEnabled(false);CV3.setEnabled(false);CV4.setEnabled(false);CV5.setEnabled(false);CV6.setEnabled(false);CV7.setEnabled(false);
        CV8.setEnabled(false);CV9.setEnabled(false);CV10.setEnabled(false);CV11.setEnabled(false);CV12.setEnabled(false);CV13.setEnabled(false);CV14.setEnabled(false);
        
        CS1.setEnabled(false);CS2.setEnabled(false);CS3.setEnabled(false);CS4.setEnabled(false);CS5.setEnabled(false);CS6.setEnabled(false);CS7.setEnabled(false);
        CS8.setEnabled(false);CS9.setEnabled(false);CS10.setEnabled(false);CS11.setEnabled(false);CS12.setEnabled(false);CS13.setEnabled(false);CS14.setEnabled(false);
    }
    public void desactivarSeleccion(){
        CL1.setSelected(false);CL2.setSelected(false);CL3.setSelected(false);CL4.setSelected(false);CL5.setSelected(false);CL6.setSelected(false);CL7.setSelected(false);
        CL8.setSelected(false);CL9.setSelected(false);CL10.setSelected(false);CL11.setSelected(false);CL12.setSelected(false);CL13.setSelected(false);CL14.setSelected(false);
        
        CMA1.setSelected(false);CMA2.setSelected(false);CMA3.setSelected(false);CMA4.setSelected(false);CMA5.setSelected(false);CMA6.setSelected(false);CMA7.setSelected(false);
        CMA8.setSelected(false);CMA9.setSelected(false);CMA10.setSelected(false);CMA11.setSelected(false);CMA12.setSelected(false);CMA13.setSelected(false);CMA14.setSelected(false);
        
        CM1.setSelected(false);CM2.setSelected(false);CM3.setSelected(false);CM4.setSelected(false);CM5.setSelected(false);CM6.setSelected(false);CM7.setSelected(false);
        CM8.setSelected(false);CM9.setSelected(false);CM10.setSelected(false);CM11.setSelected(false);CM12.setSelected(false);CM13.setSelected(false);CM14.setSelected(false);
        
        CJ1.setSelected(false);CJ2.setSelected(false);CJ3.setSelected(false);CJ4.setSelected(false);CJ5.setSelected(false);CJ6.setSelected(false);CJ7.setSelected(false);
        CJ8.setSelected(false);CJ9.setSelected(false);CJ10.setSelected(false);CJ11.setSelected(false);CJ12.setSelected(false);CJ13.setSelected(false);CJ14.setSelected(false);
        
        CV1.setSelected(false);CV2.setSelected(false);CV3.setSelected(false);CV4.setSelected(false);CV5.setSelected(false);CV6.setSelected(false);CV7.setSelected(false);
        CV8.setSelected(false);CV9.setSelected(false);CV10.setSelected(false);CV11.setSelected(false);CV12.setSelected(false);CV13.setSelected(false);CV14.setSelected(false);
        
        
        
        cbxMaestro.setSelectedItem("Selecciona Maestro");
        txtRestantes.setText("");
    }
    
    
    public void consultarGeneral(String clave){
        try {
            sSQL="select * from horario_disponible where Maestro_NumeroEmpleado like '%"+clave+"%' order by Maestro_NumeroEmpleado";
            Statement st=controlDisponibilidad.consultaDisponibilidadEspecifica();
            
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                String Dia=rs.getString("Dia");
                String Hora=rs.getString("Hora");
                
                if(Hora.equalsIgnoreCase("")){
                }
                else{
                    if(Dia.equals("Lunes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CL1.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CL2.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CL3.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CL4.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CL5.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CL6.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CL7.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CL8.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CL9.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CL10.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CL11.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CL12.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CL13.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CL14.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                    }
                    if(Dia.equals("Martes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CMA1.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CMA2.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CMA3.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CMA4.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CMA5.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CMA6.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CMA7.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CMA8.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CMA9.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CMA10.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CMA11.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CMA12.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CMA13.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CMA14.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                    }
                    if(Dia.equals("Miercoles")){
                        if(Hora.equalsIgnoreCase("7")){
                            CM1.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CM2.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CM3.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CM4.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CM5.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CM6.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CM7.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CM8.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CM9.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CM10.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CM11.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CM12.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CM13.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CM14.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                    }
                    if(Dia.equals("Jueves")){
                        if(Hora.equalsIgnoreCase("7")){
                            CJ1.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CJ2.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CJ3.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CJ4.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CJ5.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CJ6.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CJ7.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CJ8.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CJ9.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CJ10.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CJ11.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CJ12.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CJ13.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CJ14.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                    }
                    if(Dia.equals("Viernes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CV1.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CV2.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CV3.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CV4.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CV5.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CV6.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CV7.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CV8.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CV9.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CV10.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CV11.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CV12.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CV13.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CV14.setSelected(true);
                            horasRestante--;
                            String hor=Integer.toString(horasRestante);
                            txtRestantes.setText(hor);
                        }
                    }                   
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void mostrarMaestro() throws SQLException{
        cbxMaestro.removeAllItems();
        cbxMaestro.addItem("Selecciona Maestro");

        ResultSet rs = controlMaestro.consultarMaestroGeneral();
        while(rs.next()){
            cbxMaestro.addItem(rs.getString("NumeroEmpleado")+"-"+rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ");

            }
        
    }
    public void mostrarMaestroEspecifico(int buscar) throws SQLException{
        String cadena=controlMaestro.consultarMaestroEspecifico(buscar);
        recibe=cadena.split(",");
        String numEmpleado=recibe[0].trim();
        String nombreCompleto=recibe[1].trim()+" "+recibe[2].trim()+" "+recibe[3].trim();
        String horasAsignadas=recibe[4].trim();
        ET1.setText(numEmpleado);
        ET2.setText(nombreCompleto);
        ET3.setText(horasAsignadas);
        txtRestantes.setText(horasAsignadas);
        horasRestante=Integer.parseInt(horasAsignadas);

        consultarGeneral(numEmpleado);
    }
    public void HorasRestantes(){
        
        String Restantes=txtRestantes.getText();
        int horasResta=Integer.parseInt(Restantes);
        horasResta=horasResta-1;
        String resultado=Integer.toString(horasResta);
        txtRestantes.setText(resultado);
    }
    public void HorasSuma(){
        
        String Restantes=txtRestantes.getText();
        int horasResta=Integer.parseInt(Restantes);
        horasResta=horasResta+1;
        String resultado=Integer.toString(horasResta);
        txtRestantes.setText(resultado);
    }
    public void ingresarDatos(String d,int h){
        String numeroEmpleado=ET1.getText();
        int numEmpleado=Integer.parseInt(numeroEmpleado);
        modeloDisponibilidad.setNumeroEmpleado(numEmpleado);
        modeloDisponibilidad.setDia(d);
        modeloDisponibilidad.setHora(h);
        controlDisponibilidad.registrarDisponibilidad(modeloDisponibilidad);
        
    }
    public void eliminarDatos(String dia,int hora){
        String numeroEmpleado=ET1.getText();
        int numEmpleado=Integer.parseInt(numeroEmpleado);
        modeloDisponibilidad.setNumeroEmpleado(numEmpleado);
        modeloDisponibilidad.setDia(dia);
        modeloDisponibilidad.setHora(hora);
        controlDisponibilidad.eliminarDisponibilidad(modeloDisponibilidad);
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
        cbxMaestro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ET1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ET2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ET3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        CL1 = new javax.swing.JCheckBox();
        CL2 = new javax.swing.JCheckBox();
        CL3 = new javax.swing.JCheckBox();
        CL4 = new javax.swing.JCheckBox();
        CL5 = new javax.swing.JCheckBox();
        CL6 = new javax.swing.JCheckBox();
        CMA1 = new javax.swing.JCheckBox();
        CMA2 = new javax.swing.JCheckBox();
        CMA3 = new javax.swing.JCheckBox();
        CMA4 = new javax.swing.JCheckBox();
        CMA5 = new javax.swing.JCheckBox();
        CM1 = new javax.swing.JCheckBox();
        CJ1 = new javax.swing.JCheckBox();
        CV1 = new javax.swing.JCheckBox();
        CS1 = new javax.swing.JCheckBox();
        CM2 = new javax.swing.JCheckBox();
        CJ2 = new javax.swing.JCheckBox();
        CV2 = new javax.swing.JCheckBox();
        CS2 = new javax.swing.JCheckBox();
        CM3 = new javax.swing.JCheckBox();
        CJ3 = new javax.swing.JCheckBox();
        CV3 = new javax.swing.JCheckBox();
        CS3 = new javax.swing.JCheckBox();
        CM4 = new javax.swing.JCheckBox();
        CJ4 = new javax.swing.JCheckBox();
        CV4 = new javax.swing.JCheckBox();
        CS4 = new javax.swing.JCheckBox();
        CM5 = new javax.swing.JCheckBox();
        CJ5 = new javax.swing.JCheckBox();
        CV5 = new javax.swing.JCheckBox();
        CS5 = new javax.swing.JCheckBox();
        CMA6 = new javax.swing.JCheckBox();
        CM6 = new javax.swing.JCheckBox();
        CJ6 = new javax.swing.JCheckBox();
        CV6 = new javax.swing.JCheckBox();
        CS6 = new javax.swing.JCheckBox();
        CL7 = new javax.swing.JCheckBox();
        CMA7 = new javax.swing.JCheckBox();
        CM7 = new javax.swing.JCheckBox();
        CJ7 = new javax.swing.JCheckBox();
        CV7 = new javax.swing.JCheckBox();
        CS7 = new javax.swing.JCheckBox();
        CL8 = new javax.swing.JCheckBox();
        CMA8 = new javax.swing.JCheckBox();
        CM8 = new javax.swing.JCheckBox();
        CJ8 = new javax.swing.JCheckBox();
        CV8 = new javax.swing.JCheckBox();
        CS8 = new javax.swing.JCheckBox();
        CL9 = new javax.swing.JCheckBox();
        CMA9 = new javax.swing.JCheckBox();
        CM9 = new javax.swing.JCheckBox();
        CJ9 = new javax.swing.JCheckBox();
        CV9 = new javax.swing.JCheckBox();
        CS9 = new javax.swing.JCheckBox();
        CL10 = new javax.swing.JCheckBox();
        CMA10 = new javax.swing.JCheckBox();
        CM10 = new javax.swing.JCheckBox();
        CJ10 = new javax.swing.JCheckBox();
        CV10 = new javax.swing.JCheckBox();
        CS10 = new javax.swing.JCheckBox();
        CL11 = new javax.swing.JCheckBox();
        CMA11 = new javax.swing.JCheckBox();
        CM11 = new javax.swing.JCheckBox();
        CJ11 = new javax.swing.JCheckBox();
        CV11 = new javax.swing.JCheckBox();
        CS11 = new javax.swing.JCheckBox();
        CL12 = new javax.swing.JCheckBox();
        CMA12 = new javax.swing.JCheckBox();
        CM12 = new javax.swing.JCheckBox();
        CJ12 = new javax.swing.JCheckBox();
        CV12 = new javax.swing.JCheckBox();
        CS12 = new javax.swing.JCheckBox();
        CL13 = new javax.swing.JCheckBox();
        CMA13 = new javax.swing.JCheckBox();
        CM13 = new javax.swing.JCheckBox();
        CJ13 = new javax.swing.JCheckBox();
        CV13 = new javax.swing.JCheckBox();
        CS13 = new javax.swing.JCheckBox();
        CL14 = new javax.swing.JCheckBox();
        CMA14 = new javax.swing.JCheckBox();
        CM14 = new javax.swing.JCheckBox();
        CJ14 = new javax.swing.JCheckBox();
        CV14 = new javax.swing.JCheckBox();
        CS14 = new javax.swing.JCheckBox();
        lblPeticion = new javax.swing.JLabel();
        txtRestantes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Disponibilidad del Maestro");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbxMaestro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Seleccione Maestro:");

        btnAceptar.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Numero Empleado:");

        ET1.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        ET1.setText("ET1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre Maestro:");

        ET2.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        ET2.setText("ET2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Horas Asignadas:");

        ET3.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        ET3.setText("ET3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMaestro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ET1)
                            .addComponent(jLabel3)
                            .addComponent(ET2)
                            .addComponent(jLabel4)
                            .addComponent(ET3)
                            .addComponent(jLabel1))
                        .addGap(0, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setLayout(null);

        jLabel27.setText("jLabel27");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(48, 55, 40, 14);

        jPanel5.setLayout(null);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("07:00-08:00");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(10, 42, 80, 20);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("07:00-08:00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("10:00-11:00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("08:00-09:00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("11:00-12:00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("09:00-10:00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("12:00-13:00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("13:00-14:00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("14:00-15:00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("15:00-16:00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("16:00-17:00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("17:00-18:00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("18:00-19:00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("L");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("J");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("M");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("S");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("V");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("M");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("19:00-20:00");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("20:00-21:00");

        CL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL1ActionPerformed(evt);
            }
        });

        CL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL2ActionPerformed(evt);
            }
        });

        CL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL3ActionPerformed(evt);
            }
        });

        CL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL4ActionPerformed(evt);
            }
        });

        CL5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL5ActionPerformed(evt);
            }
        });

        CL6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL6ActionPerformed(evt);
            }
        });

        CMA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA1MouseClicked(evt);
            }
        });
        CMA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA1ActionPerformed(evt);
            }
        });

        CMA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA2MouseClicked(evt);
            }
        });
        CMA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA2ActionPerformed(evt);
            }
        });

        CMA3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA3MouseClicked(evt);
            }
        });
        CMA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA3ActionPerformed(evt);
            }
        });

        CMA4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA4MouseClicked(evt);
            }
        });
        CMA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA4ActionPerformed(evt);
            }
        });

        CMA5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA5MouseClicked(evt);
            }
        });
        CMA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA5ActionPerformed(evt);
            }
        });

        CM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM1MouseClicked(evt);
            }
        });
        CM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM1ActionPerformed(evt);
            }
        });

        CJ1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ1MouseClicked(evt);
            }
        });
        CJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ1ActionPerformed(evt);
            }
        });

        CV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV1MouseClicked(evt);
            }
        });
        CV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV1ActionPerformed(evt);
            }
        });

        CM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM2MouseClicked(evt);
            }
        });
        CM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM2ActionPerformed(evt);
            }
        });

        CJ2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ2MouseClicked(evt);
            }
        });
        CJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ2ActionPerformed(evt);
            }
        });

        CV2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV2MouseClicked(evt);
            }
        });
        CV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2ActionPerformed(evt);
            }
        });

        CM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM3MouseClicked(evt);
            }
        });
        CM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM3ActionPerformed(evt);
            }
        });

        CJ3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ3MouseClicked(evt);
            }
        });
        CJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ3ActionPerformed(evt);
            }
        });

        CV3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV3MouseClicked(evt);
            }
        });
        CV3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV3ActionPerformed(evt);
            }
        });

        CM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM4MouseClicked(evt);
            }
        });
        CM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM4ActionPerformed(evt);
            }
        });

        CJ4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ4MouseClicked(evt);
            }
        });
        CJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ4ActionPerformed(evt);
            }
        });

        CV4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV4MouseClicked(evt);
            }
        });
        CV4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV4ActionPerformed(evt);
            }
        });

        CM5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM5MouseClicked(evt);
            }
        });
        CM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM5ActionPerformed(evt);
            }
        });

        CJ5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ5MouseClicked(evt);
            }
        });
        CJ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ5ActionPerformed(evt);
            }
        });

        CV5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV5MouseClicked(evt);
            }
        });
        CV5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV5ActionPerformed(evt);
            }
        });

        CMA6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA6MouseClicked(evt);
            }
        });
        CMA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA6ActionPerformed(evt);
            }
        });

        CM6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM6MouseClicked(evt);
            }
        });
        CM6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM6ActionPerformed(evt);
            }
        });

        CJ6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ6MouseClicked(evt);
            }
        });
        CJ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ6ActionPerformed(evt);
            }
        });

        CV6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV6MouseClicked(evt);
            }
        });
        CV6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV6ActionPerformed(evt);
            }
        });

        CL7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL7MouseClicked(evt);
            }
        });
        CL7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL7ActionPerformed(evt);
            }
        });

        CMA7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA7MouseClicked(evt);
            }
        });
        CMA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA7ActionPerformed(evt);
            }
        });

        CM7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM7MouseClicked(evt);
            }
        });
        CM7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM7ActionPerformed(evt);
            }
        });

        CJ7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ7MouseClicked(evt);
            }
        });
        CJ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ7ActionPerformed(evt);
            }
        });

        CV7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV7MouseClicked(evt);
            }
        });
        CV7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV7ActionPerformed(evt);
            }
        });

        CL8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL8MouseClicked(evt);
            }
        });
        CL8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL8ActionPerformed(evt);
            }
        });

        CMA8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA8MouseClicked(evt);
            }
        });
        CMA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA8ActionPerformed(evt);
            }
        });

        CM8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM8MouseClicked(evt);
            }
        });
        CM8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM8ActionPerformed(evt);
            }
        });

        CJ8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ8MouseClicked(evt);
            }
        });
        CJ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ8ActionPerformed(evt);
            }
        });

        CV8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV8MouseClicked(evt);
            }
        });
        CV8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV8ActionPerformed(evt);
            }
        });

        CL9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL9MouseClicked(evt);
            }
        });
        CL9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL9ActionPerformed(evt);
            }
        });

        CMA9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA9MouseClicked(evt);
            }
        });
        CMA9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA9ActionPerformed(evt);
            }
        });

        CM9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM9MouseClicked(evt);
            }
        });
        CM9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM9ActionPerformed(evt);
            }
        });

        CJ9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ9MouseClicked(evt);
            }
        });
        CJ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ9ActionPerformed(evt);
            }
        });

        CV9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV9MouseClicked(evt);
            }
        });
        CV9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV9ActionPerformed(evt);
            }
        });

        CL10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL10MouseClicked(evt);
            }
        });
        CL10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL10ActionPerformed(evt);
            }
        });

        CMA10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA10MouseClicked(evt);
            }
        });
        CMA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA10ActionPerformed(evt);
            }
        });

        CM10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM10MouseClicked(evt);
            }
        });
        CM10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM10ActionPerformed(evt);
            }
        });

        CJ10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ10MouseClicked(evt);
            }
        });
        CJ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ10ActionPerformed(evt);
            }
        });

        CV10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV10MouseClicked(evt);
            }
        });
        CV10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV10ActionPerformed(evt);
            }
        });

        CL11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL11MouseClicked(evt);
            }
        });
        CL11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL11ActionPerformed(evt);
            }
        });

        CMA11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA11MouseClicked(evt);
            }
        });
        CMA11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA11ActionPerformed(evt);
            }
        });

        CM11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM11MouseClicked(evt);
            }
        });
        CM11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM11ActionPerformed(evt);
            }
        });

        CJ11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ11MouseClicked(evt);
            }
        });
        CJ11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ11ActionPerformed(evt);
            }
        });

        CV11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV11MouseClicked(evt);
            }
        });
        CV11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV11ActionPerformed(evt);
            }
        });

        CL12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL12MouseClicked(evt);
            }
        });
        CL12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL12ActionPerformed(evt);
            }
        });

        CMA12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA12MouseClicked(evt);
            }
        });
        CMA12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA12ActionPerformed(evt);
            }
        });

        CM12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM12MouseClicked(evt);
            }
        });
        CM12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM12ActionPerformed(evt);
            }
        });

        CJ12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ12MouseClicked(evt);
            }
        });
        CJ12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ12ActionPerformed(evt);
            }
        });

        CV12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV12MouseClicked(evt);
            }
        });
        CV12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV12ActionPerformed(evt);
            }
        });

        CL13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL13MouseClicked(evt);
            }
        });
        CL13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL13ActionPerformed(evt);
            }
        });

        CMA13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA13MouseClicked(evt);
            }
        });
        CMA13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA13ActionPerformed(evt);
            }
        });

        CM13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM13MouseClicked(evt);
            }
        });
        CM13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM13ActionPerformed(evt);
            }
        });

        CJ13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ13MouseClicked(evt);
            }
        });
        CJ13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ13ActionPerformed(evt);
            }
        });

        CV13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV13MouseClicked(evt);
            }
        });
        CV13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV13ActionPerformed(evt);
            }
        });

        CL14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CL14MouseClicked(evt);
            }
        });
        CL14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL14ActionPerformed(evt);
            }
        });

        CMA14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMA14MouseClicked(evt);
            }
        });
        CMA14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA14ActionPerformed(evt);
            }
        });

        CM14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CM14MouseClicked(evt);
            }
        });
        CM14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM14ActionPerformed(evt);
            }
        });

        CJ14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CJ14MouseClicked(evt);
            }
        });
        CJ14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ14ActionPerformed(evt);
            }
        });

        CV14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CV14MouseClicked(evt);
            }
        });
        CV14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV14ActionPerformed(evt);
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
                        .addGap(86, 86, 86)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CL14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CS14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CL1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CM1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CV1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CS1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CL2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CMA2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CM2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CS2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CL3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CMA3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CM3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CV3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CS3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CMA4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CM4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CV4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CS4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(CL4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CMA5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CM5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CJ5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CV5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CS5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CL5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CMA6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CM6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CJ6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CV6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CS6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CL6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CL14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMA14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CM14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CJ14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CV14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPeticion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPeticion.setText("horario:");

        txtRestantes.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        txtRestantes.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Horas Restante:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeticion)
                    .addComponent(txtRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("Terminar Disponibilidad");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        int valor=cbxMaestro.getSelectedIndex();
        String valorSeleccion=cbxMaestro.getItemAt(valor);
        
        if(valorSeleccion.equalsIgnoreCase("Selecciona Maestro")){
            JOptionPane.showMessageDialog(null, "Seleccione a un Maestro");
        }
        else{
            try {
                datos=valorSeleccion.split("-");
                String clave=datos[0].trim();
                int numEmpleado=Integer.parseInt(clave);
                
                mostrarMaestroEspecifico(numEmpleado);
                inhabilitarAceptar();
                habilitar();

            } catch (SQLException ex) {
                Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void CL7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CL7MouseClicked

    private void CL8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CL8MouseClicked

    private void CL9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL9MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CL9MouseClicked

    private void CL10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL10MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CL10MouseClicked

    private void CL11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL11MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CL11MouseClicked

    private void CL12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL12MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CL12MouseClicked

    private void CL13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL13MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CL13MouseClicked

    private void CL14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CL14MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CL14MouseClicked

    //PBI6:HU15 como subdirector quiero dar alta la disponibilidad de Horario
    private void CL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL1ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=7;
            boolean valor=CL1.isSelected();
            
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);
            //PBI6:HU15:02 Valida que la casill de horario esta sin seleccionar para poder asignar horario
            if(valor==true){
                //PBI6:HU15:03 Valida si cuenta con horas para asignar su disponibilidad
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL1.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    //PBI5:HU5:01 Da de alta disponibilidad de horario
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL1ActionPerformed

    private void CMA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CMA1MouseClicked

    private void CMA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA2MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CMA2MouseClicked

    private void CMA3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CMA3MouseClicked

    private void CMA4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CMA4MouseClicked

    private void CMA5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA5MouseClicked

    private void CMA6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA6MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA6MouseClicked

    private void CMA7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA7MouseClicked

    private void CMA8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA8MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CMA8MouseClicked

    private void CMA9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA9MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA9MouseClicked

    private void CMA10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA10MouseClicked

    private void CMA11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA11MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA11MouseClicked

    private void CMA12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA12MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CMA12MouseClicked

    private void CMA13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA13MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CMA13MouseClicked

    private void CMA14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMA14MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CMA14MouseClicked

    private void CM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM1MouseClicked

    private void CM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM2MouseClicked

    private void CM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM3MouseClicked

    private void CM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM4MouseClicked

    private void CM5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM5MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CM5MouseClicked

    private void CM6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM6MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM6MouseClicked

    private void CM7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM7MouseClicked

    private void CM8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM8MouseClicked

    private void CM9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM9MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM9MouseClicked

    private void CM10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM10MouseClicked

    private void CM11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM11MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM11MouseClicked

    private void CM12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM12MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM12MouseClicked

    private void CM13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM13MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CM13MouseClicked

    private void CM14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CM14MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CM14MouseClicked

    private void CJ1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ1MouseClicked

    private void CJ2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ2MouseClicked

    private void CJ3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ3MouseClicked

    private void CJ4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ4MouseClicked

    private void CJ5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ5MouseClicked

    private void CJ6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ6MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ6MouseClicked

    private void CJ7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ7MouseClicked

    private void CJ8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ8MouseClicked

    private void CJ9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CJ9MouseClicked

    private void CJ10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ10MouseClicked

    private void CJ11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CJ11MouseClicked

    private void CJ12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ12MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ12MouseClicked

    private void CJ13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ13MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ13MouseClicked

    private void CJ14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CJ14MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CJ14MouseClicked

    private void CV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV1MouseClicked

    private void CV2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV2MouseClicked

    private void CV3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV3MouseClicked

    private void CV4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV4MouseClicked

    private void CV5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV5MouseClicked

    private void CV6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV6MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CV6MouseClicked

    private void CV7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV7MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV7MouseClicked

    private void CV8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV8MouseClicked

    private void CV9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV9MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV9MouseClicked

    private void CV10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV10MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV10MouseClicked

    private void CV11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV11MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_CV11MouseClicked

    private void CV12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV12MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV12MouseClicked

    private void CV13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV13MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV13MouseClicked

    private void CV14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CV14MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CV14MouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        inhabilitar();
        desactivarSeleccion();
        iniciar();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void CL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL2ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=8;
            boolean valor=CL2.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL2.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL2ActionPerformed

    private void CL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL3ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=9;
            boolean valor=CL3.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL3.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL3ActionPerformed

    private void CL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL4ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=10;
            boolean valor=CL4.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL4.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL4ActionPerformed

    private void CL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL5ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=11;
            boolean valor=CL5.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL5.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL5ActionPerformed

    private void CL6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL6ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=12;
            boolean valor=CL6.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL6.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL6ActionPerformed

    private void CL7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL7ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=13;
            boolean valor=CL7.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL7.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL7ActionPerformed

    private void CL8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL8ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=14;
            boolean valor=CL8.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL8.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL8ActionPerformed

    private void CL9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL9ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=15;
            boolean valor=CL9.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL9.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL9ActionPerformed

    private void CL10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL10ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=16;
            boolean valor=CL10.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL10.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL10ActionPerformed

    private void CL11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL11ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=17;
            boolean valor=CL11.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL11.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL11ActionPerformed

    private void CL12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL12ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=18;
            boolean valor=CL12.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL12.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL12ActionPerformed

    private void CL13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL13ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=19;
            boolean valor=CL13.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL13.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL13ActionPerformed

    private void CL14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL14ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
            int Hora=20;
            boolean valor=CL14.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CL14.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CL14ActionPerformed

    private void CMA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA1ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=7;
            boolean valor=CMA1.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA1.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA1ActionPerformed

    private void CMA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA2ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=8;
            boolean valor=CMA2.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA2.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA2ActionPerformed

    private void CMA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA3ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=9;
            boolean valor=CMA3.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA3.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA3ActionPerformed

    private void CMA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA4ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=10;
            boolean valor=CMA4.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA4.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA4ActionPerformed

    private void CMA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA5ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=11;
            boolean valor=CMA5.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA5.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA5ActionPerformed

    private void CMA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA6ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=12;
            boolean valor=CMA6.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA6.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA6ActionPerformed

    private void CMA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA7ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=13;
            boolean valor=CMA7.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA7.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA7ActionPerformed

    private void CMA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA8ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=14;
            boolean valor=CMA8.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA8.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA8ActionPerformed

    private void CMA9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA9ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=15;
            boolean valor=CMA9.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA9.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA9ActionPerformed

    private void CMA10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA10ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=16;
            boolean valor=CMA10.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA10.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA10ActionPerformed

    private void CMA11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA11ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=17;
            boolean valor=CMA11.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA11.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA11ActionPerformed

    private void CMA12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA12ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=18;
            boolean valor=CMA12.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA12.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA12ActionPerformed

    private void CMA13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA13ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=19;
            boolean valor=CMA13.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA13.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA13ActionPerformed

    private void CMA14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA14ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
            int Hora=20;
            boolean valor=CMA14.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CMA14.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CMA14ActionPerformed

    private void CM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM1ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=7;
            boolean valor=CM1.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM1.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM1ActionPerformed

    private void CM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM2ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=8;
            boolean valor=CM2.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM2.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM2ActionPerformed

    private void CM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM3ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=9;
            boolean valor=CM3.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM3.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM3ActionPerformed

    private void CM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM4ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=10;
            boolean valor=CM4.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM4.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM4ActionPerformed

    private void CM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM5ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=11;
            boolean valor=CM5.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM5.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM5ActionPerformed

    private void CM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM6ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=12;
            boolean valor=CM6.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM6.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM6ActionPerformed

    private void CM7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM7ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=13;
            boolean valor=CM7.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM7.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM7ActionPerformed

    private void CM8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM8ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=14;
            boolean valor=CM8.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM8.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM8ActionPerformed

    private void CM9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM9ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=15;
            boolean valor=CM9.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM9.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM9ActionPerformed

    private void CM10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM10ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=16;
            boolean valor=CM10.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM10.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM10ActionPerformed

    private void CM11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM11ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=17;
            boolean valor=CM11.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM11.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM11ActionPerformed

    private void CM12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM12ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=18;
            boolean valor=CM12.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM12.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM12ActionPerformed

    private void CM13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM13ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=19;
            boolean valor=CM13.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM13.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM13ActionPerformed

    private void CM14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM14ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
            int Hora=20;
            boolean valor=CM14.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CM14.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CM14ActionPerformed

    private void CJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ1ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=7;
            boolean valor=CJ1.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ1.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ1ActionPerformed

    private void CJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ2ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=8;
            boolean valor=CJ2.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ2.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ2ActionPerformed

    private void CJ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ3ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=9;
            boolean valor=CJ3.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ3.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ3ActionPerformed

    private void CJ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ4ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=10;
            boolean valor=CJ4.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ4.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ4ActionPerformed

    private void CJ5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ5ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=11;
            boolean valor=CJ5.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ5.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ5ActionPerformed

    private void CJ6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ6ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=12;
            boolean valor=CJ6.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ6.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ6ActionPerformed

    private void CJ7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ7ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=13;
            boolean valor=CJ7.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ7.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ7ActionPerformed

    private void CJ8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ8ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=14;
            boolean valor=CJ8.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ8.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ8ActionPerformed

    private void CJ9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ9ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=15;
            boolean valor=CJ9.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ9.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ9ActionPerformed

    private void CJ10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ10ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=16;
            boolean valor=CJ10.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ10.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ10ActionPerformed

    private void CJ11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ11ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=17;
            boolean valor=CJ11.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ11.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ11ActionPerformed

    private void CJ12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ12ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=18;
            boolean valor=CJ12.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ12.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ12ActionPerformed

    private void CJ13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ13ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=19;
            boolean valor=CJ13.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ13.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ13ActionPerformed

    private void CJ14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ14ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
            int Hora=20;
            boolean valor=CJ14.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CJ14.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CJ14ActionPerformed

    private void CV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV1ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=7;
            boolean valor=CV1.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV1.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV1ActionPerformed

    private void CV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=8;
            boolean valor=CV2.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV2.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV2ActionPerformed

    private void CV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV3ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=9;
            boolean valor=CV3.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV3.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV3ActionPerformed

    private void CV4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV4ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=10;
            boolean valor=CV4.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV4.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV4ActionPerformed

    private void CV5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV5ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=11;
            boolean valor=CV5.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV5.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV5ActionPerformed

    private void CV6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV6ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=12;
            boolean valor=CV6.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV6.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV6ActionPerformed

    private void CV7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV7ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=13;
            boolean valor=CV7.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV7.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV7ActionPerformed

    private void CV8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV8ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=14;
            boolean valor=CV8.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV8.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV8ActionPerformed

    private void CV9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV9ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=15;
            boolean valor=CV9.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV9.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV9ActionPerformed

    private void CV10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV10ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=16;
            boolean valor=CV10.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV10.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV10ActionPerformed

    private void CV11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV11ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=17;
            boolean valor=CV11.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV11.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV11ActionPerformed

    private void CV12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV12ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=18;
            boolean valor=CV12.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV12.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV12ActionPerformed

    private void CV13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV13ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=19;
            boolean valor=CV13.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV13.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV13ActionPerformed

    private void CV14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV14ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
            int Hora=20;
            boolean valor=CV14.isSelected();
            
            int resul=0;
            String numEm=ET1.getText();
            int noEmpleado=Integer.parseInt(numEm);
            String horaAsignada=txtRestantes.getText();
            int horasAsignadas=Integer.parseInt(horaAsignada);  
            if(valor==true){
                if(horasRestante==0){
                    JOptionPane.showMessageDialog(null, "Ya no cuenta con cantidad de horas disponibles para asignar");
                    CV14.setSelected(false);
//                    horasRestante=horasAsignadas+1;
                }
                else{
                    HorasRestantes();
                    ingresarDatos(Dia,Hora);
                    horasRestante=horasAsignadas-1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);

                }
            }
            else{
                if(valor==false){
                    HorasSuma();
                    eliminarDatos(Dia,Hora);
                    horasRestante=horasRestante+1;
                    String canthoras=Integer.toString(horasRestante);
                    txtRestantes.setText(canthoras);
                }   
            }
    }//GEN-LAST:event_CV14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CJ1;
    private javax.swing.JCheckBox CJ10;
    private javax.swing.JCheckBox CJ11;
    private javax.swing.JCheckBox CJ12;
    private javax.swing.JCheckBox CJ13;
    private javax.swing.JCheckBox CJ14;
    private javax.swing.JCheckBox CJ2;
    private javax.swing.JCheckBox CJ3;
    private javax.swing.JCheckBox CJ4;
    private javax.swing.JCheckBox CJ5;
    private javax.swing.JCheckBox CJ6;
    private javax.swing.JCheckBox CJ7;
    private javax.swing.JCheckBox CJ8;
    private javax.swing.JCheckBox CJ9;
    private javax.swing.JCheckBox CL1;
    private javax.swing.JCheckBox CL10;
    private javax.swing.JCheckBox CL11;
    private javax.swing.JCheckBox CL12;
    private javax.swing.JCheckBox CL13;
    private javax.swing.JCheckBox CL14;
    private javax.swing.JCheckBox CL2;
    private javax.swing.JCheckBox CL3;
    private javax.swing.JCheckBox CL4;
    private javax.swing.JCheckBox CL5;
    private javax.swing.JCheckBox CL6;
    private javax.swing.JCheckBox CL7;
    private javax.swing.JCheckBox CL8;
    private javax.swing.JCheckBox CL9;
    private javax.swing.JCheckBox CM1;
    private javax.swing.JCheckBox CM10;
    private javax.swing.JCheckBox CM11;
    private javax.swing.JCheckBox CM12;
    private javax.swing.JCheckBox CM13;
    private javax.swing.JCheckBox CM14;
    private javax.swing.JCheckBox CM2;
    private javax.swing.JCheckBox CM3;
    private javax.swing.JCheckBox CM4;
    private javax.swing.JCheckBox CM5;
    private javax.swing.JCheckBox CM6;
    private javax.swing.JCheckBox CM7;
    private javax.swing.JCheckBox CM8;
    private javax.swing.JCheckBox CM9;
    private javax.swing.JCheckBox CMA1;
    private javax.swing.JCheckBox CMA10;
    private javax.swing.JCheckBox CMA11;
    private javax.swing.JCheckBox CMA12;
    private javax.swing.JCheckBox CMA13;
    private javax.swing.JCheckBox CMA14;
    private javax.swing.JCheckBox CMA2;
    private javax.swing.JCheckBox CMA3;
    private javax.swing.JCheckBox CMA4;
    private javax.swing.JCheckBox CMA5;
    private javax.swing.JCheckBox CMA6;
    private javax.swing.JCheckBox CMA7;
    private javax.swing.JCheckBox CMA8;
    private javax.swing.JCheckBox CMA9;
    private javax.swing.JCheckBox CS1;
    private javax.swing.JCheckBox CS10;
    private javax.swing.JCheckBox CS11;
    private javax.swing.JCheckBox CS12;
    private javax.swing.JCheckBox CS13;
    private javax.swing.JCheckBox CS14;
    private javax.swing.JCheckBox CS2;
    private javax.swing.JCheckBox CS3;
    private javax.swing.JCheckBox CS4;
    private javax.swing.JCheckBox CS5;
    private javax.swing.JCheckBox CS6;
    private javax.swing.JCheckBox CS7;
    private javax.swing.JCheckBox CS8;
    private javax.swing.JCheckBox CS9;
    private javax.swing.JCheckBox CV1;
    private javax.swing.JCheckBox CV10;
    private javax.swing.JCheckBox CV11;
    private javax.swing.JCheckBox CV12;
    private javax.swing.JCheckBox CV13;
    private javax.swing.JCheckBox CV14;
    private javax.swing.JCheckBox CV2;
    private javax.swing.JCheckBox CV3;
    private javax.swing.JCheckBox CV4;
    private javax.swing.JCheckBox CV5;
    private javax.swing.JCheckBox CV6;
    private javax.swing.JCheckBox CV7;
    private javax.swing.JCheckBox CV8;
    private javax.swing.JCheckBox CV9;
    private javax.swing.JLabel ET1;
    private javax.swing.JLabel ET2;
    private javax.swing.JLabel ET3;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxMaestro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblPeticion;
    private javax.swing.JTextField txtRestantes;
    // End of variables declaration//GEN-END:variables
}
