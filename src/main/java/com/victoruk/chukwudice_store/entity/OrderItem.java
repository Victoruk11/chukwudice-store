package com.victoruk.chukwudice_store.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "quantity", nullable = false)
        private int quantity;

        @Column(name = "price", precision = 10, scale = 2, nullable = false)
        private BigDecimal price;

        @Column(name = "discount_applied", precision = 10, scale = 2, nullable = false)
        private BigDecimal discountApplied = BigDecimal.ZERO;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false, length = 20)
        private OderItemStatus orderStatus ;

        @Column(name = "created_at", nullable = false)
        private LocalDate createdAt;

        @Column(name = "updated_at", nullable = false)
        private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;



//    -- Create the order_items table
//    CREATE TABLE order_items (
//            id BIGINT AUTO_INCREMENT PRIMARY KEY,
//            order_id BIGINT,
//            product_id BIGINT,
//            quantity INT NOT NULL,
//            price DECIMAL(10, 2) NOT NULL,  -- Price locked in when the order was placed
//    discount_applied DECIMAL(10, 2) DEFAULT 0.00,  -- Any discount applied
//    status VARCHAR(20) DEFAULT 'pending',  -- Status of the item in the order (optional)
//    created_at DATE,
//    updated_at DATE,
//    FOREIGN KEY (order_id) REFERENCES orders(id),
//    FOREIGN KEY (product_id) REFERENCES products(id),
//    INDEX idx_order_id (order_id),
//    INDEX idx_product_id (product_id)
//);

}
