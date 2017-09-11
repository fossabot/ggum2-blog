package net.ggum2.ggum2blog.config.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@EnableWebMvc
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ModelAndView fobiddenExceptionHandler(HttpServletRequest req, Exception e) {
        ModelAndView mv = new ModelAndView("error/403");
        mv.addObject("status", "403");
        mv.addObject("message", "Access Denied");
        return mv;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundExceptionHandler(HttpServletRequest req, Exception e) {
        ModelAndView mv = new ModelAndView("error/notfound");
        mv.addObject("status", "404");
        mv.addObject("message", "Page Not Found");
        return mv;
    }

}
