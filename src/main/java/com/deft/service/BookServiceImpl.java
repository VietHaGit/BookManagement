package com.deft.service;

import com.deft.entity.Book;
import com.deft.exception.PriceException;
import com.deft.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


//    @Override
//    public void create(BookDTO dto) {
//        Book book = new Book();
//        book.setAuthor(dto.getAuthor());
//        book.setName(dto.getName());
//        book.setPrice(dto.getPrice());
//        bookRepository.save(book);
//    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getById(Long id) {

        return bookRepository.findById(id);
    }


//    @Override
//    public List<Book> getByName(String name)
//    {
//        return bookRepository.findByNameContaining(name);
//    }

//    @Override
//    public List<Book> Search(String name , Integer price,String author){
//        return bookRepository.findByNameContainingAndPriceAndAuthor(name,price,author);
//    }


//    @Override
//    public List<Book> searchBook(String name, Integer price, String author) {
//        String sql = "select * from books";
//        if(name){
//            sql += " AND name like"
//        }
//        if(price){
//            sql += "AND price ";
//        }
//        if(author){
//            sql += " AND author like ";
//        }


    @Autowired
    private EntityManager entityManager;

    @Override
//    CriteriaBuilder
    public List<Book> searchBooks(String name, Integer price, Integer priceMin, Integer priceMax, String author) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }

        if (price != null && price < 0) {
            throw new PriceException("10000", "Phai la so duong", "price");
        }

        if (price != null && price > 0) {
            predicates.add(cb.equal(root.get("price"), price));
        }

        if (priceMin != null && priceMax != null) {
            predicates.add(cb.between(root.get("price"), priceMin, priceMax));
        }

        if (author != null) {
            predicates.add(cb.like(root.get("author"), "%" + author + "%"));
        }
        query.where(predicates.toArray(new Predicate[0]));

//        Pageable pageable = PageRequest.of(pageNo,pageSize);
//      return bookRepository.findAll(pageable);
        return entityManager.createQuery(query).getResultList();

    }


    @Override
//    Specification
    public Page<Book> searchBooks1(String name, Integer price, Integer priceMin, Integer priceMax, String author, int pageNumber, String sortBy) throws Exception {
        Specification<Book> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            if (price != null && price < 0) {
                throw new PriceException("10000", "Phai la so duong", "price");
            }

            if (price != null && price > 0) {
                predicates.add(criteriaBuilder.equal(root.get("price"), price));
            }
            if (priceMin != null && priceMax != null) {
                predicates.add(criteriaBuilder.between(root.get("price"), priceMin, priceMax));
            }

            if (author != null) {
                predicates.add(criteriaBuilder.like(root.get("author"), "%" + author + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return bookRepository.findAll(specification, PageRequest.of(pageNumber, 5, Sort.by(sortBy)));
    }


    @Override
    public Book update(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book exit = optionalBook.get();
            exit.setAuthor(book.getAuthor());
            exit.setName(book.getName());
            exit.setPrice(book.getPrice());
            return (bookRepository.save(exit));
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
