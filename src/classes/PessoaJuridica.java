/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ISAAC
 */
public class PessoaJuridica extends Perfil{
    
    private long cnpj;
    
    public PessoaJuridica(String usuario) {
        super(usuario);
    }
    
    public void setCnpj(long cnpj){
        this.cnpj = cnpj;
    }
    
    public long getCnpj(){
        return this.cnpj;
    }
    
}
