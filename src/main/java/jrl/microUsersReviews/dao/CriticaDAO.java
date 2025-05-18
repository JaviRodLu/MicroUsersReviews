package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Critica;

import java.util.List;

public interface CriticaDAO {
    List<Critica> buscarTodas();
    List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula);
    Critica buscarCriticaPorId(Integer idCritica);
    void guardarCritica(Critica critica);
    void eliminarCritica(Integer idCritica);
}
