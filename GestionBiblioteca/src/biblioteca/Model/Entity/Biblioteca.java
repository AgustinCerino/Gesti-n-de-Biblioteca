package biblioteca.Model.Entity;

import interfaces.Prestable;
import prestamo.Controller.PrestamoController;

import java.util.Date;

public class Biblioteca implements Prestable {

    private PrestamoController prestamoController;

    public Biblioteca(PrestamoController prestamoController){
        this.prestamoController = prestamoController;
    }

    public Biblioteca() {
        super();
    }

    @Override
    public void realizarPrestamo() {
        prestamoController.prestarLibro();
    }

    @Override
    public Date registrarFechas() {
        return null;
    }

    @Override
    public void realizarDevolucion() {
        prestamoController.devolucionDePrestamo();
    }
}
