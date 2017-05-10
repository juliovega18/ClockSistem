/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EntidadSalon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julve
 */
public class ControlSalon {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
//  PBI1:HU01:01: MÉTODO QUE REGISTRA UN SALON

    public boolean RegistrarSalon(EntidadSalon dts) {
        sSQL = "insert into salon (NumSalon)" + "values (?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumeroSalon());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
// //   PBI1:HU01:02: Debo ver si Numero de salón existe
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "El  salón ya  existe");
            return false;
        }

    }
//MUESTRA LOS  DATOS  EN UNA TABLA ORDENADOS POR  SALON

    public DefaultTableModel consultarSalon() throws SQLException {
        DefaultTableModel modelo;
        int idSalon = 0;

        String[] titulos = {"idSalon", "Numero de Salon"};

        String[] Grupos = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM salon order by NumSalon;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                idSalon = Integer.parseInt(rs.getString(1));
                Grupos[0] = rs.getString("idSalon");
                Grupos[1] = rs.getString("NumSalon");
                modelo.addRow(Grupos);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
//              PBI1:HU03:01 MÉTODO  QUE ELIMINA  UN SALÓN

    public boolean eliminarSalon(EntidadSalon dts) {
        sSQL = "delete from salon where NumSalon=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNumeroSalon());
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
//         PBI1:HU01:  MÉTODO QUE MODIDFICA UN SALÓN EXISTENTE

//    public boolean modificarSalon(int idSalon, String salon) {
////        sSQL = "update salon set NumSalon=? where NumSalon like '%" + buscar + "%'";
//        sSQL = "UPDATE salon SET Periodo='" + salon + "'  WHERE IdSalon='" + idSalon + "';";
//
//        try {
//            PreparedStatement pst = cn.prepareStatement(sSQL);
//
//            pst.setString(1, dts.getNumeroSalon());
//
//            int n = pst.executeUpdate();
//
//            if (n != 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return false;
//        }
//
//    }
    //         PBI1:HU02:01  MÉTODO QUE MODIDFICA UN SALÓN EXISTENTE
    public void modificarSalon(String idSalon, String salon) throws SQLException, ClassNotFoundException {

        sSQL = "UPDATE salon SET NumSalon='" + salon + "'  WHERE idSalon='" + idSalon + "';";
        System.out.println("sSQL" + sSQL);
        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "los datos han sido modificados satisfactoriamente");

    }

//            PBI1:HU01:04 MÉTODO   QUE HACE UNA CONSULTA ESPECÍFICA
    public String consultarSalonEspecifico(String buscar) throws SQLException {
        String cadena = "";

        sSQL = "select * from salon where NumSalon like '%" + buscar + "%' order by NumSalon";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                String numSalon = rs.getString("NumSalon");

                cadena = cadena + numSalon;
            }

            return cadena;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
// PBI1:HU02:02 MÉTODO  QUE CONSULTA   SI UN SALON TIENE UN HORARIO  ASIGNADO PARA NO ELIMINAR
// PBI1:HU03:02  MÉTODO  QUE CONSULTA   SI UN SALON TIENE UN HORARIO  ASIGNADO PARA NO MODIFICAR

    public String consultarSalonTieneHorario(String salon) throws SQLException {
        String cadena = "";

        sSQL = "select IdSalon  from horario  where IdSalon like '%" + salon + "%';";
//sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where  Salon_NumSalon like '%" + salon + "%';";

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sSQL);

        while (rs.next()) {
            String IdSalon = rs.getString("IdSalon");
//            String numSalon = rs.getString("NumSalon");

            cadena = cadena + IdSalon;
        }

        return cadena;
    }

    public ResultSet consultarSalonGeneral() throws SQLException {

        String cadena = "";

        DefaultListModel modelo = new DefaultListModel();

        sSQL = "select NumSalon from salon order by NumSalon;";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            return rs;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
