package top.shahow.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IBorrowFormDao;
import top.shahow.dao.IDeliveryFormDao;
import top.shahow.dao.IProductDao;
import top.shahow.dao.IStockFormDao;
import top.shahow.dao.IWareHouseDao;
import top.shahow.entity.BorrowFrom;
import top.shahow.entity.DeliveryForm;
import top.shahow.entity.Product;
import top.shahow.entity.StockForm;
import top.shahow.entity.WareHouse;
import top.shahow.service.IWareHouseService;
@Service
public class WareHouseService implements IWareHouseService{

	@Autowired
	private IWareHouseDao wareHouseDao;
	@Autowired
	private IStockFormDao stockFormDao;
	@Autowired
	private IDeliveryFormDao deliveryFormDao;
	@Autowired
	private IBorrowFormDao borrowerDao;
	
	@Override
	public WareHouse stock(StockForm stockForm) {
		// TODO Auto-generated method stub
		stockFormDao.save(stockForm);
		WareHouse wareHouse =  wareHouseDao.findByProduct_Id(stockForm.getProduct().getId());
		if(wareHouse == null) {
			wareHouse = new WareHouse();
		}
		wareHouse.setProduct(stockForm.getProduct());
		wareHouse.setProductNum(wareHouse.getProductNum() + stockForm.getProductNum());
		return wareHouseDao.save(wareHouse);
	}

	@Override
	public WareHouse delivery(DeliveryForm deliveryForm) {
		// TODO Auto-generated method stub
		Product product = deliveryForm.getProduct();
		WareHouse wareHouse =  wareHouseDao.findByProduct_Id(product.getId());
		if(wareHouse != null) {
			if(wareHouse.getProductNum() - deliveryForm.getProductNum() >= 0) {
				//库存充足
				wareHouse.setProductNum(wareHouse.getProductNum() - deliveryForm.getProductNum());
				wareHouse = wareHouseDao.save(wareHouse);
				deliveryFormDao.save(deliveryForm);
			}
		}
		return wareHouse;
	}

	@Override
	public boolean borrow(BorrowFrom borrowFrom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean giveBack(BorrowFrom borrowFrom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StockForm> getStockForms() {
		// TODO Auto-generated method stub
		return stockFormDao.findAll();
	}

	@Override
	public List<DeliveryForm> getDeliveryForms() {
		// TODO Auto-generated method stub
		return deliveryFormDao.findAll();
	}



}
