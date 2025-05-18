package jrl.microUsersReviews.controller;

import jrl.microUsersReviews.model.Rol;
import jrl.microUsersReviews.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/roles")
    public List<Rol> buscarTodos() {
        return rolService.buscarTodos();
    }

    @GetMapping("/roles/{idRol}")
    public Rol buscarRolPorId(@PathVariable("idRol") Integer idRol) {
        return rolService.buscarRolPorId(idRol);
    }

    @PostMapping("/roles")
    public void guardarRol(@RequestBody Rol rol) {
        rolService.guardarRol(rol);
    }

    @DeleteMapping("/roles/{idRol}")
    public void eliminarRol(@PathVariable("idRol") Integer idRol) {
        rolService.eliminarRol(idRol);
    }

}
