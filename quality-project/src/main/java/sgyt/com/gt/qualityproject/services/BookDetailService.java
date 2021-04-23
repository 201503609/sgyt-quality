/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import sgyt.com.gt.qualityproject.models.BookDetailModel;
import sgyt.com.gt.qualityproject.models.BookModel;
import sgyt.com.gt.qualityproject.repositories.BookDetailRepository;
import sgyt.com.gt.qualityproject.repositories.BookRepository;

/**
 *
 * @author diego
 */
@Service
public class BookDetailService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    BookDetailRepository bookDetailRepo;

    public Page<BookDetailModel> getAllbookDetailsByBook(Long bookDbid, Pageable pgbl) {
        return bookDetailRepo.findByBookDbid(bookDbid, pgbl);
    }

    public BookDetailModel saveBookDetail(Long bookDbid, BookDetailModel detail) {
        Optional<BookModel> tmpBook = bookRepo.findById(bookDbid);
        detail.setBook(tmpBook.get());
        return bookDetailRepo.save(detail);
    }

}
