package com.pondmanage.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private Float area;

    @Column(name = "created_time")
    @CreatedDate
    private Instant createdTime;

    @Column(name = "address")
    private Long address;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<Pond> pondList = new ArrayList<>();

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<WareHouse> wareHouseList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
}
