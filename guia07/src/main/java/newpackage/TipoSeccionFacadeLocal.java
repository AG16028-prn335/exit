/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;
import ues.occ.prn335.guia07.TipoSeccion;

/**
 *
 * @author gonzalez
 */
@Local
public interface TipoSeccionFacadeLocal {

    void create(TipoSeccion tipoSeccion);

    void edit(TipoSeccion tipoSeccion);

    void remove(TipoSeccion tipoSeccion);

    TipoSeccion find(Object id);

    List<TipoSeccion> findAll();

    List<TipoSeccion> findRange(int[] range);

    int count();
    
}
