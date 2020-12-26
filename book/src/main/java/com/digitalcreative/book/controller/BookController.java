package com.digitalcreative.book.controller;

import com.digitalcreative.book.model.Book;
import com.digitalcreative.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * Create - Add a new book
     * @param book An object book
     * @return The book object saved
     */
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }


    /**
     * Read - Get one book
     * @param id The id of the book
     * @return A book object full filled
     */
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") final Long id) {
        Optional<Book> book = bookService.getBook(id);
        if(book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all books
     * @return - An Iterable object of book full filled
     */
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    /**
     * Update - Update an existing book
     * @param id - The id of the book to update
     * @param book - The book object updated
     * @return
     */
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable("id") final Long id, @RequestBody Book book) {
        Optional<Book> e = bookService.getBook(id);
        if(e.isPresent()) {
            Book currentBook = e.get();

            String title = book.getTitle();
            if(title != null) {
                currentBook.setTitle(title);
            }
            String author = book.getAuthor();
            if(author != null) {
                currentBook.setAuthor(author);;
            }
            String type = book.getType();
            if(type != null) {
                currentBook.setType(type);
            }
            Integer publication = book.getPublication();
            if(publication != null) {
                currentBook.setPublication(publication);;
            }
            Integer unit = book.getUnit();
            if(unit != null) {
                currentBook.setUnit(unit);;
            }
            bookService.saveBook(currentBook);
            return currentBook;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete a book
     * @param id - The id of the book to delete
     */
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        bookService.deleteBook(id);
    }
}
