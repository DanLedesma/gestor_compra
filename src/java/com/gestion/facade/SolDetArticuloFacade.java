/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.facade;

import com.gestion.compra.SolDetArticulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.gestion.compra.SolDetArticulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.gestion.compra.Articulo;
import com.gestion.compra.SolEncArticulo;

/**
 *
 * @author 20162645
 */
@Stateless
public class SolDetArticuloFacade extends AbstractFacade<SolDetArticulo> {

    @PersistenceContext(unitName = "g_comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolDetArticuloFacade() {
        super(SolDetArticulo.class);
    }

    public boolean isArticulo1Empty(SolDetArticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetArticulo> solDetArticulo = cq.from(SolDetArticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetArticulo, entity), cb.isNotNull(solDetArticulo.get(SolDetArticulo_.articulo1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulo findArticulo1(SolDetArticulo entity) {
        return this.getMergedEntity(entity).getArticulo1();
    }

    public boolean isSolEncArticuloEmpty(SolDetArticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetArticulo> solDetArticulo = cq.from(SolDetArticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetArticulo, entity), cb.isNotNull(solDetArticulo.get(SolDetArticulo_.solEncArticulo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SolEncArticulo findSolEncArticulo(SolDetArticulo entity) {
        return this.getMergedEntity(entity).getSolEncArticulo();
    }
    
}
