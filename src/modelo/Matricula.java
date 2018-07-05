package modelo;

public class Matricula {

    /* Atributos **************************************************************/
    private int idCurso;
    private String dniAlumno;

    /* Constructores **********************************************************/
    public Matricula() {
        this.idCurso = 0;
        this.dniAlumno = "";
    }

    /* Métodos getters & setters **********************************************/
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

}
