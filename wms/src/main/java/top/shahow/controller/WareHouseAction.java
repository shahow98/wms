package top.shahow.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import top.shahow.entity.DeliveryForm;
import top.shahow.entity.Product;
import top.shahow.entity.Staff;
import top.shahow.entity.StockForm;
import top.shahow.entity.WareHouse;
import top.shahow.service.IProductService;
import top.shahow.service.IWareHouseService;

@Controller
@RequestMapping("warehouse")
public class WareHouseAction {
	@Autowired
	private IWareHouseService wareHouseService;
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "stock", method = RequestMethod.POST)
	@ResponseBody
	public String stock(StockForm stockForm, String productName, HttpSession session) {
		WareHouse wareHouse = null;
		Gson gson = new Gson();
		Staff staff = (Staff) session.getAttribute("staff_login");
		if (staff != null) {
			Product product = productService.getProductByName(productName);
			stockForm.setProduct(product);
			stockForm.setStaff(staff);
			stockForm.setStockDate(new Date());
			wareHouse = wareHouseService.stock(stockForm);
		}
		return gson.toJson(wareHouse);
	}

	
	@RequestMapping(value = "getStockForms", method = RequestMethod.GET)
	@ResponseBody
	public String getStockForms() {
		List<StockForm> stockForms = wareHouseService.getStockForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(stockForms);
	}
	
	@RequestMapping(value = "delivery", method = RequestMethod.POST)
	@ResponseBody
	public String delivery(DeliveryForm deliveryForm, String productName, HttpSession session) {
		WareHouse wareHouse = null;
		Gson gson = new Gson();
		Staff staff = (Staff) session.getAttribute("staff_login");
		if(staff != null) {
			Product product = productService.getProductByName(productName);
			deliveryForm.setProduct(product);
			deliveryForm.setStaff(staff);
			deliveryForm.setDeliveryDate(new Date());
			wareHouse = wareHouseService.delivery(deliveryForm);
			System.err.println(gson.toJson(wareHouse));
		}
		return gson.toJson(wareHouse);
	}
	
	@RequestMapping(value = "getDeliveryForms", method = RequestMethod.GET)
	@ResponseBody
	public String getDeliveryForms() {
		List<DeliveryForm> deliveryForms = wareHouseService.getDeliveryForms();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(deliveryForms);
	}
}
