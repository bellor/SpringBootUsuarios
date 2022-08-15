package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.impl.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController//Anotación de que es un controlador
@RequestMapping("/usuario")
public class UsuarioController {
	
    @Autowired//Inyecta dependencia
    UsuarioServiceImpl usuarioService;

    @GetMapping()//Obtiene información cliente
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return this.usuarioService.obtenerUsuarios();
    }

    @PostMapping()//Crear cliente
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){//La anotación @RequestBody nos sirve para deserializar un objeto completo a partir del cuerpo de la petición. Es decir si tenemos esta clase
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")//Obtiene información cliente por id
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){//La anotación @RequestParam nos sirve para acceder al valor de uno de los parámetros.
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")//Borra información cliente por id
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}