package usuario.Model.Entity;

import personaAbstracta.Model.Entity.Persona;

public class Usuario extends Persona{

    private String tipoUsuario;


    public Usuario(int id, String nombreYApellido, String tipoUsuario) {
        super(id, nombreYApellido);
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
