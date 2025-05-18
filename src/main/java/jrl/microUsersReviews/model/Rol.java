package jrl.microUsersReviews.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol", schema = "usersreviews")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer idRol;

    @Column(name = "privilegio", nullable = false, length = 45)
    private String privilegio;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer id) {
        this.idRol = idRol;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

}