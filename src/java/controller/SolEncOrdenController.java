package controller;

import modelo.SolEncOrden;
import modelo.SolDetOrden;
import java.util.Collection;
import facade.SolEncOrdenFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "solEncOrdenController")
@ViewScoped
public class SolEncOrdenController extends AbstractController<SolEncOrden> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolDetOrdenCollectionEmpty;

    public SolEncOrdenController() {
        // Inform the Abstract parent controller of the concrete SolEncOrden Entity
        super(SolEncOrden.class);
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
        SolEncOrden selected = this.getSelected();
        if (selected != null) {
            SolEncOrdenFacade ejbFacade = (SolEncOrdenFacade) this.getFacade();
            this.isSolDetOrdenCollectionEmpty = ejbFacade.isSolDetOrdenCollectionEmpty(selected);
        } else {
            this.isSolDetOrdenCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetOrden entities that
     * are retrieved from SolEncOrden and returns the navigation outcome.
     *
     * @return navigation outcome for SolDetOrden page
     */
    public String navigateSolDetOrdenCollection() {
        SolEncOrden selected = this.getSelected();
        if (selected != null) {
            SolEncOrdenFacade ejbFacade = (SolEncOrdenFacade) this.getFacade();
            Collection<SolDetOrden> selectedSolDetOrdenCollection = ejbFacade.findSolDetOrdenCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetOrden_items", selectedSolDetOrdenCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetOrden/index";
    }

}
