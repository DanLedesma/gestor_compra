/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.SolEncOrden;
import modelo.SolEncOrden_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.SolDetOrden;

/**
 *
 * @author grego
 */
@Stateless
public class SolEncOrdenFacade extends AbstractFacade<SolEncOrden> {

    @PersistenceContext(unitName = "ferreteriagestioncompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolEncOrdenFacade() {
        super(SolEncOrden.class);
    }

    public boolean isSolDetOrdenCollectionEmpty(SolEncOrden entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolEncOrden> solEncOrden = cq.from(SolEncOrden.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solEncOrden, entity), cb.isNotEmpty(solEncOrden.get(SolEncOrden_.solDetOrdenCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolDetOrden> findSolDetOrdenCollection(SolEncOrden entity) {
        SolEncOrden mergedEntity = this.getMergedEntity(entity);
        Collection<SolDetOrden> solDetOrdenCollection = mergedEntity.getSolDetOrdenCollection();
        solDetOrdenCollection.size();
        return solDetOrdenCollection;
    }
    
}
