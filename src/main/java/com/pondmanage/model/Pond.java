package com.pondmanage.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pond")
public class Pond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pond_type")
    private Integer pondType;

    @Column(name = "area")
    private Float area;

    @Column(name = "water_height")
    private Float waterHeight;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_delete")
    private Boolean isDelete = false;

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    List<EnvironmentHistory> environmentHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    List<ProductHistory> productHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    List<FeedingHistory> feedingHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    List<Shrimp> shrimpList = new ArrayList<>();

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL)
    List<Diet> dietList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", referencedColumnName = "id")
    private Zone zone;
}
