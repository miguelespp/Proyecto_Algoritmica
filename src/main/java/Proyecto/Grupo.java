/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Grupo {
    private String codigoGrupo;
    private String nombreGrupo;
    private List<Estudiante> estudiantes;

    public Grupo(String codigoGrupo, String nombreGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public int getCantidadTextosResueltos() {
        int aux = 0;
        for(Estudiante estudiante : estudiantes) {
            aux += estudiante.getCantidadTextosLeidos();
        }
        if(aux ==0) {
            return 0;
        }else{
            return aux;
        }
    }
    
    // Porcentaje de preguntas correctamente respondidas por alumnos de su GRUPO
    public double getPorcPreguntasCorrectPorAlumno() {
        double aux = 0;
        for(Estudiante estudiante : estudiantes){
            aux += estudiante.getPorcPromPregCorrRespPorTexto();
        }
        return aux;
    }
    
    // Porcentaje promedio de preguntas correctamente respondidas por texto por alumnos de su GRUPO
    public Double getPorcPromdPreguntasPorTexto(){
        
        return getPorcPreguntasCorrectPorAlumno()/estudiantes.size();
    }
    
    public void crearDirectorio() {
        String directorioBase = "Data/Groups/";
        File carpeta = new File(directorioBase);
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Directorio creado con éxito.");
            } else {
                System.out.println("Error al crear el directorio.");
                return;
            }
        }
        String rutadirectorioGrupo = directorioBase + File.separator + codigoGrupo;
        File directorioGrupo = new File(rutadirectorioGrupo);
        if (!directorioGrupo.exists()) {
            if (directorioGrupo.mkdirs()) {
                System.out.println("Directorio del grupo creado con éxito: " + rutadirectorioGrupo);
            } else {
                System.out.println("Error al crear el directorio del grupo.");
                return;
            }
        }
    }
    
    /**public void guardarInformacionGrupo() {
         String directorioBase = "Data/Groups/";
         String ruta = directorioBase +  "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            // Escribir información del grupo
            writer.write("Código del Grupo: " + codigoGrupo);
            writer.newLine();
            writer.write("Nombre del Grupo: " + nombreGrupo);
            writer.newLine();

            // Escribir información de cada estudiante
            for (Estudiante estudiante : estudiantes) {
                writer.write("Estudiante:");
                writer.newLine();
                writer.write("Nombre: " + estudiante.getNombre());
                writer.newLine();
                writer.write("Apellido: " + estudiante.getApellido());
                writer.newLine();
                // Puedes agregar más información sobre el estudiante si es necesario
                writer.newLine();
            }

            System.out.println("Información del grupo almacenada en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    }**/
     

    // Otras operaciones y métodos de la clase...
}

    

