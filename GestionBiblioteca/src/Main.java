import biblioteca.Model.Entity.Biblioteca;
import libro.Controller.LibroController;
import libro.Model.Entity.Libro;
import libro.Model.Repository.LibroRepository;
import libro.View.LibroView;
import prestamo.Controller.PrestamoController;
import prestamo.Model.Repository.PrestamoRepository;
import prestamo.View.PrestamoView;
import usuario.Controller.UsuarioController;
import usuario.Model.Entity.Usuario;
import usuario.Model.Repository.UsuarioRepository;
import usuario.View.UsuarioView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibroRepository libroRepository = new LibroRepository();
        LibroView libroView = new LibroView();

        UsuarioView usuarioView = new UsuarioView();
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        PrestamoView prestamoView = new PrestamoView();
        PrestamoRepository prestamoRepository = new PrestamoRepository();


        LibroController libroController = new LibroController(libroView, libroRepository);
        UsuarioController usuarioController = new UsuarioController(usuarioView, usuarioRepository);
        PrestamoController prestamoController = new PrestamoController(prestamoView, prestamoRepository, libroView, libroRepository, usuarioView, usuarioRepository);

        Biblioteca biblioteca = new Biblioteca(prestamoController);

        Scanner scanner = new Scanner(System.in);

        int op = -1;
        do {
            System.out.println("1- Menu Usuario");
            System.out.println("2- Menu Libros");
            System.out.println("3- Menu Biblioteca");
            System.out.println("4- Sign out");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt(); // Leer la entrada como cadena
            switch (op) {
                case 1:

                    int opUsuario = -1;
                    do {
                        System.out.println("1- Agregar Usuario");
                        System.out.println("2- Actualizar Usuario");
                        System.out.println("3- Eliminar Usuario");
                        System.out.println("4- Mostrar Lista de Usuarios");
                        System.out.println("5- Volver al Menú Principal");

                        System.out.println("Ingrese una opción");
                        opUsuario = scanner.nextInt();

                        switch (opUsuario) {
                            case 1:
                                Usuario usuario1 = new Usuario(1, "jose perez", "estudiante");
                                Usuario usuario2 = new Usuario(2, "agustin cerino", "estudiante");
                                Usuario usuario3 = new Usuario(3, "german beder", "profesor");
                                Usuario usuario4 = new Usuario(4, "marcelo toscano", "profesor");

                                usuarioController.cargarUsuario(usuario1);
                                usuarioController.cargarUsuario(usuario2);
                                usuarioController.cargarUsuario(usuario3);
                                usuarioController.cargarUsuario(usuario4);
                                break;
                            case 2:
                                usuarioController.actualizarUsuario();
                                break;
                            case 3:
                                usuarioController.eliminarUsuario();
                                break;
                            case 4:
                                usuarioController.mostrarListaUsuarios();
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                    } while (opUsuario != 5);

                    break;
                case 2:

                    int opLibro = -1;
                    do {
                        System.out.println("1- Agregar Libro");
                        System.out.println("2- Actualizar Libro");
                        System.out.println("3- Eliminar Libro");
                        System.out.println("4- Mostrar Lista de Libros");
                        System.out.println("5- Volver al Menú Principal");

                        System.out.println("Ingrese una opción");
                        opLibro = scanner.nextInt();

                        switch (opLibro) {
                            case 1:
                                Libro libro1 = new Libro("La vez que casi me muero", "gBeder", 350);
                                Libro libro2 = new Libro("El hombre que daba charla a los call center", "gBeder", 125);
                                Libro libro3 = new Libro("La generacion dorada", "gBeder", 560);

                                libroController.cargarLibro(libro1);
                                libroController.cargarLibro(libro2);
                                libroController.cargarLibro(libro3);
                                break;
                            case 2:
                                libroController.actualizarLibro();
                                break;
                            case 3:
                                libroController.eliminarLibro();
                                break;
                            case 4:
                                libroController.mostrarListaLibros();
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                    } while (opLibro != 5);

                    break;
                case 3:

                    int opBiblioteca = -1;
                    do {
                        System.out.println("1- Agregar Prestamo");
                        System.out.println("2- Verificar Estado de Prestamo");
                        System.out.println("3- Registrar Devolucion");
                        System.out.println("4- Mostrar Lista de Prestamos Activos");
                        System.out.println("5- Volver al Menú Principal");

                        System.out.println("Ingrese una opción");
                        opBiblioteca = scanner.nextInt();

                        switch (opBiblioteca) {
                            case 1:
                                biblioteca.realizarPrestamo();
                                break;
                            case 2:
                                prestamoController.verificarEstadoPrestamo();
                                break;
                            case 3:
                                biblioteca.realizarDevolucion();
                                break;
                            case 4:
                                prestamoController.mostrarListaPrestamos();
                                break;
                            case 5:
                                System.out.println("Volviendo al Menú Principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                    } while (opBiblioteca != 5);

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (op != 4);
        System.out.println("Programa finalizado");
        scanner.close();


    }
}