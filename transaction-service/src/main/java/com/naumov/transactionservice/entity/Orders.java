package com.naumov.transactionservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;
    private Instant dateCreate;
    private Integer sumTransaction;


}
