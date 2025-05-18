package jrl.microUsersReviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "critica", schema = "usersreviews")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCritica", nullable = false)
    private Integer idCritica;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "idPelicula", nullable = false)
    private Integer idPelicula;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    public Integer getIdCritica() {
        return idCritica;
    }

    public void setIdCritica(Integer idCr) {
        this.idCritica = idCr;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Critica cr = (Critica) o;
        return idCritica != null && Objects.equals(idCritica, cr.idCritica);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}