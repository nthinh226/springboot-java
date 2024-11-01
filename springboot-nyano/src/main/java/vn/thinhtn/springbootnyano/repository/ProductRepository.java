package vn.thinhtn.springbootnyano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.thinhtn.springbootnyano.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
