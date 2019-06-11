/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.SolDetOrden;

/**
 *
 * @author grego
 */
@Stateless
public class SolDetOrdenFacade extends AbstractFacade<SolDetOrden> {

    @PersistenceContext(unitName = "gestorcompra_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolDetOrdenFacade() {
        super(SolDetOrden.class);
    }
    
}
