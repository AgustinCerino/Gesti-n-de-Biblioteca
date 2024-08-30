package usuario.Model.Repository;

import interfaces.Repositorio;
import libro.Model.Entity.Libro;
import usuario.Model.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements Repositorio {

    List <Usuario> listaUsuarios;

    public UsuarioRepository() {
        super();
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public void registrar(Object obj) {

        this.listaUsuarios.add((Usuario) obj);
    }

    @Override
    public Object consultar(String id) {
        for (Usuario unUsuario : this.listaUsuarios) {
            if (unUsuario.getNombreYApellido().equals(id)) {
                return unUsuario;
            }
        }
        return null;
    }

    @Override
    public void actualizar(String id, Object obj) {
        int posLibroaActualizar = getPosUsuario(id);
        if (posLibroaActualizar != -1){
            this.listaUsuarios.set(posLibroaActualizar, (Usuario) obj);
        }
    }

    @Override
    public void eliminar(String id) {
        Usuario usuarioParaEliminar = (Usuario) consultar(id);
        if (usuarioParaEliminar != null){
            this.listaUsuarios.remove(usuarioParaEliminar);
        }
        else {
            System.out.println("El Usuario no existe!");
        }
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getPosUsuario(String nomYapell){
        for (int i=0; i<this.listaUsuarios.size();  i++){
            if (this.listaUsuarios.get(i).getNombreYApellido().equals(nomYapell)){
                return i;
            }
        }
        return -1;
    }

}
