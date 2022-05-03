package com.pondmanage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ware_house")
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Zone zone;

    @OneToMany(mappedBy = "wareHouse", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    List<EnterHistory> enterHistoryList = new ArrayList<>();
}
