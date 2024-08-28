package com.victoruk.chukwudice_store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_addresses")
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "address_line1", nullable = false)
        private String addressLine1;

        @Column(name = "city", nullable = false)
        private String city;

        @Column(name = "state", nullable = false)
        private String state;

        @Column(name = "country", nullable = false)
        private String country;

        @Column(name = "phone_number")
        private String phoneNumber;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id", nullable = false)
        private Order order;

    }

