package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.shahow.entity.DeliveryForm;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryFormDao extends JpaRepository<DeliveryForm, Integer>, JpaSpecificationExecutor<DeliveryForm>{

}
