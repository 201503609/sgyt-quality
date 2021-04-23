/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.web;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgyt.com.gt.qualityproject.models.UsuarioModel;
import sgyt.com.gt.qualityproject.services.UsuarioService;

/**
 *
 * @author diego
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioRS {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping(path = "/todos")
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return usuarioService.getUsers();
    }
    
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUser(usuario);
    }
    
}
