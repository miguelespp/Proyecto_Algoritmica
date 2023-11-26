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
    private Estadisticas estats;
    
    public Estudiante(String nombreUsuario, String contraseña, String nombres, 
            String apellidos, String fechaNacimientoString, Grupo grupo) {
        super(nombreUsuario, contraseña, nombres, apellidos, fechaNacimientoString);
        this.grupo = grupo;
        this.textosLeidos = new ArrayList<Texto>();
    }
    
    public void añadirTexto(Texto texto) {
        textosLeidos.add(texto);
    }

    public int getCantidadTextosLeidos() {
        return textosLeidos.size();
    }
    
    //Obtener la cantidad de todas las preguntas
    /**private int getTotalPreguntas() {
        int temp = 0;
        for(Texto texto : textosLeidos) {
            temp += texto.getCantidadPreguntas();
        }
        return temp;
    }**/
    
    public double getPorcPregCorrRespondidas() {
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
    
    public ArrayList<Double> getPorcPregCorrRespondidasPorTexto() {
        ArrayList<Double> porcentajes = new ArrayList<>();
        for(Texto texto : textosLeidos) {
            var correctos = (double)texto.getCorrectamenteRespondido();
            var total = (double)texto.getCantidadPreguntas();
            porcentajes.add(correctos/total);
        }
        return porcentajes;
    }
    
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
    
    public double getPorcFallarTodo() {
        int temp = 0;
        for(Texto texto : textosLeidos) {
            if (texto.falloTodo()) {
                temp++;
            }
        }
        if (getCantidadTextosLeidos() == 0) {
            return 0;
        }else{
            return (double)temp/getCantidadTextosLeidos();
        }
    }
}
