package com.pondmanage.model;

import javax.persistence.*;

@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "long_time")
    private Integer longTime;

    @Column(name = "condition")
    private Integer condition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pond_id", referencedColumnName = "id")
    private Pond pond;
}
