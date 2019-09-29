package top.shahow.service;

import top.shahow.entity.BorrowFrom;
import top.shahow.entity.DeliveryForm;
import top.shahow.entity.StockForm;
import top.shahow.entity.WareHouse;

public interface IWareHouseService {
	// 进货
	public WareHouse stock(StockForm stockForm);

	// 出货
	public WareHouse delivery(DeliveryForm deliveryForm);

	// 借货
	public boolean borrow(BorrowFrom borrowFrom);

	// 还货
	public boolean giveBack(BorrowFrom borrowFrom);
}
