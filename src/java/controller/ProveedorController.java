package controller;

import model.Proveedor;
import facade.ProveedorFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
@Named(value = "proveedorController")
@ViewScoped
public class ProveedorController extends AbstractController<Proveedor> {

    @Inject
    private MobilePageController mobilePageController;

    public ProveedorController() {
        // Inform the Abstract parent controller of the concrete Proveedor Entity
        super(Proveedor.class);
    }

}
