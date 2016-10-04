package myapp.filters;

import myapp.media.modelMapEnrichers.impl.MediaFolderModelMapEnricher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mikhail_Asadchy on 03.10.2016.
 */
@Component
public class MediaFolderHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    private MediaFolderModelMapEnricher mediaFolderModelMapEnricher;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        mediaFolderModelMapEnricher.enrichModelMap(modelAndView.getModelMap());
    }
}
