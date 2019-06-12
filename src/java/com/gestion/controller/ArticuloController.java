package com.gestion.controller;

import com.gestion.compra.Articulo;
import com.gestion.compra.SolDetArticulo;
import com.gestion.compra.SolDetOrden;
import java.util.Collection;
import com.gestion.facade.ArticuloFacade;
import com.gestion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "articuloController")
@ViewScoped
public class ArticuloController extends AbstractController<Articulo> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolDetArticuloCollectionEmpty;
    private boolean isSolDetOrdenCollectionEmpty;

    public ArticuloController() {
        // Inform the Abstract parent controller of the concrete Articulo Entity
        super(Articulo.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolDetArticuloCollectionEmpty();
        this.setIsSolDetOrdenCollectionEmpty();
    }

    public boolean getIsSolDetArticuloCollectionEmpty() {
        return this.isSolDetArticuloCollectionEmpty;
    }

    private void setIsSolDetArticuloCollectionEmpty() {
        Articulo selected = this.getSelected();
        if (selected != null) {
            ArticuloFacade ejbFacade = (ArticuloFacade) this.getFacade();
            this.isSolDetArticuloCollectionEmpty = ejbFacade.isSolDetArticuloCollectionEmpty(selected);
        } else {
            this.isSolDetArticuloCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetArticulo entities
     * that are retrieved from Articulo and returns the navigation outcome.
     *
     * @return navigation outcome for SolDetArticulo page
     */
    public String navigateSolDetArticuloCollection() {
        Articulo selected = this.getSelected();
        if (selected != null) {
            ArticuloFacade ejbFacade = (ArticuloFacade) this.getFacade();
            Collection<SolDetArticulo> selectedSolDetArticuloCollection = ejbFacade.findSolDetArticuloCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetArticulo_items", selectedSolDetArticuloCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetArticulo/index";
    }

    public boolean getIsSolDetOrdenCollectionEmpty() {
        return this.isSolDetOrdenCollectionEmpty;
    }

    private void setIsSolDetOrdenCollectionEmpty() {
        Articulo selected = this.getSelected();
        if (selected != null) {
            ArticuloFacade ejbFacade = (ArticuloFacade) this.getFacade();
            this.isSolDetOrdenCollectionEmpty = ejbFacade.isSolDetOrdenCollectionEmpty(selected);
        } else {
            this.isSolDetOrdenCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetOrden entities that
     * are retrieved from Articulo and returns the navigation outcome.
     *
     * @return navigation outcome for SolDetOrden page
     */
    public String navigateSolDetOrdenCollection() {
        Articulo selected = this.getSelected();
        if (selected != null) {
            ArticuloFacade ejbFacade = (ArticuloFacade) this.getFacade();
            Collection<SolDetOrden> selectedSolDetOrdenCollection = ejbFacade.findSolDetOrdenCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetOrden_items", selectedSolDetOrdenCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetOrden/index";
    }

}
