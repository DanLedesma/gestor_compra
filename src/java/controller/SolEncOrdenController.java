package controller;

import model.SolEncOrden;
import facade.SolEncOrdenFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "solEncOrdenController")
@ViewScoped
public class SolEncOrdenController extends AbstractController<SolEncOrden> {

    @Inject
    private MobilePageController mobilePageController;

    public SolEncOrdenController() {
        // Inform the Abstract parent controller of the concrete SolEncOrden Entity
        super(SolEncOrden.class);
    }

}
