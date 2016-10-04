package myapp.controllers.baseControllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class AbstractCRUDController extends AbstractCUDController {

    public abstract String read(ModelMap model, @PathVariable int id);

}
