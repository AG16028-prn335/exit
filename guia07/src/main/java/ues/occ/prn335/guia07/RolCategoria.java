/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gonzalez
 */
@Entity
@Table(name = "rol_categoria", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolCategoria.findAll", query = "SELECT r FROM RolCategoria r")
    , @NamedQuery(name = "RolCategoria.findByIdRol", query = "SELECT r FROM RolCategoria r WHERE r.rolCategoriaPK.idRol = :idRol")
    , @NamedQuery(name = "RolCategoria.findByIdCategoria", query = "SELECT r FROM RolCategoria r WHERE r.rolCategoriaPK.idCategoria = :idCategoria")
    , @NamedQuery(name = "RolCategoria.findByActivo", query = "SELECT r FROM RolCategoria r WHERE r.activo = :activo")})
public class RolCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolCategoriaPK rolCategoriaPK;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolCategoria")
    private List<UsuarioRolCategoria> usuarioRolCategoriaList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @OneToMany(mappedBy = "rolCategoria")
    private List<Paso> pasoList;

    public RolCategoria() {
    }

    public RolCategoria(RolCategoriaPK rolCategoriaPK) {
        this.rolCategoriaPK = rolCategoriaPK;
    }

    public RolCategoria(int idRol, int idCategoria) {
        this.rolCategoriaPK = new RolCategoriaPK(idRol, idCategoria);
    }

    public RolCategoriaPK getRolCategoriaPK() {
        return rolCategoriaPK;
    }

    public void setRolCategoriaPK(RolCategoriaPK rolCategoriaPK) {
        this.rolCategoriaPK = rolCategoriaPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<UsuarioRolCategoria> getUsuarioRolCategoriaList() {
        return usuarioRolCategoriaList;
    }

    public void setUsuarioRolCategoriaList(List<UsuarioRolCategoria> usuarioRolCategoriaList) {
        this.usuarioRolCategoriaList = usuarioRolCategoriaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<Paso> getPasoList() {
        return pasoList;
    }

    public void setPasoList(List<Paso> pasoList) {
        this.pasoList = pasoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolCategoriaPK != null ? rolCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolCategoria)) {
            return false;
        }
        RolCategoria other = (RolCategoria) object;
        if ((this.rolCategoriaPK == null && other.rolCategoriaPK != null) || (this.rolCategoriaPK != null && !this.rolCategoriaPK.equals(other.rolCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.RolCategoria[ rolCategoriaPK=" + rolCategoriaPK + " ]";
    }
    
}
