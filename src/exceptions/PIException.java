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
public class PIException extends Exception {
    private String username;
    
    public PIException(String username){
        super("O perfil informado não existe");
        this.username = username;
    }
    
    public String username(){
        return this.username;
    }
}
