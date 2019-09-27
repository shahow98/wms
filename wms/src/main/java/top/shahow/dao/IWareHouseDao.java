package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.shahow.entity.WareHouse;

@Repository
public interface IWareHouseDao extends JpaRepository<WareHouse, Integer>{

}
