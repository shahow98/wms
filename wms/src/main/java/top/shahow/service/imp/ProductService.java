package top.shahow.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IProductDao;
import top.shahow.dao.IWareHouseDao;
import top.shahow.entity.Product;
import top.shahow.entity.WareHouse;
import top.shahow.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	@Autowired
	private IWareHouseDao wareHouseDao;
	
	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		Product product = productDao.findByName(name);
		if(product == null) {
			product = new Product();
			product.setName(name);
			product = productDao.save(product);
			WareHouse wareHouse = new WareHouse();
			wareHouse.setProduct(product);
			wareHouse.setProductNum(0);
			wareHouseDao.save(wareHouse);
		}
		return product;
	}

}
