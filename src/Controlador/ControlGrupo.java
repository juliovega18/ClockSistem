/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EntidadGrupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControlGrupo {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    
   //  PBI2:HU04:  MÉTODO QUE REGISTRA UN GRUPO
    public boolean registrarGrupo(EntidadGrupo dts) {
        sSQL = "insert into grupo (NumGrupo,Semestre)" + "values (?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getNumeroGrupo());
            pst.setInt(2, dts.getSemestre());

            int n = pst.executeUpdate();
           

            if (n != 0) {
                return true;
            } else {
                return false;
            }
//VALIDA SI UN Numero de GRUPO existe
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya existe el grupo");

            return false;
        }
    }
//MÉTODO  QUE MUESTRA LOS  DATOS  EN  LA TABLA
    public DefaultTableModel ConsultarGrupo(String buscar) throws SQLException {
        DefaultTableModel modelo;

        String[] titulos = {"Número de Grupo", "Semestre"};

        String[] Grupos = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from grupo where NumGrupo like '%" + buscar + "%' order by NumGrupo";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                Grupos[0] = rs.getString("NumGrupo");
                Grupos[1] = rs.getString("Semestre");
                modelo.addRow(Grupos);

            }
            return modelo;

        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "El numero de grupo no exite" + modelo);
            
        }return null;

    }
//  PBI2:HU06  MÉTODO PARA ELIMINAR UN GRUPO
    public boolean eliminarGrupo(EntidadGrupo dts) {
        sSQL = "delete from grupo where NumGrupo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getNumeroGrupo());
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
//   PBI2:HU05:  MÉTODO QUE MODIFICA UN GRUPO
    public boolean modificarGrupo(EntidadGrupo dts, int buscar) {
        sSQL = "update grupo set NumGrupo=?, Semestre=? where NumGrupo like '%" + buscar + "%'";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getNumeroGrupo());
            pst.setInt(2, dts.getSemestre());

            int n = pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "los datos han sido modificados satisfactoriamente");

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
    //METODO QUE CONSULTA UN  GRUPO  ESPECÍFICO
    public String consultarGrupoEspecifico(String buscar) throws SQLException {
        String cadena = "";

        sSQL = "select * from grupo where NumGrupo like '%" + buscar + "%' order by NumGrupo";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                String numSalon = rs.getString("NumGrupo");
                String semestre= rs.getString("Semestre");
                cadena = cadena + numSalon + "-" + semestre;
               
            }

            return cadena;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "El numero de grupo no exite");
            return null;
        }

    }

//   MÉTODO QUE VALIDA SI EL  GRUPO TIENE  UN HORARIO  ASIGNADO PARA NO MODIFICARLO O ELIMINARLO
        public int consultarGrupoTieneHorario(int grupo) throws SQLException {
        int cadena = 0;

   sSQL = "select NumGrupo  from horario where NumGrupo like '%" + grupo + "%';";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                int numSalon = rs.getInt("NumGrupo");

                cadena = cadena + numSalon;
            }

            return cadena;
    }

      public ResultSet consultarGrupoGeneral(int semestre) throws SQLException{
 
        String cadena="";
        
        DefaultListModel modelo=new DefaultListModel();
        
        sSQL="select NumGrupo from grupo where Semestre = "+semestre+";";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
                
            return rs;
            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }
  


    
}
