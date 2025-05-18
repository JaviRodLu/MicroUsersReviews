package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJPA extends JpaRepository<Usuario,Integer> {
    Usuario findByNombreUsuario(String nombreUsuario);
    Usuario findByCorreo(String correo);
    Usuario findByCorreoAndClave(String correo, String clave);
}
