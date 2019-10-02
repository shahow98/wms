package top.shahow.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IBorrowFormDao;
import top.shahow.dao.IBorrowerDao;
import top.shahow.dao.IWareHouseDao;
import top.shahow.entity.BorrowForm;
import top.shahow.entity.BorrowForm.StatusType;
import top.shahow.entity.Borrower;
import top.shahow.entity.WareHouse;
import top.shahow.service.IBorrowerService;
@Service
public class BorrowerService implements IBorrowerService{

	@Autowired
	private IBorrowerDao borrowerDao;
	@Autowired
	private IWareHouseDao wareHouseDao;
	@Autowired
	private IBorrowFormDao borrowFormDao;
	
	@Override
	public Borrower login(Borrower user) {
		// TODO Auto-generated method stub
		return borrowerDao.findByName(user.getName());
	}

	@Override
	public boolean register(Borrower user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Borrower res = borrowerDao.findByName(user.getName());
		if(res == null) {
			borrowerDao.save(user);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean submitBorrowForm(BorrowForm borrowForm) {
		// TODO Auto-generated method stub
		boolean flag = false;
		WareHouse wareHouse = wareHouseDao.findByProduct_Id(borrowForm.getProduct().getId());
		if(wareHouse.getProductNum() >= borrowForm.getProductNum()) {
			//库存充足允许申请
			borrowForm.setStatus(StatusType.APPLY_UNDERWAY);
			borrowFormDao.save(borrowForm);
			flag = true;
		}
		return flag;
	}

}
