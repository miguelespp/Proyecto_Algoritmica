/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioLogica;

import Proyecto.Usuario;
import UsuarioOpciones.OpcionesUsuario;

/**
 *
 * @author Anthony
 */
public class UsuarioLogica {
    private static OpcionesUsuario opcionesUsuario= new OpcionesUsuario();
    
    
    public static boolean autentificar(String usuario, String contraseña){
        if(obtener (usuario)!=null){
            Usuario usuarioConsulta= obtener(usuario);
            if (usuarioConsulta.getNombreUsuario().equals(usuario) && usuarioConsulta.getContraseña().equals(contraseña)){
                return true;
            }else{
                return false;
            } 
        }
        return false;
    }
    
    public static boolean insertar(Usuario usuario){
        return  opcionesUsuario.insertar(usuario);
    }
    
    public static boolean modificar(Usuario usuario){
        return  opcionesUsuario.modificar(usuario);
        
    }
    
    public static boolean eliminar(String usuario){
        return  opcionesUsuario.eliminar(usuario);
        
    }
    
    public static Usuario obtener(String usuario){
        return  opcionesUsuario.obtener(usuario);
        
    }
    
    
}
