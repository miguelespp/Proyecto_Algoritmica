/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.*;
import Proyecto.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esp15
 */
public class AccesoUsuarios {
    private String direccion = "src/main/java/Data/Usuarios/Users.ser";
    //"C:\Users\esp15\OneDrive\Documentos\NetBeansProjects\proyecto_Algoritmica\src\main\java\Data\Usuarios\Users.txt"
    public void leer() {
        FileInputStream fis = null;
        //Object auxUser;
        try {
            fis = new FileInputStream(direccion);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //user0 = (Usuario)ois.readObject();
            List<Usuario> auxList = null;
            Usuario auxUser = null;
            try {
                /**while (true) {
                    auxUser = (Usuario)ois.readObject();
                    //System.out.println( "UserName "+auxUser.getNombreUsuario()+"\nPassword: " + auxUser.getContraseña());
                    auxUser.mostrarTodo();
                }**/
                auxList = new ArrayList<Usuario>();
                auxUser = (Usuario)ois.readObject();
                while (auxUser != null) {                    
                    auxList.add(auxUser);
                    System.out.println(auxList.size());
                    auxUser = (Usuario)ois.readObject();
                }
            } catch (EOFException e) {
                e.printStackTrace();
                System.out.println("Final del archivo alcanzado");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error E/S del archivo");
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error E/S");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Clase diferente");
        }
    }
    
    public boolean buscarUsuario(String nombreUsuario){
        /**try {
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
        return false;**/
        FileInputStream fis = null;
        Usuario user;
        try {
            fis = new FileInputStream(direccion);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            fos = new FileOutputStream(direccion, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            System.out.println("Usuario Registrado");
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

