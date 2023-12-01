/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ExamenGUI {
    private  String textoGeneral;
    private  Pregunta[] preguntas;

    public ExamenGUI() {
        this.textoGeneral = "Este es un texto muy general con nada de especial pero ya ni modo zzzzzzzzzzzzzzzzzzz zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        this.preguntas = inicializarPreguntas(); // Inicializar las preguntas en el constructor
    }

    private Pregunta[] inicializarPreguntas() {
        // Replace this with your logic to fetch questions from the exam
        Pregunta pregunta1 = new Pregunta("Pregunta1?", new String[]{"a", "b", "c"}, "a", "Razonamiento para la pregunta 1");
        Pregunta pregunta2 = new Pregunta("Pregunta2?", new String[]{"a", "b", "c"}, "b", "Razonamiento para la pregunta 2");
        Pregunta pregunta3 = new Pregunta("Pregunta3?", new String[]{"a", "b", "c"}, "c", "Razonamiento para la pregunta 3");
        Pregunta pregunta4 = new Pregunta("Pregunta4?", new String[]{"a", "b", "c", "d"}, "d", "Razonamiento para la pregunta 4");

        return new Pregunta[]{pregunta1, pregunta2, pregunta3, pregunta4};
    }

    public String getTextoGeneral() {
        return textoGeneral;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }
}

