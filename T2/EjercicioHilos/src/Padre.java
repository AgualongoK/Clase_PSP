import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {

    private String nombre;

    public Padre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {

        String line;

        try {

// Llamar a la clase Hijo compilada anteriormente

            Process hijo = new ProcessBuilder("java","src/Hijo3.java").start();

// Buffer para datos del proceso hijo

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

// Stream salida

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

            BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

            System.out.println("Introduzca el DNI del cliente a buscar: " );

// Enviar mensaje al hijo

            line = in.readLine();

            ps.println(line);

// Recibir información del padre

            line = br.readLine();

            System.out.println(line) ;

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}
