package net.ggum2.ggum2blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home_view() {
		ModelAndView mv = new ModelAndView("main/home");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login_view() {
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup_view() {
		ModelAndView mv = new ModelAndView("login/signup");
		return mv;
	}
}
