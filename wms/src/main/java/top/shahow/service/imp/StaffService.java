package top.shahow.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.shahow.dao.IStaffDao;
import top.shahow.entity.Staff;
import top.shahow.service.IStaffService;

@Service
public class StaffService implements IStaffService {

	@Autowired
	private IStaffDao staffDao;

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

}
