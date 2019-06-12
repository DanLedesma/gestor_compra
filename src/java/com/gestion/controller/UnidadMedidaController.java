package com.gestion.controller;

import com.gestion.compra.UnidadMedida;
import com.gestion.compra.SolDetOrden;
import java.util.Collection;
import com.gestion.facade.UnidadMedidaFacade;
import com.gestion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "unidadMedidaController")
@ViewScoped
public class UnidadMedidaController extends AbstractController<UnidadMedida> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolDetOrdenCollectionEmpty;

    public UnidadMedidaController() {
        // Inform the Abstract parent controller of the concrete UnidadMedida Entity
        super(UnidadMedida.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolDetOrdenCollectionEmpty();
    }

    public boolean getIsSolDetOrdenCollectionEmpty() {
        return this.isSolDetOrdenCollectionEmpty;
    }

    private void setIsSolDetOrdenCollectionEmpty() {
        UnidadMedida selected = this.getSelected();
        if (selected != null) {
            UnidadMedidaFacade ejbFacade = (UnidadMedidaFacade) this.getFacade();
            this.isSolDetOrdenCollectionEmpty = ejbFacade.isSolDetOrdenCollectionEmpty(selected);
        } else {
            this.isSolDetOrdenCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetOrden entities that
     * are retrieved from UnidadMedida and returns the navigation outcome.
     *
     * @return navigation outcome for SolDetOrden page
     */
    public String navigateSolDetOrdenCollection() {
        UnidadMedida selected = this.getSelected();
        if (selected != null) {
            UnidadMedidaFacade ejbFacade = (UnidadMedidaFacade) this.getFacade();
            Collection<SolDetOrden> selectedSolDetOrdenCollection = ejbFacade.findSolDetOrdenCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetOrden_items", selectedSolDetOrdenCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetOrden/index";
    }

}
