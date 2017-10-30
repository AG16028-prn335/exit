/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.prn335.guia07.PostPaso;

/**
 *
 * @author gonzalez
 */
@Stateless
public class PostPasoFacade extends AbstractFacade<PostPaso> implements PostPasoFacadeLocal {

    @PersistenceContext(unitName = "ues.occ.prn335_guia07_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostPasoFacade() {
        super(PostPaso.class);
    }
    
}
