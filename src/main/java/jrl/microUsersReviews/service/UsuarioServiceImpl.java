package jrl.microUsersReviews.service;

import jrl.microUsersReviews.dao.UsuarioDAO;
import jrl.microUsersReviews.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioDAO.buscarTodos();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return usuarioDAO.buscarUsuarioPorId(idUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioDAO.buscarUsuarioPorNombreUsuario(nombreUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        return usuarioDAO.buscarUsuarioPorCorreo(correo);
    }

    @Override
    public Usuario buscarUsuarioPorCorreoClave(String correo, String clave) {
        return usuarioDAO.buscarUsuarioPorCorreoClave(correo, clave);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() == null) {
            usuarioDAO.guardarUsuario(usuario);
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if (usuarioDAO.buscarUsuarioPorId(usuario.getIdUsuario()) != null) {
            usuarioDAO.actualizarUsuario(usuario);
        }
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioDAO.eliminarUsuario(idUsuario);
    }

    @Override
    public void eliminarCritica(Integer idUsuario, Integer idCritica) {
        usuarioDAO.eliminarCritica(idUsuario, idCritica);
    }

    @Override
    public void asignarRol(Integer idUsuario, Integer idRol) {
        usuarioDAO.asignarRol(idUsuario, idRol);
    }

    @Override
    public void quitarRol(Integer idUsuario, Integer idRol) {
        usuarioDAO.quitarRol(idUsuario, idRol);
    }

}
