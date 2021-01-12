package com.digitalcreative.book.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer publication;
    private Integer unit;

    private String title;
    private String author;
    private Integer type;

}
