package com.deft.controller;

import com.deft.entity.Book;
import com.deft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookService.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getById(id);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Book>> searchByName(@RequestParam(required = false) String name){
//        if (name!=null){
//            List<Book> books = bookService.getByName(name);
//            return new ResponseEntity<>(books,HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }

//    @PostMapping
//    public void create(@RequestBody BookDTO dto) {
//
//        bookService.create(dto);
//    }


//    @GetMapping("/search")
//    public ResponseEntity<List<Book>> Search(@RequestParam(value = "name" ,required = false) String name,
//                                             @RequestParam(value = "price",required = false) Integer price,
//                                             @RequestParam(value = "author",required = false) String author
//                                             ){
//        List<Book> books = bookService.Search(name, price, author);
//        if (books.isEmpty()){
//            return ResponseEntity.noContent().build();
//        }
//        else {
//            return ResponseEntity.ok(books);
//        }
//    }


//    @GetMapping("/searchBook")
//    public List<Book> searchBook(@RequestParam(required = false) String name,
//                                 @RequestParam(required = false) Integer price,
//                                 @RequestParam(required = false) String author){
//        return bookService.searchBook(name,price,author);
//    }


    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer price,
                                  @RequestParam(required = false) Integer priceMin,
                                  @RequestParam(required = false) Integer priceMax,
                                  @RequestParam(required = false) String author
//                                 @RequestParam(defaultValue = "0") Integer pageNo,
//                                 @RequestParam(defaultValue = "3") Integer pageSize
    ) throws Exception {
        List<Book> books = bookService.searchBooks(name, price, priceMin, priceMax, author);
        return books;

    }


    @GetMapping("/search1")
    public ResponseEntity<Page<Book>> searchBooks1(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) Integer price,
                                                   @RequestParam(required = false) Integer priceMin,
                                                   @RequestParam(required = false) Integer priceMax,
                                                   @RequestParam(required = false) String author,
                                                   @RequestParam(defaultValue = "0") int pageNumber,
                                                   @RequestParam(defaultValue = "price") String sortBy) throws Exception {
        Page<Book> books = bookService.searchBooks1(name, price, priceMin, priceMax, author, pageNumber, sortBy);
        return ResponseEntity.ok(books);
    }


    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book saveBook = bookService.create(book);
        return ResponseEntity.ok(saveBook);
    }


    @PutMapping("{id}")
    public ResponseEntity<Book> upDate(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> optionalBook = Optional.ofNullable(bookService.update(id, book));
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
