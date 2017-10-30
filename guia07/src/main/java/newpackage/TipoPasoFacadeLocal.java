/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;
import ues.occ.prn335.guia07.TipoPaso;

/**
 *
 * @author gonzalez
 */
@Local
public interface TipoPasoFacadeLocal {

    void create(TipoPaso tipoPaso);

    void edit(TipoPaso tipoPaso);

    void remove(TipoPaso tipoPaso);

    TipoPaso find(Object id);

    List<TipoPaso> findAll();

    List<TipoPaso> findRange(int[] range);

    int count();
    
}
