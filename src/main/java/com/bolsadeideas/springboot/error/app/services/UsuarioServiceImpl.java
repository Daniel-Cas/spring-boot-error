package com.bolsadeideas.springboot.error.app.services;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = new ArrayList<>();
        this.lista.add( new Usuario(1, "Daniel","Castillo"));
        this.lista.add( new Usuario(2, "Chela","Castillo"));
        this.lista.add( new Usuario(3, "Michel","Castillo"));
        this.lista.add( new Usuario(4, "Samira","Castillo"));
        this.lista.add( new Usuario(5, "Mama","Castillo"));
        this.lista.add( new Usuario(6, "Paco","Petra"));
        this.lista.add( new Usuario(7, "Juan","Rodriguez"));
        this.lista.add( new Usuario(8, "Julieth","Segura"));

    }

    @Override
    public List<Usuario> listar() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;
        for( Usuario usuario: this.lista){
            if(usuario.getId().equals(id)) {
                resultado = usuario;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = this.obtenerPorId(id);

        return Optional.ofNullable(usuario);
    }
}
