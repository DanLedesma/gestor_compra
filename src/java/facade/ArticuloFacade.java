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
import modelo.Articulo;
import modelo.Articulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.SolDetArticulo;
import modelo.SolDetOrden;

/**
 *
 * @author grego
 */
@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> {

    @PersistenceContext(unitName = "ferreteriagestioncompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticuloFacade() {
        super(Articulo.class);
    }

    public boolean isSolDetArticuloCollectionEmpty(Articulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulo> articulo = cq.from(Articulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulo, entity), cb.isNotEmpty(articulo.get(Articulo_.solDetArticuloCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolDetArticulo> findSolDetArticuloCollection(Articulo entity) {
        Articulo mergedEntity = this.getMergedEntity(entity);
        Collection<SolDetArticulo> solDetArticuloCollection = mergedEntity.getSolDetArticuloCollection();
        solDetArticuloCollection.size();
        return solDetArticuloCollection;
    }

    public boolean isSolDetOrdenCollectionEmpty(Articulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulo> articulo = cq.from(Articulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulo, entity), cb.isNotEmpty(articulo.get(Articulo_.solDetOrdenCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolDetOrden> findSolDetOrdenCollection(Articulo entity) {
        Articulo mergedEntity = this.getMergedEntity(entity);
        Collection<SolDetOrden> solDetOrdenCollection = mergedEntity.getSolDetOrdenCollection();
        solDetOrdenCollection.size();
        return solDetOrdenCollection;
    }
    
}
