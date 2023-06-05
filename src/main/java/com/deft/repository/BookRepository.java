package com.deft.repository;


import com.deft.entity.Book;
import com.deft.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
//    CriteriaBuilder getEntityManager();
//    List<Book> findByNameContaining(String name);
//    List<Book> findByPriceContaining(Integer price);
//    List<Book> findByAuthorContaining(String author);

//    List<Book> findByNameContainingAndPriceAndAuthor(String name ,Integer price, String author);

//    List<Book> findAllByName(String name , Pageable pageable);

}