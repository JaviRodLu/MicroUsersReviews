package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Critica;
import jrl.microUsersReviews.model.Rol;
import jrl.microUsersReviews.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    UsuarioJPA usuarioJPA;

    @Autowired
    CriticaJPA criticaJPA;

    @Autowired
    RolJPA rolJPA;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioJPA.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioJPA.findById(idUsuario);
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioJPA.findByNombreUsuario(nombreUsuario));
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        return null;
    }


    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioJPA.findByCorreo(correo));
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorCorreoClave(String correo, String clave) {
        Optional<Usuario> optionalUsuario = Optional.ofNullable(usuarioJPA.findByCorreoAndClave(correo, clave));
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        return null;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioJPA.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioJPA.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioJPA.deleteById(idUsuario);
    }

    @Override
    public void eliminarCritica(Integer idUsuario, Integer idCritica) {
        Usuario u = buscarUsuarioPorId(idUsuario);
        if (u != null) {
            u.removeCritica(criticaJPA.findById(idCritica).orElse(null));
        }
        criticaJPA.deleteById(idCritica);
    }

    @Override
    public void asignarRol(Integer idUsuario, Integer idRol) {
        Optional<Usuario> optionalUsuario = usuarioJPA.findById(idUsuario);
        if (optionalUsuario.isPresent()) {
            Usuario u = optionalUsuario.get();
            Optional<Rol> optionalRol = rolJPA.findById(idRol);
            if (optionalRol.isPresent()) {
                u.addRol(optionalRol.get());
                usuarioJPA.save(u);
            }
        }
    }

    @Override
    public void quitarRol(Integer idUsuario, Integer idRol) {
        Optional<Usuario> optionalUsuario = usuarioJPA.findById(idUsuario);
        if (optionalUsuario.isPresent()) {
            Usuario u = optionalUsuario.get();
            Optional<Rol> optionalRol = rolJPA.findById(idRol);
            if (optionalRol.isPresent()) {
                if (u.getRoles().contains(optionalRol.get())) {
                    u.removeRol(optionalRol.get());
                    usuarioJPA.save(u);
                }
            }
        }
    }

}
