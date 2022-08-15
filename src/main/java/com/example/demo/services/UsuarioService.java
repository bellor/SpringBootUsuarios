package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.UsuarioModel;

public interface UsuarioService {
	
    public ArrayList<UsuarioModel> obtenerUsuarios();

    public UsuarioModel guardarUsuario(UsuarioModel usuario);

    public Optional<UsuarioModel> obtenerPorId(Long id);

    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad);

    public boolean eliminarUsuario(Long id);

}
