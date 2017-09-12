package net.ggum2.ggum2blog.config.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

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
