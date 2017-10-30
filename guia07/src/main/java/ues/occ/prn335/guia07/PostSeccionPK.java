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
public class PostSeccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_post", nullable = false)
    private int idPost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_seccion", nullable = false)
    private int idSeccion;

    public PostSeccionPK() {
    }

    public PostSeccionPK(int idPost, int idSeccion) {
        this.idPost = idPost;
        this.idSeccion = idSeccion;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPost;
        hash += (int) idSeccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostSeccionPK)) {
            return false;
        }
        PostSeccionPK other = (PostSeccionPK) object;
        if (this.idPost != other.idPost) {
            return false;
        }
        if (this.idSeccion != other.idSeccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.PostSeccionPK[ idPost=" + idPost + ", idSeccion=" + idSeccion + " ]";
    }
    
}
