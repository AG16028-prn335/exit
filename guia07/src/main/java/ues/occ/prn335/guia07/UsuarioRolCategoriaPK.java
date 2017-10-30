/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gonzalez
 */
@Embeddable
public class UsuarioRolCategoriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria", nullable = false)
    private int idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol", nullable = false)
    private int idRol;

    public UsuarioRolCategoriaPK() {
    }

    public UsuarioRolCategoriaPK(int idUsuario, int idCategoria, int idRol) {
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idCategoria;
        hash += (int) idRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolCategoriaPK)) {
            return false;
        }
        UsuarioRolCategoriaPK other = (UsuarioRolCategoriaPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.UsuarioRolCategoriaPK[ idUsuario=" + idUsuario + ", idCategoria=" + idCategoria + ", idRol=" + idRol + " ]";
    }
    
}
