package com.yunussen.debtpaymentws.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "collections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CollectionEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double totalDebt;

    @Column(name = "user_id")
    private Long userId;


    /*@JoinColumn(name = "user_id")
    @ManyToOne()
    private UserEntity userDetails;*/
}

