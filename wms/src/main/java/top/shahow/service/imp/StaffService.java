package top.shahow.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IBorrowFormDao;
import top.shahow.dao.IBorrowerDao;
import top.shahow.dao.IProductDao;
import top.shahow.dao.IStaffDao;
import top.shahow.entity.BorrowForm;
import top.shahow.entity.BorrowForm.StatusType;
import top.shahow.entity.Borrower;
import top.shahow.entity.Product;
import top.shahow.entity.Staff;
import top.shahow.service.IStaffService;

@Service
public class StaffService implements IStaffService {

	@Autowired
	private IStaffDao staffDao;
	@Autowired
	private IBorrowFormDao borrowFormDao;
	@Autowired
	private IBorrowerDao borrowerDao;
	@Autowired
	private IProductDao productDao;

	@Override
	public Staff login(Staff user) {
		// TODO Auto-generated method stub
		Staff staff = null;
		Staff res = staffDao.findByName(user.getName());
		if (res != null && user.getPassword().equals(res.getPassword())) {
			staff = res;
		}
		return staff;
	}

	@Override
	public boolean register(Staff user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Staff res = staffDao.findByName(user.getName());
		if (res == null) {
			// 数据库中不存在该用户
			staffDao.save(user);
			flag = true;
		}
		return flag;
	}

	@Override
	public Staff getStaffById(int id) {
		// TODO Auto-generated method stub
		Optional<Staff> staff = staffDao.findById(id);
		return staff.get();
	}

	@Override
	public boolean examineAndApproveOfBorrowForm(BorrowForm borrowForm, int status) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Optional<BorrowForm> res = borrowFormDao.findById(borrowForm.getId());
		borrowForm = res.get();
		if(borrowForm != null) {
			borrowForm.setStatus(status);
			if(status == StatusType.APPLY_GIVEBACK) {
				borrowForm.setRepayDate(new Date());
			}
			borrowFormDao.save(borrowForm);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<BorrowForm> getBorrowForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findAll();
	}

	@Override
	public List<BorrowForm> getConsentBorrowForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findByStatus(StatusType.APPLY_CONSENT);
	}

	@Override
	public List<BorrowForm> getRefuseBorrowForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findByStatus(StatusType.APPLY_REFUSE);
	}

	@Override
	public List<BorrowForm> getUnderwayBorrowForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findByStatus(StatusType.APPLY_UNDERWAY);
	}

	@Override
	public List<BorrowForm> getBorrowFormsByProductNameAndBorrowerName(String productName, String borrowerName) {
		// TODO Auto-generated method stub
		List<BorrowForm> borrowForms = null;
		
		Product product = productDao.findByName(productName);
		Borrower borrower = borrowerDao.findByName(borrowerName);
		
		if(product != null && borrower != null) {
			borrowForms = borrowFormDao.findByProduct_idAndBorrower_idAndStatus(product.getId(), borrower.getId(), StatusType.APPLY_CONSENT);
		}else if(product != null) {
			borrowForms = borrowFormDao.findByProduct_idAndStatus(product.getId(), StatusType.APPLY_CONSENT);
		}else if(borrower != null) {
			borrowForms = borrowFormDao.findByBorrower_idAndStatus(borrower.getId(), StatusType.APPLY_CONSENT);
		}else {
			borrowForms = new ArrayList<BorrowForm>();
		}
		return borrowForms;
	}

	@Override
	public List<BorrowForm> getGiveBackForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findByStatus(StatusType.APPLY_GIVEBACK);
	}

}
