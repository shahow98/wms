package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{

}
