package usuario.View;

import libro.Model.Entity.Libro;
import usuario.Model.Entity.Usuario;

import java.util.Scanner;

public class UsuarioView {

    Scanner scanner = new Scanner(System.in);

    public Usuario cargarUsuarioManual (){

        System.out.println("Ingrese el ID del Usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el Nombre Y Apellido del Usuario: ");
        String nomYApell = scanner.nextLine();

        System.out.println("Ingrese el Tipo de Usuario: (Estudiante/Profesor) ");
        String tipo = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(id,nomYApell, tipo);

        return nuevoUsuario;
    }
    public void leerUsuario(Usuario unUsuario){
        System.out.println("----------------------------");
        System.out.println("Nombre y Apellido: " + unUsuario.getNombreYApellido());
        System.out.println("Tipo de Uusario: " + unUsuario.getTipoUsuario());
        System.out.println("ID del Usuario: " + unUsuario.getId());
        System.out.println("----------------------------");
    }

    public String pedirNombreParaActualizar(){
        System.out.println("Ingrese el Nombre del Usuario que desea actualizar: ");
        String nombre = scanner.nextLine();

        return nombre;
    }

    public Usuario pedirDatosActualizadosUsuario(Usuario unUsuario){

        System.out.println("Ingrese el nuevo Tipo de Usuario: ");
        unUsuario.setTipoUsuario(scanner.nextLine());

        return unUsuario;
    }

    public String pedirNombreParaEliminar(){
        System.out.println("Ingrese el Nombre del Usuario que desea eliminar: ");
        String nombre = scanner.nextLine();

        return nombre;
    }


}
