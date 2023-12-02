/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        
    public Texto(){
        
    }    
    
    public Texto( String contenido) {
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
    
    public void setId(int Id){
        this.id = Id;
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
    
    public Double getPorcPregCorrectR(){
        return ((double)getCorrectamenteRespondido())/getCantidadPreguntas();
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
    
    public boolean isNingunaRespondida() {
        for(Pregunta preguntita:preguntas) {
            if (preguntita.isRespondida()) {
                return false;
            }
        }
        return true;
    }
    
    public void guardarEnArchivo() {
        String directorioActual = "Data/Texts/Hoy/";
        File carpeta = new File(directorioActual);
            File[] archivos = carpeta.listFiles();
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Directorio creado con éxito.");
                } else {
                    System.out.println("Error al crear el directorio.");
                    return;
                }
            }
            int cantidadArchivos = archivos != null ? archivos.length : 0;
            this.id = cantidadArchivos + 1;
            String nombreArchivo = id +".txt";
            System.out.println(nombreArchivo);
            File archivo = new File(carpeta,nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            // Escribir ID y Contenido
            writer.write("ID: " + id);
            writer.newLine();
            writer.write("=====================TEXTO======================");
            writer.newLine();
            writer.write(contenido);
            writer.newLine();


            // Escribir preguntas
            for (Pregunta pregunta : preguntas) {
                writer.write("=====================PREGUNTAS======================");
                writer.newLine();
                writer.write(pregunta.getEnunciado());
                writer.newLine();
                writer.write("=====================ALTERNATIVAS======================");
                writer.newLine();
                for (int i = 0; i < 5; i++) {
                    writer.write(pregunta.getAlternativas(i+1));
                    writer.newLine();
                }
                writer.write("=====================RESPUESTA CORRECTA======================");
                writer.newLine();
                writer.write(pregunta.getRespuestaCorrecta());
                writer.newLine();
                writer.write("=====================RAZONAMIENTO======================");
                writer.newLine();
                writer.write(pregunta.getRazonamiento());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

  


