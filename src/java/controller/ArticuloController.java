package controller;

import model.Articulo;
import facade.ArticuloFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "articuloController")
@ViewScoped
public class ArticuloController extends AbstractController<Articulo> {

    @Inject
    private MobilePageController mobilePageController;

    public ArticuloController() {
        // Inform the Abstract parent controller of the concrete Articulo Entity
        super(Articulo.class);
    }

}
