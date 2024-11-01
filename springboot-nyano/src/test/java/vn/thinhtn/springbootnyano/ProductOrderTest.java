package vn.thinhtn.springbootnyano;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import vn.thinhtn.springbootnyano.entity.OrderEntity;
import vn.thinhtn.springbootnyano.entity.ProductEntity;
import vn.thinhtn.springbootnyano.repository.OrderRepository;
import vn.thinhtn.springbootnyano.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void ManyToManyTest() {
        ProductEntity p1 = new ProductEntity();
        ProductEntity p2 = new ProductEntity();

        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();
        OrderEntity o3 = new OrderEntity();

        p1.setProductName("p 1");
        p1.setProductPrice(new BigDecimal("4.6"));

        p1.setProductName("p 2");
        p1.setProductPrice(new BigDecimal("4.7"));

        o1.setUserId(1);
        o2.setUserId(2);

        // List Order in Product
        p1.setOrderList(List.of(o1, o2));
        p2.setOrderList(List.of(o1, o2, o3));

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

        // product
        productRepository.save(p1);
        productRepository.save(p2);

    }

    @Test
    @Transactional
    void selectManyToManyTest() {
        ProductEntity p1 = productRepository.findById(1L).orElseThrow();
        System.out.println(p1);
        System.out.println(p1.getOrderList());
    }
}
