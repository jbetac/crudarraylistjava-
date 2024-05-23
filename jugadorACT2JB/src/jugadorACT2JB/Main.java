package jugadorACT2JB;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//creamos ArrayList para almacenar a los jugadores
	private static ArrayList<Jugador> jugadores = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //creamos objeto tipo scanner para obtener los datos ingresados por teclado
        int opcion;
// creamos el menú de opciones del programa para elegir
        do {
            System.out.println("\\****Menu Jugador V1.0****//");
            System.out.println("[1]. Agregar un jugador");
            System.out.println("[2]. Buscar un jugador");
            System.out.println("[3]. Modificar un jugador");
            System.out.println("[4]. Eliminar un jugador");
            System.out.println("[5]. Listar todos los jugadores");
            System.out.println("[6]. Salir del programa");
            System.out.print("Ingrese una opción[1 - 6]: ");
            opcion = scanner.nextInt(); //Obtenemos el digito para evaluar la opcion
// por medio de un switch - case evaluamos la opcion para hacer llamado a los métodos 
            switch (opcion) {
                case 1:
                    agregarJugador(scanner);
                    break;
                case 2:
                    buscarJugador(scanner);
                    break;
                case 3:
                    modificarJugador(scanner);
                    break;
                case 4:
                    eliminarJugador(scanner);
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    System.out.println("¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void agregarJugador(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt();

        Jugador jugador = new Jugador(nombre, edad);
        jugadores.add(jugador);

        System.out.println("Jugador agregado correctamente.");
        listarJugadores();
    }

    private static void buscarJugador(Scanner scanner) {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        boolean encontrado = false;

        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                System.out.println("Jugador encontrado:");
                System.out.println(jugador);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con el ID ingresado.");
        }
    }

 // Método para editar los datos de un jugador
    private static void modificarJugador(Scanner scanner) {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        boolean encontrado = false;

        // Iterar sobre la lista de jugadores para encontrar el jugador con el ID ingresado
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                // Si se encuentra el jugador, imprimir sus detalles
                System.out.println("Jugador encontrado:");
                System.out.println(jugador);
                //hacemos un backup de los datos en caso que no se guarden los cambios
                String bkNombre = jugador.getNombre();
                int bkEdad = jugador.getEdad();
                // Solicitar nuevos datos para el jugador
                System.out.print("Ingrese el nuevo nombre del jugador: ");
                String nombre = scanner.next();
                jugador.setNombre(nombre);

                System.out.print("Ingrese la nueva edad del jugador: ");
                int edad = scanner.nextInt();
                jugador.setEdad(edad);

                // Mostrar mensaje de confirmación para guardar los cambios
                System.out.print("¿Desea guardar los cambios? (S/N): ");
                String confirmacion = scanner.next().toUpperCase(); //con el método toUpperCase garantizamos que la letra sea mayúscula
                if (confirmacion.equals("S")) {
                    System.out.println("Cambios guardados correctamente.");
                } else {
                    // Si el usuario no confirma, se cancela la modificación
                    System.out.println("Modificación cancelada. Los cambios no se han guardado.");
                    // Restaurar los valores originales del jugador de las variables backup
                    jugador.setNombre(bkNombre);
                    jugador.setEdad(bkEdad);
                }
                encontrado = true;
                break;
            }
        }

        // Si no se encuentra el jugador, mostrar un mensaje de error
        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con el ID ingresado.");
        }

        // Mostrar la lista de jugadores actualizada
        listarJugadores();
    }


    private static void eliminarJugador(Scanner scanner) {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        boolean encontrado = false;

        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                System.out.println("Jugador encontrado:");
                System.out.println(jugador);

                System.out.print("¿Está seguro que desea eliminar este jugador? (S/N): ");
                String confirmacion = scanner.next().toUpperCase();
                if (confirmacion.equals("S")) {
                    jugadores.remove(jugador);
                    System.out.println("Jugador eliminado correctamente.");
                } else if (confirmacion.equals("N")) {
                    System.out.println("Operación de eliminación cancelada.");
                } else {
                    System.out.println("Opción no válida. Operación de eliminación cancelada.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con el ID ingresado.");
        }

        listarJugadores();
    }

    private static void listarJugadores() {
        System.out.println("Lista de jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }

	}

}
