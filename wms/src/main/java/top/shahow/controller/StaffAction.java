package top.shahow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import top.shahow.entity.Staff;
import top.shahow.service.IStaffService;

@Controller
@RequestMapping("staff")
public class StaffAction {
	@Autowired
	private IStaffService staffService;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(Staff user, HttpSession session) {
		boolean flag = false;
		Staff staff = staffService.login(user);
		if(staff != null) {
			session.setAttribute("staff_login", staff);
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping("register")
	@ResponseBody
	public String register(Staff user) {
		boolean flag = false;
		flag = staffService.register(user);
		Gson gson = new Gson();
		return gson.toJson(flag);
		
	}
}
