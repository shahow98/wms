package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.shahow.entity.StockForm;

@Repository
public interface IStockFormDao extends JpaRepository<StockForm, Integer>{

}
