/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "meta", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meta.findAll", query = "SELECT m FROM Meta m")
    , @NamedQuery(name = "Meta.findByIdMeta", query = "SELECT m FROM Meta m WHERE m.idMeta = :idMeta")
    , @NamedQuery(name = "Meta.findByNombre", query = "SELECT m FROM Meta m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Meta.findByActivo", query = "SELECT m FROM Meta m WHERE m.activo = :activo")
    , @NamedQuery(name = "Meta.findByDescripcion", query = "SELECT m FROM Meta m WHERE m.descripcion = :descripcion")})
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_meta", nullable = false)
    private Integer idMeta;
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
    @JoinTable(name = "post_meta", joinColumns = {
        @JoinColumn(name = "id_meta", referencedColumnName = "id_meta", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_post", referencedColumnName = "id_post", nullable = false)})
    @ManyToMany
    private List<Post> postList;

    public Meta() {
    }

    public Meta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Meta(Integer idMeta, String nombre) {
        this.idMeta = idMeta;
        this.nombre = nombre;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
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
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.Meta[ idMeta=" + idMeta + " ]";
    }
    
}
