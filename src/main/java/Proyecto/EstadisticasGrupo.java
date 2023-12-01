/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class EstadisticasGrupo {
    Grupo grupo;
    int cantidadTextosResultos;
    Double porcPreguntasRespondidosCorrect;
    Double wasa;
    ArrayList<Texto> masLeidos;
    ArrayList<Texto> masFaciles;
    ArrayList<Texto> masDificiles;
    
    public EstadisticasGrupo(Grupo grupo) {
        this.grupo = grupo;
        this.cantidadTextosResultos = 0;
        this.porcPreguntasRespondidosCorrect = 0.0;
        this.wasa = 0.0;
        this.masLeidos = new ArrayList<>();
        this.masFaciles = new ArrayList<>();
        this.masDificiles = new ArrayList<>();
    }
    
    public void actualizar() {
        this.cantidadTextosResultos = grupo.getCantidadTextosResueltos();
        this.porcPreguntasRespondidosCorrect = grupo.getPorcPreguntasCorrectPorAlumno();
        
    }
    
    
}
