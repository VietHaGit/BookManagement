package com.deft.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY) // có nhiều cuốn sach 1 cung mot loai
    @JoinColumn(name = "category_id") // thông qua khóa ngoại category_id
    @ToString.Exclude
    private Category category;




}
