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
import sgyt.com.gt.qualityproject.models.AuthorModel;
import sgyt.com.gt.qualityproject.models.BookModel;
import sgyt.com.gt.qualityproject.repositories.AuthorRepository;
import sgyt.com.gt.qualityproject.repositories.BookRepository;

/**
 *
 * @author diego
 */
@Service
public class BookService {

    @Autowired
    AuthorRepository authRepo;

    @Autowired
    BookRepository bookRepo;

    public Page<BookModel> getAllBooksByAuthor(Long authDbid, Pageable pgbl) {
        return bookRepo.findByAuthorDbid(authDbid, pgbl);
    }

    public BookModel saveBook(Long authDbid, BookModel book) {
        Optional<AuthorModel> tmpAuthor = authRepo.findById(authDbid);
        book.setAuthor(tmpAuthor.get());
        return bookRepo.save(book);
    }
}
