package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.Staff;


@Repository
public interface IStaffDao extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff>{
	public Staff findByName(String name);
}
