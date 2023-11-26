/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author esp15
 */
public class AccesoUsuarios {
    //"C:\Users\esp15\OneDrive\Documentos\NetBeansProjects\proyecto_Algoritmica\src\main\java\Data\Usuarios\Users.txt"
    public void leer(){
        try {
            FileReader fileReader = new FileReader("src/main/java/Data/Usuarios/Users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        }
    }
    
}
