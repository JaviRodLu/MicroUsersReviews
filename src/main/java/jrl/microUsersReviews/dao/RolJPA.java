package jrl.microUsersReviews.dao;

import jrl.microUsersReviews.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJPA extends JpaRepository<Rol, Integer> {
}
