package com.pondmanage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "enter_price")
    private Float enterPrice;

    @Column(name = "measure")
    private String measure;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    List<EnterHistory> enterHistoryList = new ArrayList<>();
}
