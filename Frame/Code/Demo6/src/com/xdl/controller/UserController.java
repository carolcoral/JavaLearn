package com.xdl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
   @RequestMapping("/user/toUserInfo.do")
   public  String  toUserInfo(){
	   return  "userInfo";
   }
   @RequestMapping("/user/toLogin.do")
   public  String  toLogin() throws Exception{
	   if(1==1){
		   throw new Exception();
	   }
	   return  "login";
   }
   @RequestMapping("/user/login.do")
   public  String  login(@ModelAttribute("username") String  username,
	   String password,HttpServletRequest request){
	   // @ModelAttribute("username")  相当于模型对象.addAttribute("key","value")
	   if("abc".equals(username) && "123".equals(password)){
		   // 登录成功就往session 中放一个username
		   request.getSession().setAttribute("username", username);
	       return  "main";
	   }else{
		   request.setAttribute("msg", "登录失败");
		   return  "login";
	   }
   }
   @ExceptionHandler
   public  String execute(Exception e){
	   return  "error3";
   }
}
