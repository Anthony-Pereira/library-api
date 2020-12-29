package com.digitalcreative.loan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer bookId;

    private String borrowingDate;
    private String returnDate;

    private Boolean prolongation;

}
