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
public class Texto {
    private int id;
    private String contenido;
    private ArrayList<Pregunta> preguntas;
    private boolean resuelto;

    public Texto(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
        this.preguntas = new ArrayList<>();
        resuelto = false;
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    // Getters y setters para acceder a los atributos
    public int getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public boolean contienePalabraClave(String pClave) {
        ArrayList<String> composicion;
        return false;
    }
    
    public int getCantidadPreguntas() {
        return preguntas.size();
    }
    
    public int getCorrectamenteRespondido() {
        int aux = 0;
        for(Pregunta pregunta : preguntas) {
            if(pregunta.isRespondidoCorrectamente()) {
                aux++;
            }
        }
        return aux;
    }
    
    public boolean falloTodo() {
        for(Pregunta pregunta : preguntas) {
            if (pregunta.isRespondidoCorrectamente()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean acertoTodo() {
        for(Pregunta pregunta : preguntas) {
            if (!pregunta.isRespondidoCorrectamente()) {
                return false;
            }
        }
        return true;
    }
}

