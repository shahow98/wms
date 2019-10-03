package top.shahow.service;

import top.shahow.entity.BorrowForm;
import top.shahow.entity.Borrower;

public interface IBorrowerService extends IUserService<Borrower>{
	public boolean submitBorrowForm(BorrowForm borrowForm);
}
