package myapp.controllers.entities;

import myapp.controllers.baseControllers.AbstractCRUDController;
import myapp.controllers.users.security.SecurityUtil;
import myapp.entities.Albums;
import myapp.entities.Users;
import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import myapp.services.AlbumsService;
import myapp.services.ImagesService;
import myapp.media.MediaPathResolver;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/albums/")
@Controller
@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
class AlbumsController extends AbstractCRUDController {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(AlbumsController.class);

    @Autowired
    private MediaPathResolver mediaPathResolver;

    @Autowired
    private AlbumsService albumsService;

    @RequestMapping("")
    public String index(ModelMap model)
    {
        Users user = SecurityUtil.getCurrentUser();
        List<Albums> albums = albumsService.findByUserId(user.getUserId());

        if (albums == null)
        {
            return "redirect:/albums/mayBeCreate";
        }

        model.addAttribute("albums", albums);
        return "/albums/index";
    }

    @RequestMapping("{albumId}")
    public String read(ModelMap model, @PathVariable int albumId)
    {
        Albums album = albumsService.findWithImages(albumId);

        model.addAttribute("album", album);

        return "/albums/showAlbum";
    }

    @RequestMapping("mayBeCreate")
    public String mayBeCreate()
    {
        return "/albums/mayBeCreate";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String save(ModelMap model)
    {
        model.addAttribute("albums", new Albums());
        return "/albums/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(@Valid Albums albums, Errors result)
    {
        if (result.hasErrors())
        {
            return "/albums/add";
        }

        Users user = SecurityUtil.getCurrentUser();

        albums.setUserId(user.getUserId());

        albumsService.save(albums);
        return "redirect:/albums/";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(ModelMap model, @PathVariable int id)
    {
        model.addAttribute("albums", albumsService.find(id));

        return "/albums/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@Valid Albums albums, Errors errors)
    {

        if (errors.hasErrors())
        {
            return "/albums/edit";
        }

        albumsService.update(albums);
        return "redirect:/albums/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(ModelMap model, @PathVariable int id)
    {
        model.addAttribute("albums", albumsService.findWithImages(id));
        return "/albums/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam int albumId)
    {
        ImagesService.setImageDirectory(mediaPathResolver.getMediaFolderRoot());
        albumsService.delete(albumId);
        return "redirect:/albums/";
    }

}
