/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;
import ues.occ.prn335.guia07.Cometario;

/**
 *
 * @author gonzalez
 */
@Local
public interface CometarioFacadeLocal {

    void create(Cometario cometario);

    void edit(Cometario cometario);

    void remove(Cometario cometario);

    Cometario find(Object id);

    List<Cometario> findAll();

    List<Cometario> findRange(int[] range);

    int count();
    
}
