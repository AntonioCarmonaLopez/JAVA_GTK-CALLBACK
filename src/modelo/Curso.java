package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Curso {

    /* Atributos **************************************************************/
    private int id;
    private String titulo;
    private double horas;
    private String dniProfesor;
    private LocalDate fecIni;
    private LocalDate fecFin;
    private char modalidad;         // (P)resencial, (T)elemático
    private ESTADOCURSO estado;     // Programado, Realizándose, Finalizado

    public static enum ESTADOCURSO {
        Programado, Realizándose, Finalizado
    }

    /* Constructores **********************************************************/
    public Curso() {
        id = 0;
        titulo = "";
        horas = 0.0;
        dniProfesor = null;
        fecIni = null;
        fecFin = null;
        modalidad = 'P';
        estado = null;
    }

    /* Métodos getters & setters **********************************************/
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

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public String getDniProfesor() {
        return dniProfesor;
    }

    public String getDniProfesorString() {
        if (dniProfesor == null) {
            return "";
        } else {
            return dniProfesor;
        }
    }

    public void setDniProfesor(String dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    public LocalDate getFecIni() {
        return fecIni;
    }

    public String getFecIniString() {
        if (fecIni != null) {
            return fecIni.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        } else {
            return "";
        }
    }

    public void setFecIni(LocalDate fecIni) {
        this.fecIni = fecIni;
    }

    public void setFecIniString(String fecIni) {
        if (fecIni == null) {
            this.fecIni = null;
        } else {
            this.fecIni = LocalDate.of(Integer.parseInt(fecIni.substring(6, 10)),
                    Integer.parseInt(fecIni.substring(3, 5)),
                    Integer.parseInt(fecIni.substring(0, 2)));
        }
    }

    public LocalDate getFecFin() {
        return fecFin;
    }

    public String getFecFinString() {
        if (fecFin != null) {
            return fecFin.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        } else {
            return "";
        }
    }

    public void setFecFin(LocalDate fecFin) {
        this.fecFin = fecFin;
    }

    public void setFecFinString(String fecFin) {
        if (fecFin == null) {
            this.fecFin = null;
        } else {
            this.fecFin = LocalDate.of(Integer.parseInt(fecFin.substring(6, 10)),
                    Integer.parseInt(fecFin.substring(3, 5)),
                    Integer.parseInt(fecFin.substring(0, 2)));
        }
    }

    public char getModalidad() {
        return modalidad;
    }

    public void setModalidad(char modalidad) {
        this.modalidad = modalidad;
    }

    public ESTADOCURSO getEstado() {
        return estado;
    }

    public String getEstadoString() {
        if (estado == null) {
            return "";
        } else {
            return estado.toString();
        }
    }

    public void setEstado(ESTADOCURSO estado) {
        this.estado = estado;
    }

}
