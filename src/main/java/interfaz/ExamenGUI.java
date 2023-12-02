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
import Proyecto.Pregunta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    private Pregunta leerPreguntaDesdeArchivo(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String texto = "";
            String enunciado = "";
            ArrayList<String> alternativas = new ArrayList<>();
            String alternativaCorrecta = "";
            String razonamiento = "";

            // Leer el contenido del archivo
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("=====================TEXTO======================")) {
                    texto = br.readLine();
                } else if (linea.startsWith("=====================PREGUNTA")) {
                    enunciado = br.readLine();
                } else if (linea.startsWith("=====================ALTERNATIVAS")) {
                    while (!(linea = br.readLine()).startsWith("=====================")) {
                        alternativas.add(linea.trim());
                    }
                } else if (linea.startsWith("=====================ALTERNATIVA CORRECTA")) {
                    alternativaCorrecta = br.readLine().trim();
                } else if (linea.startsWith("=====================RAZONAMIENTO")) {
                    razonamiento = br.readLine();
                }
            }

            // Crear y devolver el objeto Pregunta
            return new Pregunta(enunciado, alternativas.toArray(new String[0]), alternativaCorrecta, razonamiento);

        } catch (FileNotFoundException e) {
        System.err.println("Archivo no encontrado: " + archivo.getAbsolutePath());
        e.printStackTrace();
        return null;
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + archivo.getAbsolutePath());
        e.printStackTrace();
    }
        return null;
}

    public Pregunta[] getPreguntas() {
        return preguntas;
    }
}

