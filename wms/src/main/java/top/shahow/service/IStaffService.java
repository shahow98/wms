package top.shahow.service;

import top.shahow.entity.Staff;

public interface IStaffService extends IUserService<Staff>{
	public Staff getStaffById(int id);
}
