package jrl.microUsersReviews.controller;

import jrl.microUsersReviews.model.Usuario;
import jrl.microUsersReviews.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/usuarios/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathVariable("idUsuario") Integer idUsuario) {
        return usuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping("/usuarios/nombreUsuario/{nombre}")
    public Usuario buscarUsuarioPorNombreUsuario(@PathVariable("nombre") String nombre) {
        return usuarioService.buscarUsuarioPorNombreUsuario(nombre);
    }

    @GetMapping("/usuarios/correo/{correo}")
    public Usuario buscarUsuarioPorCorreo(@PathVariable("correo") String correo) {
        return usuarioService.buscarUsuarioPorCorreo(correo);
    }

    @GetMapping("/usuarios/login/{correo}/{clave}")
    public Usuario buscarUsuarioPorCorreoClave(@PathVariable("correo") String correo, @PathVariable("clave") String clave) {
        return usuarioService.buscarUsuarioPorCorreoClave(correo, clave);
    }

    @PostMapping("/usuarios")
    public void guardarUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/usuarios")
    public void actualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
    }

    @GetMapping("/usuarios/asignarRol/{idUsuario}/{idRol}")
    public void asignarRol(@PathVariable("idUsuario") Integer idUsuario, @PathVariable("idRol") Integer idRol) {
        usuarioService.asignarRol(idUsuario, idRol);
    }

    @GetMapping("/usuarios/quitarRol/{idUsuario}/{idRol}")
    public void quitarRol(@PathVariable("idUsuario") Integer idUsuario, @PathVariable("idRol") Integer idRol) {
        usuarioService.quitarRol(idUsuario, idRol);
    }

}
