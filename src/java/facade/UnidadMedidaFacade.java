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
import model.UnidadMedida;
import model.UnidadMedida_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.SolDetOrden;

/**
 *
 * @author grego
 */
@Stateless
public class UnidadMedidaFacade extends AbstractFacade<UnidadMedida> {

    @PersistenceContext(unitName = "g_comprasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadMedidaFacade() {
        super(UnidadMedida.class);
    }

    public boolean isSolDetOrdenCollectionEmpty(UnidadMedida entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UnidadMedida> unidadMedida = cq.from(UnidadMedida.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidadMedida, entity), cb.isNotEmpty(unidadMedida.get(UnidadMedida_.solDetOrdenCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<SolDetOrden> findSolDetOrdenCollection(UnidadMedida entity) {
        UnidadMedida mergedEntity = this.getMergedEntity(entity);
        Collection<SolDetOrden> solDetOrdenCollection = mergedEntity.getSolDetOrdenCollection();
        solDetOrdenCollection.size();
        return solDetOrdenCollection;
    }
    
}
