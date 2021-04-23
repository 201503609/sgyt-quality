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
import sgyt.com.gt.qualityproject.models.BookDetailModel;
import sgyt.com.gt.qualityproject.services.BookDetailService;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/book-detail")
public class BookDetailRS {

    @Autowired
    BookDetailService bookSvc;

    @GetMapping("/book/{book}")
    public Page<BookDetailModel> getAllDetailsBookByDbidBook(@PathVariable(value = "book") Long bookDbid, Pageable pgbl) {
        return bookSvc.getAllbookDetailsByBook(bookDbid, pgbl);
    }

    @PostMapping("/book/{book}")
    public BookDetailModel saveBookDetail(@PathVariable(value = "book") Long bookDbid, @RequestBody BookDetailModel bookDetail) {
        return bookSvc.saveBookDetail(bookDbid, bookDetail);
    }
}
