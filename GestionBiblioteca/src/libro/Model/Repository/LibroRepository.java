package libro.Model.Repository;

import interfaces.Repositorio;
import libro.Model.Entity.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroRepository implements Repositorio {


    private List <Libro> listaLibros;

    public LibroRepository() {
        this.listaLibros = new ArrayList<>();
    }

    @Override
    public void registrar(Object obj) {

        this.listaLibros.add((Libro) obj);

    }

    @Override
    public Object consultar(String id) {
        for (Libro unLibro : this.listaLibros) {
            if (unLibro.getTitulo().equals(id)) {
                return unLibro;
            }
        }
        return null;
    }

    @Override
    public void actualizar(String id, Object obj) {
        int posLibroaActualizar = getPosLibro(id);
        if (posLibroaActualizar != -1){
            this.listaLibros.set(posLibroaActualizar, (Libro) obj);
        }
    }

    @Override
    public void eliminar(String id) {

        Libro libroParaEliminar = (Libro) consultar(id);
        if (libroParaEliminar != null){
            this.listaLibros.remove(libroParaEliminar);
        }
        else {
            System.out.println("El libro no existe!");
        }
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public int getPosLibro(String titulo){
        for (int i=0; i<this.listaLibros.size();  i++){
            if (this.listaLibros.get(i).getTitulo().equals(titulo)){
                return i;
            }
        }
        return -1;
    }

    /*Libro recorrerListaLibros(){
        for (Libro unLibro: this.listaLibros){
            return unLibro;
        }
        return null;
    }*/


}
