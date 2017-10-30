/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.prn335.guia07;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gonzalez
 */
@Entity
@Table(name = "tipo_post_seccion", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPostSeccion.findAll", query = "SELECT t FROM TipoPostSeccion t")
    , @NamedQuery(name = "TipoPostSeccion.findByIdSeccion", query = "SELECT t FROM TipoPostSeccion t WHERE t.tipoPostSeccionPK.idSeccion = :idSeccion")
    , @NamedQuery(name = "TipoPostSeccion.findByIdTipoPost", query = "SELECT t FROM TipoPostSeccion t WHERE t.tipoPostSeccionPK.idTipoPost = :idTipoPost")
    , @NamedQuery(name = "TipoPostSeccion.findByActivo", query = "SELECT t FROM TipoPostSeccion t WHERE t.activo = :activo")
    , @NamedQuery(name = "TipoPostSeccion.findByObligatorio", query = "SELECT t FROM TipoPostSeccion t WHERE t.obligatorio = :obligatorio")
    , @NamedQuery(name = "TipoPostSeccion.findByPeso", query = "SELECT t FROM TipoPostSeccion t WHERE t.peso = :peso")})
public class TipoPostSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoPostSeccionPK tipoPostSeccionPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "obligatorio")
    private Boolean obligatorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso", nullable = false)
    private int peso;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seccion seccion;
    @JoinColumn(name = "id_tipo_post", referencedColumnName = "id_tipo_post", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPost tipoPost;

    public TipoPostSeccion() {
    }

    public TipoPostSeccion(TipoPostSeccionPK tipoPostSeccionPK) {
        this.tipoPostSeccionPK = tipoPostSeccionPK;
    }

    public TipoPostSeccion(TipoPostSeccionPK tipoPostSeccionPK, int peso) {
        this.tipoPostSeccionPK = tipoPostSeccionPK;
        this.peso = peso;
    }

    public TipoPostSeccion(int idSeccion, int idTipoPost) {
        this.tipoPostSeccionPK = new TipoPostSeccionPK(idSeccion, idTipoPost);
    }

    public TipoPostSeccionPK getTipoPostSeccionPK() {
        return tipoPostSeccionPK;
    }

    public void setTipoPostSeccionPK(TipoPostSeccionPK tipoPostSeccionPK) {
        this.tipoPostSeccionPK = tipoPostSeccionPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public TipoPost getTipoPost() {
        return tipoPost;
    }

    public void setTipoPost(TipoPost tipoPost) {
        this.tipoPost = tipoPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPostSeccionPK != null ? tipoPostSeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPostSeccion)) {
            return false;
        }
        TipoPostSeccion other = (TipoPostSeccion) object;
        if ((this.tipoPostSeccionPK == null && other.tipoPostSeccionPK != null) || (this.tipoPostSeccionPK != null && !this.tipoPostSeccionPK.equals(other.tipoPostSeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.prn335.guia07.TipoPostSeccion[ tipoPostSeccionPK=" + tipoPostSeccionPK + " ]";
    }
    
}
