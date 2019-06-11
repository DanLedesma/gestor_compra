package controller;

import model.SolEncArticulo;
import facade.SolEncArticuloFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "solEncArticuloController")
@ViewScoped
public class SolEncArticuloController extends AbstractController<SolEncArticulo> {

    @Inject
    private MobilePageController mobilePageController;

    public SolEncArticuloController() {
        // Inform the Abstract parent controller of the concrete SolEncArticulo Entity
        super(SolEncArticulo.class);
    }

}
