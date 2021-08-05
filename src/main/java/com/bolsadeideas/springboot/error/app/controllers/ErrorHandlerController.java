package com.bolsadeideas.springboot.error.app.controllers;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String aritmeticError(ArithmeticException ex, Model model){

        model.addAttribute("error","Error de aritmética");
        model.addAttribute(" message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/aritmetic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String NumberException( NumberFormatException ex, Model model){

        model.addAttribute("error","Formato número invalido");
        model.addAttribute(" message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/generica";
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public String usuarioNoEncontrado( UsuarioNoEncontradoException ex, Model model){

        model.addAttribute("error","Error: usuario no encontrado!");
        model.addAttribute(" message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/usuario";
    }
}
