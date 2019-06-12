package com.gestion.controller;

import com.gestion.compra.Proveedor;
import com.gestion.compra.SolEncArticulo;
import java.util.Collection;
import com.gestion.facade.ProveedorFacade;
import com.gestion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "proveedorController")
@ViewScoped
public class ProveedorController extends AbstractController<Proveedor> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolEncArticuloCollectionEmpty;

    public ProveedorController() {
        // Inform the Abstract parent controller of the concrete Proveedor Entity
        super(Proveedor.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolEncArticuloCollectionEmpty();
    }

    public boolean getIsSolEncArticuloCollectionEmpty() {
        return this.isSolEncArticuloCollectionEmpty;
    }

    private void setIsSolEncArticuloCollectionEmpty() {
        Proveedor selected = this.getSelected();
        if (selected != null) {
            ProveedorFacade ejbFacade = (ProveedorFacade) this.getFacade();
            this.isSolEncArticuloCollectionEmpty = ejbFacade.isSolEncArticuloCollectionEmpty(selected);
        } else {
            this.isSolEncArticuloCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolEncArticulo entities
     * that are retrieved from Proveedor and returns the navigation outcome.
     *
     * @return navigation outcome for SolEncArticulo page
     */
    public String navigateSolEncArticuloCollection() {
        Proveedor selected = this.getSelected();
        if (selected != null) {
            ProveedorFacade ejbFacade = (ProveedorFacade) this.getFacade();
            Collection<SolEncArticulo> selectedSolEncArticuloCollection = ejbFacade.findSolEncArticuloCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolEncArticulo_items", selectedSolEncArticuloCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solEncArticulo/index";
    }

}
