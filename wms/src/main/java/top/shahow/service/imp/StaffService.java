package top.shahow.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IBorrowFormDao;
import top.shahow.dao.IStaffDao;
import top.shahow.entity.BorrowForm;
import top.shahow.entity.Staff;
import top.shahow.service.IStaffService;

@Service
public class StaffService implements IStaffService {

	@Autowired
	private IStaffDao staffDao;
	@Autowired
	private IBorrowFormDao borrowFormDao;

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
			flag = true;
		}
		return flag;
	}

	@Override
	public List<BorrowForm> getBorrowForms() {
		// TODO Auto-generated method stub
		return borrowFormDao.findAll();
	}

}
