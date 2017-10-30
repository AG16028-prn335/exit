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
public class RolCategoriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol", nullable = false)
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria", nullable = false)
    private int idCategoria;

    public RolCategoriaPK() {
    }

    public RolCategoriaPK(int idRol, int idCategoria) {
        this.idRol = idRol;
        this.idCategoria = idCategoria;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRol;
        hash += (int) idCategoria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolCategoriaPK)) {
            return false;
        }
        RolCategoriaPK other = (RolCategoriaPK) object;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.RolCategoriaPK[ idRol=" + idRol + ", idCategoria=" + idCategoria + " ]";
    }
    
}
