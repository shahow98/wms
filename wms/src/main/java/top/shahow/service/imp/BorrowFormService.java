package top.shahow.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IBorrowFormDao;
import top.shahow.entity.BorrowForm;
import top.shahow.service.IBorrowFormService;

@Service
public class BorrowFormService implements IBorrowFormService{

	@Autowired
	private IBorrowFormDao borrowFormDao;
	
	@Override
	public BorrowForm getBorrowFormById(int id) {
		// TODO Auto-generated method stub
		Optional<BorrowForm> optional = borrowFormDao.findById(id);
		return optional.get();
	}
}
