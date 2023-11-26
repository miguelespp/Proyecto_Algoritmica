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
public class Estadisticas {
    private Estudiante estudiante;
    private int cantidadTextosLeidos;
    private double porcentajePreguntasCorrectasTotal;
    private ArrayList<Double> porcentajePromedioCorrectasPorTexto;
    private double porcentajeTextosFallados;
    private double porcentajeTextosAcertados;

    public Estadisticas(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.cantidadTextosLeidos = 0;
        this.porcentajePreguntasCorrectasTotal = 0;
        this.porcentajePromedioCorrectasPorTexto = null;
        this.porcentajeTextosFallados = 0;
        this.porcentajeTextosAcertados = 0;
    }
    
    public boolean actualizar() {
        try {
            this.cantidadTextosLeidos = estudiante.getCantidadTextosLeidos();
            this.porcentajePreguntasCorrectasTotal = estudiante.getPorcPregCorrRespondidas();
            this.porcentajePromedioCorrectasPorTexto = estudiante.getPorcPregCorrRespondidasPorTexto();
            this.porcentajeTextosFallados = estudiante.getPorcFallarTodo();
            this.porcentajeTextosAcertados = getPorcentajeTextosAcertados();
            return true;
        } catch (Exception e) {
            System.out.println("Fallo al actualizar las estadisticas");
        }
        return false;
    }

    // Getters y setters para acceder a los atributos
    public int getCantidadTextosLeidos() {
        return cantidadTextosLeidos;
    }

    public double getPorcentajePreguntasCorrectasTotal() {
        return porcentajePreguntasCorrectasTotal;
    }

    public ArrayList<Double> getPorcentajePromedioCorrectasPorTexto() {
        return porcentajePromedioCorrectasPorTexto;
    }

    public double getPorcentajeTextosFallados() {
        return porcentajeTextosFallados;
    }

    public double getPorcentajeTextosAcertados() {
        return porcentajeTextosAcertados;
    }
}
