/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;



/**
 *
 * @author PC
 */
public class Pregunta {
    private final String text;
    private final String[] alternativas;
    private final String respuestaCorrecta;
    private final String razonamiento;

    public Pregunta(String text, String[] alternativas, String respuestaCorrecta, String razonamiento) {
        this.text = text;
        this.alternativas = alternativas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.razonamiento = razonamiento;
    }

    public String getText() {
        return text;
    }

    public String[] getAlternativas() {
        return alternativas.clone(); // Devolver una copia para evitar modificaciones externas
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getRazonamiento() {
        return razonamiento;
    }
}


