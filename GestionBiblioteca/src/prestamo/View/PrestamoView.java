package prestamo.View;

import libro.Model.Entity.Libro;
import prestamo.Model.Entity.Prestamo;
import usuario.Model.Entity.Usuario;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

public class PrestamoView {

    Scanner scanner = new Scanner(System.in);

    public String pedirTituloParaPrestar(){
        System.out.println("Ingrese el Titulo del libro que va a Prestar: ");
        String titulo = scanner.nextLine();

        return titulo;
    }

    public String pedirNombreParaPrestar(){
        System.out.println("Ingrese el Nombre del Usuario al que se lo va a Prestar: ");
        String titulo = scanner.nextLine();

        return titulo;
    }

    public void leerPrestamo(Prestamo unPrestamo){
        Usuario u = unPrestamo.getUsuario();
        Libro l = unPrestamo.getLibro();
        Date fechaPrestamo = unPrestamo.getFechaPrestamo();
        Date fechaDevolucion = unPrestamo.getFechaDevolucion();

        System.out.println("------------------------------------");
        System.out.println("     INFORMACION DEL PRESTAMO");
        System.out.println();
        System.out.println("Prestado a: " + u.getNombreYApellido());
        System.out.println("El libro: " + l.getTitulo());
        System.out.println();
        System.out.println("Fecha de prestamo: " + fechaPrestamo);
        System.out.println("Fecha de devolucion: " + fechaDevolucion);
        System.out.println("------------------------------------");
    }

    public String pedirNombreParaDevolucion(){
        System.out.println("Ingrese el Nombre del Usuario que realiza la devolucion: ");
        String titulo = scanner.nextLine();

        return titulo;
    }

}
