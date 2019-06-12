/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion.facade;

import com.gestion.compra.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.gestion.compra.Empleado_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.gestion.compra.Departamento;
import com.gestion.compra.SolEncArticulo;
import java.util.Collection;

/**
 *
 * @author 20162645
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "g_comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public boolean isDepartamentoEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotNull(empleado.get(Empleado_.departamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamento findDepartamento(Empleado entity) {
        return this.getMergedEntity(entity).getDepartamento();
    }

    public boolean isSolEncArticuloCollectionEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotEmpty(empleado.get(Empleado_.solEncArticuloCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolEncArticulo> findSolEncArticuloCollection(Empleado entity) {
        Empleado mergedEntity = this.getMergedEntity(entity);
        Collection<SolEncArticulo> solEncArticuloCollection = mergedEntity.getSolEncArticuloCollection();
        solEncArticuloCollection.size();
        return solEncArticuloCollection;
    }
    
}
