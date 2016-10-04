package myapp.media;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MediaPathResolver {

    @Value("${media.folder}")
    private String mediaFolderPath;

    @Value("${media.server.url}")
    private String mediaServerUrl;

    public String getMediaFolderRoot()
    {
        return mediaFolderPath;
    }

    public String getMediaServerUrl(){
        return mediaServerUrl;
    }

}
