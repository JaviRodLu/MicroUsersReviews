package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolDAOImpl implements RolDAO {

    @Autowired
    RolJPA rolJPA;

    @Override
    public List<Rol> buscarTodos() {
        return rolJPA.findAll();
    }

    @Override
    public Rol buscarRolPorId(Integer idRol) {
        Optional<Rol> optionalRol = rolJPA.findById(idRol);
        if (optionalRol.isPresent()) {
            return optionalRol.get();
        }
        return null;
    }

    @Override
    public void guardarRol(Rol rol) {
        rolJPA.save(rol);
    }

    @Override
    public void eliminarRol(Integer idRol) {
        rolJPA.deleteById(idRol);
    }

}
