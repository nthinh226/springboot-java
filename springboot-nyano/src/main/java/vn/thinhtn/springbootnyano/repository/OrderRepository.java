package vn.thinhtn.springbootnyano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.thinhtn.springbootnyano.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
