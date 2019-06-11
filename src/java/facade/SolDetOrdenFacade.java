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
import model.SolDetOrden_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Articulo;
import model.Marca;
import model.SolEncOrden;
import model.UnidadMedida;

/**
 *
 * @author grego
 */
@Stateless
public class SolDetOrdenFacade extends AbstractFacade<SolDetOrden> {

    @PersistenceContext(unitName = "g_comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolDetOrdenFacade() {
        super(SolDetOrden.class);
    }

    public boolean isArticulo1Empty(SolDetOrden entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetOrden> solDetOrden = cq.from(SolDetOrden.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetOrden, entity), cb.isNotNull(solDetOrden.get(SolDetOrden_.articulo1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Articulo findArticulo1(SolDetOrden entity) {
        return this.getMergedEntity(entity).getArticulo1();
    }

    public boolean isMarcaEmpty(SolDetOrden entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetOrden> solDetOrden = cq.from(SolDetOrden.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetOrden, entity), cb.isNotNull(solDetOrden.get(SolDetOrden_.marca)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marca findMarca(SolDetOrden entity) {
        return this.getMergedEntity(entity).getMarca();
    }

    public boolean isSolEncOrdenEmpty(SolDetOrden entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetOrden> solDetOrden = cq.from(SolDetOrden.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetOrden, entity), cb.isNotNull(solDetOrden.get(SolDetOrden_.solEncOrden)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SolEncOrden findSolEncOrden(SolDetOrden entity) {
        return this.getMergedEntity(entity).getSolEncOrden();
    }

    public boolean isUnidadMedEmpty(SolDetOrden entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolDetOrden> solDetOrden = cq.from(SolDetOrden.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solDetOrden, entity), cb.isNotNull(solDetOrden.get(SolDetOrden_.unidadMed)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UnidadMedida findUnidadMed(SolDetOrden entity) {
        return this.getMergedEntity(entity).getUnidadMed();
    }
    
}
