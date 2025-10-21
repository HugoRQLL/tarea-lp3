package ejercicio_2;

class ControladorAutenticacion {
    private SistemaAutenticacion sistema;
    private VistaLogin vistaLogin;
    private VistaRegistro vistaRegistro;
    private Usuario usuarioActivo;

    public ControladorAutenticacion(SistemaAutenticacion sistema, VistaLogin vistaLogin, VistaRegistro vistaRegistro) {
        this.sistema = sistema;
        this.vistaLogin = vistaLogin;
        this.vistaRegistro = vistaRegistro;
        this.usuarioActivo = null;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean registrar() {
        String nombre = vistaRegistro.pedirNombre();
        String correo = vistaRegistro.pedirCorreo();
        String contrasena = vistaRegistro.pedirContrasena();

        Usuario nuevo = new Usuario(nombre, correo, contrasena);
        if (sistema.registrar(nuevo)) {
            vistaRegistro.mostrarMensaje("Registro exitoso. Ahora puede iniciar sesión.");
            return true;
        } else {
            vistaRegistro.mostrarMensaje("El correo ya está registrado.");
            return false;
        }
    }

    public boolean iniciarSesion() {
        String correo = vistaLogin.pedirCorreo();
        String contrasena = vistaLogin.pedirContrasena();
        Usuario u = sistema.validar(correo, contrasena);

        if (u != null) {
            usuarioActivo = u;
            vistaLogin.mostrarMensaje("Inicio de sesión exitoso. Bienvenido, " + u.getNombre() + "!");
            return true;
        } else {
            vistaLogin.mostrarMensaje("Credenciales incorrectas.");
            return false;
        }
    }

    public void cerrarSesion() {
        usuarioActivo = null;
        vistaLogin.mostrarMensaje("Sesión cerrada.");
    }
}

// Controlador de Reseñas
class ControladorResenas {
    private SistemaResenas sistema;
    private VistaResenas vista;

    public ControladorResenas(SistemaResenas sistema, VistaResenas vista) {
        this.sistema = sistema;
        this.vista = vista;
    }

    public void agregar(Usuario usuario) {
        String comentario = vista.pedirComentario();
        int calificacion = vista.pedirCalificacion();

        if (calificacion < 1 || calificacion > 5) {
            System.out.println("Calificación inválida, debe ser entre 1 y 5.");
            return;
        }

        Resena resena = new Resena(usuario, comentario, calificacion);
        sistema.agregar(resena);
        vista.mostrar(sistema.obtener());
    }
}
