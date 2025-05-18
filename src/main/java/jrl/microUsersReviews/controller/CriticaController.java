package jrl.microUsersReviews.controller;

import jrl.microUsersReviews.model.Critica;
import jrl.microUsersReviews.service.CriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriticaController {
    @Autowired
    CriticaService criticaService;

    @GetMapping("/criticas")
    public List<Critica> buscarTodas() {
        return criticaService.buscarTodas();
    }

    @GetMapping("/criticas/pelicula/{idPelicula}")
    public List<Critica> buscarCriticasPorIdPelicula(@PathVariable("idPelicula") Integer idPelicula) {
        return criticaService.buscarCriticasPorIdPelicula(idPelicula);
    }

    @GetMapping("/criticas/{idCritica}")
    public Critica buscarCriticaPorId(@PathVariable("idCritica") Integer idCritica) {
        return criticaService.buscarCriticaPorId(idCritica);
    }

    @PostMapping("/criticas")
    public void guardarCritica(@RequestBody Critica critica) {
        criticaService.guardarCritica(critica);
    }

    @DeleteMapping("/criticas/{idCritica}")
    public void eliminarCritica(@PathVariable("idCritica") Integer idCritica) {
        criticaService.eliminarCritica(idCritica);
    }

}
