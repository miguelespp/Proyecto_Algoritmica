/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Anthony
 */
import Data.Usuarios.ManejadorArchivosUsuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    
    public Usuario(){
        
    }

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
     
     public void mostrarTodo() {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         System.out.println("NombreUsuario: " + nombreUsuario +
                 "\nContraseña: " + contraseña + 
                 "\nNombre: " + nombres + " " + apellidos + 
                 "\nFecha de Nacimiento: " + formatoFecha.format(fechaNacimiento)
         );
     }
     
     // Método para guardar los datos del usuario en un archivo de texto
    public void guardarEnArchivo(String tipoUsuario) {
        ManejadorArchivosUsuarios.guardarUsuario(this, tipoUsuario);
    }
    
    // Supongamos que ya tienes un objeto 'estudiante' creado entonces se llama asi a la funcion : "estudiante.guardarEnArchivo("Estudiantes");"
    // Supongamos que ya tienes un objeto 'profesor' creado entonces se llama asi a la funcion : "profesor.guardarEnArchivo("Profesores");"
    
    // Método para buscar un usuario en el archivo y devolver su información


    public Usuario buscarUsuario(String tipoUsuario, String nombreUsuarioABuscar, String contraseña) {
        String nombreArchivo = tipoUsuario + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Buscar la línea que contiene el nombre de usuario
                if (line.equals("Nombre de usuario: "+nombreUsuarioABuscar)) {
                    // Encontrado, leer las líneas siguientes para obtener la información completa
                    String lineaSiguiente;
                    if ((lineaSiguiente = reader.readLine()) != null) {
                        if (lineaSiguiente.equals("Contraseña: "+contraseña)) {
                            String nombres = reader.readLine().substring("Nombres: ".length());
                            String apellidos = reader.readLine().substring("Apellidos: ".length());
                            String fechaNacimientoStr = reader.readLine().substring("Fecha de nacimiento: ".length());
                            Usuario temp =  new Usuario(nombreUsuarioABuscar, contraseña, nombres, apellidos, fechaNacimientoStr);
                            return temp;
                        }
                    }
                    

                    // Convertir la cadena de fecha de nacimiento a un objeto Date (puedes utilizar un SimpleDateFormat)
                    // Aquí se asume que la fecha está en el formato correcto
                    // Date fechaNacimiento = parseFechaNacimiento(fechaNacimientoStr);

                    // Crear y devolver un nuevo objeto Usuario con la información encontrada
                    
                }
            }

            // Si no se encuentra el usuario
            System.out.println("Usuario no encontrado: " + nombreUsuarioABuscar);
        } catch (IOException e) {
            System.err.println("Error al buscar el usuario en el archivo: " + e.getMessage());
        }

        return null; // Devolver null si no se encuentra el usuario
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
