package jrl.microUsersReviews.service;

import jrl.microUsersReviews.dao.RolDAO;
import jrl.microUsersReviews.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolDAO rolDAO;

    @Override
    public List<Rol> buscarTodos() {
        return rolDAO.buscarTodos();
    }

    @Override
    public Rol buscarRolPorId(Integer idRol) {
        return rolDAO.buscarRolPorId(idRol);
    }

    @Override
    public void guardarRol(Rol rol) {
        if (rol.getIdRol() == null) {
            rolDAO.guardarRol(rol);
        }
    }

    @Override
    public void eliminarRol(Integer idRol) {
        rolDAO.eliminarRol(idRol);
    }

}
