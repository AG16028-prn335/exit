/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gonzalez
 */
@Entity
@Table(name = "usuario_rol_categoria", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRolCategoria.findAll", query = "SELECT u FROM UsuarioRolCategoria u")
    , @NamedQuery(name = "UsuarioRolCategoria.findByIdUsuario", query = "SELECT u FROM UsuarioRolCategoria u WHERE u.usuarioRolCategoriaPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioRolCategoria.findByIdCategoria", query = "SELECT u FROM UsuarioRolCategoria u WHERE u.usuarioRolCategoriaPK.idCategoria = :idCategoria")
    , @NamedQuery(name = "UsuarioRolCategoria.findByIdRol", query = "SELECT u FROM UsuarioRolCategoria u WHERE u.usuarioRolCategoriaPK.idRol = :idRol")
    , @NamedQuery(name = "UsuarioRolCategoria.findByActivo", query = "SELECT u FROM UsuarioRolCategoria u WHERE u.activo = :activo")})
public class UsuarioRolCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioRolCategoriaPK usuarioRolCategoriaPK;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumns({
        @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false, insertable = false, updatable = false)
        , @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private RolCategoria rolCategoria;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioRolCategoria() {
    }

    public UsuarioRolCategoria(UsuarioRolCategoriaPK usuarioRolCategoriaPK) {
        this.usuarioRolCategoriaPK = usuarioRolCategoriaPK;
    }

    public UsuarioRolCategoria(int idUsuario, int idCategoria, int idRol) {
        this.usuarioRolCategoriaPK = new UsuarioRolCategoriaPK(idUsuario, idCategoria, idRol);
    }

    public UsuarioRolCategoriaPK getUsuarioRolCategoriaPK() {
        return usuarioRolCategoriaPK;
    }

    public void setUsuarioRolCategoriaPK(UsuarioRolCategoriaPK usuarioRolCategoriaPK) {
        this.usuarioRolCategoriaPK = usuarioRolCategoriaPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public RolCategoria getRolCategoria() {
        return rolCategoria;
    }

    public void setRolCategoria(RolCategoria rolCategoria) {
        this.rolCategoria = rolCategoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioRolCategoriaPK != null ? usuarioRolCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolCategoria)) {
            return false;
        }
        UsuarioRolCategoria other = (UsuarioRolCategoria) object;
        if ((this.usuarioRolCategoriaPK == null && other.usuarioRolCategoriaPK != null) || (this.usuarioRolCategoriaPK != null && !this.usuarioRolCategoriaPK.equals(other.usuarioRolCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.UsuarioRolCategoria[ usuarioRolCategoriaPK=" + usuarioRolCategoriaPK + " ]";
    }
    
}
