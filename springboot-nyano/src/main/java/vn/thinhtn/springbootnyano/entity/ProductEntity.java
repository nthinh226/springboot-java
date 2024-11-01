package vn.thinhtn.springbootnyano.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Table(name = "java_product_001")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private BigDecimal productPrice;

    // product have many order and order have many product
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "java_product_order_001",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderEntity> orderList;
}
