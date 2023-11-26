/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Proyecto.Usuario;

/**
 *
 * @author esp15
 */
public class Prueba {
    public static void main(String[] args) throws ClassNotFoundException {
        AccesoUsuarios acces = new AccesoUsuarios();
        Usuario user1 = new Usuario("Ayudin1590", "casino2134", 
                "juan", "Flurencio Sarmento", "15/07/2000");
        //acces.registrarUsuario(user1);
        acces.leer();
    }
}
