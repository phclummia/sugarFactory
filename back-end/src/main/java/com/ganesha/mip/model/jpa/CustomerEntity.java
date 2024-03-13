package com.ganesha.mip.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table( name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customerEntity")
    private List<CustomerBucketDetailEntity> customerBucketDetailEntities = new ArrayList<>();

    /*
    public void addCustomerBucket(CustomerBucketDetailEntity entity) {
        customerBucketDetailEntities.add(entity);
        entity.setCustomerEntity(this);
    }*/
}
