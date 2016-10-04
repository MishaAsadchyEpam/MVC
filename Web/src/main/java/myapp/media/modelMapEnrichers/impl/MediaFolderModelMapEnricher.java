package myapp.media.modelMapEnrichers.impl;

import myapp.media.MediaPathResolver;
import myapp.media.modelMapEnrichers.ModelMapEnricher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * Created by Mikhail_Asadchy on 03.10.2016.
 */
@Component
public class MediaFolderModelMapEnricher implements ModelMapEnricher {

    @Autowired
    private MediaPathResolver mediaPathResolver;

    @Override
    public void enrichModelMap(ModelMap modelMap) {
        modelMap.addAttribute("mediaFolder", mediaPathResolver.getMediaServerUrl());
    }
}
