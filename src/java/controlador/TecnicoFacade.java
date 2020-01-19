/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tecnico;

/**
 *
 * @author matia
 */
@Stateless
public class TecnicoFacade extends AbstractFacade<Tecnico> {

    @PersistenceContext(unitName = "OKCASAMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicoFacade() {
        super(Tecnico.class);
    }
    
}
