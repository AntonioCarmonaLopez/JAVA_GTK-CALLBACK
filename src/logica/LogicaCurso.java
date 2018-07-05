package logica;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Curso;
import modelo.Profesor;
import vista.FrmMantenimientoCurso;

public class LogicaCurso {

    /* Métodos ****************************************************************/
    public static boolean existeCurso(Curso c) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Cursos WHERE id=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, c.getId());
            rs = pst.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error existeCurso()!!", e);
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

    public static void altaCurso(Curso c) throws Exception {
        if (existeCurso(c)) {
            throw new Exception("El curso ya existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Cursos VALUES (?,?,?,?,?,?,?,?)";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, c.getId());
            pst.setString(2, c.getTitulo());
            pst.setDouble(3, c.getHoras());
            pst.setString(4, c.getDniProfesor());
            pst.setDate(5, (c.getFecIni() == null) ? null : Date.valueOf(c.getFecIni()));
            pst.setDate(6, (c.getFecFin() == null) ? null : Date.valueOf(c.getFecFin()));
            pst.setString(7, String.valueOf(c.getModalidad()));
            pst.setString(8, (c.getEstado() == null) ? null : c.getEstado().toString());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void bajaCurso(Curso c) throws Exception {
        if (!existeCurso(c)) {
            throw new Exception("El curso no existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM Cursos WHERE id=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error bajaCurso()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void listadoCursos(List<Curso> t) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Cursos ORDER BY id";
            pst = ConexionBD.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            Curso c;
            while (rs.next()) {
                c = new Curso();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setHoras(rs.getDouble("horas"));
                c.setDniProfesor(rs.getString("dniProfesor"));
                c.setFecIni((rs.getDate("fecIni") == null) ? null : rs.getDate("fecIni").toLocalDate());
                c.setFecFin((rs.getDate("fecFin") == null) ? null : rs.getDate("fecFin").toLocalDate());
                c.setModalidad(rs.getString("modalidad").charAt(0));
                c.setEstado((rs.getString("estado") == null) ? null : Curso.ESTADOCURSO.valueOf(rs.getString("estado")));
                t.add(c);
            }
        } catch (Exception e) {
            throw new Exception("Error listadoCursos()!!", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void buscar(List<Curso> t) throws SQLException, Exception {
        String sql;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (!FrmMantenimientoCurso.idBuscar.isEmpty() && FrmMantenimientoCurso.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Cursos WHERE id LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoCurso.idBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Curso c;
                while (rs.next()) {
                    c = new Curso();
                    c.setId(rs.getInt("id"));
                    c.setTitulo(rs.getString("titulo"));
                    t.add(c);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Cursos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (FrmMantenimientoCurso.idBuscar.isEmpty() && !FrmMantenimientoCurso.nombreBuscar.isEmpty()) {
            try {
                sql = "SELECT * FROM Cursos WHERE titulo  LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoCurso.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                Curso c;
                while (rs.next()) {
                    c = new Curso();
                    c.setId(rs.getInt("id"));
                    c.setTitulo(rs.getString("titulo"));
                    t.add(c);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Cursos", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (!FrmMantenimientoCurso.idBuscar.isEmpty() && !FrmMantenimientoCurso.nombreBuscar.isEmpty()) {

            try {
                sql = "SELECT * FROM Cursos WHERE id LIKE ? AND titulo LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoCurso.idBuscar + "%";
                String newFiltro2 = "%" + FrmMantenimientoCurso.nombreBuscar + "%";
                pst.setString(1, newFiltro);
                pst.setString(2, newFiltro2);
                rs = pst.executeQuery();
                Curso c;
                while (rs.next()) {
                    c = new Curso();
                    c.setId(rs.getInt("id"));
                    c.setTitulo(rs.getString("titulo"));
                    t.add(c);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Cursos", e);
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
                sql = "SELECT * FROM Cursos ORDER BY id";
                pst = ConexionBD.getConn().prepareStatement(sql);
                rs = pst.executeQuery();
                Curso c;
                while (rs.next()) {
                    c = new Curso();
                    c.setId(rs.getInt("id"));
                    c.setTitulo(rs.getString("titulo"));
                    c.setHoras(rs.getDouble("horas"));
                    c.setDniProfesor(rs.getString("dniProfesor"));
                    c.setFecIni((rs.getDate("fecIni") == null) ? null : rs.getDate("fecIni").toLocalDate());
                    c.setFecFin((rs.getDate("fecFin") == null) ? null : rs.getDate("fecFin").toLocalDate());
                    c.setModalidad(rs.getString("modalidad").charAt(0));
                    c.setEstado((rs.getString("estado") == null) ? null : Curso.ESTADOCURSO.valueOf(rs.getString("estado")));
                    t.add(c);
                }
            } catch (Exception e) {
                throw new Exception("Error buscar curso", e);
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

    public static void actualizaCurso(Curso c) throws Exception {

        PreparedStatement pst = null;
        try {
            String sql = "UPDATE Cursos SET titulo=?,horas=?,dniProfesor=?,fecIni=?,fecFin=?,"
                    + "modalidad=?,estado=? WHERE id=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setString(1, c.getTitulo());
            pst.setDouble(2, c.getHoras());
            pst.setString(3, c.getDniProfesor());
            pst.setDate(4, (c.getFecIni() == null) ? null : Date.valueOf(c.getFecIni()));
            pst.setDate(5, (c.getFecFin() == null) ? null : Date.valueOf(c.getFecFin()));
            pst.setString(6, String.valueOf(c.getModalidad()));
            pst.setString(7, (c.getEstado() == null) ? null : c.getEstado().toString());
            pst.setInt(8, c.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error actualizar Curso", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }
    
    public static boolean getCurso(Curso c) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Cursos WHERE id=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, c.getId());
            rs = pst.executeQuery();
            while (rs.next()){
               c.setTitulo(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new Exception("Error al recuperar Curso", e);
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
