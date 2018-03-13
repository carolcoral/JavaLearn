package site.cnkj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import site.cnkj.bean.User;
import site.cnkj.service.UserService;

@Controller
public class UserLoginController {
	@Resource
	private UserService userService;

	@RequestMapping("/tologin.do")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login.do")
	public String Login(String user_name, String user_password, HttpSession session) {
		User user = userService.UserLogin(user_name, user_password);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:tomain.do";
		} else {
			return "login";
		}
	}

	@RequestMapping("/tomain.do")
	public String tomain() {
		return "main";
	}

}
