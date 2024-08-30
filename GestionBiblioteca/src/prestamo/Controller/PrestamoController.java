package prestamo.Controller;

import libro.Model.Entity.Libro;
import libro.Model.Repository.LibroRepository;
import libro.View.LibroView;
import prestamo.Model.Entity.Prestamo;
import prestamo.Model.Repository.PrestamoRepository;
import prestamo.View.PrestamoView;
import usuario.Model.Entity.Usuario;
import usuario.Model.Repository.UsuarioRepository;
import usuario.View.UsuarioView;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class PrestamoController {

    private PrestamoView prestamoView;
    private PrestamoRepository prestamoRepository;
    private LibroRepository libroRepository;
    private LibroView libroView;

    private UsuarioView usuarioView;
    private UsuarioRepository usuarioRepository;


    public PrestamoController(PrestamoView prestamoView, PrestamoRepository prestamoRepository, LibroView libroView, LibroRepository libroRepository,
                              UsuarioView usuarioView, UsuarioRepository usuarioRepository ){
        this.prestamoView = prestamoView;
        this.prestamoRepository = prestamoRepository;

        this.libroView = libroView;
        this.libroRepository = libroRepository;

        this.usuarioView = usuarioView;
        this.usuarioRepository = usuarioRepository;
    }

    public Libro buscaLibroParaPrestamo(String titulo){
        Libro libroParaPrestamo = (Libro) libroRepository.consultar(titulo);
        if (libroParaPrestamo != null){
            return libroParaPrestamo;
        }
        else{
            System.out.println("El Libro " + titulo +  " no existe!");
            return null;
        }
    }

    public Usuario buscaUsuarioParaPrestar(String nombre){
        Usuario usuarioParaPrestar = (Usuario) usuarioRepository.consultar(nombre);
        if (usuarioParaPrestar != null){
            return usuarioParaPrestar;
        }
        else {
            System.out.println("El Usuario " + nombre + " no existe!");
            return null;
        }
    }

    public void prestarLibro(){
        //seleccionar el libro
        String tituloLibro = prestamoView.pedirTituloParaPrestar();
        Libro libroParaPrestar = this.buscaLibroParaPrestamo(tituloLibro);
        //seleccionar el usuario
        String nombreUsuario = prestamoView.pedirNombreParaPrestar();
        Usuario usuarioParaPrestar = this.buscaUsuarioParaPrestar(nombreUsuario);

        Prestamo unPrestamo = this.fechasPrestamo();
        unPrestamo.setLibro(libroParaPrestar);
        unPrestamo.setUsuario(usuarioParaPrestar);

        if(libroParaPrestar != null && usuarioParaPrestar != null){
            unPrestamo.setLibro(libroParaPrestar);
            unPrestamo.setUsuario(usuarioParaPrestar);
        }

        this.prestamoRepository.registrar(unPrestamo);

        System.out.println("El prestamo se realizo con exito!");

    }

    public Prestamo fechasPrestamo(/*Prestamo unPrestamo*/){
        Date fechaPrestamo = new Date();
        long tiempoPrestamo = 7*24*60*60*1000; //7 dias en milisegundos
        Date fechaDeDevolucionEsperada = new Date(fechaPrestamo.getTime() + tiempoPrestamo);

        Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDeDevolucionEsperada);

        return prestamo;
    }

    public void devolucionDePrestamo(){
        String nombre = prestamoView.pedirNombreParaDevolucion();
        Prestamo prestamo = (Prestamo) prestamoRepository.consultar(nombre);
        this.prestamoView.leerPrestamo(prestamo);
        this.prestamoRepository.eliminar(nombre);

        System.out.println("La Devolucion se realizo con exito!");
    }

    public void mostrarListaPrestamos(){
        List<Prestamo> listaPrestamos = this.prestamoRepository.getListaPrestamos();
        for (Prestamo unPrestamo: listaPrestamos){
            this.prestamoView.leerPrestamo(unPrestamo);
        }
    }

    public void verificarEstadoPrestamo(){
        String nombre = prestamoView.pedirNombreParaDevolucion();
        Prestamo prestamo = (Prestamo) prestamoRepository.consultar(nombre);
        this.prestamoView.leerPrestamo(prestamo);

        Date fechaDeDevolucionEsperada = prestamo.getFechaDevolucion();
        Date fechaActual = new Date();

        if (fechaActual.getTime() > fechaDeDevolucionEsperada.getTime()){
            System.out.println("           ---------ALERTA---------");
            System.out.println("La fecha de Devolucion excede el plazo pactado");
            System.out.println();
            System.out.println("El Usuario " + prestamo.getUsuario().getNombreYApellido() + " debe abonar una multa de $5000");
        }
        else {
            System.out.println("El prestamo sigue en vigencia");
        }
    }





}
