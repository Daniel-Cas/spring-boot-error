package com.bolsadeideas.springboot.error.app.controllers;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @SuppressWarnings("unused")
    @GetMapping("/index")
    public String index(){
        //Integer numero= 100/0;
        Integer valor = Integer.parseInt("1as");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {

//        Usuario usuario = usuarioService.obtenerPorId(id);

//        if( usuario == null ){
//            throw new UsuarioNoEncontradoException(id.toString());
//        }

        Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow( () -> new UsuarioNoEncontradoException(id.toString()));

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle del usuario:  ".concat( usuario.getNombre() ) );

        return "ver";
    }
}
