/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author ISAAC
 */
public class PDException extends Exception {
    private String username;
    
    public PDException(String username){
        super("O perfil informado encontra-se desativado");
        this.username = username;
    }
    
    public String username(){
        return this.username;
    }
}
