/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EntidadAsignarMateria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class ControlAsignarMateria {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    
    public boolean registrarAsignarMateria(EntidadAsignarMateria dts){
        sSQL="insert into asignarmateria (Maestro_NumeroEmpleado,Materia_ClaveMateria)"+"values (?,?)";
        
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getNumeroEmpleado());
            pst.setInt(2, dts.getClaveMateria());

            
            int n=pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La asignacion de la Materia han sido actualizados");
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ya existe la asignacion");
            
            return false;
        }
    }
    
    public DefaultTableModel consultarMateriaTabla(int buscar) throws SQLException{
        DefaultTableModel modelo;
        
        String[] titulos={"Clave","Nombre Materia","Horas x semana"};
        
        String[] Materias=new String [3];
        
        modelo=new DefaultTableModel(null,titulos);
        
        sSQL="select * from materia INNER JOIN asignarmateria ON materia.ClaveMateria=asignarmateria.Materia_ClaveMateria where asignarmateria.Maestro_NumeroEmpleado like '%"+ buscar +"%' order by Maestro_NumeroEmpleado";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                Materias[0]=rs.getString("ClaveMateria");
                Materias[1]=rs.getString("NombreMateria");
                Materias[2]=rs.getString("Horas");

                
                modelo.addRow(Materias);
                
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }
    public String consultaGeneralAsignarMateria(int clave,int numEmpl){
        String cadena="";
        sSQL="select * from asignarmateria WHERE Materia_ClaveMateria like '"+clave+"' AND Maestro_NumeroEmpleado like '"+numEmpl+"' ";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                int numeroEmpleado=rs.getInt("Maestro_NumeroEmpleado");
                int claveMateria=rs.getInt("Materia_ClaveMateria");
                

                
                cadena=cadena+numeroEmpleado+" "+claveMateria;
                
            }
            
            
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "no se encontro ");
            cadena="";
        }
        
        return cadena;
    }
    public boolean eliminarAsignarMateria(EntidadAsignarMateria dts){
        sSQL="delete from asignarmateria where Materia_ClaveMateria=?";
        try{
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1, dts.getClaveMateria());
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
    public DefaultTableModel consultaEspecificaAsignacion(int bus){
        DefaultTableModel modelo;
        String[] titulos={"Clave","Nombre Materia","Horas x semana"};
        
        String[] Materias=new String [3];
        
        modelo=new DefaultTableModel(null,titulos);
        
        String cadena="";
        sSQL="select NombreMateria,Horas,Materia_ClaveMateria FROM materia,asignarmateria WHERE materia.ClaveMateria=asignarmateria.Materia_ClaveMateria AND Maestro_NumeroEmpleado like '"+bus+"' ";
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                Materias[0]=rs.getString("Materia_ClaveMateria");
                Materias[1]=rs.getString("NombreMateria");
                Materias[2]=rs.getString("Horas");

                
                modelo.addRow(Materias);
                
            }
            return modelo;
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
