/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlAsignarMateria;
import Controlador.ControlDisponibilidad;
import Controlador.ControlGrupo;
import Controlador.ControlHorario;
import Controlador.ControlMaestro;
import Controlador.ControlMateria;
import Controlador.ControlSalon;
import Modelo.EntidadHorario;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class InterfazAsignarHorario extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfazHorario 
     */
    DefaultListModel modelo;
    DefaultTableModel modelo1;
    private String sSQL="";
    int IDSALON=0;
    int GRUPO=0;
    int cont=0;
    
    String datos[]=null;
    String datos2[]=null;
    String recibe[]=null;
    String salon1[]=null;
    String consultaDatos1[]=null;
    ControlMaestro controlMaestro=new ControlMaestro();
    ControlAsignarMateria controlAsig=new ControlAsignarMateria();
    ControlMateria controlMateria=new ControlMateria();
    ControlGrupo controlGrupo=new ControlGrupo();
    ControlSalon controlSalon=new ControlSalon();
    ControlDisponibilidad controlDisponibilidad=new ControlDisponibilidad();
    
    EntidadHorario entidadHorario=new EntidadHorario();
    ControlHorario controlHorario=new ControlHorario();
    
    
    
    public InterfazAsignarHorario() {
        try {
            initComponents();
            mostrarMaestro();
            inhabilitar();
            deshabilitar();
            colorInicial();
            cbxMaestro.setSelectedItem("Seleccione maestro");
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deshabilitar(){
        cbxActividad.setEnabled(false);
        cbxGrupo.setEnabled(false);
        cbxSalon.setEnabled(false);
        txtHoras.setEnabled(false);
//        cbxActividad.setEnabled(false);
        btnSiguiente.setEnabled(false);
    }
    
    public void mostrarMaestro() throws SQLException{
        cbxMaestro.removeAllItems();
        cbxMaestro.addItem("Selecciona Maestro");

        ResultSet rs = controlMaestro.consultarMaestroGeneral();
        while(rs.next()){
            cbxMaestro.addItem(rs.getString("NumeroEmpleado")+"-"+rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ");

            }
        
    }

    public void habilitarCancelar(){
        cbxMaestro.setEnabled(true);
        btnAceptar.setEnabled(true);
        ET1.setText("");
        ET2.setText("");
        ET3.setText("");
        ET4.setText("");
        ET5.setText("");
        ET6.setText("");
        ET7.setText("");
        cbxActividad.setEnabled(false);
        cbxSalon.setEnabled(false);
        cbxGrupo.setEnabled(false);
        cbxActividad.setSelectedItem("Selecciona Actividad");
        cbxMaestro.setSelectedItem("Selecciona Maestro");
        cbxSalon.setSelectedItem("(Selecciona Salon)");
        cbxGrupo.setSelectedItem("(Selecciona Grupo)");
        
    }
    
    public void mostrarGrupos(int busca) throws SQLException{
        cbxGrupo.removeAllItems();
        cbxGrupo.addItem("(Selecciona Grupo)");

        ResultSet rs = controlGrupo.consultarGrupoGeneral(busca);
        while(rs.next()){
            cbxGrupo.addItem(rs.getString("NumGrupo"));

            }
        
    }
    public void mostrarSalon() throws SQLException{
        cbxSalon.removeAllItems();
        cbxSalon.addItem("(Selecciona Salon)");

        ResultSet rs = controlSalon.consultarSalonGeneral();
        while(rs.next()){
            cbxSalon.addItem(rs.getString("idSalon")+"-"+rs.getString("NumSalon"));

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
        ET7.setText(horasAsignadas);
//        consultarGeneral(numEmpleado);
    }
    public void eliminarHora(String dia,int hora){
        String numeroEmpleado=ET1.getText();
        int numEmpleado=Integer.parseInt(numeroEmpleado);
        entidadHorario.setNumEmpleado(numEmpleado);
        entidadHorario.setDia(dia);
        entidadHorario.setHora(hora);
        controlHorario.eliminarHora(entidadHorario);
    }
    public void colorInicial(){
        eje1.setBackground(Color.yellow);
        eje2.setBackground(Color.BLUE);
        eje3.setBackground(Color.RED);
        eje4.setBackground(Color.GREEN);
        
        PCL1.setBackground(Color.WHITE);PCL2.setBackground(Color.WHITE);PCL3.setBackground(Color.WHITE);PCL4.setBackground(Color.WHITE);PCL5.setBackground(Color.WHITE);
        PCL6.setBackground(Color.WHITE);PCL7.setBackground(Color.WHITE);PCL8.setBackground(Color.WHITE);PCL9.setBackground(Color.WHITE);PCL10.setBackground(Color.WHITE);
        PCL11.setBackground(Color.WHITE);PCL12.setBackground(Color.WHITE);PCL13.setBackground(Color.WHITE);PCL14.setBackground(Color.WHITE);
        
        PCMA1.setBackground(Color.WHITE);PCMA2.setBackground(Color.WHITE);PCMA3.setBackground(Color.WHITE);PCMA4.setBackground(Color.WHITE);PCMA5.setBackground(Color.WHITE);
        PCMA6.setBackground(Color.WHITE);PCMA7.setBackground(Color.WHITE);PCMA8.setBackground(Color.WHITE);PCMA9.setBackground(Color.WHITE);PCMA10.setBackground(Color.WHITE);
        PCMA11.setBackground(Color.WHITE);PCMA12.setBackground(Color.WHITE);PCMA13.setBackground(Color.WHITE);PCMA14.setBackground(Color.WHITE);
        
        PCM1.setBackground(Color.WHITE);PCM2.setBackground(Color.WHITE);PCM3.setBackground(Color.WHITE);PCM4.setBackground(Color.WHITE);PCM5.setBackground(Color.WHITE);
        PCM6.setBackground(Color.WHITE);PCM7.setBackground(Color.WHITE);PCM8.setBackground(Color.WHITE);PCM9.setBackground(Color.WHITE);PCM10.setBackground(Color.WHITE);
        PCM11.setBackground(Color.WHITE);PCM12.setBackground(Color.WHITE);PCM13.setBackground(Color.WHITE);PCM14.setBackground(Color.WHITE);
        
        PCJ1.setBackground(Color.WHITE);PCJ2.setBackground(Color.WHITE);PCJ3.setBackground(Color.WHITE);PCJ4.setBackground(Color.WHITE);PCJ5.setBackground(Color.WHITE);
        PCJ6.setBackground(Color.WHITE);PCJ7.setBackground(Color.WHITE);PCJ8.setBackground(Color.WHITE);PCJ9.setBackground(Color.WHITE);PCJ10.setBackground(Color.WHITE);
        PCJ11.setBackground(Color.WHITE);PCJ12.setBackground(Color.WHITE);PCJ13.setBackground(Color.WHITE);PCJ14.setBackground(Color.WHITE);
        
        PCV1.setBackground(Color.WHITE);PCV2.setBackground(Color.WHITE);PCV3.setBackground(Color.WHITE);PCV4.setBackground(Color.WHITE);PCV5.setBackground(Color.WHITE);
        PCV6.setBackground(Color.WHITE);PCV7.setBackground(Color.WHITE);PCV8.setBackground(Color.WHITE);PCV9.setBackground(Color.WHITE);PCV10.setBackground(Color.WHITE);
        PCV11.setBackground(Color.WHITE);PCV12.setBackground(Color.WHITE);PCV13.setBackground(Color.WHITE);PCV14.setBackground(Color.WHITE);
        
        
    }
    public void mostrarMateriasAsignadas(int buscar) throws SQLException{
        
            modelo1=controlAsig.consultaEspecificaAsignacion(buscar);
            tbMateria.setModel(modelo1);
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
        
        
        
//        cbxMaestro.setSelectedItem("Selecciona Maestro");
//        txtRestantes.setText("");
    }
    
    public void mostrarDisponibilidadMaestro(int clave){
        try {
            sSQL="select * from disponibilidahorario where Maestro_NumeroEmpleado like '%"+clave+"%' order by Maestro_NumeroEmpleado";
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
                            CL1.setEnabled(true);
                            PCL1.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CL2.setEnabled(true);
                            PCL2.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CL3.setEnabled(true);
                            PCL3.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CL4.setEnabled(true);
                            PCL4.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CL5.setEnabled(true);
                            PCL5.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CL6.setEnabled(true);
                            PCL6.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CL7.setEnabled(true);
                            PCL7.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CL8.setEnabled(true);
                            PCL8.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CL9.setEnabled(true);
                            PCL9.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CL10.setEnabled(true);
                            PCL10.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CL11.setEnabled(true);
                            PCL11.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CL12.setEnabled(true);
                            PCL12.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CL13.setEnabled(true);
                            PCL13.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CL14.setEnabled(true);
                            PCL14.setBackground(Color.yellow);
                        }
                    }
                    if(Dia.equals("Martes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CMA1.setEnabled(true);
                            PCMA1.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CMA2.setEnabled(true);
                            PCMA2.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CMA3.setEnabled(true);
                            PCMA3.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CMA4.setEnabled(true);
                            PCMA4.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CMA5.setEnabled(true);
                            PCMA5.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CMA6.setEnabled(true);
                            PCMA6.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CMA7.setEnabled(true);
                            PCMA7.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CMA8.setEnabled(true);
                            PCMA8.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CMA9.setEnabled(true);
                            PCMA9.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CMA10.setEnabled(true);
                            PCMA10.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CMA11.setEnabled(true);
                            PCMA11.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CMA12.setEnabled(true);
                            PCMA12.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CMA13.setEnabled(true);
                            PCMA13.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CMA14.setEnabled(true);
                            PCMA14.setBackground(Color.yellow);
                        }
                    }
                    if(Dia.equals("Miercoles")){
                        if(Hora.equalsIgnoreCase("7")){
                            CM1.setEnabled(true);
                            PCM1.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CM2.setEnabled(true);
                            PCM2.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CM3.setEnabled(true);
                            PCM3.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CM4.setEnabled(true);
                            PCM4.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CM5.setEnabled(true);
                            PCM5.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CM6.setEnabled(true);
                            PCM6.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CM7.setEnabled(true);
                            PCM7.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CM8.setEnabled(true);
                            PCM8.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CM9.setEnabled(true);
                            PCM9.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CM10.setEnabled(true);
                            PCM10.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CM11.setEnabled(true);
                            PCM11.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CM12.setEnabled(true);
                            PCM12.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CM13.setEnabled(true);
                            PCM13.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CM14.setEnabled(true);
                            PCM14.setBackground(Color.yellow);
                        }
                    }
                    if(Dia.equals("Jueves")){
                        if(Hora.equalsIgnoreCase("7")){
                            CJ1.setEnabled(true);
                            PCJ1.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CJ2.setEnabled(true);
                            PCJ2.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CJ3.setEnabled(true);
                            PCJ3.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CJ4.setEnabled(true);
                            PCJ4.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CJ5.setEnabled(true);
                            PCJ5.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CJ6.setEnabled(true);
                            PCJ6.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CJ7.setEnabled(true);
                            PCJ7.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CJ8.setEnabled(true);
                            PCJ8.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CJ9.setEnabled(true);
                            PCJ9.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CJ10.setEnabled(true);
                            PCJ10.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CJ11.setEnabled(true);
                            PCJ11.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CJ12.setEnabled(true);
                            PCJ12.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CJ13.setEnabled(true);
                            PCJ13.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CJ14.setEnabled(true);
                            PCJ14.setBackground(Color.yellow);
                        }
                    }
                    if(Dia.equals("Viernes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CV1.setEnabled(true);
                            PCV1.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CV2.setEnabled(true);
                            PCV2.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CV3.setEnabled(true);
                            PCV3.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CV4.setEnabled(true);
                            PCV4.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CV5.setEnabled(true);
                            PCV5.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CV6.setEnabled(true);
                            PCV6.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CV7.setEnabled(true);
                            PCV7.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CV8.setEnabled(true);
                            PCV8.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CV9.setEnabled(true);
                            PCV9.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CV10.setEnabled(true);
                            PCV10.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CV11.setEnabled(true);
                            PCV11.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CV12.setEnabled(true);
                            PCV12.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CV13.setEnabled(true);
                            PCV13.setBackground(Color.yellow);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CV14.setEnabled(true);
                            PCV14.setBackground(Color.yellow);
                        }
                    }                   
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void mostrarDisponibilidadGrupo(int nuGrupo){
        try {
            sSQL="select * from horario where NumGrupo like '%"+nuGrupo+"%';";
            Statement st=controlHorario.consultaHorarioEspecificaGrupo();
            
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
                            CL1.setEnabled(false);
                            PCL1.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CL2.setSelected(true);
                            CL2.setEnabled(false);
                            PCL2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CL3.setSelected(true);
                            CL3.setEnabled(false);
                            PCL3.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CL4.setSelected(true);
                            CL4.setEnabled(false);
                            PCL4.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CL5.setSelected(true);
                            CL5.setEnabled(false);
                            PCL5.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CL6.setSelected(true);
                            CL6.setEnabled(false);
                            PCL6.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CL7.setSelected(true);
                            CL7.setEnabled(false);
                            PCL7.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CL8.setSelected(true);
                            CL8.setEnabled(false);
                            PCL8.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CL9.setSelected(true);
                            CL9.setEnabled(false);
                            PCL9.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CL10.setSelected(true);
                            CL10.setEnabled(false);
                            PCL10.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CL11.setSelected(true);
                            CL11.setEnabled(false);
                            PCL11.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CL12.setSelected(true);
                            CL12.setEnabled(false);
                            PCL12.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CL13.setSelected(true);
                            CL13.setEnabled(false);
                            PCL13.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CL14.setSelected(true);
                            CL14.setEnabled(false);
                            PCL14.setBackground(Color.BLUE);
                        }
                    }
                    if(Dia.equals("Martes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CMA1.setSelected(true);
                            CMA1.setEnabled(false);
                            PCMA1.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CMA2.setSelected(true);
                            CMA2.setEnabled(false);
                            PCMA2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CMA3.setSelected(true);
                            CMA3.setEnabled(false);
                            PCMA3.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CMA4.setSelected(true);
                            CMA4.setEnabled(false);
                            PCMA4.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CMA5.setSelected(true);
                            CMA5.setEnabled(false);
                            PCMA5.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CMA6.setSelected(true);
                            CMA6.setEnabled(false);
                            PCMA6.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CMA7.setSelected(true);
                            CMA7.setEnabled(false);
                            PCMA7.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CMA8.setSelected(true);
                            CMA8.setEnabled(false);
                            PCMA8.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CMA9.setSelected(true);
                            CMA9.setEnabled(false);
                            PCMA9.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CMA10.setSelected(true);
                            CMA10.setEnabled(false);
                            PCMA10.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CMA11.setSelected(true);
                            CMA11.setEnabled(false);
                            PCMA11.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CMA12.setSelected(true);
                            CMA12.setEnabled(false);
                            PCMA12.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CMA13.setSelected(true);
                            CMA13.setEnabled(false);
                            PCMA13.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CMA14.setSelected(true);
                            CMA14.setEnabled(false);
                            PCMA14.setBackground(Color.BLUE);
                        }
                    }
                    if(Dia.equals("Miercoles")){
                        if(Hora.equalsIgnoreCase("7")){
                            CM1.setSelected(true);
                            CM1.setEnabled(false);
                            PCM1.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CM2.setSelected(true);
                            CM2.setEnabled(false);
                            PCM2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CM3.setSelected(true);
                            CM3.setEnabled(false);
                            PCM3.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CM4.setSelected(true);
                            CM4.setEnabled(false);
                            PCM4.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CM5.setSelected(true);
                            CM5.setEnabled(false);
                            PCM5.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CM6.setSelected(true);
                            CM6.setEnabled(false);
                            PCM6.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CM7.setSelected(true);
                            CM7.setEnabled(false);
                            PCM7.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CM8.setSelected(true);
                            CM8.setEnabled(false);
                            PCM8.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CM9.setSelected(true);
                            CM9.setEnabled(false);
                            PCM9.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CM10.setSelected(true);
                            CM10.setEnabled(false);
                            PCM10.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CM11.setSelected(true);
                            CM11.setEnabled(false);
                            PCM11.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CM12.setSelected(true);
                            CM12.setEnabled(false);
                            PCM12.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CM13.setSelected(true);
                            CM13.setEnabled(false);
                            PCM13.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CM14.setSelected(true);
                            CM14.setEnabled(false);
                            PCM14.setBackground(Color.BLUE);
                        }
                    }
                    if(Dia.equals("Jueves")){
                        if(Hora.equalsIgnoreCase("7")){
                            CJ1.setSelected(true);
                            CJ1.setEnabled(false);
                            PCJ1.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CJ2.setSelected(true);
                            CJ2.setEnabled(false);
                            PCJ2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CJ3.setSelected(true);
                            CJ3.setEnabled(false);
                            PCJ3.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CJ4.setSelected(true);
                            CJ4.setEnabled(false);
                            PCJ4.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CJ5.setSelected(true);
                            CJ5.setEnabled(false);
                            PCJ5.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CJ6.setSelected(true);
                            CJ6.setEnabled(false);
                            PCJ6.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CJ7.setSelected(true);
                            CJ7.setEnabled(false);
                            PCJ7.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CJ8.setSelected(true);
                            CJ8.setEnabled(false);
                            PCJ8.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CJ9.setSelected(true);
                            CJ9.setEnabled(false);
                            PCJ9.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CJ10.setSelected(true);
                            CJ10.setEnabled(false);
                            PCJ10.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CJ11.setSelected(true);
                            CJ11.setEnabled(false);
                            PCJ11.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CJ12.setSelected(true);
                            CJ12.setEnabled(false);
                            PCJ12.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CJ13.setSelected(true);
                            CJ13.setEnabled(false);
                            PCJ13.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CJ14.setSelected(true);
                            CJ14.setEnabled(false);
                            PCJ14.setBackground(Color.BLUE);
                        }
                    }
                    if(Dia.equals("Viernes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CV1.setSelected(true);
                            CV1.setEnabled(false);
                            PCV1.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CV2.setSelected(true);
                            CV2.setEnabled(false);
                            PCV2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CV3.setSelected(true);
                            CV3.setEnabled(false);
                            PCV2.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CV4.setSelected(true);
                            CV4.setEnabled(false);
                            PCV4.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CV5.setSelected(true);
                            CV5.setEnabled(false);
                            PCV5.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CV6.setSelected(true);
                            CV6.setEnabled(false);
                            PCV6.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CV7.setSelected(true);
                            CV7.setEnabled(false);
                            PCV7.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CV8.setSelected(true);
                            CV8.setEnabled(false);
                            PCV8.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CV9.setSelected(true);
                            CV9.setEnabled(false);
                            PCV9.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CV10.setSelected(true);
                            CV10.setEnabled(false);
                            PCV10.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CV11.setSelected(true);
                            CV11.setEnabled(false);
                            PCV11.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CV12.setSelected(true);
                            CV12.setEnabled(false);
                            PCV12.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CV13.setSelected(true);
                            CV13.setEnabled(false);
                            PCV13.setBackground(Color.BLUE);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CV14.setSelected(true);
                            CV14.setEnabled(false);
                            PCV14.setBackground(Color.BLUE);
                        }
                    }                   
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void mostrarHorarioMaestro(int numeroEmpleado){
        try {
            sSQL="select * from horario where NumeroEmpleado like '%"+numeroEmpleado+"%';";
            Statement st=controlHorario.consultaHorarioEspecificaGrupo();
            
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
                            CL1.setEnabled(false);
                            PCL1.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CL2.setSelected(true);
                            CL2.setEnabled(false);
                            PCL2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CL3.setSelected(true);
                            CL3.setEnabled(false);
                            PCL3.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CL4.setSelected(true);
                            CL4.setEnabled(false);
                            PCL4.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CL5.setSelected(true);
                            CL5.setEnabled(false);
                            PCL5.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CL6.setSelected(true);
                            CL6.setEnabled(false);
                            PCL6.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CL7.setSelected(true);
                            CL7.setEnabled(false);
                            PCL7.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CL8.setSelected(true);
                            CL8.setEnabled(false);
                            PCL8.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CL9.setSelected(true);
                            CL9.setEnabled(false);
                            PCL9.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CL10.setSelected(true);
                            CL10.setEnabled(false);
                            PCL10.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CL11.setSelected(true);
                            CL11.setEnabled(false);
                            PCL11.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CL12.setSelected(true);
                            CL12.setEnabled(false);
                            PCL12.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CL13.setSelected(true);
                            CL13.setEnabled(false);
                            PCL13.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CL14.setSelected(true);
                            CL14.setEnabled(false);
                            PCL14.setBackground(Color.RED);
                        }
                    }
                    if(Dia.equals("Martes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CMA1.setSelected(true);
                            CMA1.setEnabled(false);
                            PCMA1.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CMA2.setSelected(true);
                            CMA2.setEnabled(false);
                            PCMA2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CMA3.setSelected(true);
                            CMA3.setEnabled(false);
                            PCMA3.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CMA4.setSelected(true);
                            CMA4.setEnabled(false);
                            PCMA4.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CMA5.setSelected(true);
                            CMA5.setEnabled(false);
                            PCMA5.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CMA6.setSelected(true);
                            CMA6.setEnabled(false);
                            PCMA6.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CMA7.setSelected(true);
                            CMA7.setEnabled(false);
                            PCMA7.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CMA8.setSelected(true);
                            CMA8.setEnabled(false);
                            PCMA8.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CMA9.setSelected(true);
                            CMA9.setEnabled(false);
                            PCMA9.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CMA10.setSelected(true);
                            CMA10.setEnabled(false);
                            PCMA10.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CMA11.setSelected(true);
                            CMA11.setEnabled(false);
                            PCMA11.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CMA12.setSelected(true);
                            CMA12.setEnabled(false);
                            PCMA12.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CMA13.setSelected(true);
                            CMA13.setEnabled(false);
                            PCMA13.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CMA14.setSelected(true);
                            CMA14.setEnabled(false);
                            PCMA14.setBackground(Color.RED);
                        }
                    }
                    if(Dia.equals("Miercoles")){
                        if(Hora.equalsIgnoreCase("7")){
                            CM1.setSelected(true);
                            CM1.setEnabled(false);
                            PCM1.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CM2.setSelected(true);
                            CM2.setEnabled(false);
                            PCM2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CM3.setSelected(true);
                            CM3.setEnabled(false);
                            PCM3.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CM4.setSelected(true);
                            CM4.setEnabled(false);
                            PCM4.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CM5.setSelected(true);
                            CM5.setEnabled(false);
                            PCM5.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CM6.setSelected(true);
                            CM6.setEnabled(false);
                            PCM6.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CM7.setSelected(true);
                            CM7.setEnabled(false);
                            PCM7.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CM8.setSelected(true);
                            CM8.setEnabled(false);
                            PCM8.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CM9.setSelected(true);
                            CM9.setEnabled(false);
                            PCM9.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CM10.setSelected(true);
                            CM10.setEnabled(false);
                            PCM10.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CM11.setSelected(true);
                            CM11.setEnabled(false);
                            PCM11.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CM12.setSelected(true);
                            CM12.setEnabled(false);
                            PCM12.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CM13.setSelected(true);
                            CM13.setEnabled(false);
                            PCM13.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CM14.setSelected(true);
                            CM14.setEnabled(false);
                            PCM14.setBackground(Color.RED);
                        }
                    }
                    if(Dia.equals("Jueves")){
                        if(Hora.equalsIgnoreCase("7")){
                            CJ1.setSelected(true);
                            CJ1.setEnabled(false);
                            PCJ1.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CJ2.setSelected(true);
                            CJ2.setEnabled(false);
                            PCJ2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CJ3.setSelected(true);
                            CJ3.setEnabled(false);
                            PCJ3.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CJ4.setSelected(true);
                            CJ4.setEnabled(false);
                            PCJ4.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CJ5.setSelected(true);
                            CJ5.setEnabled(false);
                            PCJ5.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CJ6.setSelected(true);
                            CJ6.setEnabled(false);
                            PCJ6.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CJ7.setSelected(true);
                            CJ7.setEnabled(false);
                            PCJ7.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CJ8.setSelected(true);
                            CJ8.setEnabled(false);
                            PCJ8.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CJ9.setSelected(true);
                            CJ9.setEnabled(false);
                            PCJ9.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CJ10.setSelected(true);
                            CJ10.setEnabled(false);
                            PCJ10.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CJ11.setSelected(true);
                            CJ11.setEnabled(false);
                            PCJ11.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CJ12.setSelected(true);
                            CJ12.setEnabled(false);
                            PCJ12.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CJ13.setSelected(true);
                            CJ13.setEnabled(false);
                            PCJ13.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CJ14.setSelected(true);
                            CJ14.setEnabled(false);
                            PCJ14.setBackground(Color.RED);
                        }
                    }
                    if(Dia.equals("Viernes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CV1.setSelected(true);
                            CV1.setEnabled(false);
                            PCV1.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CV2.setSelected(true);
                            CV2.setEnabled(false);
                            PCV2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CV3.setSelected(true);
                            CV3.setEnabled(false);
                            PCV2.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CV4.setSelected(true);
                            CV4.setEnabled(false);
                            PCV4.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CV5.setSelected(true);
                            CV5.setEnabled(false);
                            PCV5.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CV6.setSelected(true);
                            CV6.setEnabled(false);
                            PCV6.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CV7.setSelected(true);
                            CV7.setEnabled(false);
                            PCV7.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CV8.setSelected(true);
                            CV8.setEnabled(false);
                            PCV8.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CV9.setSelected(true);
                            CV9.setEnabled(false);
                            PCV9.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CV10.setSelected(true);
                            CV10.setEnabled(false);
                            PCV10.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CV11.setSelected(true);
                            CV11.setEnabled(false);
                            PCV11.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CV12.setSelected(true);
                            CV12.setEnabled(false);
                            PCV12.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CV13.setSelected(true);
                            CV13.setEnabled(false);
                            PCV13.setBackground(Color.RED);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CV14.setSelected(true);
                            CV14.setEnabled(false);
                            PCV14.setBackground(Color.RED);
                        }
                    }                   
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void mostrarHorarioSalon(int idSalon){
        try {
            sSQL="select * from horario where idSalon like '%"+idSalon+"%';";
            Statement st=controlHorario.consultaHorarioEspecificaGrupo();
            
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
                            CL1.setEnabled(false);
                            PCL1.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CL2.setSelected(true);
                            CL2.setEnabled(false);
                            PCL2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CL3.setSelected(true);
                            CL3.setEnabled(false);
                            PCL3.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CL4.setSelected(true);
                            CL4.setEnabled(false);
                            PCL4.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CL5.setSelected(true);
                            CL5.setEnabled(false);
                            PCL5.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CL6.setSelected(true);
                            CL6.setEnabled(false);
                            PCL6.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CL7.setSelected(true);
                            CL7.setEnabled(false);
                            PCL7.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CL8.setSelected(true);
                            CL8.setEnabled(false);
                            PCL8.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CL9.setSelected(true);
                            CL9.setEnabled(false);
                            PCL9.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CL10.setSelected(true);
                            CL10.setEnabled(false);
                            PCL10.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CL11.setSelected(true);
                            CL11.setEnabled(false);
                            PCL11.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CL12.setSelected(true);
                            CL12.setEnabled(false);
                            PCL12.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CL13.setSelected(true);
                            CL13.setEnabled(false);
                            PCL13.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CL14.setSelected(true);
                            CL14.setEnabled(false);
                            PCL14.setBackground(Color.GREEN);
                        }
                    }
                    if(Dia.equals("Martes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CMA1.setSelected(true);
                            CMA1.setEnabled(false);
                            PCMA1.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CMA2.setSelected(true);
                            CMA2.setEnabled(false);
                            PCMA2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CMA3.setSelected(true);
                            CMA3.setEnabled(false);
                            PCMA3.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CMA4.setSelected(true);
                            CMA4.setEnabled(false);
                            PCMA4.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CMA5.setSelected(true);
                            CMA5.setEnabled(false);
                            PCMA5.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CMA6.setSelected(true);
                            CMA6.setEnabled(false);
                            PCMA6.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CMA7.setSelected(true);
                            CMA7.setEnabled(false);
                            PCMA7.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CMA8.setSelected(true);
                            CMA8.setEnabled(false);
                            PCMA8.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CMA9.setSelected(true);
                            CMA9.setEnabled(false);
                            PCMA9.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CMA10.setSelected(true);
                            CMA10.setEnabled(false);
                            PCMA10.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CMA11.setSelected(true);
                            CMA11.setEnabled(false);
                            PCMA11.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CMA12.setSelected(true);
                            CMA12.setEnabled(false);
                            PCMA12.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CMA13.setSelected(true);
                            CMA13.setEnabled(false);
                            PCMA13.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CMA14.setSelected(true);
                            CMA14.setEnabled(false);
                            PCMA14.setBackground(Color.GREEN);
                        }
                    }
                    if(Dia.equals("Miercoles")){
                        if(Hora.equalsIgnoreCase("7")){
                            CM1.setSelected(true);
                            CM1.setEnabled(false);
                            PCM1.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CM2.setSelected(true);
                            CM2.setEnabled(false);
                            PCM2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CM3.setSelected(true);
                            CM3.setEnabled(false);
                            PCM3.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CM4.setSelected(true);
                            CM4.setEnabled(false);
                            PCM4.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CM5.setSelected(true);
                            CM5.setEnabled(false);
                            PCM5.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CM6.setSelected(true);
                            CM6.setEnabled(false);
                            PCM6.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CM7.setSelected(true);
                            CM7.setEnabled(false);
                            PCM7.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CM8.setSelected(true);
                            CM8.setEnabled(false);
                            PCM8.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CM9.setSelected(true);
                            CM9.setEnabled(false);
                            PCM9.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CM10.setSelected(true);
                            CM10.setEnabled(false);
                            PCM10.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CM11.setSelected(true);
                            CM11.setEnabled(false);
                            PCM11.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CM12.setSelected(true);
                            CM12.setEnabled(false);
                            PCM12.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CM13.setSelected(true);
                            CM13.setEnabled(false);
                            PCM13.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CM14.setSelected(true);
                            CM14.setEnabled(false);
                            PCM14.setBackground(Color.GREEN);
                        }
                    }
                    if(Dia.equals("Jueves")){
                        if(Hora.equalsIgnoreCase("7")){
                            CJ1.setSelected(true);
                            CJ1.setEnabled(false);
                            PCJ1.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CJ2.setSelected(true);
                            CJ2.setEnabled(false);
                            PCJ2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CJ3.setSelected(true);
                            CJ3.setEnabled(false);
                            PCJ3.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CJ4.setSelected(true);
                            CJ4.setEnabled(false);
                            PCJ4.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CJ5.setSelected(true);
                            CJ5.setEnabled(false);
                            PCJ5.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CJ6.setSelected(true);
                            CJ6.setEnabled(false);
                            PCJ6.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CJ7.setSelected(true);
                            CJ7.setEnabled(false);
                            PCJ7.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CJ8.setSelected(true);
                            CJ8.setEnabled(false);
                            PCJ8.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CJ9.setSelected(true);
                            CJ9.setEnabled(false);
                            PCJ9.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CJ10.setSelected(true);
                            CJ10.setEnabled(false);
                            PCJ10.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CJ11.setSelected(true);
                            CJ11.setEnabled(false);
                            PCJ11.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CJ12.setSelected(true);
                            CJ12.setEnabled(false);
                            PCJ12.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CJ13.setSelected(true);
                            CJ13.setEnabled(false);
                            PCJ13.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CJ14.setSelected(true);
                            CJ14.setEnabled(false);
                            PCJ14.setBackground(Color.GREEN);
                        }
                    }
                    if(Dia.equals("Viernes")){
                        if(Hora.equalsIgnoreCase("7")){
                            CV1.setSelected(true);
                            CV1.setEnabled(false);
                            PCV1.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("8")){
                            CV2.setSelected(true);
                            CV2.setEnabled(false);
                            PCV2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("9")){
                            CV3.setSelected(true);
                            CV3.setEnabled(false);
                            PCV2.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("10")){
                            CV4.setSelected(true);
                            CV4.setEnabled(false);
                            PCV4.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("11")){
                            CV5.setSelected(true);
                            CV5.setEnabled(false);
                            PCV5.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("12")){
                            CV6.setSelected(true);
                            CV6.setEnabled(false);
                            PCV6.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("13")){
                            CV7.setSelected(true);
                            CV7.setEnabled(false);
                            PCV7.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("14")){
                            CV8.setSelected(true);
                            CV8.setEnabled(false);
                            PCV8.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("15")){
                            CV9.setSelected(true);
                            CV9.setEnabled(false);
                            PCV9.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("16")){
                            CV10.setSelected(true);
                            CV10.setEnabled(false);
                            PCV10.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("17")){
                            CV11.setSelected(true);
                            CV11.setEnabled(false);
                            PCV11.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("18")){
                            CV12.setSelected(true);
                            CV12.setEnabled(false);
                            PCV12.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("19")){
                            CV13.setSelected(true);
                            CV13.setEnabled(false);
                            PCV13.setBackground(Color.GREEN);
                        }
                        if(Hora.equalsIgnoreCase("20")){
                            CV14.setSelected(true);
                            CV14.setEnabled(false);
                            PCV14.setBackground(Color.GREEN);
                        }
                    }                   
                }               
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void registrarHorario(String dia,int hora){
        int num=0;
        String NumEmpleado=ET1.getText();
        int seleccActividad=cbxActividad.getSelectedIndex();
        String actividad=cbxActividad.getItemAt(seleccActividad);
        String claveMateria=ET3.getText();
//        int materia=Integer.parseInt(claveMateria);
        int seleccSalon=cbxSalon.getSelectedIndex();
        String noSalon=cbxSalon.getItemAt(seleccSalon);
        int seleccGrupo=cbxGrupo.getSelectedIndex();
        String noGrupo=cbxGrupo.getItemAt(seleccGrupo);
        
        
        if(actividad.equalsIgnoreCase("CATEP")){
            int empleado=Integer.parseInt(NumEmpleado);
            entidadHorario.setTipoActividad(actividad);
            entidadHorario.setDia(dia);
            entidadHorario.setHora(hora);
            entidadHorario.setNumEmpleado(empleado);
            controlHorario.RegistrarHorarioProyectos(entidadHorario);
        }
        if(actividad.equalsIgnoreCase("Proyecto")){
            int empleado=Integer.parseInt(NumEmpleado);
            int materia1=Integer.parseInt(claveMateria);
            entidadHorario.setTipoActividad(actividad);
            entidadHorario.setDia(dia);
            entidadHorario.setHora(hora);
            entidadHorario.setClaveMateria(materia1);
            entidadHorario.setNumEmpleado(empleado);
            controlHorario.RegistrarHorarioProyectos(entidadHorario);
        }
        if(actividad.equalsIgnoreCase("Clases") || actividad.equalsIgnoreCase("Asesoria")){
            int empleado=Integer.parseInt(NumEmpleado);
            int materia=Integer.parseInt(claveMateria);
            int grupo=Integer.parseInt(noGrupo);

            datos2=noSalon.split("-");
            String idSalon1=datos2[0].trim();
            int salon=Integer.parseInt(idSalon1);
            entidadHorario.setTipoActividad(actividad);
            entidadHorario.setDia(dia);
            entidadHorario.setHora(hora);
            entidadHorario.setNumEmpleado(empleado);
            entidadHorario.setClaveMateria(materia);
            entidadHorario.setNumGrupo(grupo);
            entidadHorario.setNumSalon(salon);
            controlHorario.RegistrarHorario(entidadHorario);
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
        jPanel3 = new javax.swing.JPanel();
        cbxMaestro = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ET1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ET2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        ET7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMateria = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ET3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ET4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        ET5 = new javax.swing.JLabel();
        ET6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        PCL1 = new javax.swing.JPanel();
        CL1 = new javax.swing.JCheckBox();
        PCMA1 = new javax.swing.JPanel();
        CMA1 = new javax.swing.JCheckBox();
        PCM1 = new javax.swing.JPanel();
        CM1 = new javax.swing.JCheckBox();
        PCJ1 = new javax.swing.JPanel();
        CJ1 = new javax.swing.JCheckBox();
        PCV1 = new javax.swing.JPanel();
        CV1 = new javax.swing.JCheckBox();
        PCL2 = new javax.swing.JPanel();
        CL2 = new javax.swing.JCheckBox();
        PCMA2 = new javax.swing.JPanel();
        CMA2 = new javax.swing.JCheckBox();
        PCM2 = new javax.swing.JPanel();
        CM2 = new javax.swing.JCheckBox();
        PCJ2 = new javax.swing.JPanel();
        CJ2 = new javax.swing.JCheckBox();
        PCV2 = new javax.swing.JPanel();
        CV2 = new javax.swing.JCheckBox();
        PCL3 = new javax.swing.JPanel();
        CL3 = new javax.swing.JCheckBox();
        PCMA3 = new javax.swing.JPanel();
        CMA3 = new javax.swing.JCheckBox();
        PCM3 = new javax.swing.JPanel();
        CM3 = new javax.swing.JCheckBox();
        PCJ3 = new javax.swing.JPanel();
        CJ3 = new javax.swing.JCheckBox();
        PCV3 = new javax.swing.JPanel();
        CV3 = new javax.swing.JCheckBox();
        PCL4 = new javax.swing.JPanel();
        CL4 = new javax.swing.JCheckBox();
        PCMA4 = new javax.swing.JPanel();
        CMA4 = new javax.swing.JCheckBox();
        PCM4 = new javax.swing.JPanel();
        CM4 = new javax.swing.JCheckBox();
        PCJ4 = new javax.swing.JPanel();
        CJ4 = new javax.swing.JCheckBox();
        PCV4 = new javax.swing.JPanel();
        CV4 = new javax.swing.JCheckBox();
        PCL5 = new javax.swing.JPanel();
        CL5 = new javax.swing.JCheckBox();
        PCMA5 = new javax.swing.JPanel();
        CMA5 = new javax.swing.JCheckBox();
        PCM5 = new javax.swing.JPanel();
        CM5 = new javax.swing.JCheckBox();
        PCJ5 = new javax.swing.JPanel();
        CJ5 = new javax.swing.JCheckBox();
        PCV5 = new javax.swing.JPanel();
        CV5 = new javax.swing.JCheckBox();
        PCL6 = new javax.swing.JPanel();
        CL6 = new javax.swing.JCheckBox();
        PCMA6 = new javax.swing.JPanel();
        CMA6 = new javax.swing.JCheckBox();
        PCM6 = new javax.swing.JPanel();
        CM6 = new javax.swing.JCheckBox();
        PCJ6 = new javax.swing.JPanel();
        CJ6 = new javax.swing.JCheckBox();
        PCV6 = new javax.swing.JPanel();
        CV6 = new javax.swing.JCheckBox();
        PCL7 = new javax.swing.JPanel();
        CL7 = new javax.swing.JCheckBox();
        PCMA7 = new javax.swing.JPanel();
        CMA7 = new javax.swing.JCheckBox();
        PCM7 = new javax.swing.JPanel();
        CM7 = new javax.swing.JCheckBox();
        PCJ7 = new javax.swing.JPanel();
        CJ7 = new javax.swing.JCheckBox();
        PCV7 = new javax.swing.JPanel();
        CV7 = new javax.swing.JCheckBox();
        PCL8 = new javax.swing.JPanel();
        CL8 = new javax.swing.JCheckBox();
        PCMA8 = new javax.swing.JPanel();
        CMA8 = new javax.swing.JCheckBox();
        PCM8 = new javax.swing.JPanel();
        CM8 = new javax.swing.JCheckBox();
        PCJ8 = new javax.swing.JPanel();
        CJ8 = new javax.swing.JCheckBox();
        PCV8 = new javax.swing.JPanel();
        CV8 = new javax.swing.JCheckBox();
        PCL9 = new javax.swing.JPanel();
        CL9 = new javax.swing.JCheckBox();
        PCMA9 = new javax.swing.JPanel();
        CMA9 = new javax.swing.JCheckBox();
        PCM9 = new javax.swing.JPanel();
        CM9 = new javax.swing.JCheckBox();
        PCJ9 = new javax.swing.JPanel();
        CJ9 = new javax.swing.JCheckBox();
        PCV9 = new javax.swing.JPanel();
        CV9 = new javax.swing.JCheckBox();
        PCL10 = new javax.swing.JPanel();
        CL10 = new javax.swing.JCheckBox();
        PCMA10 = new javax.swing.JPanel();
        CMA10 = new javax.swing.JCheckBox();
        PCM10 = new javax.swing.JPanel();
        CM10 = new javax.swing.JCheckBox();
        PCJ10 = new javax.swing.JPanel();
        CJ10 = new javax.swing.JCheckBox();
        PCV10 = new javax.swing.JPanel();
        CV10 = new javax.swing.JCheckBox();
        PCL11 = new javax.swing.JPanel();
        CL11 = new javax.swing.JCheckBox();
        PCMA11 = new javax.swing.JPanel();
        CMA11 = new javax.swing.JCheckBox();
        PCM11 = new javax.swing.JPanel();
        CM11 = new javax.swing.JCheckBox();
        PCJ11 = new javax.swing.JPanel();
        CJ11 = new javax.swing.JCheckBox();
        PCV11 = new javax.swing.JPanel();
        CV11 = new javax.swing.JCheckBox();
        PCL12 = new javax.swing.JPanel();
        CL12 = new javax.swing.JCheckBox();
        PCMA12 = new javax.swing.JPanel();
        CMA12 = new javax.swing.JCheckBox();
        PCM12 = new javax.swing.JPanel();
        CM12 = new javax.swing.JCheckBox();
        PCJ12 = new javax.swing.JPanel();
        CJ12 = new javax.swing.JCheckBox();
        PCV12 = new javax.swing.JPanel();
        CV12 = new javax.swing.JCheckBox();
        PCL13 = new javax.swing.JPanel();
        CL13 = new javax.swing.JCheckBox();
        PCMA13 = new javax.swing.JPanel();
        CMA13 = new javax.swing.JCheckBox();
        PCM13 = new javax.swing.JPanel();
        CM13 = new javax.swing.JCheckBox();
        PCJ13 = new javax.swing.JPanel();
        CJ13 = new javax.swing.JCheckBox();
        PCV13 = new javax.swing.JPanel();
        CV13 = new javax.swing.JCheckBox();
        PCL14 = new javax.swing.JPanel();
        CL14 = new javax.swing.JCheckBox();
        PCMA14 = new javax.swing.JPanel();
        CMA14 = new javax.swing.JCheckBox();
        PCM14 = new javax.swing.JPanel();
        CM14 = new javax.swing.JCheckBox();
        PCJ14 = new javax.swing.JPanel();
        CJ14 = new javax.swing.JCheckBox();
        PCV14 = new javax.swing.JPanel();
        CV14 = new javax.swing.JCheckBox();
        PCV15 = new javax.swing.JPanel();
        CS1 = new javax.swing.JCheckBox();
        PCV16 = new javax.swing.JPanel();
        CS2 = new javax.swing.JCheckBox();
        PCV17 = new javax.swing.JPanel();
        CS3 = new javax.swing.JCheckBox();
        PCV18 = new javax.swing.JPanel();
        CS4 = new javax.swing.JCheckBox();
        PCV19 = new javax.swing.JPanel();
        CS5 = new javax.swing.JCheckBox();
        PCV20 = new javax.swing.JPanel();
        CS6 = new javax.swing.JCheckBox();
        PCV21 = new javax.swing.JPanel();
        CS7 = new javax.swing.JCheckBox();
        PCV22 = new javax.swing.JPanel();
        CS8 = new javax.swing.JCheckBox();
        PCV23 = new javax.swing.JPanel();
        CS9 = new javax.swing.JCheckBox();
        PCV24 = new javax.swing.JPanel();
        CS10 = new javax.swing.JCheckBox();
        PCV25 = new javax.swing.JPanel();
        CS11 = new javax.swing.JCheckBox();
        PCV26 = new javax.swing.JPanel();
        CS12 = new javax.swing.JCheckBox();
        PCV27 = new javax.swing.JPanel();
        CS13 = new javax.swing.JCheckBox();
        PCV28 = new javax.swing.JPanel();
        CS14 = new javax.swing.JCheckBox();
        btnSiguiente = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxActividad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxSalon = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxGrupo = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        eje1 = new javax.swing.JPanel();
        CSEJE = new javax.swing.JCheckBox();
        eje2 = new javax.swing.JPanel();
        CSEJE1 = new javax.swing.JCheckBox();
        eje3 = new javax.swing.JPanel();
        CSEJE2 = new javax.swing.JCheckBox();
        eje4 = new javax.swing.JPanel();
        CSEJE3 = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Asignar Horario");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccione Maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        cbxMaestro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxMaestro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Maestro" }));

        btnAceptar.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addComponent(cbxMaestro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informacion del maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Numero Empleado");

        ET1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");

        ET2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Horas");

        ET7.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(ET1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ET2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ET7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ET1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ET7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccione Materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tbMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Clave", "Nombre Materia"
            }
        ));
        tbMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMateriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMateria);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Clave Materia:");

        ET3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Nombre Materia:");

        ET4.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Horas:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Semestre:");

        ET5.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        ET6.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ET3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ET4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ET6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ET5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ET3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ET6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ET4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Horario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("10:00-11:00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("08:00-09:00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("07:00-08:00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("09:00-10:00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("19:00-20:00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("15:00-16:00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("14:00-15:00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("17:00-18:00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("16:00-17:00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("11:00-12:00");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("12:00-13:00");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("18:00-19:00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("13:00-14:00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("M");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("L");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("20:00-21:00");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("M");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("V");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("J");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("S");

        PCL1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL1.setPreferredSize(new java.awt.Dimension(22, 22));

        CL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL1Layout = new javax.swing.GroupLayout(PCL1);
        PCL1.setLayout(PCL1Layout);
        PCL1Layout.setHorizontalGroup(
            PCL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL1Layout.setVerticalGroup(
            PCL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA1.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA1Layout = new javax.swing.GroupLayout(PCMA1);
        PCMA1.setLayout(PCMA1Layout);
        PCMA1Layout.setHorizontalGroup(
            PCMA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA1Layout.setVerticalGroup(
            PCMA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM1.setPreferredSize(new java.awt.Dimension(22, 22));

        CM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM1Layout = new javax.swing.GroupLayout(PCM1);
        PCM1.setLayout(PCM1Layout);
        PCM1Layout.setHorizontalGroup(
            PCM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM1Layout.setVerticalGroup(
            PCM1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ1.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ1Layout = new javax.swing.GroupLayout(PCJ1);
        PCJ1.setLayout(PCJ1Layout);
        PCJ1Layout.setHorizontalGroup(
            PCJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ1Layout.setVerticalGroup(
            PCJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV1.setPreferredSize(new java.awt.Dimension(22, 22));

        CV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV1Layout = new javax.swing.GroupLayout(PCV1);
        PCV1.setLayout(PCV1Layout);
        PCV1Layout.setHorizontalGroup(
            PCV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV1Layout.setVerticalGroup(
            PCV1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL2.setPreferredSize(new java.awt.Dimension(22, 22));

        CL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL2Layout = new javax.swing.GroupLayout(PCL2);
        PCL2.setLayout(PCL2Layout);
        PCL2Layout.setHorizontalGroup(
            PCL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL2Layout.setVerticalGroup(
            PCL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA2.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA2Layout = new javax.swing.GroupLayout(PCMA2);
        PCMA2.setLayout(PCMA2Layout);
        PCMA2Layout.setHorizontalGroup(
            PCMA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA2Layout.setVerticalGroup(
            PCMA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM2.setPreferredSize(new java.awt.Dimension(22, 22));

        CM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM2Layout = new javax.swing.GroupLayout(PCM2);
        PCM2.setLayout(PCM2Layout);
        PCM2Layout.setHorizontalGroup(
            PCM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM2Layout.setVerticalGroup(
            PCM2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ2.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ2Layout = new javax.swing.GroupLayout(PCJ2);
        PCJ2.setLayout(PCJ2Layout);
        PCJ2Layout.setHorizontalGroup(
            PCJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ2Layout.setVerticalGroup(
            PCJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV2.setPreferredSize(new java.awt.Dimension(22, 22));

        CV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV2Layout = new javax.swing.GroupLayout(PCV2);
        PCV2.setLayout(PCV2Layout);
        PCV2Layout.setHorizontalGroup(
            PCV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV2Layout.setVerticalGroup(
            PCV2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL3.setPreferredSize(new java.awt.Dimension(22, 22));

        CL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL3Layout = new javax.swing.GroupLayout(PCL3);
        PCL3.setLayout(PCL3Layout);
        PCL3Layout.setHorizontalGroup(
            PCL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL3Layout.setVerticalGroup(
            PCL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA3.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA3Layout = new javax.swing.GroupLayout(PCMA3);
        PCMA3.setLayout(PCMA3Layout);
        PCMA3Layout.setHorizontalGroup(
            PCMA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA3Layout.setVerticalGroup(
            PCMA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM3.setPreferredSize(new java.awt.Dimension(22, 22));

        CM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM3Layout = new javax.swing.GroupLayout(PCM3);
        PCM3.setLayout(PCM3Layout);
        PCM3Layout.setHorizontalGroup(
            PCM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM3Layout.setVerticalGroup(
            PCM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ3.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ3Layout = new javax.swing.GroupLayout(PCJ3);
        PCJ3.setLayout(PCJ3Layout);
        PCJ3Layout.setHorizontalGroup(
            PCJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ3Layout.setVerticalGroup(
            PCJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV3.setPreferredSize(new java.awt.Dimension(22, 22));

        CV3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV3Layout = new javax.swing.GroupLayout(PCV3);
        PCV3.setLayout(PCV3Layout);
        PCV3Layout.setHorizontalGroup(
            PCV3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV3Layout.setVerticalGroup(
            PCV3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL4.setPreferredSize(new java.awt.Dimension(22, 22));

        CL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL4Layout = new javax.swing.GroupLayout(PCL4);
        PCL4.setLayout(PCL4Layout);
        PCL4Layout.setHorizontalGroup(
            PCL4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL4Layout.setVerticalGroup(
            PCL4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA4.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA4Layout = new javax.swing.GroupLayout(PCMA4);
        PCMA4.setLayout(PCMA4Layout);
        PCMA4Layout.setHorizontalGroup(
            PCMA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA4Layout.setVerticalGroup(
            PCMA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM4.setPreferredSize(new java.awt.Dimension(22, 22));

        CM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM4Layout = new javax.swing.GroupLayout(PCM4);
        PCM4.setLayout(PCM4Layout);
        PCM4Layout.setHorizontalGroup(
            PCM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM4Layout.setVerticalGroup(
            PCM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ4.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ4Layout = new javax.swing.GroupLayout(PCJ4);
        PCJ4.setLayout(PCJ4Layout);
        PCJ4Layout.setHorizontalGroup(
            PCJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ4Layout.setVerticalGroup(
            PCJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV4.setPreferredSize(new java.awt.Dimension(22, 22));

        CV4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV4Layout = new javax.swing.GroupLayout(PCV4);
        PCV4.setLayout(PCV4Layout);
        PCV4Layout.setHorizontalGroup(
            PCV4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV4Layout.setVerticalGroup(
            PCV4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL5.setPreferredSize(new java.awt.Dimension(22, 22));

        CL5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL5Layout = new javax.swing.GroupLayout(PCL5);
        PCL5.setLayout(PCL5Layout);
        PCL5Layout.setHorizontalGroup(
            PCL5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL5Layout.setVerticalGroup(
            PCL5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA5.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA5Layout = new javax.swing.GroupLayout(PCMA5);
        PCMA5.setLayout(PCMA5Layout);
        PCMA5Layout.setHorizontalGroup(
            PCMA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA5Layout.setVerticalGroup(
            PCMA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM5.setPreferredSize(new java.awt.Dimension(22, 22));

        CM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM5Layout = new javax.swing.GroupLayout(PCM5);
        PCM5.setLayout(PCM5Layout);
        PCM5Layout.setHorizontalGroup(
            PCM5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM5Layout.setVerticalGroup(
            PCM5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ5.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ5Layout = new javax.swing.GroupLayout(PCJ5);
        PCJ5.setLayout(PCJ5Layout);
        PCJ5Layout.setHorizontalGroup(
            PCJ5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ5Layout.setVerticalGroup(
            PCJ5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV5.setPreferredSize(new java.awt.Dimension(22, 22));

        CV5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV5Layout = new javax.swing.GroupLayout(PCV5);
        PCV5.setLayout(PCV5Layout);
        PCV5Layout.setHorizontalGroup(
            PCV5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV5Layout.setVerticalGroup(
            PCV5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL6.setPreferredSize(new java.awt.Dimension(22, 22));

        CL6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL6Layout = new javax.swing.GroupLayout(PCL6);
        PCL6.setLayout(PCL6Layout);
        PCL6Layout.setHorizontalGroup(
            PCL6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL6Layout.setVerticalGroup(
            PCL6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA6.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA6Layout = new javax.swing.GroupLayout(PCMA6);
        PCMA6.setLayout(PCMA6Layout);
        PCMA6Layout.setHorizontalGroup(
            PCMA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA6Layout.setVerticalGroup(
            PCMA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM6.setPreferredSize(new java.awt.Dimension(22, 22));

        CM6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM6Layout = new javax.swing.GroupLayout(PCM6);
        PCM6.setLayout(PCM6Layout);
        PCM6Layout.setHorizontalGroup(
            PCM6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM6Layout.setVerticalGroup(
            PCM6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ6.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ6Layout = new javax.swing.GroupLayout(PCJ6);
        PCJ6.setLayout(PCJ6Layout);
        PCJ6Layout.setHorizontalGroup(
            PCJ6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ6Layout.setVerticalGroup(
            PCJ6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV6.setPreferredSize(new java.awt.Dimension(22, 22));

        CV6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV6Layout = new javax.swing.GroupLayout(PCV6);
        PCV6.setLayout(PCV6Layout);
        PCV6Layout.setHorizontalGroup(
            PCV6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV6Layout.setVerticalGroup(
            PCV6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL7.setPreferredSize(new java.awt.Dimension(22, 22));

        CL7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL7Layout = new javax.swing.GroupLayout(PCL7);
        PCL7.setLayout(PCL7Layout);
        PCL7Layout.setHorizontalGroup(
            PCL7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL7Layout.setVerticalGroup(
            PCL7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA7.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA7Layout = new javax.swing.GroupLayout(PCMA7);
        PCMA7.setLayout(PCMA7Layout);
        PCMA7Layout.setHorizontalGroup(
            PCMA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA7Layout.setVerticalGroup(
            PCMA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM7.setPreferredSize(new java.awt.Dimension(22, 22));

        CM7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM7Layout = new javax.swing.GroupLayout(PCM7);
        PCM7.setLayout(PCM7Layout);
        PCM7Layout.setHorizontalGroup(
            PCM7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM7Layout.setVerticalGroup(
            PCM7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ7.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ7Layout = new javax.swing.GroupLayout(PCJ7);
        PCJ7.setLayout(PCJ7Layout);
        PCJ7Layout.setHorizontalGroup(
            PCJ7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ7Layout.setVerticalGroup(
            PCJ7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV7.setPreferredSize(new java.awt.Dimension(22, 22));

        CV7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV7Layout = new javax.swing.GroupLayout(PCV7);
        PCV7.setLayout(PCV7Layout);
        PCV7Layout.setHorizontalGroup(
            PCV7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV7Layout.setVerticalGroup(
            PCV7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL8.setPreferredSize(new java.awt.Dimension(22, 22));

        CL8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL8Layout = new javax.swing.GroupLayout(PCL8);
        PCL8.setLayout(PCL8Layout);
        PCL8Layout.setHorizontalGroup(
            PCL8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL8Layout.setVerticalGroup(
            PCL8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA8.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA8Layout = new javax.swing.GroupLayout(PCMA8);
        PCMA8.setLayout(PCMA8Layout);
        PCMA8Layout.setHorizontalGroup(
            PCMA8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA8Layout.setVerticalGroup(
            PCMA8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM8.setPreferredSize(new java.awt.Dimension(22, 22));

        CM8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM8Layout = new javax.swing.GroupLayout(PCM8);
        PCM8.setLayout(PCM8Layout);
        PCM8Layout.setHorizontalGroup(
            PCM8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM8Layout.setVerticalGroup(
            PCM8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ8.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ8Layout = new javax.swing.GroupLayout(PCJ8);
        PCJ8.setLayout(PCJ8Layout);
        PCJ8Layout.setHorizontalGroup(
            PCJ8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ8Layout.setVerticalGroup(
            PCJ8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV8.setPreferredSize(new java.awt.Dimension(22, 22));

        CV8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV8Layout = new javax.swing.GroupLayout(PCV8);
        PCV8.setLayout(PCV8Layout);
        PCV8Layout.setHorizontalGroup(
            PCV8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV8Layout.setVerticalGroup(
            PCV8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL9.setPreferredSize(new java.awt.Dimension(22, 22));

        CL9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL9Layout = new javax.swing.GroupLayout(PCL9);
        PCL9.setLayout(PCL9Layout);
        PCL9Layout.setHorizontalGroup(
            PCL9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL9Layout.setVerticalGroup(
            PCL9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA9.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA9Layout = new javax.swing.GroupLayout(PCMA9);
        PCMA9.setLayout(PCMA9Layout);
        PCMA9Layout.setHorizontalGroup(
            PCMA9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA9Layout.setVerticalGroup(
            PCMA9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM9.setPreferredSize(new java.awt.Dimension(22, 22));

        CM9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM9Layout = new javax.swing.GroupLayout(PCM9);
        PCM9.setLayout(PCM9Layout);
        PCM9Layout.setHorizontalGroup(
            PCM9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM9Layout.setVerticalGroup(
            PCM9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ9.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ9Layout = new javax.swing.GroupLayout(PCJ9);
        PCJ9.setLayout(PCJ9Layout);
        PCJ9Layout.setHorizontalGroup(
            PCJ9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ9Layout.setVerticalGroup(
            PCJ9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV9.setPreferredSize(new java.awt.Dimension(22, 22));

        CV9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV9Layout = new javax.swing.GroupLayout(PCV9);
        PCV9.setLayout(PCV9Layout);
        PCV9Layout.setHorizontalGroup(
            PCV9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV9Layout.setVerticalGroup(
            PCV9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL10.setPreferredSize(new java.awt.Dimension(22, 22));

        CL10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL10Layout = new javax.swing.GroupLayout(PCL10);
        PCL10.setLayout(PCL10Layout);
        PCL10Layout.setHorizontalGroup(
            PCL10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL10Layout.setVerticalGroup(
            PCL10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA10.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA10Layout = new javax.swing.GroupLayout(PCMA10);
        PCMA10.setLayout(PCMA10Layout);
        PCMA10Layout.setHorizontalGroup(
            PCMA10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA10Layout.setVerticalGroup(
            PCMA10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM10.setPreferredSize(new java.awt.Dimension(22, 22));

        CM10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM10Layout = new javax.swing.GroupLayout(PCM10);
        PCM10.setLayout(PCM10Layout);
        PCM10Layout.setHorizontalGroup(
            PCM10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM10Layout.setVerticalGroup(
            PCM10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ10.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ10Layout = new javax.swing.GroupLayout(PCJ10);
        PCJ10.setLayout(PCJ10Layout);
        PCJ10Layout.setHorizontalGroup(
            PCJ10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ10Layout.setVerticalGroup(
            PCJ10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV10.setPreferredSize(new java.awt.Dimension(22, 22));

        CV10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV10Layout = new javax.swing.GroupLayout(PCV10);
        PCV10.setLayout(PCV10Layout);
        PCV10Layout.setHorizontalGroup(
            PCV10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV10Layout.setVerticalGroup(
            PCV10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL11.setPreferredSize(new java.awt.Dimension(22, 22));

        CL11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL11Layout = new javax.swing.GroupLayout(PCL11);
        PCL11.setLayout(PCL11Layout);
        PCL11Layout.setHorizontalGroup(
            PCL11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL11Layout.setVerticalGroup(
            PCL11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA11.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA11Layout = new javax.swing.GroupLayout(PCMA11);
        PCMA11.setLayout(PCMA11Layout);
        PCMA11Layout.setHorizontalGroup(
            PCMA11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA11Layout.setVerticalGroup(
            PCMA11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM11.setPreferredSize(new java.awt.Dimension(22, 22));

        CM11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM11Layout = new javax.swing.GroupLayout(PCM11);
        PCM11.setLayout(PCM11Layout);
        PCM11Layout.setHorizontalGroup(
            PCM11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM11Layout.setVerticalGroup(
            PCM11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ11.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ11Layout = new javax.swing.GroupLayout(PCJ11);
        PCJ11.setLayout(PCJ11Layout);
        PCJ11Layout.setHorizontalGroup(
            PCJ11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ11Layout.setVerticalGroup(
            PCJ11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV11.setPreferredSize(new java.awt.Dimension(22, 22));

        CV11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV11Layout = new javax.swing.GroupLayout(PCV11);
        PCV11.setLayout(PCV11Layout);
        PCV11Layout.setHorizontalGroup(
            PCV11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV11Layout.setVerticalGroup(
            PCV11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL12.setPreferredSize(new java.awt.Dimension(22, 22));

        CL12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL12Layout = new javax.swing.GroupLayout(PCL12);
        PCL12.setLayout(PCL12Layout);
        PCL12Layout.setHorizontalGroup(
            PCL12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL12Layout.setVerticalGroup(
            PCL12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA12.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA12Layout = new javax.swing.GroupLayout(PCMA12);
        PCMA12.setLayout(PCMA12Layout);
        PCMA12Layout.setHorizontalGroup(
            PCMA12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA12Layout.setVerticalGroup(
            PCMA12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM12.setPreferredSize(new java.awt.Dimension(22, 22));

        CM12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM12Layout = new javax.swing.GroupLayout(PCM12);
        PCM12.setLayout(PCM12Layout);
        PCM12Layout.setHorizontalGroup(
            PCM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM12Layout.setVerticalGroup(
            PCM12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ12.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ12Layout = new javax.swing.GroupLayout(PCJ12);
        PCJ12.setLayout(PCJ12Layout);
        PCJ12Layout.setHorizontalGroup(
            PCJ12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ12Layout.setVerticalGroup(
            PCJ12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV12.setPreferredSize(new java.awt.Dimension(22, 22));

        CV12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV12Layout = new javax.swing.GroupLayout(PCV12);
        PCV12.setLayout(PCV12Layout);
        PCV12Layout.setHorizontalGroup(
            PCV12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV12Layout.setVerticalGroup(
            PCV12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL13.setPreferredSize(new java.awt.Dimension(22, 22));

        CL13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL13Layout = new javax.swing.GroupLayout(PCL13);
        PCL13.setLayout(PCL13Layout);
        PCL13Layout.setHorizontalGroup(
            PCL13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL13Layout.setVerticalGroup(
            PCL13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA13.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA13Layout = new javax.swing.GroupLayout(PCMA13);
        PCMA13.setLayout(PCMA13Layout);
        PCMA13Layout.setHorizontalGroup(
            PCMA13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA13Layout.setVerticalGroup(
            PCMA13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM13.setPreferredSize(new java.awt.Dimension(22, 22));

        CM13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM13Layout = new javax.swing.GroupLayout(PCM13);
        PCM13.setLayout(PCM13Layout);
        PCM13Layout.setHorizontalGroup(
            PCM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM13Layout.setVerticalGroup(
            PCM13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ13.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ13Layout = new javax.swing.GroupLayout(PCJ13);
        PCJ13.setLayout(PCJ13Layout);
        PCJ13Layout.setHorizontalGroup(
            PCJ13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ13Layout.setVerticalGroup(
            PCJ13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV13.setPreferredSize(new java.awt.Dimension(22, 22));

        CV13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV13Layout = new javax.swing.GroupLayout(PCV13);
        PCV13.setLayout(PCV13Layout);
        PCV13Layout.setHorizontalGroup(
            PCV13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV13Layout.setVerticalGroup(
            PCV13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCL14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCL14.setPreferredSize(new java.awt.Dimension(22, 22));

        CL14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CL14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCL14Layout = new javax.swing.GroupLayout(PCL14);
        PCL14.setLayout(PCL14Layout);
        PCL14Layout.setHorizontalGroup(
            PCL14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCL14Layout.setVerticalGroup(
            PCL14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCL14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CL14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCMA14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCMA14.setPreferredSize(new java.awt.Dimension(22, 22));

        CMA14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMA14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCMA14Layout = new javax.swing.GroupLayout(PCMA14);
        PCMA14.setLayout(PCMA14Layout);
        PCMA14Layout.setHorizontalGroup(
            PCMA14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCMA14Layout.setVerticalGroup(
            PCMA14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCMA14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CMA14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCM14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCM14.setPreferredSize(new java.awt.Dimension(22, 22));

        CM14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CM14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCM14Layout = new javax.swing.GroupLayout(PCM14);
        PCM14.setLayout(PCM14Layout);
        PCM14Layout.setHorizontalGroup(
            PCM14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCM14Layout.setVerticalGroup(
            PCM14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCM14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CM14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCJ14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCJ14.setPreferredSize(new java.awt.Dimension(22, 22));

        CJ14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CJ14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCJ14Layout = new javax.swing.GroupLayout(PCJ14);
        PCJ14.setLayout(PCJ14Layout);
        PCJ14Layout.setHorizontalGroup(
            PCJ14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCJ14Layout.setVerticalGroup(
            PCJ14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCJ14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CJ14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV14.setPreferredSize(new java.awt.Dimension(22, 22));

        CV14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CV14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PCV14Layout = new javax.swing.GroupLayout(PCV14);
        PCV14.setLayout(PCV14Layout);
        PCV14Layout.setHorizontalGroup(
            PCV14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV14Layout.setVerticalGroup(
            PCV14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CV14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV15.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV15Layout = new javax.swing.GroupLayout(PCV15);
        PCV15.setLayout(PCV15Layout);
        PCV15Layout.setHorizontalGroup(
            PCV15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV15Layout.setVerticalGroup(
            PCV15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV16.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV16Layout = new javax.swing.GroupLayout(PCV16);
        PCV16.setLayout(PCV16Layout);
        PCV16Layout.setHorizontalGroup(
            PCV16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV16Layout.setVerticalGroup(
            PCV16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV17.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV17Layout = new javax.swing.GroupLayout(PCV17);
        PCV17.setLayout(PCV17Layout);
        PCV17Layout.setHorizontalGroup(
            PCV17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV17Layout.setVerticalGroup(
            PCV17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV18.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV18Layout = new javax.swing.GroupLayout(PCV18);
        PCV18.setLayout(PCV18Layout);
        PCV18Layout.setHorizontalGroup(
            PCV18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV18Layout.setVerticalGroup(
            PCV18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV19.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV19Layout = new javax.swing.GroupLayout(PCV19);
        PCV19.setLayout(PCV19Layout);
        PCV19Layout.setHorizontalGroup(
            PCV19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV19Layout.setVerticalGroup(
            PCV19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV20.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV20Layout = new javax.swing.GroupLayout(PCV20);
        PCV20.setLayout(PCV20Layout);
        PCV20Layout.setHorizontalGroup(
            PCV20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV20Layout.setVerticalGroup(
            PCV20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV21.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV21Layout = new javax.swing.GroupLayout(PCV21);
        PCV21.setLayout(PCV21Layout);
        PCV21Layout.setHorizontalGroup(
            PCV21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV21Layout.setVerticalGroup(
            PCV21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV22.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV22Layout = new javax.swing.GroupLayout(PCV22);
        PCV22.setLayout(PCV22Layout);
        PCV22Layout.setHorizontalGroup(
            PCV22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV22Layout.setVerticalGroup(
            PCV22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV23.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV23Layout = new javax.swing.GroupLayout(PCV23);
        PCV23.setLayout(PCV23Layout);
        PCV23Layout.setHorizontalGroup(
            PCV23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV23Layout.setVerticalGroup(
            PCV23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV24.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV24Layout = new javax.swing.GroupLayout(PCV24);
        PCV24.setLayout(PCV24Layout);
        PCV24Layout.setHorizontalGroup(
            PCV24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV24Layout.setVerticalGroup(
            PCV24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV25.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV25Layout = new javax.swing.GroupLayout(PCV25);
        PCV25.setLayout(PCV25Layout);
        PCV25Layout.setHorizontalGroup(
            PCV25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV25Layout.setVerticalGroup(
            PCV25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV26.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV26Layout = new javax.swing.GroupLayout(PCV26);
        PCV26.setLayout(PCV26Layout);
        PCV26Layout.setHorizontalGroup(
            PCV26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV26Layout.setVerticalGroup(
            PCV26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV27.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV27Layout = new javax.swing.GroupLayout(PCV27);
        PCV27.setLayout(PCV27Layout);
        PCV27Layout.setHorizontalGroup(
            PCV27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV27Layout.setVerticalGroup(
            PCV27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PCV28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PCV28.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout PCV28Layout = new javax.swing.GroupLayout(PCV28);
        PCV28.setLayout(PCV28Layout);
        PCV28Layout.setHorizontalGroup(
            PCV28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PCV28Layout.setVerticalGroup(
            PCV28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCV28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CS14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PCL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCMA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCV16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCMA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PCV15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PCL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PCL8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PCMA8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCL13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(PCL14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCMA14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCM14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCJ14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCV28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnSiguiente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguiente.setText("Agregar Horario");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de Actividad: ");

        cbxActividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Selecciona Actividad)", "Clases", "Asesoria", "Proyecto", "CATEP" }));
        cbxActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxActividadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Seleccionar Salon");

        cbxSalon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxSalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Selecciona Salon)" }));
        cbxSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSalonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Seleccionar Grupo");

        cbxGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Selecciona Grupo)" }));
        cbxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbxActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbxSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cbxActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cbxSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leyenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        eje1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eje1.setPreferredSize(new java.awt.Dimension(22, 22));

        CSEJE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSEJEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eje1Layout = new javax.swing.GroupLayout(eje1);
        eje1.setLayout(eje1Layout);
        eje1Layout.setHorizontalGroup(
            eje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        eje1Layout.setVerticalGroup(
            eje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        eje2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eje2.setPreferredSize(new java.awt.Dimension(22, 22));

        CSEJE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSEJE1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eje2Layout = new javax.swing.GroupLayout(eje2);
        eje2.setLayout(eje2Layout);
        eje2Layout.setHorizontalGroup(
            eje2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        eje2Layout.setVerticalGroup(
            eje2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        eje3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eje3.setPreferredSize(new java.awt.Dimension(22, 22));

        CSEJE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSEJE2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eje3Layout = new javax.swing.GroupLayout(eje3);
        eje3.setLayout(eje3Layout);
        eje3Layout.setHorizontalGroup(
            eje3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        eje3Layout.setVerticalGroup(
            eje3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        eje4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eje4.setPreferredSize(new java.awt.Dimension(22, 22));

        CSEJE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSEJE3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eje4Layout = new javax.swing.GroupLayout(eje4);
        eje4.setLayout(eje4Layout);
        eje4Layout.setHorizontalGroup(
            eje4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        eje4Layout.setVerticalGroup(
            eje4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eje4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CSEJE3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Horario Actual de Maestro");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Horas Disponibles");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Horario del Grupo");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Horario del Salon");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eje3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eje4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eje3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eje4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Horas:");

        txtHoras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHoras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHoras.setText("0");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                int numBuscar=Integer.parseInt(clave);
                mostrarMaestroEspecifico(numBuscar);
                mostrarMateriasAsignadas(numBuscar);
                btnAceptar.setEnabled(false);
                cbxMaestro.setEnabled(false);
                cbxActividad.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(InterfazAsignarHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void tbMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMateriaMouseClicked
        try {
            String cadena="";
            String mensaje[]=null;
            // TODO add your handling code here:
            String numEmpleado=ET1.getText();
            
            if(numEmpleado.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Seleccione Maestro");
            }
            else{
                String materia=ET3.getText();
                if(materia.equalsIgnoreCase("")){
                    int fila=tbMateria.rowAtPoint(evt.getPoint());
                    String clave=tbMateria.getValueAt(fila, 1).toString();
                    cadena=controlMateria.consultarMateriaEspecifico(clave);
                    mensaje=cadena.split("-");
                    ET3.setText(mensaje[0].trim());
                    ET4.setText(mensaje[1].trim());
                    ET6.setText(mensaje[2].trim());
                    ET5.setText(mensaje[3].trim());
                    String semestre=mensaje[2].trim();
                    int semestreNum=Integer.parseInt(semestre);

                    
//                    btnSiguiente.setEnabled(true);
                    mostrarGrupos(semestreNum);
                    mostrarSalon();
                    cbxActividad.setEnabled(true);
                }
                
            }
            
            
            
            
                
                
            
            
            
//            JOptionPane.showMessageDialog(null, "Recibi de: "+semestreNum);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAsignarHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tbMateriaMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        // TODO add your handling code here:
        String numeroMaestro=ET1.getText();
        String Materia=ET3.getText();
        int seleccionActividad=cbxActividad.getSelectedIndex();
        String actividad=(String) cbxActividad.getItemAt(seleccionActividad);
        int seleccionGrupo=cbxGrupo.getSelectedIndex();
        String grupo=(String) cbxGrupo.getItemAt(seleccionGrupo);
        
        int seleccionSalon=cbxSalon.getSelectedIndex();
        String salon=(String) cbxSalon.getItemAt(seleccionSalon);
        
        if(actividad.equalsIgnoreCase("(Selecciona Actividad)")){
            JOptionPane.showMessageDialog(null, "Seleccione una actividad");
        }
        else{
            if(actividad.equalsIgnoreCase("Proyecto") || actividad.equalsIgnoreCase("CATEP")){
            int numBuscar=Integer.parseInt(numeroMaestro);
            deshabilitar();
            mostrarDisponibilidadMaestro(numBuscar);
            int numempl=Integer.parseInt(numeroMaestro);
            mostrarHorarioMaestro(numempl);
            }
            if(ET3.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Seleccione materia");
            }
            else{
                if(actividad.equalsIgnoreCase("Clases") || actividad.equalsIgnoreCase("Asesoria")){
                    if(grupo.equalsIgnoreCase("(Selecciona Grupo)")){
                        JOptionPane.showMessageDialog(null, "Seleccione Grupo");
                    }
                    else{
                        if(salon.equalsIgnoreCase("(Selecciona Salon)")){
                            JOptionPane.showMessageDialog(null, "Seleccione Salon");
                        }
                        else{
                            salon1=salon.split("-");
                            int idsalon=Integer.parseInt(salon1[0].trim());
                            int numBuscar=Integer.parseInt(numeroMaestro);
                            int nGrupo=Integer.parseInt(grupo);
                            int consul=controlHorario.consultarGrupoMateria(numBuscar,nGrupo);
                            
                            deshabilitar();
                            int numempl=Integer.parseInt(numeroMaestro);
                            mostrarDisponibilidadMaestro(numBuscar);
                            mostrarDisponibilidadGrupo(nGrupo);
                            mostrarHorarioSalon(idsalon);
                            mostrarHorarioMaestro(numempl);   
                        }
        
                    }
                }
            }
        }       
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void cbxActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxActividadActionPerformed
        // TODO add your handling code here:

            if(evt.getSource()==cbxActividad){
                int valor=cbxMaestro.getSelectedIndex();
                String seleccion=cbxActividad.getItemAt(valor);
                if(cbxActividad.getSelectedItem().equals("Clases") || cbxActividad.getSelectedItem().equals("Asesoria")){
                    cbxSalon.setEnabled(true);
                    cbxGrupo.setEnabled(true);
                    btnSiguiente.setEnabled(true);
                }
                if(cbxActividad.getSelectedItem().equals("CATEP") || cbxActividad.getSelectedItem().equals("Proyecto")){
                    cbxSalon.setEnabled(false);
                    cbxGrupo.setEnabled(false);
                    btnSiguiente.setEnabled(true);
                }
            }



 
    }//GEN-LAST:event_cbxActividadActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        habilitarCancelar();
        desactivarSeleccion();
        colorInicial();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked
    //Consulta especifica por solon si ya esta asignada la materia con otro maestro
    private void cbxSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSalonActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_cbxSalonActionPerformed

    private void cbxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGrupoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxGrupoActionPerformed

    private void CSEJEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSEJEActionPerformed
        // TODO add your handling code here:
        boolean valor=CSEJE.isSelected();
        if(valor==true){
            eje1.setBackground(Color.yellow);
        }
        
    }//GEN-LAST:event_CSEJEActionPerformed

    private void CL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL1ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=7;
        boolean valor=CL1.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL1.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL1ActionPerformed

    private void CL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL2ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=8;
        boolean valor=CL2.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL2.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL2ActionPerformed

    private void CL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL3ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=9;
        boolean valor=CL3.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL3.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL3ActionPerformed

    private void CL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL4ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=10;
        boolean valor=CL4.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL4.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL4ActionPerformed

    private void CL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL5ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=11;
        boolean valor=CL5.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL5.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL5ActionPerformed

    private void CL6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL6ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=12;
        boolean valor=CL6.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL6.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL6ActionPerformed

    private void CL7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL7ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=13;
        boolean valor=CL7.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL7.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL7ActionPerformed

    private void CL8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL8ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=14;
        boolean valor=CL8.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL8.setSelected(false);
            }
            registrarHorario(Dia,Hora);
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL8ActionPerformed

    private void CL9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL9ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=15;
        boolean valor=CL9.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL9.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL9ActionPerformed

    private void CL10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL10ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=16;
        boolean valor=CL10.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL10.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL10ActionPerformed

    private void CL11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL11ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=17;
        boolean valor=CL11.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL11.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL11ActionPerformed

    private void CL12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL12ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=18;
        boolean valor=CL12.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL12.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL12ActionPerformed

    private void CL13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL13ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=19;
        boolean valor=CL13.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL13.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL13ActionPerformed

    private void CL14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CL14ActionPerformed
        // TODO add your handling code here:
        String Dia="Lunes";
        int Hora=20;
        boolean valor=CL14.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CL14.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CL14ActionPerformed

    private void CMA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA1ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=7;
        boolean valor=CMA1.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA1.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA1ActionPerformed

    private void CMA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA2ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=8;
        boolean valor=CMA2.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA2.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA2ActionPerformed

    private void CMA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA3ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=9;
        boolean valor=CMA3.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA3.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA3ActionPerformed

    private void CMA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA4ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=10;
        boolean valor=CMA4.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA4.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
               eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont)); 
            }
        }
    }//GEN-LAST:event_CMA4ActionPerformed

    private void CMA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA5ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=11;
        boolean valor=CMA5.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA5.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA5ActionPerformed

    private void CMA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA6ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=12;
        boolean valor=CMA6.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA6.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA6ActionPerformed

    private void CMA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA7ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=13;
        boolean valor=CMA7.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA7.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA7ActionPerformed

    private void CMA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA8ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=14;
        boolean valor=CMA8.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA8.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA8ActionPerformed

    private void CMA9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA9ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=15;
        boolean valor=CMA9.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA9.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA9ActionPerformed

    private void CMA10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA10ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=16;
        boolean valor=CMA10.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA10.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA10ActionPerformed

    private void CMA11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA11ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=17;
        boolean valor=CMA11.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA11.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA11ActionPerformed

    private void CMA12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA12ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=18;
        boolean valor=CMA12.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA12.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA12ActionPerformed

    private void CMA13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA13ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=19;
        boolean valor=CMA13.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA13.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA13ActionPerformed

    private void CMA14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMA14ActionPerformed
        // TODO add your handling code here:
        String Dia="Martes";
        int Hora=20;
        boolean valor=CMA14.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CMA14.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CMA14ActionPerformed

    private void CM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM1ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=7;
        boolean valor=CM1.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM1.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM1ActionPerformed

    private void CM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM2ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=8;
        boolean valor=CM2.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM2.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM2ActionPerformed

    private void CM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM3ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=9;
        boolean valor=CM3.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM3.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM3ActionPerformed

    private void CM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM4ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=10;
        boolean valor=CM4.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM4.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM4ActionPerformed

    private void CM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM5ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=11;
        boolean valor=CM5.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM5.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM5ActionPerformed

    private void CM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM6ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=12;
        boolean valor=CM6.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM6.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM6ActionPerformed

    private void CM7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM7ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=13;
        boolean valor=CM7.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM7.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM7ActionPerformed

    private void CM8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM8ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=14;
        boolean valor=CM8.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM8.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM8ActionPerformed

    private void CM9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM9ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=15;
        boolean valor=CM9.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM9.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM9ActionPerformed

    private void CM10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM10ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=16;
        boolean valor=CM10.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM10.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM10ActionPerformed

    private void CM11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM11ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=17;
        boolean valor=CM11.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM11.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM11ActionPerformed

    private void CM12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM12ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=18;
        boolean valor=CM12.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM12.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM12ActionPerformed

    private void CM13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM13ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=19;
        boolean valor=CM13.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM13.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM13ActionPerformed

    private void CM14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CM14ActionPerformed
        // TODO add your handling code here:
        String Dia="Miercoles";
        int Hora=20;
        boolean valor=CM14.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CM14.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CM14ActionPerformed

    private void CJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ1ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=7;
        boolean valor=CJ1.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ1.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ1ActionPerformed

    private void CJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ2ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=8;
        boolean valor=CJ2.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ2.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ2ActionPerformed

    private void CJ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ3ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=9;
        boolean valor=CJ3.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ3.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ3ActionPerformed

    private void CJ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ4ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=10;
        boolean valor=CJ4.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ4.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ4ActionPerformed

    private void CJ5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ5ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=11;
        boolean valor=CJ5.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ5.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ5ActionPerformed

    private void CJ6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ6ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=12;
        boolean valor=CJ6.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ6.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ6ActionPerformed

    private void CJ7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ7ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=13;
        boolean valor=CJ7.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ7.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ7ActionPerformed

    private void CJ8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ8ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=14;
        boolean valor=CJ8.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ8.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ8ActionPerformed

    private void CJ9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ9ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=15;
        boolean valor=CJ9.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ9.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ9ActionPerformed

    private void CJ10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ10ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=16;
        boolean valor=CJ10.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ10.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ10ActionPerformed

    private void CJ11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ11ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=17;
        boolean valor=CJ11.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ11.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ11ActionPerformed

    private void CJ12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ12ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=18;
        boolean valor=CJ12.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ12.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ12ActionPerformed

    private void CJ13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ13ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=19;
        boolean valor=CJ13.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ13.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ13ActionPerformed

    private void CJ14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CJ14ActionPerformed
        // TODO add your handling code here:
        String Dia="Jueves";
        int Hora=20;
        boolean valor=CJ14.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CJ14.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CJ14ActionPerformed

    private void CV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV1ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=7;
        boolean valor=CV1.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV1.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV1ActionPerformed

    private void CV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV2ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=8;
        boolean valor=CV2.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV2.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV2ActionPerformed

    private void CV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV3ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=9;
        boolean valor=CV3.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV3.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV3ActionPerformed

    private void CV4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV4ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=10;
        boolean valor=CV4.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV4.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV4ActionPerformed

    private void CV5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV5ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=11;
        boolean valor=CV5.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV5.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV5ActionPerformed

    private void CV6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV6ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=12;
        boolean valor=CV6.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV6.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV6ActionPerformed

    private void CV7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV7ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=13;
        boolean valor=CV7.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV7.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV7ActionPerformed

    private void CV8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV8ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=14;
        boolean valor=CV8.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV8.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV8ActionPerformed

    private void CV9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV9ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=15;
        boolean valor=CV9.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV9.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV9ActionPerformed

    private void CV10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV10ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=16;
        boolean valor=CV10.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV10.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV10ActionPerformed

    private void CV11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV11ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=17;
        boolean valor=CV11.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV11.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV11ActionPerformed

    private void CV12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV12ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=18;
        boolean valor=CV12.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV12.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV12ActionPerformed

    private void CV13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV13ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=19;
        boolean valor=CV13.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV13.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV13ActionPerformed

    private void CV14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CV14ActionPerformed
        // TODO add your handling code here:
        String Dia="Viernes";
        int Hora=20;
        boolean valor=CV14.isSelected();
        String horas=ET5.getText();
        int cantHoras=Integer.parseInt(horas);
        if(valor==true){
            if(cont==cantHoras){
                JOptionPane.showMessageDialog(null, "Ya se asigno limite de horas de la materia");
                CV14.setSelected(false);
            }
            else{
                registrarHorario(Dia,Hora);
                cont=cont+1;
                txtHoras.setText(Integer.toString(cont));
            }
            
        }
        else{
            if(valor==false){
                eliminarHora(Dia,Hora);
                cont=cont-1;
                txtHoras.setText(Integer.toString(cont));
            }
        }
    }//GEN-LAST:event_CV14ActionPerformed

    private void CSEJE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSEJE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSEJE1ActionPerformed

    private void CSEJE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSEJE2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSEJE2ActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        cont=0;
        txtHoras.setText("0");
        inhabilitar();
        desactivarSeleccion();
        habilitarCancelar();
        colorInicial();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void CSEJE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSEJE3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSEJE3ActionPerformed


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
    private javax.swing.JCheckBox CSEJE;
    private javax.swing.JCheckBox CSEJE1;
    private javax.swing.JCheckBox CSEJE2;
    private javax.swing.JCheckBox CSEJE3;
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
    private javax.swing.JLabel ET4;
    private javax.swing.JLabel ET5;
    private javax.swing.JLabel ET6;
    private javax.swing.JLabel ET7;
    private javax.swing.JPanel PCJ1;
    private javax.swing.JPanel PCJ10;
    private javax.swing.JPanel PCJ11;
    private javax.swing.JPanel PCJ12;
    private javax.swing.JPanel PCJ13;
    private javax.swing.JPanel PCJ14;
    private javax.swing.JPanel PCJ2;
    private javax.swing.JPanel PCJ3;
    private javax.swing.JPanel PCJ4;
    private javax.swing.JPanel PCJ5;
    private javax.swing.JPanel PCJ6;
    private javax.swing.JPanel PCJ7;
    private javax.swing.JPanel PCJ8;
    private javax.swing.JPanel PCJ9;
    private javax.swing.JPanel PCL1;
    private javax.swing.JPanel PCL10;
    private javax.swing.JPanel PCL11;
    private javax.swing.JPanel PCL12;
    private javax.swing.JPanel PCL13;
    private javax.swing.JPanel PCL14;
    private javax.swing.JPanel PCL2;
    private javax.swing.JPanel PCL3;
    private javax.swing.JPanel PCL4;
    private javax.swing.JPanel PCL5;
    private javax.swing.JPanel PCL6;
    private javax.swing.JPanel PCL7;
    private javax.swing.JPanel PCL8;
    private javax.swing.JPanel PCL9;
    private javax.swing.JPanel PCM1;
    private javax.swing.JPanel PCM10;
    private javax.swing.JPanel PCM11;
    private javax.swing.JPanel PCM12;
    private javax.swing.JPanel PCM13;
    private javax.swing.JPanel PCM14;
    private javax.swing.JPanel PCM2;
    private javax.swing.JPanel PCM3;
    private javax.swing.JPanel PCM4;
    private javax.swing.JPanel PCM5;
    private javax.swing.JPanel PCM6;
    private javax.swing.JPanel PCM7;
    private javax.swing.JPanel PCM8;
    private javax.swing.JPanel PCM9;
    private javax.swing.JPanel PCMA1;
    private javax.swing.JPanel PCMA10;
    private javax.swing.JPanel PCMA11;
    private javax.swing.JPanel PCMA12;
    private javax.swing.JPanel PCMA13;
    private javax.swing.JPanel PCMA14;
    private javax.swing.JPanel PCMA2;
    private javax.swing.JPanel PCMA3;
    private javax.swing.JPanel PCMA4;
    private javax.swing.JPanel PCMA5;
    private javax.swing.JPanel PCMA6;
    private javax.swing.JPanel PCMA7;
    private javax.swing.JPanel PCMA8;
    private javax.swing.JPanel PCMA9;
    private javax.swing.JPanel PCV1;
    private javax.swing.JPanel PCV10;
    private javax.swing.JPanel PCV11;
    private javax.swing.JPanel PCV12;
    private javax.swing.JPanel PCV13;
    private javax.swing.JPanel PCV14;
    private javax.swing.JPanel PCV15;
    private javax.swing.JPanel PCV16;
    private javax.swing.JPanel PCV17;
    private javax.swing.JPanel PCV18;
    private javax.swing.JPanel PCV19;
    private javax.swing.JPanel PCV2;
    private javax.swing.JPanel PCV20;
    private javax.swing.JPanel PCV21;
    private javax.swing.JPanel PCV22;
    private javax.swing.JPanel PCV23;
    private javax.swing.JPanel PCV24;
    private javax.swing.JPanel PCV25;
    private javax.swing.JPanel PCV26;
    private javax.swing.JPanel PCV27;
    private javax.swing.JPanel PCV28;
    private javax.swing.JPanel PCV3;
    private javax.swing.JPanel PCV4;
    private javax.swing.JPanel PCV5;
    private javax.swing.JPanel PCV6;
    private javax.swing.JPanel PCV7;
    private javax.swing.JPanel PCV8;
    private javax.swing.JPanel PCV9;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxActividad;
    private javax.swing.JComboBox<String> cbxGrupo;
    private javax.swing.JComboBox<String> cbxMaestro;
    private javax.swing.JComboBox<String> cbxSalon;
    private javax.swing.JPanel eje1;
    private javax.swing.JPanel eje2;
    private javax.swing.JPanel eje3;
    private javax.swing.JPanel eje4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbMateria;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables
}
