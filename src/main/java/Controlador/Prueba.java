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
        Usuario user1 = new Usuario("Chuckiyauri1520", "wasa163512", 
                "Wasaberto", "Osorio Wuisper", "25/11/1992");
        acces.registrarUsuario(user1);
        //acces.leer();
    }
}
