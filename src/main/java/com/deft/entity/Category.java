//package com.deft.entity;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "category")
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) // một thể loại có nhiều cuốn sách
//    //mappedBy trỏ tới tên biến trong categoty
//    private Set<Book> books;
////
////    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
////    @JoinColumn(name = "category_id")
////    private List<Book> books = new ArrayList<>();
//
//
//
//}
