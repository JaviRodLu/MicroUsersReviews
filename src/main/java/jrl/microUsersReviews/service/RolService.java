package jrl.microUsersReviews.service;

import jrl.microUsersReviews.model.Rol;

import java.util.List;

public interface RolService {
    List<Rol> buscarTodos();
    Rol buscarRolPorId(Integer idRol);
    void guardarRol(Rol rol);
    void eliminarRol(Integer idRol);
}
