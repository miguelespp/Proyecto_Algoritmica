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
public class Estudiante extends Usuario{
    private Grupo grupo;
    private List<Texto> textosLeidos;
    
    public Estudiante(String nombreUsuario, String contraseña, String nombres, 
            String apellidos, String fechaNacimientoString, Grupo grupo) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.grupo = grupo;
        this.textosLeidos = new ArrayList<>();
    }
}
