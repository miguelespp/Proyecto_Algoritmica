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

    public Texto(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    // Getters y setters para acceder a los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    public boolean contienePalabraClave(String pClave) {
        ArrayList<String> composicion;
        return false;
    }
}
