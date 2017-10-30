/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;
import ues.occ.prn335.guia07.PostSeccion;

/**
 *
 * @author gonzalez
 */
@Local
public interface PostSeccionFacadeLocal {

    void create(PostSeccion postSeccion);

    void edit(PostSeccion postSeccion);

    void remove(PostSeccion postSeccion);

    PostSeccion find(Object id);

    List<PostSeccion> findAll();

    List<PostSeccion> findRange(int[] range);

    int count();
    
}
