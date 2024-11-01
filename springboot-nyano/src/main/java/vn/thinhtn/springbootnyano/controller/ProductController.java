package vn.thinhtn.springbootnyano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.thinhtn.springbootnyano.entity.ProductEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
// localhost:8080/v1/api
public class ProductController {

    @PostMapping("/products/add")
    public ProductEntity createProduct(ProductEntity product) {
//        return productService.create(product);
        return null;
    }

    /**
     * List All
     * @return List
     */
    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
//        return productService.findAllProducts();
        return null;
    }
}
