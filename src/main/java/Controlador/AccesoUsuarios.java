/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.*;
import Proyecto.Usuario;

/**
 *
 * @author esp15
 */
public class AccesoUsuarios {
    //"C:\Users\esp15\OneDrive\Documentos\NetBeansProjects\proyecto_Algoritmica\src\main\java\Data\Usuarios\Users.txt"
    public void leer() {
        FileInputStream fis = null;
        Usuario user0;
        try {
            fis = new FileInputStream("src/main/java/Data/Usuarios/Users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            user0 = (Usuario)ois.readObject();
            System.out.println(user0.getNombreUsuario());
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Clase diferente");
        }
    }
    
    public boolean buscarUsuario(String nombreUsuario){
        try {
            FileReader fr = new FileReader("src/main/java/Data/Usuarios/Users.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(nombreUsuario)) {
                    System.out.println("Usuario encontrado");
                    return true;
                }
            }
            System.out.println("Usuario no encontrado");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        }
        return false;
    }
    
    public void registrarUsuario(Usuario user) {
        /**try {
            FileWriter fw = new FileWriter("src/main/java/Data/Usuarios/Users.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nombreUsuario + "\n" + contraseña);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Usuario no registrado");
        }**/
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/main/java/Data/Usuarios/Users.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se puedo registrar al usuario");
        } finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

