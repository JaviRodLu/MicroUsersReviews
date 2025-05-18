package jrl.microUsersReviews.service;

import jrl.microUsersReviews.dao.CriticaDAO;
import jrl.microUsersReviews.model.Critica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticaServiceImpl implements CriticaService {

    @Autowired
    CriticaDAO criticaDAO;

    @Override
    public List<Critica> buscarTodas() {
        return criticaDAO.buscarTodas();
    }

    @Override
    public List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula) {
        return criticaDAO.buscarCriticasPorIdPelicula(idPelicula);
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        return criticaDAO.buscarCriticaPorId(idCritica);
    }

    @Override
    public void guardarCritica(Critica critica) {
        if (critica.getIdCritica() == null) {
            criticaDAO.guardarCritica(critica);
        }
    }

    @Override
    public void eliminarCritica(Integer idCritica) {
        criticaDAO.eliminarCritica(idCritica);
    }

}
