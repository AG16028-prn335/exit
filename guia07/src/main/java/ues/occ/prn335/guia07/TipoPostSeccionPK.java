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
public class TipoPostSeccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_seccion", nullable = false)
    private int idSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_post", nullable = false)
    private int idTipoPost;

    public TipoPostSeccionPK() {
    }

    public TipoPostSeccionPK(int idSeccion, int idTipoPost) {
        this.idSeccion = idSeccion;
        this.idTipoPost = idTipoPost;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getIdTipoPost() {
        return idTipoPost;
    }

    public void setIdTipoPost(int idTipoPost) {
        this.idTipoPost = idTipoPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSeccion;
        hash += (int) idTipoPost;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPostSeccionPK)) {
            return false;
        }
        TipoPostSeccionPK other = (TipoPostSeccionPK) object;
        if (this.idSeccion != other.idSeccion) {
            return false;
        }
        if (this.idTipoPost != other.idTipoPost) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.TipoPostSeccionPK[ idSeccion=" + idSeccion + ", idTipoPost=" + idTipoPost + " ]";
    }
    
}
