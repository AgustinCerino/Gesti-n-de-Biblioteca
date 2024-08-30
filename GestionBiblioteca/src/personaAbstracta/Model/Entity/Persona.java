package personaAbstracta.Model.Entity;

public abstract class Persona {

    private int id;
    private String nombreYApellido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Persona(int id, String nombreYApellido) {
        this.id = id;
        this.nombreYApellido = nombreYApellido;
    }

}
