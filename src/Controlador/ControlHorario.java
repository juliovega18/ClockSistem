/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EntidadGrupo;
import Modelo.EntidadHorario;
import Modelo.EntidadMaestro;
import Modelo.EntidadMateria;
import Modelo.EntidadSalon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marisol
 */
public class ControlHorario {

    EntidadMaestro EntiMaestro = new EntidadMaestro();
    EntidadMateria EntiMateria = new EntidadMateria();
    EntidadGrupo EntiGrupo = new EntidadGrupo();
    EntidadSalon EntiSalon = new EntidadSalon();
    EntidadHorario entidadHorario=new EntidadHorario();

    private Conexion mysql = new Conexion();
    private Connection connection = mysql.conectar();
    private String sSQL = "";
    PreparedStatement ps = null;
    EntidadHorario EntiHora = new EntidadHorario();

    public ControlHorario() {

    }

    /*Método que muestra los datos   en la tabla*/
    public DefaultTableModel mostrarDatos(String maestro, String materia, String salon, String grupo) {
        int idHorario = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            modelo.addColumn("idHorario");
            modelo.addColumn("Periodo");
            modelo.addColumn("Fecha");
            modelo.addColumn("Maestro");
            modelo.addColumn("TipoActividad");
            modelo.addColumn("Semestre");
            modelo.addColumn("Materia");
            modelo.addColumn("Salon");
            modelo.addColumn("Grupo");
            modelo.addColumn("Dia");
            modelo.addColumn("Hora");

//            tbHorario.setModel(modelo);
            if (maestro.equals("") && materia.equals("") && grupo.equals("") && salon.equals("")) {
                sSQL = "select idHorario, Periodo, Fecha, Nombre, ApellidoPaterno, ApellidoMaterno, TipoActividad, SemestreMateria, NombreMateria, NumSalon, NumGrupo, Dia, Hora from horario, maestro, materia, grupo, salon WHERE  horario.Maestro_NumeroEmpleado=maestro.NumeroEmpleado and horario.Materia_ClaveMateria=materia.ClaveMateria and horario.Salon_NumSalon=salon.NumSalon and horario.Grupo_NumGrupo=grupo.NumGrupo;";

            } else {
                sSQL = "select idHorario, Periodo, Fecha, Nombre, ApellidoPaterno, ApellidoMaterno, TipoActividad, SemestreMateria, NombreMateria, NumSalon, NumGrupo, Dia, Hora from horario, maestro, materia, grupo, salon WHERE maestro.NumeroEmpleado='" + maestro + "' and materia.ClaveMateria='" + materia + "' and salon.NumSalon='" + salon + "' and grupo.NumGrupo='" + grupo + "';";
            }

            String[] Horarios = new String[11];

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            System.out.println("el primer mostrar" + sSQL);

            while (rs.next()) {
                idHorario = Integer.parseInt(rs.getString(1));
                Horarios[0] = rs.getString("idHorario");
                Horarios[1] = rs.getString("Periodo");
                Horarios[2] = rs.getString("Fecha");
                Horarios[3] = rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ";//  consulta  id  traer
                Horarios[4] = rs.getString("TipoActividad");
                Horarios[5] = rs.getString("SemestreMateria") + " ";
                Horarios[6] = rs.getString("NombreMateria") + " ";
                Horarios[7] = rs.getString("NumSalon") + " ";
                Horarios[8] = rs.getString("NumGrupo") + " ";
                Horarios[9] = rs.getString("Dia");
                Horarios[10] = rs.getString("Hora");

                modelo.addRow(Horarios);

            }

//            tbHorario.setModel(modelo);
            return modelo;

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        return null;
    }
////

    /*Metodo que modifica datos  con respecto   al maestro*/
    public void modificarHorario(String idHorario, String periodo, String fecha, String actividad, String maestro, String materia, String grupo, String salon, String dia, String hora) throws SQLException, ClassNotFoundException {

        sSQL = "UPDATE horario SET Periodo='" + periodo + "', Fecha='" + fecha + "', TipoActividad='" + actividad + "', Maestro_NumeroEmpleado='" + maestro + "', Materia_ClaveMateria='" + materia + "', Grupo_NumGrupo='" + grupo + "', Salon_NumSalon='" + salon + "', Dia='" + dia + "', Hora='" + hora + "'  WHERE idHorario='" + idHorario + "';";
        System.out.println("sSQL" + sSQL);
        ps = connection.prepareStatement(sSQL);
        ps.executeUpdate();

    }

    /*Metodo que elimina horario del maestro*/
    public void eliminarHorario(String idHorario) throws SQLException, ClassNotFoundException {
//              delete from horario where Maestro_NumeroEmpleado='675' and Materia_ClaveMateria= '22111' and Grupo_NumGrupo='502' and Salon_NumSalon= '502';
        sSQL = "delete from horario WHERE idHorario='" + idHorario + "' ;";
        System.out.println("sSQL" + sSQL);
        ps = connection.prepareStatement(sSQL);
        ps.executeUpdate();

    }

    /*Metodo que  cuenta los numeroEmpleado registradas en  horario*/
    public int contarHorasMaestro(String numEmpleado) throws SQLException, ClassNotFoundException {
        int contarNumEmpleadoEnHorario = 0;
        sSQL = "select count(*) from horario where Maestro_NumeroEmpleado='" + numEmpleado + "';";
        Statement st = connection.createStatement();
        ResultSet rsContarNumEmpleado = st.executeQuery(sSQL);

        while (rsContarNumEmpleado.next()) {
            contarNumEmpleadoEnHorario = Integer.parseInt(rsContarNumEmpleado.getString(1).toString());
        }

        return contarNumEmpleadoEnHorario;
    }

    /*Metodo que extrae las horas  asignadas de la materia */
    public int HorasMaestro(String numEmpleado) throws SQLException, ClassNotFoundException {
        int horasAsignadas = 0;
        sSQL = "select HorasAsignadas from maestro where NumeroEmpleado  like '%" + numEmpleado + "%';";
//                
        Statement st = connection.createStatement();
        ResultSet rsHorasMaestro = st.executeQuery(sSQL);

        while (rsHorasMaestro.next()) {
            horasAsignadas = Integer.parseInt(rsHorasMaestro.getString(1).toString());
        }

        return horasAsignadas;
    }

    /*Metodo que  cuenta los  clave de las materias registradas en  horario*/
    public int contarHorasMateria(String clave) throws SQLException, ClassNotFoundException {
        int contarClaveMateriasEnHorario = 0;
        sSQL = "select count(*) from horario where Materia_ClaveMateria='" + clave + "';";

        Statement st = connection.createStatement();
        ResultSet rsContarClaveMateria = st.executeQuery(sSQL);

        while (rsContarClaveMateria.next()) {
            contarClaveMateriasEnHorario = Integer.parseInt(rsContarClaveMateria.getString(1).toString());
        }

        return contarClaveMateriasEnHorario;
    }

    /*Metodo que extrae las horas  asignadas de la materia */
    public int extraeHorasAsignadas(String clave) throws SQLException, ClassNotFoundException {
        int horasAsignadas = 0;
        sSQL = "select horas from materia where ClaveMateria  like '%" + clave + "%';";

        Statement st = connection.createStatement();
        ResultSet rsHorasMateria = st.executeQuery(sSQL);

        while (rsHorasMateria.next()) {
            horasAsignadas = Integer.parseInt(rsHorasMateria.getString(1).toString());
        }

        return horasAsignadas;
    }


    /*Metodo  que regresa   los  datos  de la tabla de Maestro */
    public ResultSet cargaComboMaestro() {

        sSQL = "SELECT NumeroEmpleado, Nombre, ApellidoPaterno, ApellidoMaterno FROM maestro;";

        try {
            ps = connection.prepareStatement(sSQL);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultadoMaestro = null;
        try {
            resultadoMaestro = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoMaestro;

    }

    /*Metodo  que regresa   los  datos  de la tabla de Materia */
    public ResultSet consultarSemestre(String semestre) {
//                SELECT distinct(horasAsignadas), NombreMateria FROM  materia WHERE SemestreMateria= "1";
        sSQL = "SELECT distinct(ClaveMateria), NombreMateria FROM  materia WHERE SemestreMateria= " + semestre + ";";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sSQL);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            System.out.println("rs" + rs);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    /*Metodo  que regresa  el semestre de la materia  de la tabla de Maestro */
    public ResultSet cargaComboSemestre() {

        sSQL = "SELECT distinct(SemestreMateria) FROM materia order by SemestreMateria;";

        try {
            ps = connection.prepareStatement(sSQL);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultadoSemestre = null;
        try {
            resultadoSemestre = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoSemestre;
    }


    /*Metodo  que regresa   los  datos  de la tabla de grupo */
    public ResultSet cargaComboGrupo() {

        sSQL = "SELECT NumGrupo  FROM grupo;";

        try {
            ps = connection.prepareStatement(sSQL);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultadoGrupo = null;
        try {
            resultadoGrupo = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoGrupo;
    }

    /*Metodo  que regresa   los  datos  de la tabla de salon */
    public ResultSet cargaComboSalon() {

        sSQL = "SELECT NumSalon  FROM salon;";

        try {
            ps = connection.prepareStatement(sSQL);

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultadoSalon = null;
        try {
            resultadoSalon = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(ControlHorario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoSalon;
    }


    /*Metodo  que registra   los  datos  de la tabla de horario */
    public boolean RegistrarHorario(EntidadHorario dts) {

        sSQL = "insert into horario (TipoActividad,Dia,Hora,NumeroEmpleado,ClaveMateria,NumGrupo,idSalon) "+
                "values (?,?,?,?,?,?,?)";

        try {

            ps = connection.prepareStatement(sSQL);
            ps.setString(1, dts.getTipoActividad());
            ps.setString(2, dts.getDia());
            ps.setInt(3, dts.getHora());
            ps.setInt(4, dts.getNumEmpleado());
            ps.setInt(5, dts.getClaveMateria());
            ps.setInt(6, dts.getNumGrupo());
            ps.setInt(7, dts.getNumSalon());

            int n = ps.executeUpdate();
//            JOptionPane.showConfirmDialog(null, n);

//            if (n != 0) {
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
    public boolean RegistrarHorarioProyectos(EntidadHorario dts) {

        sSQL = "insert into horario (TipoActividad,Dia,Hora,NumeroEmpleado,ClaveMateria) "+
                "values (?,?,?,?,?)";

        try {

            ps = connection.prepareStatement(sSQL);
            ps.setString(1, dts.getTipoActividad());
            ps.setString(2, dts.getDia());
            ps.setInt(3, dts.getHora());
            ps.setInt(4, dts.getNumEmpleado());
            ps.setInt(5, dts.getClaveMateria());
//            ps.setInt(6, dts.getNumGrupo());
//            ps.setInt(7, dts.getNumSalon());

            int n = ps.executeUpdate();
            JOptionPane.showConfirmDialog(null, n);

//            if (n != 0) {
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
    public Statement consultaHorarioEspecificaGrupo(){
        String cadena="";  
        try{
            Statement st=connection.createStatement();         
                return st; 
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
    }

    /*metodo  que carga  todos  los datos  en  la tabla horario*/
    public DefaultTableModel cargarTablaHorario(String periodo, String fecha, String actividad, String maestro, String materia, String grupo, String salon, String dia, String hora) {
        int idHorario = 0;

        DefaultTableModel modelo = new DefaultTableModel();
        try {
            modelo.addColumn("Periodo");
            modelo.addColumn("Fecha");
            modelo.addColumn("Maestro");
            modelo.addColumn("TipoActividad");
            modelo.addColumn("Semestre");
            modelo.addColumn("Materia");
            modelo.addColumn("Salon");
            modelo.addColumn("Grupo");
            modelo.addColumn("Dia");
            modelo.addColumn("Hora");
            String[] Horarios = new String[10];
            sSQL = "select idHorario, Periodo, Fecha, Nombre, ApellidoPaterno, ApellidoMaterno, TipoActividad, SemestreMateria, NombreMateria, NumSalon, NumGrupo, Dia, Hora from horario, maestro, materia, grupo, salon WHERE  horario.Maestro_NumeroEmpleado=maestro.NumeroEmpleado and horario.Materia_ClaveMateria=materia.ClaveMateria and horario.Salon_NumSalon=salon.NumSalon and horario.Grupo_NumGrupo=grupo.NumGrupo;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                idHorario = Integer.parseInt(rs.getString(1));
                Horarios[0] = rs.getString("Periodo");
                Horarios[1] = rs.getString("Fecha");
                Horarios[2] = rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno") + " ";//  consulta  id  traer
                Horarios[3] = rs.getString("TipoActividad");
                Horarios[4] = rs.getString("SemestreMateria") + " ";
                Horarios[5] = rs.getString("NombreMateria") + " ";
                Horarios[6] = rs.getString("NumSalon") + " ";
                Horarios[7] = rs.getString("NumGrupo") + " ";
                Horarios[8] = rs.getString("Dia");
                Horarios[9] = rs.getString("Hora");
                modelo.addRow(Horarios);

            }

            return modelo;

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, e);

            return null;
        }

    }

    public void Actualizar(String periodo, String fecha, String actividad, String maestro, String materia, String grupo, String salon, String dia, String hora) {

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");

        if (confirmar == JOptionPane.YES_OPTION) {

//            Connection conexion = null;
            try {

//                conexion = metodospool.dataSource.getConnection();
                Statement st = connection.createStatement();

//
//                String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
//                        + "WHERE id_contacto=?";
                sSQL = "UPDATE horario SET Periodo='?', Fecha='?', TipoActividad='?', Maestro_NumeroEmpleado='?', Materia_ClaveMateria='?', Grupo_NumGrupo='?', Salon_NumSalon='?', Dia='?', Hora='?'  WHERE idHorario='?';";

                PreparedStatement prest = connection.prepareStatement(sSQL);


//                ps.setString(1, EntiHora.getPeriodo());


                if (prest.executeUpdate() > 0) {

                    JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                            + "Inténtelo nuevamente.", "Error en la operación",
                            JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                        + "Inténtelo nuevamente.\n"
                        + "Error: " + e, "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);

            } finally {

                if (connection != null) {

                    try {

                        connection.close();

                    } catch (SQLException e) {

                        JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión."
                                + "Error: " + e, "Error en la operación",
                                JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        }

    }

    public boolean editar(EntidadHorario EntiHora) {

        sSQL = "UPDATE horario SET Periodo='?', Fecha='?', TipoActividad='?', Maestro_NumeroEmpleado='?', Materia_ClaveMateria='?', Grupo_NumGrupo='?', Salon_NumSalon='?', Dia='?', Hora='?'  WHERE idHorario='?';";
        System.out.println("sSQL" + sSQL);
        try {
            ps = connection.prepareStatement(sSQL);

            ps.setString(8, EntiHora.getDia());
            ps.setInt(9, EntiHora.getHora());
            int n = ps.executeUpdate();
            System.out.println("n" + n);
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

    /*Metodo que valida que maestro, materia, grupo, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos1(String salon, String grupo, String dia, String hora, String materia, String maestro) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Materia_ClaveMateria like '%" + materia + "%'and Maestro_NumeroEmpleado like '%" + maestro + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 1" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {
// if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {
                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que materia, grupo, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos2(String salon, String grupo, String dia, String hora, String materia) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Materia_ClaveMateria like '%" + materia + "%';";
        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 2" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que maestro, grupo, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos3(String salon, String grupo, String dia, String hora, String maestro) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select  idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Maestro_NumeroEmpleado like '%" + maestro + "%';";
        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 3" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que materia, grupo, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos4(String grupo, String dia, String hora, String materia) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Materia_ClaveMateria like '%" + materia + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 4" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que maestro, grupo, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos5(String grupo, String dia, String hora, String maestro) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Maestro_NumeroEmpleado like '%" + maestro + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 5" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que materia, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos6(String salon, String dia, String hora, String materia) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Materia_ClaveMateria like '%" + materia + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 6" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que maestro, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos7(String salon, String dia, String hora, String maestro) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Maestro_NumeroEmpleado like '%" + maestro + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 7" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que grupo, salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos8(String salon, String grupo, String dia, String hora) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select  idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 8" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que salon, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos9(String salon, String dia, String hora) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select  idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 9" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    /*Metodo que valida que grupo, dia y hora estan registrados en la base  de datos*/
    public boolean existeDatos10(String grupo, String dia, String hora) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select  idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 10" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    public boolean existeDatos11(String dia, String hora) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        sSQL = "select  idHorario, maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where  Dia like '%" + dia + "%' and Hora like '%" + hora + "%';";

        Statement st = connection.createStatement();
        ResultSet resultado = st.executeQuery(sSQL);

        System.out.println("existe 11" + sSQL);

        while (resultado.next()) {
            if (Integer.parseInt(resultado.getObject(1).toString()) > 0) {

                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;

    }

    public DefaultTableModel mostrarHorario(String salon, String grupo, String dia, String hora, String materia, String maestro) {
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("Nombre");
        modelo2.addColumn("ApellidoPaterno");
        modelo2.addColumn("ApellidoMaterno");
        modelo2.addColumn("Materia");
        modelo2.addColumn("Salon");
        modelo2.addColumn("Grupo");
        modelo2.addColumn("Dia");
        modelo2.addColumn("Hora");
        String[] Horario = new String[8];
        sSQL = "select maestro.Nombre, maestro.ApellidoPaterno, maestro.ApellidoMaterno, materia.NombreMateria, Salon_NumSalon, Grupo_NumGrupo, Dia, Hora  from horario inner join materia on materia.ClaveMateria = horario.Materia_ClaveMateria inner join maestro on maestro.NumeroEmpleado=horario.Maestro_NumeroEmpleado where Salon_NumSalon like '%" + salon + "%' and Grupo_NumGrupo like  '%" + grupo + "%' and Dia like '%" + dia + "%' and Hora like '%" + hora + "%' and Materia_ClaveMateria like '%" + materia + "%'and Maestro_NumeroEmpleado like '%" + maestro + "%';";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                Horario[0] = rs.getString("Nombre");
                Horario[1] = rs.getString("ApellidoPaterno");
                Horario[2] = rs.getString("ApellidoMaterno");
                Horario[3] = rs.getString("NombreMateria");
                Horario[4] = rs.getString("Salon_NumSalon");
                Horario[5] = rs.getString("Grupo_NumGrupo");
                Horario[6] = rs.getString("Dia");
                Horario[7] = rs.getString("Hora");
                modelo2.addRow(Horario);

            }

            return modelo2;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("numero  de  salon existe" + modelo2);
            return null;
        }

    }
    
    public int consultarGrupoMateria(int idMateria,int grupo){
        int cadena=0;
            
            
            sSQL="select idHorario from horario where ClaveMateria like '"+ idMateria +"';";
            
try{
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                int idhorario=rs.getInt("idHorario");


                cadena=cadena+idhorario;
                
            }
            
                return cadena;
            
            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return cadena;
        }
    }
    public boolean eliminarHora(EntidadHorario dts){
        sSQL="delete from horario where NumeroEmpleado=? AND Dia=? AND Hora=?";
        try{
            PreparedStatement pst=connection.prepareStatement(sSQL);
            
            
            pst.setInt(1, dts.getNumEmpleado());
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
    

}
