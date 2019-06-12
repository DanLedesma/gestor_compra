package com.gestion.controller;

import com.gestion.compra.Departamento;
import com.gestion.compra.Empleado;
import java.util.Collection;
import com.gestion.facade.DepartamentoFacade;
import com.gestion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEmpleadoCollectionEmpty;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmpleadoCollectionEmpty();
    }

    public boolean getIsEmpleadoCollectionEmpty() {
        return this.isEmpleadoCollectionEmpty;
    }

    private void setIsEmpleadoCollectionEmpty() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            this.isEmpleadoCollectionEmpty = ejbFacade.isEmpleadoCollectionEmpty(selected);
        } else {
            this.isEmpleadoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from Departamento and returns the navigation outcome.
     *
     * @return navigation outcome for Empleado page
     */
    public String navigateEmpleadoCollection() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            Collection<Empleado> selectedEmpleadoCollection = ejbFacade.findEmpleadoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleado_items", selectedEmpleadoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleado/index";
    }

}
