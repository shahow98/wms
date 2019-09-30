package top.shahow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import top.shahow.entity.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{
	public Product findByName(String name);
	public List<Product> findByCategory(String category);
}
