package controller;

import model.SolDetOrden;
import facade.SolDetOrdenFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "solDetOrdenController")
@ViewScoped
public class SolDetOrdenController extends AbstractController<SolDetOrden> {

    @Inject
    private MobilePageController mobilePageController;

    public SolDetOrdenController() {
        // Inform the Abstract parent controller of the concrete SolDetOrden Entity
        super(SolDetOrden.class);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolDetOrdenPK(new model.SolDetOrdenPK());
    }

}
