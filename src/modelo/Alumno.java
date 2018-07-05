package modelo;

public class Alumno {

    /* Atributos **************************************************************/
    private String dni;
    private String nombre;
    private boolean mayorEdad;

    /* Constructores **********************************************************/
    public Alumno() {
        dni = "";
        nombre = "";
        mayorEdad = false;
    }

    /* Métodos getters & setters **********************************************/
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

    public boolean isMayorEdad() {
        return mayorEdad;
    }

    public void setMayorEdad(boolean mayorEdad) {
        this.mayorEdad = mayorEdad;
    }

}
