package top.shahow.service;

import java.util.List;

import top.shahow.entity.BorrowFrom;
import top.shahow.entity.DeliveryForm;
import top.shahow.entity.Product;
import top.shahow.entity.StockForm;
import top.shahow.entity.WareHouse;

public interface IWareHouseService {
	// 进货
	public WareHouse stock(StockForm stockForm);
	public List<StockForm> getStockForms();

	// 出货
	public WareHouse delivery(DeliveryForm deliveryForm);
	public List<DeliveryForm> getDeliveryForms();

	// 借货
	public boolean borrow(BorrowFrom borrowFrom);

	// 还货
	public boolean giveBack(BorrowFrom borrowFrom);
}
