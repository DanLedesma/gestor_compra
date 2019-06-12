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
import modelo.Proveedor;
import modelo.Proveedor_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.SolEncArticulo;

/**
 *
 * @author grego
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "ferreteriagestioncompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }

    public boolean isSolEncArticuloCollectionEmpty(Proveedor entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Proveedor> proveedor = cq.from(Proveedor.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(proveedor, entity), cb.isNotEmpty(proveedor.get(Proveedor_.solEncArticuloCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolEncArticulo> findSolEncArticuloCollection(Proveedor entity) {
        Proveedor mergedEntity = this.getMergedEntity(entity);
        Collection<SolEncArticulo> solEncArticuloCollection = mergedEntity.getSolEncArticuloCollection();
        solEncArticuloCollection.size();
        return solEncArticuloCollection;
    }
    
}
