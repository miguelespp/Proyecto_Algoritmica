/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Anthony
 */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario implements Serializable{
  
    private String nombreUsuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;

     public Usuario(String nombreUsuario, String contraseña, String nombres, String apellidos, String fechaNacimientoString) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;

        // Convertir la cadena de fecha de nacimiento a un objeto Date
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.fechaNacimiento = formatoFecha.parse(fechaNacimientoString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("No se puede convertir a Date");
        }
    }
    

    // Métodos
    public void login() {
        // Lógica de inicio de sesión
        System.out.println("Inicio de sesión exitoso para " + nombreUsuario);
    }

    public void logout() {
        // Lógica de cierre de sesión
        System.out.println("Cierre de sesión para " + nombreUsuario);
    }

    public void registrarse() {
        // Lógica de registro
        System.out.println("Usuario registrado: " + nombreUsuario);
    }

    public void guardarDatos() {
        // Lógica para guardar datos del usuario
        System.out.println("Datos de " + nombreUsuario + " guardados correctamente.");
    }

    public void cargarDatos() {
        // Lógica para cargar datos del usuario
        System.out.println("Datos de " + nombreUsuario + " cargados correctamente.");
    }

    // Getters y setters (pueden ser generados automáticamente en muchos IDE)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
