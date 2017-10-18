package net.ggum2.ggum2blog.controller;

import lombok.extern.slf4j.Slf4j;
import net.ggum2.ggum2blog.domain.Account;
import net.ggum2.ggum2blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String signup(
			@RequestParam(required = true) String email,
			@RequestParam(required = true) String name,
			@RequestParam(required = true) String nickname,
			@RequestParam(required = true) String password
			) {
		Account user = Account.builder()
				.id(email)
				.name(name)
				.nickname(nickname)
				.password(password)
				.build();

		boolean result = loginService.create(user);

		if (result) {
			return "redirect:/";
		} else {
			return "redirect:/singup?error";
		}
	}

}
