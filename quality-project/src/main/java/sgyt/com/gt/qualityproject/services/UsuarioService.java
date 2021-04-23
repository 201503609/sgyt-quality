/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgyt.com.gt.qualityproject.models.UsuarioModel;

import sgyt.com.gt.qualityproject.repositories.UsuarioRepositorie;

/**
 *
 * @author diego
 */

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositorie usuario;
    
    public ArrayList<UsuarioModel> getUsers(){
        return (ArrayList<UsuarioModel>) usuario.findAll();       
    }
    
    public UsuarioModel saveUser(UsuarioModel user){
        return usuario.save(user);
    }
    
}
