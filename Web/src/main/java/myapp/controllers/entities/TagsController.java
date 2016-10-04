package myapp.controllers.entities;

import myapp.controllers.baseControllers.AbstractCUDController;
import myapp.entities.Tags;
import myapp.services.TagsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/tags/")
@PreAuthorize("hasRole('" + "ROLE_ADMIN" + "')")
@Controller
class TagsController extends AbstractCUDController {

    private static final Logger logger = Logger.getLogger(TagsController.class);

    @Autowired
    private TagsService tagsService;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        model.addAttribute("tagss", tagsService.getAll());
        return "/tags/index";
    }

    @RequestMapping("available")
    @ResponseBody
    public String available(@RequestParam String tagName)
    {
        return (tagsService.findByName(tagName) == null) + "";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String save(ModelMap model)
    {
        model.addAttribute("tags", new Tags());
        return "/tags/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(@Valid Tags tags,
                       BindingResult result)
    {
        if (result.hasErrors())
        {
            return "/tags/add";
        }

        try
        {
            tagsService.save(tags);
        }
        catch (DataIntegrityViolationException e)
        {
            result.rejectValue("tagName", "Not unique tag name", "Такой тэг уже существует");
            return "/tags/add";
        }

        return "redirect:/tags/";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable int id)
    {
        model.addAttribute("tags", tagsService.find(id));
        return "/tags/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Tags tags)
    {
        tagsService.update(tags);
        return "redirect:/tags/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(ModelMap model, @PathVariable int id)
    {
        model.addAttribute("tags", tagsService.find(id));
        return "/tags/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam int tagId)
    {
        tagsService.delete(tagId);
        return "redirect:/tags/";
    }

}