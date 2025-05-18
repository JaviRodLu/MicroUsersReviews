package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Critica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriticaJPA extends JpaRepository<Critica, Integer> {
    List<Critica> findByIdPelicula(Integer idPelicula);
}
