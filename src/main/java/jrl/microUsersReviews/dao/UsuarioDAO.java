package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> buscarTodos();
    Usuario buscarUsuarioPorId(Integer idUsuario);
    Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
    Usuario buscarUsuarioPorCorreo(String correo);
    Usuario buscarUsuarioPorCorreoClave(String correo, String clave);
    void guardarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Integer idUsuario);
    void eliminarCritica(Integer idUsuario, Integer idCritica);
    void asignarRol(Integer idUsuario, Integer idRol);
    void quitarRol(Integer idUsuario, Integer idRol);
}
