/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import exceptions.UJCException;
import interfaces.IRepositorioUsuario;
import java.util.ArrayList;

/**
 *
 * @author ISAAC
 */
public class MyUsuarios implements IRepositorioUsuario {
    public ArrayList<Perfil> usuarios;
    
    public MyUsuarios(){
        usuarios = new ArrayList<>();
    }

    @Override
    public void cadastrar(Perfil usuario)throws UJCException {
        Perfil p = buscar(usuario.getUsuario());
        if(p == null)
            usuarios.add(usuario);
        else
            throw new UJCException(p.getUsuario());
    }

    @Override
    public Perfil buscar(String usuario) {
        for(Perfil p : usuarios){
            if(p.getUsuario().equals(usuario))
                return p;
        }
        return null;
    }

    @Override
    public void atualizar(Perfil usuario) {
        Perfil toUpdate = buscar(usuario.getUsuario());
        if(toUpdate != null){
            toUpdate.setUsuario(usuario.getUsuario());
            toUpdate.setAtivo(usuario.isAtivo());
        }
        if(toUpdate instanceof PessoaFisica){
            PessoaFisica pf = (PessoaFisica)usuario;
            ((PessoaFisica) toUpdate).setCpf(pf.getCpf());
        }
        if(toUpdate instanceof PessoaJuridica){
            PessoaJuridica pj = (PessoaJuridica)usuario;
            ((PessoaJuridica) toUpdate).setCnpj(pj.getCnpj());
        }
        
            
        
    }
}
