/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.facade;

import com.gestion.compra.SolEncArticulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.gestion.compra.SolEncArticulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.gestion.compra.SolDetArticulo;
import com.gestion.compra.Empleado;
import com.gestion.compra.Proveedor;
import java.util.Collection;

/**
 *
 * @author 20162645
 */
@Stateless
public class SolEncArticuloFacade extends AbstractFacade<SolEncArticulo> {

    @PersistenceContext(unitName = "g_comprasPU")
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
