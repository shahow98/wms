package top.shahow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavAction {
	@RequestMapping(value = "welcome")
	public String welcome() {
		return "forward:/html/home.html";
	}
	@RequestMapping(value = "signup")
	public String signUp() {
		return "forward:/html/register.html";
	}
	@RequestMapping(value = "signin")
	public String signIn() {
		return "forward:/html/signin.html";
	}
	@RequestMapping(value = "stock")
	public String stock() {
		return "forward:/html/stock.html";
	}
	@RequestMapping(value = "delivery")
	public String delivery() {
		return "forward:/html/delivery.html";
	}
	@RequestMapping(value = "borrow")
	public String borrow() {
		return "forward:/html/borrow.html";
	}
}
