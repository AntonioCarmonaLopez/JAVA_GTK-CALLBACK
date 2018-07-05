package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import vista.FrmMantenimientoAlumno;

public class LogicaAlumno {

    /* Métodos ****************************************************************/
    public static boolean existeAlumno(Alumno a) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Alumnos WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, a.getDni());
            rs = pst.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error existeAlumno()!!", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
        return false;
    }

    public static void altaAlumno(Alumno a) throws Exception {
        if (existeAlumno(a)) {
            throw new Exception("El alumno ya existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Alumnos VALUES (?,?,?)";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, a.getDni());
            pst.setString(2, a.getNombre());
            pst.setBoolean(3, a.isMayorEdad());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error altaAlumno()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void bajaAlumno(Alumno a) throws Exception {
        if (!existeAlumno(a)) {
            throw new Exception("El alumno no existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM Alumnos WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, a.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error bajaAlumno()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void listadoAlumnos(List<Alumno> t) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Alumnos ORDER BY dni";
            pst = ConexionBD.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            Alumno a;
            while (rs.next()) {
                a = new Alumno();
                a.setDni(rs.getString("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setMayorEdad(rs.getBoolean("mayorEdad"));
                t.add(a);
            }
        } catch (Exception e) {
            throw new Exception("Error listadoAlumnos()!!", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
    }
    public static void buscar(List<Alumno> t) throws SQLException, Exception {
        String sql;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (!FrmMantenimientoAlumno.dniBuscar.isEmpty() && FrmMantenimientoAlumno.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Alumnos WHERE dni LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoAlumno.dniBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Alumno a;
                while (rs.next()) {
                    a=new Alumno();
                    a.setDni(rs.getString("dni"));
                    a.setNombre(rs.getString("nombre"));
                    a.setMayorEdad(rs.getBoolean("mayorEdad"));
                    t.add(a);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda alumnos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (FrmMantenimientoAlumno.dniBuscar.isEmpty() && !FrmMantenimientoAlumno.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Alumnos WHERE nombre  LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoAlumno.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Alumno a;
                while (rs.next()) {
                    a=new Alumno();
                    a.setDni(rs.getString("dni"));
                    a.setNombre(rs.getString("nombre"));
                    a.setMayorEdad(rs.getBoolean("mayorEdad"));
                    t.add(a);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda alumnos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (!FrmMantenimientoAlumno.dniBuscar.isEmpty() && !FrmMantenimientoAlumno.nombreBuscar.isEmpty()) {

            try {
                sql = "SELECT * FROM Alumnos WHERE dni LIKE ? AND Nombre LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoAlumno.dniBuscar + "%";
                String newFiltro2 = "%" + FrmMantenimientoAlumno.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                pst.setString(2, newFiltro2);
                rs = pst.executeQuery();
                Alumno a;
                while (rs.next()) {
                    a=new Alumno();
                    a.setDni(rs.getString("dni"));
                    a.setNombre(rs.getString("nombre"));
                    a.setMayorEdad(rs.getBoolean("mayorEdad"));
                    t.add(a);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda alumnos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else {
            try {
                sql = "SELECT * FROM Alumnos ORDER BY dni";
                pst = ConexionBD.getConn().prepareStatement(sql);
                rs = pst.executeQuery();
                Alumno a;
                while (rs.next()) {
                    a=new Alumno();
                    a.setDni(rs.getString("dni"));
                    a.setNombre(rs.getString("nombre"));
                    a.setMayorEdad(rs.getBoolean("mayorEdad"));
                    t.add(a);
                }
            } catch (Exception e) {
                throw new Exception("Error buscar alumnos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        }
    }
    
     public static void actualizaAlumno(Alumno a) throws Exception {

        PreparedStatement pst = null;
        try {
            String sql = "UPDATE Alumnos SET nombre=?,mayorEdad=? WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, a.getNombre());
            pst.setBoolean(2, a.isMayorEdad());
            pst.setString(3, a.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error actualizar alumno", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }
    
     public static boolean getAlumno(Alumno a) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Alumnos WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, a.getDni());
            rs = pst.executeQuery();
            while (rs.next()){
               a.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new Exception("Error al recuperar Alumno", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
        return false;
    }
}
