package top.shahow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class NavAction {
	@RequestMapping(value = "/")
	public String home() {
		return "forward:/html/home.html";
	}
	
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
	@RequestMapping(value = "warehouse")
	public String warehouse() {
		return "forward:/html/warehouse.html";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("staff_login", null);
		session.setAttribute("borrower_login", null);
		return "forward:/html/home.html";
		
	}
}
