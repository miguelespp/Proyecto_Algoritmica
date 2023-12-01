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
}
