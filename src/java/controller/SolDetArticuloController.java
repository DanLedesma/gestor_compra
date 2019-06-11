package controller;

import model.SolDetArticulo;
import facade.SolDetArticuloFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "solDetArticuloController")
@ViewScoped
public class SolDetArticuloController extends AbstractController<SolDetArticulo> {

    @Inject
    private MobilePageController mobilePageController;

    public SolDetArticuloController() {
        // Inform the Abstract parent controller of the concrete SolDetArticulo Entity
        super(SolDetArticulo.class);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolDetArticuloPK(new model.SolDetArticuloPK());
    }

}
