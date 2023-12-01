/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Profesor extends Usuario {
    private String carreraProfesional;
    private List<Grupo> grupos;
    
    public Profesor(String nombreUsuario, String contraseña, String nombres, String apellidos, String fechaNacimientoString, String carreraProfesional) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.carreraProfesional = carreraProfesional;
    }
     @Override
    public void mostrarTodo() {
        super.mostrarTodo();
        System.out.println("Carrera Profesional: " + carreraProfesional);
    }
    public void guardarEnArchivo() {
        String nombreArchivo = "Profesores.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            super.guardarEnArchivo("Profesor");
            writer.write("Carrera Profesional: " + carreraProfesional);
            writer.newLine();

            System.out.println("Datos del usuario guardados en el archivo " + nombreArchivo + " con éxito.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
    public String getCarreraProfesional() {
        return carreraProfesional;
    }
}
