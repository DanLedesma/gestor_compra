package controller;

import model.SolDetOrden;
import facade.SolDetOrdenFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solDetOrdenController")
@ViewScoped
public class SolDetOrdenController extends AbstractController<SolDetOrden> {

    @Inject
    private ArticuloController articulo1Controller;
    @Inject
    private MarcaController marcaController;
    @Inject
    private SolEncOrdenController solEncOrdenController;
    @Inject
    private UnidadMedidaController unidadMedController;
    @Inject
    private MobilePageController mobilePageController;

    public SolDetOrdenController() {
        // Inform the Abstract parent controller of the concrete SolDetOrden Entity
        super(SolDetOrden.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getSolDetOrdenPK().setIdOrden(this.getSelected().getSolEncOrden().getIdOrden());
        this.getSelected().getSolDetOrdenPK().setArticulo(this.getSelected().getArticulo1().getIdArticulo());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolDetOrdenPK(new model.SolDetOrdenPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articulo1Controller.setSelected(null);
        marcaController.setSelected(null);
        solEncOrdenController.setSelected(null);
        unidadMedController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Articulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticulo1(ActionEvent event) {
        SolDetOrden selected = this.getSelected();
        if (selected != null && articulo1Controller.getSelected() == null) {
            articulo1Controller.setSelected(selected.getArticulo1());
        }
    }

    /**
     * Sets the "selected" attribute of the Marca controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMarca(ActionEvent event) {
        SolDetOrden selected = this.getSelected();
        if (selected != null && marcaController.getSelected() == null) {
            marcaController.setSelected(selected.getMarca());
        }
    }

    /**
     * Sets the "selected" attribute of the SolEncOrden controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSolEncOrden(ActionEvent event) {
        SolDetOrden selected = this.getSelected();
        if (selected != null && solEncOrdenController.getSelected() == null) {
            solEncOrdenController.setSelected(selected.getSolEncOrden());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadMedida controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidadMed(ActionEvent event) {
        SolDetOrden selected = this.getSelected();
        if (selected != null && unidadMedController.getSelected() == null) {
            unidadMedController.setSelected(selected.getUnidadMed());
        }
    }

}
