/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Anthony
 */
public class Estadisticas {
    private int cantidadTextosLeidos;
    private float porcentajePreguntasCorrectasTotal;
    private float porcentajePromedioCorrectasPorTexto;
    private float porcentajeTextosFallados;
    private float porcentajeTextosAcertados;

    public Estadisticas(int cantidadTextosLeidos, float porcentajePreguntasCorrectasTotal, 
                        float porcentajePromedioCorrectasPorTexto, float porcentajeTextosFallados, 
                        float porcentajeTextosAcertados) {
        this.cantidadTextosLeidos = cantidadTextosLeidos;
        this.porcentajePreguntasCorrectasTotal = porcentajePreguntasCorrectasTotal;
        this.porcentajePromedioCorrectasPorTexto = porcentajePromedioCorrectasPorTexto;
        this.porcentajeTextosFallados = porcentajeTextosFallados;
        this.porcentajeTextosAcertados = porcentajeTextosAcertados;
    }

    // Getters y setters para acceder a los atributos
    public int getCantidadTextosLeidos() {
        return cantidadTextosLeidos;
    }

    public void setCantidadTextosLeidos(int cantidadTextosLeidos) {
        this.cantidadTextosLeidos = cantidadTextosLeidos;
    }

    public float getPorcentajePreguntasCorrectasTotal() {
        return porcentajePreguntasCorrectasTotal;
    }

    public void setPorcentajePreguntasCorrectasTotal(float porcentajePreguntasCorrectasTotal) {
        this.porcentajePreguntasCorrectasTotal = porcentajePreguntasCorrectasTotal;
    }

    public float getPorcentajePromedioCorrectasPorTexto() {
        return porcentajePromedioCorrectasPorTexto;
    }

    public void setPorcentajePromedioCorrectasPorTexto(float porcentajePromedioCorrectasPorTexto) {
        this.porcentajePromedioCorrectasPorTexto = porcentajePromedioCorrectasPorTexto;
    }

    public float getPorcentajeTextosFallados() {
        return porcentajeTextosFallados;
    }

    public void setPorcentajeTextosFallados(float porcentajeTextosFallados) {
        this.porcentajeTextosFallados = porcentajeTextosFallados;
    }

    public float getPorcentajeTextosAcertados() {
        return porcentajeTextosAcertados;
    }

    public void setPorcentajeTextosAcertados(float porcentajeTextosAcertados) {
        this.porcentajeTextosAcertados = porcentajeTextosAcertados;
    }
}
