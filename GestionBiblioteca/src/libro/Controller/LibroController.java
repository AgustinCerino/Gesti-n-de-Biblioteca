package libro.Controller;

import libro.Model.Entity.Libro;
import libro.View.LibroView;
import libro.Model.Repository.LibroRepository;

import java.util.ArrayList;
import java.util.List;

public class LibroController {

    private LibroView libroView;
    private LibroRepository libroRepository;

    public LibroController(LibroView libroView, LibroRepository libroRepository){
        this.libroView = libroView;
        this.libroRepository = libroRepository;
    }

    public void creacionLibro(){
        this.cargarLibro(libroView.cargarLibroManual());
    }

    public void cargarLibro(Libro unLibro){

        libroRepository.getListaLibros().add(unLibro);
    }

    public void actualizarLibro(){
        String tituloLibroParaActualizar = libroView.pedirTituloParaActualizar();
        Libro libroParaActualizar = (Libro) libroRepository.consultar(tituloLibroParaActualizar);

        if ( libroParaActualizar != null) {

            Libro libroActualizado = libroView.pedirDatosActualizadosLibro(libroParaActualizar);
            libroRepository.actualizar(tituloLibroParaActualizar, libroActualizado);
            System.out.println("La Actualizacion fue exitosa!");

        }
        else {
            System.out.println("El libro ingresado no existe!");
        }
    }

    public void eliminarLibro(){

        String tituloLibroParaEliminar = libroView.pedirTituloParaEliminar();

        libroRepository.eliminar(tituloLibroParaEliminar);
        System.out.println("El Libro se elimino con exito!");

    }

    public void mostrarListaLibros(){

    List<Libro> listaLibros = this.libroRepository.getListaLibros();

        for (Libro unLibro: listaLibros){
            libroView.leerLibro(unLibro);
        }
    }





}
