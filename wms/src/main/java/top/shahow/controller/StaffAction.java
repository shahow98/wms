package top.shahow.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import top.shahow.entity.BorrowForm;
import top.shahow.entity.BorrowForm.StatusType;
import top.shahow.entity.Staff;
import top.shahow.service.IBorrowFormService;
import top.shahow.service.IBorrowerService;
import top.shahow.service.IStaffService;

@Controller
@RequestMapping("staff")
public class StaffAction {
	@Autowired
	private IStaffService staffService;
	@Autowired
	private IBorrowFormService borrowFormService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String login(Staff user, HttpSession session) {
		
		boolean flag = false;
		Staff staff = staffService.login(user);
		if(staff != null) {
			session.setAttribute("staff_login", staff);
			flag = true;
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public String register(Staff user) {
		boolean flag = false;
		flag = staffService.register(user);
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "validName", method = RequestMethod.POST)
	@ResponseBody
	public String validName(String name) {
		boolean flag = false;
		Gson gson = new Gson();
		flag = staffService.validName(name);
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "islogin", method = RequestMethod.GET)
	@ResponseBody
	public String isLogin(HttpSession session) {
		boolean flag = false;
		Staff staff = (Staff) session.getAttribute("staff_login");
		if(staff != null) {
			flag = true;
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "getBorrowForms", method = RequestMethod.GET)
	@ResponseBody
	public String getBorrowForms() {
		List<BorrowForm> borrowForms = staffService.getBorrowForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "getConsentBorrowForms", method = RequestMethod.GET)
	@ResponseBody
	public String getConsentBorrowForms() {
		List<BorrowForm> borrowForms = staffService.getConsentBorrowForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "getRefuseBorrowForms", method = RequestMethod.GET)
	@ResponseBody
	public String getRefuseBorrowForms() {
		List<BorrowForm> borrowForms = staffService.getRefuseBorrowForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "getUnderwayBorrowForms", method = RequestMethod.GET)
	@ResponseBody
	public String getUnderwayBorrowForms() {
		List<BorrowForm> borrowForms = staffService.getUnderwayBorrowForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "getGiveBackForms", method = RequestMethod.GET)
	@ResponseBody
	public String getGiveBackForms() {
		List<BorrowForm> borrowForms = staffService.getGiveBackForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "getFilterGiveBackForms", method = RequestMethod.POST)
	@ResponseBody
	public String getFilterGiveBackForms(String productName, String borrowerName) {
		List<BorrowForm> borrowForms = staffService.getBorrowFormsByProductNameAndBorrowerName(productName, borrowerName);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(borrowForms);
	}
	
	@RequestMapping(value = "consentBorrowForm", method = RequestMethod.POST)
	@ResponseBody
	public String consentBorrowForm(int borrowFormId, HttpSession session) {
		boolean flag = false;
		Staff staff = (Staff) session.getAttribute("staff_login");
		if(staff != null) {
			BorrowForm borrowForm = borrowFormService.getBorrowFormById(borrowFormId);
			borrowForm.setStaff(staff);
			flag = staffService.examineAndApproveOfBorrowForm(borrowForm, StatusType.APPLY_CONSENT);
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "refuseBorrowForm", method = RequestMethod.POST)
	@ResponseBody
	public String refuseBorrowForm(int borrowFormId, HttpSession session) {
		boolean flag = false;
		Staff staff = (Staff) session.getAttribute("staff_login");
		if(staff != null) {
			BorrowForm borrowForm = borrowFormService.getBorrowFormById(borrowFormId);
			borrowForm.setStaff(staff);
			flag = staffService.examineAndApproveOfBorrowForm(borrowForm, StatusType.APPLY_REFUSE);
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
	
	@RequestMapping(value = "giveBackForm", method = RequestMethod.POST)
	@ResponseBody
	public String giveBackForm(int borrowFormId, HttpSession session) {
		boolean flag = false;
		Staff staff = (Staff) session.getAttribute("staff_login");
		if(staff != null) {
			BorrowForm borrowForm = borrowFormService.getBorrowFormById(borrowFormId);
			borrowForm.setStaff(staff);
			flag = staffService.examineAndApproveOfBorrowForm(borrowForm, StatusType.APPLY_GIVEBACK);
		}
		Gson gson = new Gson();
		return gson.toJson(flag);
	}
}
