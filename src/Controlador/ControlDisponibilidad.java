/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EntidadDisponibilidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author julve
 */
public class ControlDisponibilidad {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    
    public boolean registrarDisponibilidad(EntidadDisponibilidad dts){
        sSQL="insert into disponibilidahorario (Maestro_NumeroEmpleado,Dia,Hora)"+"values (?,?,?)";
        
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getNumeroEmpleado());
            pst.setString(2, dts.getDia());
            pst.setInt(3, dts.getHora());

            
            int n=pst.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Los datos del grupo han sido actualizados");
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ya existe el grupo");
            
            return false;
        }
    }
    public void consultarAsignacion(int numeroEmpleado){
        String cadena="";
        sSQL="select * from disponibilidahorario where Maestro_NumeroEmpleado = '"+numeroEmpleado+"' ";
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                String numempl=rs.getString("NumeroEmpleado");
                String nomb=rs.getString("Nombre");
                String aPaterno=rs.getString("ApellidoPaterno");
                String aMaterno=rs.getString("ApellidoMaterno");
                String HAsignacion=rs.getString("HorasAsignadas");
                
//                modelo.addRow(Maestros);
                cadena=cadena+numempl+","+nomb+","+aPaterno+","+aMaterno+","+HAsignacion;
                
            }
            
//                return cadena;
            
        }catch(Exception e){
            
        }
        
        
    }
   public Statement consultaDisponibilidadEspecifica(){
        String cadena="";  
        try{
            Statement st=cn.createStatement();         
                return st; 
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }
    
    public boolean eliminarDisponibilidad(EntidadDisponibilidad dts){
        sSQL="delete from disponibilidahorario where Maestro_NumeroEmpleado=? AND Dia=? AND Hora=?";
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1, dts.getNumeroEmpleado());
            pst.setString(2, dts.getDia());
            pst.setInt(3, dts.getHora());
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    public int consultarHorasAsignadas(int numeroEmpleado){
        int contador=0;
        sSQL="select count(*) from disponibilidahorario where Maestro_NumeroEmpleado = "+numeroEmpleado+" ";
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                contador++;
                
            }
            
//                return cadena;
            
        }catch(Exception e){
            
        }
        return contador;
        
    }
    
    
}
