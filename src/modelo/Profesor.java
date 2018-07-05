package modelo;

public class Profesor {

    /* Atributos **************************************************************/
    private String dni;
    private String nombre;

    /* Constructores **********************************************************/
    public Profesor() {
        dni = "";
        nombre = "";
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

}
