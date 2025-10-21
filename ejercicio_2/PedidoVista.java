package ejercicio_2;

import java.util.*;
class VistaLogin {
    private Scanner entrada;

    public VistaLogin() {
        entrada = new Scanner(System.in);
    }

    public String pedirCorreo() {
        System.out.print("Ingrese su correo: ");
        return entrada.nextLine();
    }

    public String pedirContrasena() {
        System.out.print("Ingrese su contraseña: ");
        return entrada.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

// Clase VistaRegistro
class VistaRegistro {
    private Scanner entrada;

    public VistaRegistro() {
        entrada = new Scanner(System.in);
    }

    public String pedirNombre() {
        System.out.print("Ingrese su nombre: ");
        return entrada.nextLine();
    }

    public String pedirCorreo() {
        System.out.print("Ingrese su correo: ");
        return entrada.nextLine();
    }

    public String pedirContrasena() {
        System.out.print("Ingrese su contraseña: ");
        return entrada.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

// Clase VistaResenas
class VistaResenas {
    private Scanner entrada;

    public VistaResenas() {
        entrada = new Scanner(System.in);
    }

    public String pedirComentario() {
        System.out.print("Escriba su reseña: ");
        return entrada.nextLine();
    }

    public int pedirCalificacion() {
        System.out.print("Califique del 1 al 5: ");
        return Integer.parseInt(entrada.nextLine());
    }

    public void mostrar(List<Resena> resenas) {
        System.out.println("\n--- Reseñas ---");
        for (Resena r : resenas) {
            System.out.println(r.toString());
        }
        System.out.println("----------------\n");
    }
}

