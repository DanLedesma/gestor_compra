package controller;

import modelo.Empleado;
import modelo.SolEncArticulo;
import java.util.Collection;
import facade.EmpleadoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController extends AbstractController<Empleado> {

    @Inject
    private DepartamentoController departamentoController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolEncArticuloCollectionEmpty;

    public EmpleadoController() {
        // Inform the Abstract parent controller of the concrete Empleado Entity
        super(Empleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        departamentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsSolEncArticuloCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDepartamento(ActionEvent event) {
        Empleado selected = this.getSelected();
        if (selected != null && departamentoController.getSelected() == null) {
            departamentoController.setSelected(selected.getDepartamento());
        }
    }

    public boolean getIsSolEncArticuloCollectionEmpty() {
        return this.isSolEncArticuloCollectionEmpty;
    }

    private void setIsSolEncArticuloCollectionEmpty() {
        Empleado selected = this.getSelected();
        if (selected != null) {
            EmpleadoFacade ejbFacade = (EmpleadoFacade) this.getFacade();
            this.isSolEncArticuloCollectionEmpty = ejbFacade.isSolEncArticuloCollectionEmpty(selected);
        } else {
            this.isSolEncArticuloCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolEncArticulo entities
     * that are retrieved from Empleado and returns the navigation outcome.
     *
     * @return navigation outcome for SolEncArticulo page
     */
    public String navigateSolEncArticuloCollection() {
        Empleado selected = this.getSelected();
        if (selected != null) {
            EmpleadoFacade ejbFacade = (EmpleadoFacade) this.getFacade();
            Collection<SolEncArticulo> selectedSolEncArticuloCollection = ejbFacade.findSolEncArticuloCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolEncArticulo_items", selectedSolEncArticuloCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solEncArticulo/index";
    }

}
