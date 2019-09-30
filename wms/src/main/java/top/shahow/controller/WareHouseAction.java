package top.shahow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import top.shahow.entity.Product;
import top.shahow.entity.StockForm;
import top.shahow.entity.WareHouse;
import top.shahow.service.IWareHouseService;

@Controller
@RequestMapping("warehouse")
public class WareHouseAction {
	@Autowired
	private IWareHouseService wareHouseService;
	
	@RequestMapping(value = "stock", method = RequestMethod.POST)
	@ResponseBody
	public String stock(StockForm stockForm, Product product) {
		Gson gson = new Gson();
		System.out.println(stockForm);
		System.out.println(product);
		WareHouse wareHouse = wareHouseService.stock(stockForm, product);
		return gson.toJson(wareHouse);
	}
}
