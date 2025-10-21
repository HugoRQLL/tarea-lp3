package ejercicio_2;

import java.util.*;

// Clase Usuario
class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
}

// Clase Reseña
class Resena {
    private Usuario usuario;
    private String comentario;
    private int calificacion;
    private Date fecha;

    public Resena(Usuario usuario, String comentario, int calificacion) {
        this.usuario = usuario;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha = new Date();
    }

    public String toString() {
        return "Reseña de " + usuario.getNombre() + " [" + calificacion + " estrellas]: " + comentario + " (" + fecha + ")";
    }
}

// Clase Sistema de Autenticación
class SistemaAutenticacion {
    private List<Usuario> usuarios;

    public SistemaAutenticacion() {
        this.usuarios = new ArrayList<>();
    }

    public boolean registrar(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(usuario.getCorreo())) {
                return false; // correo ya registrado
            }
        }
        usuarios.add(usuario);
        return true;
    }

    public Usuario validar(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }
}

class SistemaResenas {
    private List<Resena> resenas;

    public SistemaResenas() {
        this.resenas = new ArrayList<>();
    }

    public void agregar(Resena resena) {
        resenas.add(resena);
    }

    public List<Resena> obtener() {
        return resenas;
    }
}
