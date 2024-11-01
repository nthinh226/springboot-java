//package vn.thinhtn.springbootnyano.repository.impl;
//
//import org.springframework.stereotype.Repository;
//import vn.thinhtn.springbootnyano.entity.ProductEntity;
//import vn.thinhtn.springbootnyano.repository.ProductRepository;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Repository
//public class ProductRepositoryImpl implements ProductRepository {
//    @Override
//    public ProductEntity create(ProductEntity product) {
//        ProductEntity productEntity = new ProductEntity();
//        productEntity.setId(1L);
//        productEntity.setProductName("Tips Java");
//        productEntity.setProductPrice(new BigDecimal("21.6"));
//        return productEntity;
//    }
//
//    @Override
//    public List<ProductEntity> findAllProducts() {
//        ProductEntity productEntity = new ProductEntity();
//        productEntity.setId(1L);
//        productEntity.setProductName("Tips Java");
//        productEntity.setProductPrice(new BigDecimal("21.6"));
//        return List.of(productEntity);
//    }
//}
