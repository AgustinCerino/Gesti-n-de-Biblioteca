package libro.View;

import libro.Model.Entity.Libro;
import usuario.Model.Entity.Usuario;

import java.util.List;
import java.util.Scanner;

public class LibroView {

    Scanner scanner = new Scanner(System.in);

    public Libro cargarLibroManual (){

        System.out.println("Ingrese el Titulo del Libro: ");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el Autor del Libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingrese la Cantidad de Copias Disponibles: ");
        int cant = scanner.nextInt();
        scanner.nextLine();

        Libro nuevoLibro = new Libro(titulo, autor, cant);

        return nuevoLibro;
    }
public void leerLibro(Libro unLibro){
    System.out.println("----------------------------");
    System.out.println("Titulo: " + unLibro.getTitulo());
    System.out.println("Autor: " + unLibro.getAutor());
    System.out.println("Cantidad de Copias Disponibles: " + unLibro.getCantCopiasDisponibles());
    System.out.println("----------------------------");
}

public String pedirTituloParaActualizar(){
    System.out.println("Ingrese el Titulo del libro que desea actualizar: ");
    String titulo = scanner.nextLine();

    return titulo;
}

public Libro pedirDatosActualizadosLibro(Libro unLibro){

    System.out.println("Ingrese la nueva Cantidad de Copias Disponibles: ");
    unLibro.setCantCopiasDisponibles(scanner.nextInt());
    scanner.nextLine();

    return unLibro;
}

    public String pedirTituloParaEliminar(){
        System.out.println("Ingrese el Titulo del libro que desea eliminar: ");
        String titulo = scanner.nextLine();

        return titulo;
    }

}
