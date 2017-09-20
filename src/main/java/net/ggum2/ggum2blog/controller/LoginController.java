package net.ggum2.ggum2blog.controller;

import lombok.extern.slf4j.Slf4j;
import net.ggum2.ggum2blog.domain.User;
import net.ggum2.ggum2blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

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

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(
			@RequestParam(required = true) String email,
			@RequestParam(required = true) String name,
			@RequestParam(required = true) String nickname,
			@RequestParam(required = true) String password
			) {
		ModelAndView mv = new ModelAndView("redirect:/login");

		User user = User.builder()
				.username(email)
				.name(name)
				.nickname(nickname)
				.password(password)
				.build();

		UserDetails result = loginService.create(user);

		if (result != null) {
			mv.addObject("signupUser", result);
		}

		return mv;
	}
}
