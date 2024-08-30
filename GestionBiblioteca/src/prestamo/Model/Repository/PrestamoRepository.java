package prestamo.Model.Repository;

import interfaces.Repositorio;
import libro.Model.Entity.Libro;
import libro.Model.Repository.LibroRepository;
import prestamo.Model.Entity.Prestamo;
import usuario.Model.Entity.Usuario;
import usuario.Model.Repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class PrestamoRepository implements Repositorio {

    LibroRepository libroRepository = new LibroRepository();
    UsuarioRepository usuarioRepository = new UsuarioRepository();

    private List<Prestamo> listaPrestamos;

    public PrestamoRepository(){
        this.listaPrestamos = new ArrayList<>();
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    @Override
    public void registrar(Object obj) {
        this.listaPrestamos.add((Prestamo) obj);
    }

    @Override
    public Object consultar(String id) {
        for (Prestamo unPrestamo: this.listaPrestamos) {
            if (unPrestamo.getUsuario().getNombreYApellido().equals(id)) {
                return unPrestamo;
            }
        }
        return null;
    }

    @Override
    public void actualizar(String id, Object obj) {

    }

    @Override
    public void eliminar(String id) {
        Prestamo prestamoParaEliminar = (Prestamo) consultar(id);
        if (prestamoParaEliminar != null){
            this.listaPrestamos.remove(prestamoParaEliminar);
        }
        else {
            System.out.println("El Prestamo no existe!");
        }
    }


}
