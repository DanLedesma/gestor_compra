package controller;

import model.Marca;
import facade.MarcaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "marcaController")
@ViewScoped
public class MarcaController extends AbstractController<Marca> {

    @Inject
    private MobilePageController mobilePageController;

    public MarcaController() {
        // Inform the Abstract parent controller of the concrete Marca Entity
        super(Marca.class);
    }

}
