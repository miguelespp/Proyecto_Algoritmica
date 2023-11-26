/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Profesor extends Usuario {
    private String carrera;
    private List<Grupo> grupos;
    
    public Profesor(String nombreUsuario, String contraseña, String nombres, 
            String apellidos, String fechaNacimientoString, String carrera) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.carrera = carrera;
        this.grupos = new ArrayList<>();
    }
}
