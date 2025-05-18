package jrl.microUsersReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario", schema = "usersreviews")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "nombreUsuario", nullable = false, length = 45)
    private String nombreUsuario;

    @Column(name = "clave", nullable = false, length = 60)
    private String clave;

    @Column(name = "correo", nullable = false, length = 75)
    private String correo;

    @ColumnDefault("1")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

    @ManyToMany
    @JoinTable(name = "rolusuario",
            joinColumns = {@JoinColumn(name = "usuario", referencedColumnName = "idUsuario")},
            inverseJoinColumns = {@JoinColumn(name = "rol", referencedColumnName = "idRol")})
    private List<Rol> roles;

    @JsonIgnoreProperties("usuario")
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.ALL})
    private List<Critica> criticas;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario != null && Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addCritica(Critica critica) {
        getCriticas().add(critica);
        critica.setUsuario(this);
    }

    public void removeCritica(Critica critica) {
        if (critica != null) {
            getCriticas().remove(critica);
        }
    }

    public void addRol(Rol rol) {
        if (rol != null) {
            getRoles().add(rol);
        }
    }

    public void removeRol(Rol rol) {
        if (rol != null) {
            getRoles().remove(rol);
        }
    }

}