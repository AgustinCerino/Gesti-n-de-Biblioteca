package interfaces;

public interface Repositorio {
    void registrar(Object obj);
    Object consultar(String id);
    void actualizar(String id, Object obj);
    void eliminar(String id);

}
