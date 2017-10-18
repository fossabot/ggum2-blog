package net.ggum2.ggum2blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/picture/upload")
public class PictureUploadController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView view() {
        ModelAndView mv = new ModelAndView("picture/upload_view");
        return mv;
    }

}
