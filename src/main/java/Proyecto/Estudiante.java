/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Estudiante extends Usuario{
    private Grupo grupo;
    private List<Texto> textosLeidos;
    private Estadisticas estats;
    
    
    public Estudiante(String nombreUsuario, String contraseña, String nombres, 
            String apellidos, String fechaNacimientoString) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.grupo = null;
        this.textosLeidos = new ArrayList<Texto>();
    }
    
    public Estudiante(String nombreUsuario, String contraseña, String nombres, 
            String apellidos, String fechaNacimientoString, Grupo grupo) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.grupo = grupo;
        this.textosLeidos = new ArrayList<Texto>();
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    public Grupo getGrupo() {
        return grupo;
    }
    
    public void añadirTexto(Texto texto) {
        textosLeidos.add(texto);
    }

    public int getCantidadTextosLeidos() {
        return textosLeidos.size();
    }
    
    // Porcentaje de preguntas correctamente respondidas en total
    public double getPorcPregCorrResp() {
        int correctos = 0;
        int total = 0;
        for(Texto texto : textosLeidos) {
            total += texto.getCantidadPreguntas();
            correctos += texto.getCorrectamenteRespondido();
        }
        if (total == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }else {
            return (double)correctos / (double)total;
        }
    }
    
    // Porcentaje promedio de preguntas correctamente respondidas por texto
    public double getPorcPromPregCorrRespPorTexto() {
        double aux = 0;
        for(Texto texto : textosLeidos) {
            aux += ((double)texto.getCorrectamenteRespondido()/ texto.getCantidadPreguntas());
        }
        return aux/textosLeidos.size();
    }
    
    // Porcentaje de textos en los que el estudiante acertó todas las preguntas
    public double getPorcAcertoTodo() {
        int temp = 0;
        for(Texto texto : textosLeidos) {
            if (texto.acertoTodo()) {
                temp++;
            }
        }
        if (getCantidadTextosLeidos() == 0) {
            return 0;
        }else{
            return (double)temp/getCantidadTextosLeidos();
        }
    }
    
    // Porcentaje de textos en los que el estudiante falló todas las preguntas
    public double getPorcFallarTodo() {
        int temp = 0;
        for(Texto texto : textosLeidos) {
            if (texto.falloTodo()) {
                temp++;
            }
        }
        if (getCantidadTextosLeidos() == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }else{
            return (double)temp/getCantidadTextosLeidos();
        }
    }
    
    public Usuario buscarUsuario( String nombreUsuarioABuscar, String contraseña) {
        String directorioBase = "Data/Groups/";
        File aux = new File(directorioBase);
        File[] aux2 = aux.listFiles();
        // String nombreArchivo =  "Estudiantes.txt";
        if(!aux.exists()){
            if (aux.mkdirs()) {
                
            }else{
                return null;
            }
        }
        
        for(File carpeta : aux2) {
            try (BufferedReader reader = new BufferedReader(new FileReader(carpeta))) {
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
        }

        

        return null; // Devolver null si no se encuentra el usuario
    }
}
