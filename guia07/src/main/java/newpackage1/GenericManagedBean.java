/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import newpackage.GenericFacadeLocal;

/**
 *
 * @author gonzalez
 */
public abstract class GenericManagedBean<T> implements Serializable {
  List<T> listaDatos;

    /**
     * Este metodo sirve para crear un nuevo un registro
     */
    public void crear() {
        if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().create(getEntity());
                llenarLista();
                enviarMensaje(false,"Registro creado correctamente.");
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
                enviarMensaje(true,"Error al crear registro creado correctamente.");
            }
        }
    }

    /**
     * Este metodo sirve para editar un registro
     */
    public void editar() {
        if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().edit(getEntity());
                llenarLista();
                enviarMensaje(false,"Edicion realizada correctamente.");
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
                enviarMensaje(true,"Error al editar registro.");
            }
        }
    }

    /**
     * Este metodo sirve para eliminar un registro
     */
    public void eliminar() {
        if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().remove(getEntity());
                llenarLista();
                enviarMensaje(false,"Registro eliminado correctamente");
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
                enviarMensaje(true,"Error al eliminar registro");
            }
        }
    }

    /**
     * Este metodo sirve para llenar una lista de datos obtenidos de la base de
     * datos
     */
    public void llenarLista() {
        if (getFacadeLocal().findAll() != null) {
            this.listaDatos = getFacadeLocal().findAll();
        } else {
            this.listaDatos = Collections.EMPTY_LIST;
        }
    }

    /**
     * Este metodo sirve para mostrar un mensaje en el JSF
     *
     * @param error espera un true o false para mostrar un mensaje de error o
     * confirmacion respectivaente
     * @param mensaje espera el mensaje a mostrar
     */
    public void enviarMensaje(boolean error, String mensaje) {
        if (error=false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", mensaje));
        }
    }

    /**
     * 
     * @return se espera que retorne el una interfaz de algun tipo para trabajar con ell
     */
    protected abstract GenericFacadeLocal<T> getFacadeLocal();

    /**
     *
     * @return se espera que retorne una entitdad para trabajar con ella
     */
    public abstract T getEntity();  
}
