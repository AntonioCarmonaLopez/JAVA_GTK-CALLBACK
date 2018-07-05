package logica;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Matricula;
import vista.FrmMantenimientoMatricula;

public class LogicaMatricula {

    /* Métodos ****************************************************************/
    public static boolean existeMatricula(Matricula m) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Matriculas WHERE idCurso=? AND dniAlumno=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, m.getIdCurso());
            pst.setString(2, m.getDniAlumno());
            rs = pst.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new Exception("Error existeMatricula()!!", e);
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

    public static void altaMatricula(Matricula m) throws Exception {
        if (existeMatricula(m)) {
            throw new Exception("La matrícula ya existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO Matriculas VALUES (?,?)";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, m.getIdCurso());
            pst.setString(2, m.getDniAlumno());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error altaMatricula()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void bajaMatricula(Matricula m) throws Exception {
        if (!existeMatricula(m)) {
            throw new Exception("La matrícula no existe!!");
        }
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM Matriculas WHERE idCurso=? AND dniAlumno=?";
            pst = ConexionBD.getConn().prepareStatement(sql);
            pst.setInt(1, m.getIdCurso());
            pst.setString(2, m.getDniAlumno());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error bajaMatricula()!!", e);
        } finally {
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void listadoMatriculas(List<MatriculasListado> t) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT c.id,c.titulo,a.dni,a.nombre "
                    + "FROM Cursos c,Alumnos a,Matriculas m "
                    + "WHERE c.id=m.idCurso AND a.dni=m.dniAlumno "
                    + "ORDER BY c.id,a.dni";
            pst = ConexionBD.getConn().prepareStatement(sql);
            rs = pst.executeQuery();
            MatriculasListado ml;
            while (rs.next()) {
                ml = new MatriculasListado();
                ml.setId(rs.getInt(1));
                ml.setTitulo(rs.getString(2));
                ml.setDni(rs.getString(3));
                ml.setNombre(rs.getString(4));
                t.add(ml);
            }
        } catch (Exception e) {
            throw new Exception("Error listadoMatriculas()!!", e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
    }

    public static void buscar(List<MatriculasListado> t) throws SQLException, Exception {
        String sql;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (!FrmMantenimientoMatricula.idBuscar.isEmpty() && FrmMantenimientoMatricula.dniBuscar.isEmpty()) {
            try {
                sql = "SELECT m.idCurso,m.dniAlumno,c.titulo,a.nombre "
                        + "FROM Matriculas m,Cursos c,Alumnos a "
                        + "WHERE c.id=m.idCurso "
                            + "AND a.dni=m.dniAlumno " 
                            + "AND m.idCurso LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoMatricula.idBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                MatriculasListado ml;
                while (rs.next()) {
                    ml = new MatriculasListado();
                    ml.setId(rs.getInt(1));
                    ml.setTitulo(rs.getString(2));
                    ml.setDni(rs.getString(3));
                    ml.setNombre(rs.getString(4));
                    t.add(ml);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Matriculas", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (FrmMantenimientoMatricula.idBuscar.isEmpty() && !FrmMantenimientoMatricula.dniBuscar.isEmpty()) {
            try {
                sql = "SELECT m.idCurso,m.dniAlumno,c.titulo,a.nombre "
                        + "FROM Matriculas m,Cursos c,Alumnos a "
                        + "WHERE c.id=m.idCurso "
                            + "AND a.dni=m.dniAlumno "
                            + "AND m.dniAlumno  LIKE ?";
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoMatricula.dniBuscar + "%";
                pst.setString(1, newFiltro);
                rs = pst.executeQuery();
                MatriculasListado ml;
                while (rs.next()) {
                    ml = new MatriculasListado();
                    ml.setId(rs.getInt(1));
                    ml.setTitulo(rs.getString(2));
                    ml.setDni(rs.getString(3));
                    ml.setNombre(rs.getString(4));
                    t.add(ml);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Matriculas", e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            }
        } else if (!FrmMantenimientoMatricula.idBuscar.isEmpty() && !FrmMantenimientoMatricula.dniBuscar.isEmpty()) {

            try {
                sql = "SELECT m.idCurso,m.dniAlumno,c.titulo,a.nombre "
                        + "FROM Matriculas m,Cursos c,Alumnos a "
                        + "WHERE c.id=m.idCurso "
                            + "AND a.dni=m.dniAlumno "
                            + "AND m.dniAlumno  LIKE ? "
                            + "AND m.idCurso LIKE ?";
                        
                pst = ConexionBD.getConn().prepareCall(sql);
                String newFiltro = "%" + FrmMantenimientoMatricula.idBuscar + "%";
                String newFiltro2 = "%" + FrmMantenimientoMatricula.dniBuscar + "%";
                pst.setString(1, newFiltro);
                pst.setString(2, newFiltro2);
                rs = pst.executeQuery();
                MatriculasListado ml;
                while (rs.next()) {
                    ml = new MatriculasListado();
                    ml.setId(rs.getInt(1));
                    ml.setTitulo(rs.getString(2));
                    ml.setDni(rs.getString(3));
                    ml.setNombre(rs.getString(4));
                    t.add(ml);
                }
            } catch (Exception e) {
                throw new Exception("Error Busqueda Matriculas", e);
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
                sql="SELECT m.idCurso,m.dniAlumno,c.titulo,a.nombre "
                        + "FROM Matriculas m,Cursos c,Alumnos a "
                        + "WHERE c.id=m.idCurso AND a.dni=m.dniAlumno";
                pst = ConexionBD.getConn().prepareStatement(sql);
                rs = pst.executeQuery();
                MatriculasListado ml;
                while (rs.next()) {
                    ml = new MatriculasListado();
                    ml.setId(rs.getInt(1));
                    ml.setTitulo(rs.getString(2));
                    ml.setDni(rs.getString(3));
                    ml.setNombre(rs.getString(4));
                    t.add(ml);
                }
            } catch (Exception e) {
                throw new Exception("Error buscar matricula", e);
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

    public static class MatriculasListado {

        private int id;
        private String titulo;
        private String dni;
        private String nombre;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

}
