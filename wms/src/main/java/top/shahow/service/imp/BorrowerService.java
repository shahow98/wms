package top.shahow.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import top.shahow.dao.IBorrowerDao;
import top.shahow.entity.Borrower;
import top.shahow.service.IBorrowerService;

public class BorrowerService implements IBorrowerService{

	@Autowired
	private IBorrowerDao borrowerDao;
	
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
		if(res != null) {
			borrowerDao.save(user);
			flag = true;
		}
		return flag;
	}

}
