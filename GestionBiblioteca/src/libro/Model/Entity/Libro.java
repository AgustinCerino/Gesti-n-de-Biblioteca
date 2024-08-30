package libro.Model.Entity;

public class Libro {

    private String titulo;
    private String autor;
    private int cantCopiasDisponibles;

    public Libro(String titulo, String autor, int cantCopiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantCopiasDisponibles = cantCopiasDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantCopiasDisponibles() {
        return cantCopiasDisponibles;
    }

    public void setCantCopiasDisponibles(int cantCopiasDisponibles) {
        this.cantCopiasDisponibles = cantCopiasDisponibles;
    }
}
