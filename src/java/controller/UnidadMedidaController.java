package controller;

import model.UnidadMedida;
import facade.UnidadMedidaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "unidadMedidaController")
@ViewScoped
public class UnidadMedidaController extends AbstractController<UnidadMedida> {

    @Inject
    private MobilePageController mobilePageController;

    public UnidadMedidaController() {
        // Inform the Abstract parent controller of the concrete UnidadMedida Entity
        super(UnidadMedida.class);
    }

}
