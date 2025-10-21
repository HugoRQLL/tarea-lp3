package ejercicio_2;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        SistemaAutenticacion sistemaAutenticacion = new SistemaAutenticacion();
        SistemaResenas sistemaResenas = new SistemaResenas();

        VistaLogin vistaLogin = new VistaLogin();
        VistaRegistro vistaRegistro = new VistaRegistro();
        VistaResenas vistaResenas = new VistaResenas();

        ControladorAutenticacion controladorAutenticacion = new ControladorAutenticacion(sistemaAutenticacion, vistaLogin, vistaRegistro);
        ControladorResenas controladorResenas = new ControladorResenas(sistemaResenas, vistaResenas);

        boolean salir = false;
        Usuario usuarioActual = null;

        while (!salir) {
            System.out.println("\n--- Sistema de Autenticación y Reseñas ---");

            if (controladorAutenticacion.getUsuarioActivo() == null) {
                System.out.println("1. Registrar usuario");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> controladorAutenticacion.registrar();
                    case 2 -> {
                        if (controladorAutenticacion.iniciarSesion())
                            usuarioActual = controladorAutenticacion.getUsuarioActivo();
                    }
                    case 3 -> salir = true;
                    default -> System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Usuario: " + controladorAutenticacion.getUsuarioActivo().getNombre());
                System.out.println("1. Cerrar sesión");
                System.out.println("2. Escribir una reseña");
                System.out.println("3. Ver reseñas");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> controladorAutenticacion.cerrarSesion();
                    case 2 -> controladorResenas.agregar(usuarioActual);
                    case 3 -> vistaResenas.mostrar(sistemaResenas.obtener());
                    case 4 -> salir = true;
                    default -> System.out.println("Opción inválida.");
                }
            }
        }

        System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
        entrada.close();
    }
}
