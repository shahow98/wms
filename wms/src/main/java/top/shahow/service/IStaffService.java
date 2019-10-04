package top.shahow.service;

import java.util.List;

import top.shahow.entity.BorrowForm;
import top.shahow.entity.Staff;

public interface IStaffService extends IUserService<Staff>{
	public Staff getStaffById(int id);
	//员工同意即借货成功。反之，借货失败
	public boolean examineAndApproveOfBorrowForm(BorrowForm borrowForm, int status);
	public List<BorrowForm> getBorrowForms();
	public List<BorrowForm> getConsentBorrowForms();
	public List<BorrowForm> getRefuseBorrowForms();
	public List<BorrowForm> getUnderwayBorrowForms();
	public List<BorrowForm> getGiveBackForms();
	public List<BorrowForm> getBorrowFormsByProductNameAndBorrowerName(String productName, String borrowerName);
}
