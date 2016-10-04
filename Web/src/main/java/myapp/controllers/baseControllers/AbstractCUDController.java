package myapp.controllers.baseControllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class AbstractCUDController {

    public abstract String save(ModelMap model);

    public abstract String edit(ModelMap model, @PathVariable int id);

    public abstract String delete(ModelMap model, @PathVariable int id);

}
