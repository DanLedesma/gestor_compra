package com.gestion.controller;

import com.gestion.compra.SolDetArticulo;
import com.gestion.facade.SolDetArticuloFacade;
import com.gestion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solDetArticuloController")
@ViewScoped
public class SolDetArticuloController extends AbstractController<SolDetArticulo> {

    @Inject
    private ArticuloController articulo1Controller;
    @Inject
    private SolEncArticuloController solEncArticuloController;
    @Inject
    private MobilePageController mobilePageController;

    public SolDetArticuloController() {
        // Inform the Abstract parent controller of the concrete SolDetArticulo Entity
        super(SolDetArticulo.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getSolDetArticuloPK().setIdSolicitud(this.getSelected().getSolEncArticulo().getIdSolicitud());
        this.getSelected().getSolDetArticuloPK().setArticulo(this.getSelected().getArticulo1().getIdArticulo());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolDetArticuloPK(new com.gestion.compra.SolDetArticuloPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        articulo1Controller.setSelected(null);
        solEncArticuloController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Articulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArticulo1(ActionEvent event) {
        SolDetArticulo selected = this.getSelected();
        if (selected != null && articulo1Controller.getSelected() == null) {
            articulo1Controller.setSelected(selected.getArticulo1());
        }
    }

    /**
     * Sets the "selected" attribute of the SolEncArticulo controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSolEncArticulo(ActionEvent event) {
        SolDetArticulo selected = this.getSelected();
        if (selected != null && solEncArticuloController.getSelected() == null) {
            solEncArticuloController.setSelected(selected.getSolEncArticulo());
        }
    }

}
