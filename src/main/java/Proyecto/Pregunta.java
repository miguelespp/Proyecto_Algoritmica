/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Anthony
 */
public class Pregunta {
    private String enunciado;
    private String[] alternativas = new String[5];
    private String respuestaCorrecta;
    private String razonamiento;
    private boolean respondida;
    private boolean correctamenteRespondido;
    
    public Pregunta() {
        this.enunciado = "";
        this.respuestaCorrecta = "";
        this.razonamiento = "";
        this.respondida = false;
        this.correctamenteRespondido = false;
    }

    public Pregunta(String enunciado, String[] alternativas, String respuestaCorrecta, String razonamiento) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.razonamiento = razonamiento;
        this.respondida = false;
        this.correctamenteRespondido = false;
    }

    // Getters y setters para acceder a los atributos
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativas(int posicion) {
        return alternativas[posicion-1];
    }

    public void setAlternativas(int posicion, String propuesta) {
        this.alternativas[posicion-1] = propuesta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRazonamiento() {
        return razonamiento;
    }

    public void setRazonamiento(String razonamiento) {
        this.razonamiento = razonamiento;
    }
    
    //util para la clase estadistica
    public boolean isRespondida() {
        return respondida;
    }
    
    //maracamos como respondida y se lo bloquea de la interfaz o alguna accion correspondiente
    public void marcarRespondida() {
        this.respondida = true;
    }
    
    //util para la clase estadistica
    public boolean isRespondidoCorrectamente() {
        return correctamenteRespondido;
    }
    
    //con esto validamos la respuesta seleccionada
    public void comprobarRespuesta(String resptSeleccionada){
        if (resptSeleccionada == respuestaCorrecta) {
            correctamenteRespondido = true;
        }else{
            correctamenteRespondido = false;
        }
    }
    
    public String[] getAlternativas() {
        return alternativas.clone(); // Devolver una copia para evitar modificaciones externas
    }
}
