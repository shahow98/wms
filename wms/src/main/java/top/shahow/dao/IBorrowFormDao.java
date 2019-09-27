package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.BorrowFrom;

@Repository
public interface IBorrowFormDao extends JpaRepository<BorrowFrom, Integer>, JpaSpecificationExecutor<BorrowFrom>{

}
