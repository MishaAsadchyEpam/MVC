package myapp.hadlers;

import myapp.controllers.users.security.SecurityUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ExceptionsHandler {

    private static final Logger logger = Logger.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxUploadSizeExceededException(Exception e)
    {
        logger.error("Max Upload Size Exceeded. UserId = " + SecurityUtil.getCurrentUser().getUserId());
        return "/images/add";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllExceptions(Exception e)
    {
        logger.error("Unknown exception! Exception type = " + e.getClass().getName());
        return "/error/exception";
    }


}
