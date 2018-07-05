package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Profesor;
import vista.FrmMantenimientoProfesores;

public class LogicaProfesor {

    /* Métodos ****************************************************************/
    public static boolean existeProfesor(Profesor p) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Profesores WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, p.getDni());
            rs = pst.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error existeProfesor()!!", e);
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

    public static void altaProfesor(Profesor p) throws Exception {
        if (existeProfesor(p)) {
            throw new Exception("El profesor ya existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Profesores VALUES (?,?)";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, p.getDni());
            pst.setString(2, p.getNombre());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error altaProfesor()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void bajaProfesor(Profesor p) throws Exception {
        if (!existeProfesor(p)) {
            throw new Exception("El profesor no existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM Profesores WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, p.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error bajaProfesor()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void listadoProfesores(List<Profesor> t) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Profesores ORDER BY dni";
            pst = ConexionBD.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            Profesor p;
            while (rs.next()) {
                p = new Profesor();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                t.add(p);
            }
        } catch (Exception e) {
            throw new Exception("Error listadoProfesores()!!", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void buscar(List<Profesor> t) throws SQLException, Exception {
        String sql;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (!FrmMantenimientoProfesores.dniBuscar.isEmpty() && FrmMantenimientoProfesores.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Profesores WHERE dni LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoProfesores.dniBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Profesor p;
                while (rs.next()) {
                    p = new Profesor();
                    p.setDni(rs.getString("dni"));
                    p.setNombre(rs.getString("nombre"));
                    t.add(p);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda profesores", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (FrmMantenimientoProfesores.dniBuscar.isEmpty() && !FrmMantenimientoProfesores.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Profesores WHERE nombre LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoProfesores.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Profesor p;
                while (rs.next()) {
                    p = new Profesor();
                    p.setDni(rs.getString("dni"));
                    p.setNombre(rs.getString("nombre"));
                    t.add(p);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda profesores", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (!FrmMantenimientoProfesores.dniBuscar.isEmpty() && !FrmMantenimientoProfesores.nombreBuscar.isEmpty()) {

            try {
                sql = "SELECT * FROM Profesores WHERE dni  LIKE ? AND Nombre LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoProfesores.dniBuscar + "%";
                String newFiltro2 = "%" + FrmMantenimientoProfesores.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                pst.setString(2, newFiltro2);
                rs = pst.executeQuery();
                Profesor p;
                while (rs.next()) {
                    p = new Profesor();
                    p.setDni(rs.getString("dni"));
                    p.setNombre(rs.getString("nombre"));
                    t.add(p);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda profesores", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        }else{
            try {
            sql = "SELECT * FROM Profesores ORDER BY dni";
            pst = ConexionBD.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            Profesor p;
            while (rs.next()) {
                p = new Profesor();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                t.add(p);
            }
        } catch (Exception e) {
            throw new Exception("Error buscar profesores", e);
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

    public static void actualizaProfesor(Profesor p) throws Exception {

        PreparedStatement pst = null;
        try {
            String sql = "UPDATE Profesores SET nombre=? WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setString(2, p.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error actualizar profesor", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }
    
    public static boolean getProfesor(Profesor p) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Profesores WHERE dni=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, p.getDni());
            rs = pst.executeQuery();
            while (rs.next()){
               p.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new Exception("Error al recuperar profesor", e);
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
