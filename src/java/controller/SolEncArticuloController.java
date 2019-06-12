package controller;

import modelo.SolEncArticulo;
import modelo.SolDetArticulo;
import java.util.Collection;
import facade.SolEncArticuloFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solEncArticuloController")
@ViewScoped
public class SolEncArticuloController extends AbstractController<SolEncArticulo> {

    @Inject
    private EmpleadoController empSolController;
    @Inject
    private ProveedorController idProvController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolDetArticuloCollectionEmpty;

    public SolEncArticuloController() {
        // Inform the Abstract parent controller of the concrete SolEncArticulo Entity
        super(SolEncArticulo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        empSolController.setSelected(null);
        idProvController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolDetArticuloCollectionEmpty();
    }

    public boolean getIsSolDetArticuloCollectionEmpty() {
        return this.isSolDetArticuloCollectionEmpty;
    }

    private void setIsSolDetArticuloCollectionEmpty() {
        SolEncArticulo selected = this.getSelected();
        if (selected != null) {
            SolEncArticuloFacade ejbFacade = (SolEncArticuloFacade) this.getFacade();
            this.isSolDetArticuloCollectionEmpty = ejbFacade.isSolDetArticuloCollectionEmpty(selected);
        } else {
            this.isSolDetArticuloCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetArticulo entities
     * that are retrieved from SolEncArticulo and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SolDetArticulo page
     */
    public String navigateSolDetArticuloCollection() {
        SolEncArticulo selected = this.getSelected();
        if (selected != null) {
            SolEncArticuloFacade ejbFacade = (SolEncArticuloFacade) this.getFacade();
            Collection<SolDetArticulo> selectedSolDetArticuloCollection = ejbFacade.findSolDetArticuloCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetArticulo_items", selectedSolDetArticuloCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetArticulo/index";
    }

    /**
     * Sets the "selected" attribute of the Empleado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEmpSol(ActionEvent event) {
        SolEncArticulo selected = this.getSelected();
        if (selected != null && empSolController.getSelected() == null) {
            empSolController.setSelected(selected.getEmpSol());
        }
    }

    /**
     * Sets the "selected" attribute of the Proveedor controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProv(ActionEvent event) {
        SolEncArticulo selected = this.getSelected();
        if (selected != null && idProvController.getSelected() == null) {
            idProvController.setSelected(selected.getIdProv());
        }
    }

}
