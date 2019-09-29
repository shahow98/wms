package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.Borrower;
import top.shahow.entity.Staff;

@Repository
public interface IBorrowerDao extends JpaRepository<Borrower, Integer>, JpaSpecificationExecutor<Borrower>{
	public Borrower findByName(String name);
}
