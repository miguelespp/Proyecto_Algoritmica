/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Usuarios;
import Proyecto.Profesor;
import Proyecto.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jhon
 */
public class ManejadorArchivosUsuarios {
    public static List<Usuario> leerUsuarios(String tipoUsuario) {
        List<Usuario> usuarios = new ArrayList<>();
        String nombreArchivo = tipoUsuario + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String nombreUsuario = line.substring("Nombre de usuario: ".length());
                String contraseña = reader.readLine().substring("Contraseña: ".length());
                String nombres = reader.readLine().substring("Nombres: ".length());
                String apellidos = reader.readLine().substring("Apellidos: ".length());
                String fechaNacimientoStr = reader.readLine().substring("Fecha de nacimiento: ".length());

                Usuario usuario = new Usuario(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoStr);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return usuarios;
    }
    
    public boolean buscarUsuario(String nombreUsuario, String contraseña) {
        
        
        try {
            FileReader fr = new FileReader("Estudiantes.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals("Nombre de usuario: "+nombreUsuario)) {
                    String lineaSiguiente;
                    if((lineaSiguiente = br.readLine()) != null) {
                        if (lineaSiguiente.equals("Contraseña: "+contraseña)) {
                            return true;
                        }
                    }
                }
            }
            System.out.println("Usuario no encontrado");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        }
        return false;
    }

    public static void guardarUsuario(Usuario usuario, String tipoUsuario) {
        String nombreArchivo = tipoUsuario + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write("Nombre de usuario: " + usuario.getNombreUsuario());
            writer.newLine();
            writer.write("Contraseña: " + usuario.getContraseña());
            writer.newLine();
            writer.write("Nombres: " + usuario.getNombres());
            writer.newLine();
            writer.write("Apellidos: " + usuario.getApellidos());
            writer.newLine();
            writer.write("Fecha de nacimiento: " + usuario.getFechaNacimiento().toString());
            writer.newLine();

            if (usuario instanceof Profesor) {
                // Si es un profesor, también guardamos la carrera profesional
                Profesor profesor = (Profesor) usuario;
                writer.write("Carrera Profesional: " + profesor.getCarreraProfesional());
                writer.newLine();
            }

            System.out.println("Datos del usuario guardados en el archivo " + nombreArchivo + " con éxito.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}
