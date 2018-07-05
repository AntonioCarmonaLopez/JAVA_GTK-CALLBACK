package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    /* Atributos **************************************************************/
    private static Connection conn;

    private static final String DB = "T12p03";  // El schema y usuario deben existir en la BD!!
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB + "?useSSL=false"; // &useServerPrepStmts=true";
    private static final String USER = "root";
    private static final String PASS = "root";

    /* Constructores **********************************************************/
    public ConexionBD() {
        conn = null;
    }

    /* Métodos getters & setters **********************************************/
    public static Connection getConn() {
        return conn;
    }

    /* Métodos ****************************************************************/
    private static void crearTablas() throws Exception {
        Statement st = null;
        String sql;
        try {
            st = conn.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS Profesores ("
                    + "dni VARCHAR(10) NOT NULL,"
                    + "nombre VARCHAR(50) NOT NULL,"
                    + "CONSTRAINT pk_Profesores PRIMARY KEY (dni) )";
            st.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS Cursos ("
                    + "id INTEGER NOT NULL,"
                    + "titulo VARCHAR(50) NOT NULL,"
                    + "horas DECIMAL(6,2) NOT NULL,"
                    + "dniProfesor VARCHAR(10) NULL,"
                    + "fecIni DATE NULL,"
                    + "fecFin DATE NULL,"
                    + "modalidad CHAR(1) NOT NULL,"
                    + "estado VARCHAR(12) NULL,"
                    + "CONSTRAINT pk_Cursos PRIMARY KEY (id),"
                    + "CONSTRAINT fk_Cursos_Profesores FOREIGN KEY (dniProfesor)"
                    + " REFERENCES Profesores (dni) ON DELETE SET NULL )";
            st.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS Alumnos ("
                    + "dni VARCHAR(10) NOT NULL,"
                    + "nombre VARCHAR(50) NOT NULL,"
                    + "mayorEdad BOOLEAN NOT NULL,"
                    + "CONSTRAINT pk_Alumnos PRIMARY KEY (dni) )";
            st.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS Matriculas ("
                    + "idCurso INTEGER NOT NULL,"
                    + "dniAlumno VARCHAR(10) NOT NULL,"
                    + "CONSTRAINT pk_Matriculas PRIMARY KEY (idCurso,dniAlumno),"
                    + "CONSTRAINT fk_Matriculas_Cursos FOREIGN KEY (idCurso)"
                    + " REFERENCES Cursos (id) ON DELETE CASCADE,"
                    + "CONSTRAINT fk_Matriculas_Alumnos FOREIGN KEY (dniAlumno)"
                    + " REFERENCES Alumnos (dni) ON DELETE CASCADE )";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new Exception("Error crearTablas()!!", e);
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public static void abrirConexion() throws Exception {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            crearTablas();
        } catch (SQLException e) {
            throw new Exception("Error abrirConexion()!!", e);
        }
    }

    public static void cerrarConexion() throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception("Error cerrarConexion()!!", e);
        }
    }

}
