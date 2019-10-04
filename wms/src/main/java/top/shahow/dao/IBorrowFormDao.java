package top.shahow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.BorrowForm;

@Repository
public interface IBorrowFormDao extends JpaRepository<BorrowForm, Integer>, JpaSpecificationExecutor<BorrowForm>{
	public List<BorrowForm> findByStatus(int status);
	public List<BorrowForm> findByProduct_id(int productId);
	public List<BorrowForm> findByProduct_idAndStatus(int productId, int status);
	public List<BorrowForm> findByBorrower_id(int borrowerId);
	public List<BorrowForm> findByBorrower_idAndStatus(int borrowerId, int status);
	public List<BorrowForm> findByProduct_idAndBorrower_id(int productId, int borrowerId);
	public List<BorrowForm> findByProduct_idAndBorrower_idAndStatus(int productId, int borrowerId, int status);
}
