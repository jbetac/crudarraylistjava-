package jugadorACT2JB;




import java.util.concurrent.atomic.AtomicInteger; //importamos los métodos de atomic para generar los ID´s
  // creamos la clase Jugador con sus atributos
 public class Jugador {
	
	private static final AtomicInteger contadorId = new AtomicInteger(1000);
    private int id;
    private String nombre;
    private int edad;
 //constructor de la clase jugador
    public Jugador(String nombre, int edad) {
        this.id = contadorId.getAndIncrement();
        this.nombre = nombre;
        this.edad = edad;
    }
 //métodos getters and setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
 // método toString para dar formato a la salida de la información
    @Override
    public String toString() {
        return "Jugador{" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                '}';
    }

}
