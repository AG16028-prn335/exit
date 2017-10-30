/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import newpackage.GenericFacadeLocal;
import newpackage.RolFacadeLocal;
import org.primefaces.event.SelectEvent;
import ues.occ.prn335.guia07.Rol;

/**
 *
 * @author gonzalez
 */
@Named(value = "rolBean")
@ViewScoped
public class RolBean extends GenericManagedBean<Rol> implements  Serializable{

  
    @EJB
    RolFacadeLocal Rolfc;
    Rol rol;
  

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    boolean visible = false, activo;

    @Override
    protected GenericFacadeLocal<Rol> getFacadeLocal() {
        return Rolfc;
    }

    @Override
    public Rol getEntity() {
        return rol;
    }

    @Override
    public void editar() {
        super.editar();
        reiniciarValores();
    }

    @Override
    public void eliminar() {
        super.eliminar();
        reiniciarValores();
    }

    @Override
    public void crear() {
        super.crear();
        reiniciarValores();
    }

    public RolFacadeLocal getRolfc() {
        return Rolfc;
    }

    public void setRolfc(RolFacadeLocal Rolfc) {
        this.Rolfc = Rolfc;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void reiniciarValores() {
        rol.setIdRol(null);
        rol.setNombre(null);
        rol.setActivo(false);
        rol.setDescripcion(null);
    }

    public void onRowSelect(SelectEvent event) {
        visible = true;
    }

    public void Cancelar() {
        rol = new Rol();
        visible = false;
    }

    @PostConstruct
    public void init() {
        super.llenarLista();
    }

    /**
     * este metodo filtra los roles no utilizados
     *
     * @return
     */
    public List<Rol> obtenerUtilizados() {
        List salida;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sv.edu.uesocc.ingenieria.prn335_Guia05_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query c = em.createNamedQuery("Rol.noUtilizados");
        salida = c.getResultList();

        if (salida != null) {
            return salida;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * este metodo sirve para la accion de filtrado
     */
   
    

}
