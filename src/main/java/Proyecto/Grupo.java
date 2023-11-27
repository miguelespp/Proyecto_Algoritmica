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
public class Grupo {
    private String codigoGrupo;
    private String nombreGrupo;
    private List<Estudiante> estudiantes;

    public Grupo(String codigoGrupo, String nombreGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupo = nombreGrupo;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public int getCantidadTextosResueltos() {
        int aux = 0;
        for(Estudiante estudiante : estudiantes) {
            aux += estudiante.getCantidadTextosLeidos();
        }
        if(aux ==0) {
            return 0;
        }else{
            return aux;
        }
    }
    
    public Double getPorcPreguntasCorrectPorTexto() {
        double aux = 0;
        for(Estudiante estudiante : estudiantes){
            aux += estudiante.getPorcPregCorrRespondidas();
        }
        return aux/estudiantes.size();
    }
}
