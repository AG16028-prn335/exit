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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gonzalez
 */
@Entity
@Table(name = "post_paso", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostPaso.findAll", query = "SELECT p FROM PostPaso p")
    , @NamedQuery(name = "PostPaso.findByIdPost", query = "SELECT p FROM PostPaso p WHERE p.postPasoPK.idPost = :idPost")
    , @NamedQuery(name = "PostPaso.findByIdPaso", query = "SELECT p FROM PostPaso p WHERE p.postPasoPK.idPaso = :idPaso")
    , @NamedQuery(name = "PostPaso.findByIdUsuario", query = "SELECT p FROM PostPaso p WHERE p.idUsuario = :idUsuario")
    , @NamedQuery(name = "PostPaso.findByIdCategoria", query = "SELECT p FROM PostPaso p WHERE p.idCategoria = :idCategoria")
    , @NamedQuery(name = "PostPaso.findByIdRol", query = "SELECT p FROM PostPaso p WHERE p.idRol = :idRol")
    , @NamedQuery(name = "PostPaso.findByAprobado", query = "SELECT p FROM PostPaso p WHERE p.aprobado = :aprobado")
    , @NamedQuery(name = "PostPaso.findByComentarios", query = "SELECT p FROM PostPaso p WHERE p.comentarios = :comentarios")})
public class PostPaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PostPasoPK postPasoPK;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "id_rol")
    private Integer idRol;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Size(max = 2147483647)
    @Column(name = "comentarios", length = 2147483647)
    private String comentarios;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paso paso;
    @JoinColumn(name = "id_post", referencedColumnName = "id_post", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Post post;

    public PostPaso() {
    }

    public PostPaso(PostPasoPK postPasoPK) {
        this.postPasoPK = postPasoPK;
    }

    public PostPaso(int idPost, int idPaso) {
        this.postPasoPK = new PostPasoPK(idPost, idPaso);
    }

    public PostPasoPK getPostPasoPK() {
        return postPasoPK;
    }

    public void setPostPasoPK(PostPasoPK postPasoPK) {
        this.postPasoPK = postPasoPK;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Paso getPaso() {
        return paso;
    }

    public void setPaso(Paso paso) {
        this.paso = paso;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postPasoPK != null ? postPasoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostPaso)) {
            return false;
        }
        PostPaso other = (PostPaso) object;
        if ((this.postPasoPK == null && other.postPasoPK != null) || (this.postPasoPK != null && !this.postPasoPK.equals(other.postPasoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.PostPaso[ postPasoPK=" + postPasoPK + " ]";
    }
    
}
