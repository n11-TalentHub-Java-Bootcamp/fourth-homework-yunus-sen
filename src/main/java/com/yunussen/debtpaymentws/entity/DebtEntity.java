package com.yunussen.debtpaymentws.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "debts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DebtEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "last_date" , scale=2)
    private Double debtValue;

    @Temporal(TemporalType.DATE)
    @Column(name = "vade_date")
    private Date vadeDate;

    @Enumerated(EnumType.STRING)
    private DebtType debtType;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "parent_debt_id")
    private Long parentDebtId;

    /*@JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_debt_id")
    private DebtEntity parentDebt;*/
}
