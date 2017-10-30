/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gonzalez
 */
@Entity
@Table(name = "tipo_post", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPost.findAll", query = "SELECT t FROM TipoPost t")
    , @NamedQuery(name = "TipoPost.findByIdTipoPost", query = "SELECT t FROM TipoPost t WHERE t.idTipoPost = :idTipoPost")
    , @NamedQuery(name = "TipoPost.findByNombre", query = "SELECT t FROM TipoPost t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoPost.findByActivo", query = "SELECT t FROM TipoPost t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoPost.findByDescripcion", query = "SELECT t FROM TipoPost t WHERE t.descripcion = :descripcion")})
public class TipoPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_post", nullable = false)
    private Integer idTipoPost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPost")
    private List<TipoPostSeccion> tipoPostSeccionList;
    @OneToMany(mappedBy = "idTipoPost")
    private List<Post> postList;

    public TipoPost() {
    }

    public TipoPost(Integer idTipoPost) {
        this.idTipoPost = idTipoPost;
    }

    public TipoPost(Integer idTipoPost, String nombre) {
        this.idTipoPost = idTipoPost;
        this.nombre = nombre;
    }

    public Integer getIdTipoPost() {
        return idTipoPost;
    }

    public void setIdTipoPost(Integer idTipoPost) {
        this.idTipoPost = idTipoPost;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TipoPostSeccion> getTipoPostSeccionList() {
        return tipoPostSeccionList;
    }

    public void setTipoPostSeccionList(List<TipoPostSeccion> tipoPostSeccionList) {
        this.tipoPostSeccionList = tipoPostSeccionList;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPost != null ? idTipoPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPost)) {
            return false;
        }
        TipoPost other = (TipoPost) object;
        if ((this.idTipoPost == null && other.idTipoPost != null) || (this.idTipoPost != null && !this.idTipoPost.equals(other.idTipoPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.TipoPost[ idTipoPost=" + idTipoPost + " ]";
    }
    
}
