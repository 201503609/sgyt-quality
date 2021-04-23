/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import sgyt.com.gt.qualityproject.models.BookModel;
import sgyt.com.gt.qualityproject.services.BookService;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/book")
public class BookRS {

    @Autowired
    BookService bookSvc;

    @GetMapping("/author/{author}")
    public Page<BookModel> getAllBooksByAuthor(@PathVariable(value = "author") Long authorDbid, Pageable pgbl) {
        return bookSvc.getAllBooksByAuthor(authorDbid, pgbl);
    }

    @PostMapping("/author/{author}")
    public BookModel saveBook(@PathVariable(value = "author") Long authorDbid, @RequestBody BookModel book) {
        return bookSvc.saveBook(authorDbid, book);
    }

}
