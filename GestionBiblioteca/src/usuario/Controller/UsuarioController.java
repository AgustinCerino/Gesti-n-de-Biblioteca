package usuario.Controller;

import libro.Model.Entity.Libro;
import usuario.Model.Entity.Usuario;
import usuario.Model.Repository.UsuarioRepository;
import usuario.View.UsuarioView;

import java.util.List;

public class UsuarioController {

    private UsuarioView usuarioView;
    private UsuarioRepository usuarioRepository;

    public UsuarioController (UsuarioView usuarioView, UsuarioRepository usuarioRepository){
        this.usuarioView = usuarioView;
        this.usuarioRepository = usuarioRepository;
    }

    public void creacionDeUsuario(){
        this.cargarUsuario(usuarioView.cargarUsuarioManual());
    }

    public void cargarUsuario(Usuario unUsuario){

        usuarioRepository.getListaUsuarios().add(unUsuario);
    }

    public void actualizarUsuario(){
        String nombreUsuarioParaActualizar = usuarioView.pedirNombreParaActualizar();
        Usuario usuarioParaActualizar = (Usuario) usuarioRepository.consultar(nombreUsuarioParaActualizar);

        if ( usuarioParaActualizar != null) {

            Usuario usuarioActualizado = usuarioView.pedirDatosActualizadosUsuario(usuarioParaActualizar);
            usuarioRepository.actualizar(nombreUsuarioParaActualizar, usuarioActualizado);
            System.out.println("La Actualizacion fue exitosa!");

        }
        else {
            System.out.println("El Usuario ingresado no existe!");
        }
    }

    public void eliminarUsuario(){

        String nombreUsuarioParaEliminar = usuarioView.pedirNombreParaEliminar();

        usuarioRepository.eliminar(nombreUsuarioParaEliminar);
        System.out.println("El Usuario se elimino con exito!");

    }

    public void mostrarListaUsuarios(){

        List<Usuario> listaUsuarios = this.usuarioRepository.getListaUsuarios();

        for (Usuario unUsuario: listaUsuarios){
            usuarioView.leerUsuario(unUsuario);
        }
    }
}
