/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.ejb.Local;
import ues.occ.prn335.guia07.UsuarioRolCategoria;

/**
 *
 * @author gonzalez
 */
@Local
public interface UsuarioRolCategoriaFacadeLocal {

    void create(UsuarioRolCategoria usuarioRolCategoria);

    void edit(UsuarioRolCategoria usuarioRolCategoria);

    void remove(UsuarioRolCategoria usuarioRolCategoria);

    UsuarioRolCategoria find(Object id);

    List<UsuarioRolCategoria> findAll();

    List<UsuarioRolCategoria> findRange(int[] range);

    int count();
    
}
