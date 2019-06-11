package controller;

import model.Marca;
import model.SolDetOrden;
import java.util.Collection;
import facade.MarcaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcaController")
@ViewScoped
public class MarcaController extends AbstractController<Marca> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isSolDetOrdenCollectionEmpty;

    public MarcaController() {
        // Inform the Abstract parent controller of the concrete Marca Entity
        super(Marca.class);
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
        Marca selected = this.getSelected();
        if (selected != null) {
            MarcaFacade ejbFacade = (MarcaFacade) this.getFacade();
            this.isSolDetOrdenCollectionEmpty = ejbFacade.isSolDetOrdenCollectionEmpty(selected);
        } else {
            this.isSolDetOrdenCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolDetOrden entities that
     * are retrieved from Marca and returns the navigation outcome.
     *
     * @return navigation outcome for SolDetOrden page
     */
    public String navigateSolDetOrdenCollection() {
        Marca selected = this.getSelected();
        if (selected != null) {
            MarcaFacade ejbFacade = (MarcaFacade) this.getFacade();
            Collection<SolDetOrden> selectedSolDetOrdenCollection = ejbFacade.findSolDetOrdenCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolDetOrden_items", selectedSolDetOrdenCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/solDetOrden/index";
    }

}
