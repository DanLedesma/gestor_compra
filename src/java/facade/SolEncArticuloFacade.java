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
import modelo.SolEncArticulo;
import modelo.SolEncArticulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.SolDetArticulo;
import modelo.Empleado;
import modelo.Proveedor;

/**
 *
 * @author grego
 */
@Stateless
public class SolEncArticuloFacade extends AbstractFacade<SolEncArticulo> {

    @PersistenceContext(unitName = "ferreteriagestioncompraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolEncArticuloFacade() {
        super(SolEncArticulo.class);
    }

    public boolean isSolDetArticuloCollectionEmpty(SolEncArticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolEncArticulo> solEncArticulo = cq.from(SolEncArticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solEncArticulo, entity), cb.isNotEmpty(solEncArticulo.get(SolEncArticulo_.solDetArticuloCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolDetArticulo> findSolDetArticuloCollection(SolEncArticulo entity) {
        SolEncArticulo mergedEntity = this.getMergedEntity(entity);
        Collection<SolDetArticulo> solDetArticuloCollection = mergedEntity.getSolDetArticuloCollection();
        solDetArticuloCollection.size();
        return solDetArticuloCollection;
    }

    public boolean isEmpSolEmpty(SolEncArticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolEncArticulo> solEncArticulo = cq.from(SolEncArticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solEncArticulo, entity), cb.isNotNull(solEncArticulo.get(SolEncArticulo_.empSol)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleado findEmpSol(SolEncArticulo entity) {
        return this.getMergedEntity(entity).getEmpSol();
    }

    public boolean isIdProvEmpty(SolEncArticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolEncArticulo> solEncArticulo = cq.from(SolEncArticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solEncArticulo, entity), cb.isNotNull(solEncArticulo.get(SolEncArticulo_.idProv)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Proveedor findIdProv(SolEncArticulo entity) {
        return this.getMergedEntity(entity).getIdProv();
    }
    
}
