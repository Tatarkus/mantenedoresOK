/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Clientebanco;

/**
 *
 * @author matia
 */
@Stateless
public class ClientebancoFacade extends AbstractFacade<Clientebanco> {

    @PersistenceContext(unitName = "OKCASAMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientebancoFacade() {
        super(Clientebanco.class);
    }
    
}
