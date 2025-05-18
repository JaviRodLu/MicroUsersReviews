package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Critica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CriticaDAOImpl implements CriticaDAO {

    @Autowired
    CriticaJPA criticaJPA;

    @Override
    public List<Critica> buscarTodas() {
        return criticaJPA.findAll();
    }

    @Override
    public List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula) {
        return criticaJPA.findByIdPelicula(idPelicula);
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        Optional<Critica> optionalCritica = criticaJPA.findById(idCritica);
        if (optionalCritica.isPresent()) {
            return optionalCritica.get();
        }
        return null;
    }

    @Override
    public void guardarCritica(Critica critica) {
        criticaJPA.save(critica);
    }

    @Override
    public void eliminarCritica(Integer idCritica) {
        criticaJPA.deleteById(idCritica);
    }
}
