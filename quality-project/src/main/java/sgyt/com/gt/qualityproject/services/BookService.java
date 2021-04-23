/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import sgyt.com.gt.qualityproject.exception.ResourceNotFoundException;
import sgyt.com.gt.qualityproject.models.AuthorModel;
import sgyt.com.gt.qualityproject.models.BookDetailModel;
import sgyt.com.gt.qualityproject.models.BookModel;
import sgyt.com.gt.qualityproject.models.CategoryModel;
import sgyt.com.gt.qualityproject.models.ValueListModel;
import sgyt.com.gt.qualityproject.repositories.*;

/**
 *
 * @author diego
 */
@Service
public class BookService {

    @Autowired
    AuthorRepository authRepo;
    @Autowired
    CategoryRepository cateRepo;
    @Autowired
    BookRepository bookRepo;
    @Autowired
    ValueListRepository vlRepo;
   
    @Autowired
    BookDetailService bookDetaSvc;
    
    private static String ERROR_AUTHOR = "El autor ingresado no existe en la db";

    public Page<BookModel> getAllBooksByAuthor(Long authDbid, Pageable pgbl) {
        return bookRepo.findByAuthorDbid(authDbid, pgbl);
    }

    public Page<BookModel> getAllBooksByCategory(Long cateDbid, Pageable pgbl) {
        return bookRepo.findByCategoryDbid(cateDbid, pgbl);
    }

    public BookModel saveBook(Long authDbid, Long cateDbid, BookModel book) {
        Optional<AuthorModel> tmpAuthor = authRepo.findById(authDbid);
        Optional<CategoryModel> tmpCate = cateRepo.findById(cateDbid);
        book.setAuthor(tmpAuthor.get());
        book.setCategory(tmpCate.get());
        BookModel result = bookRepo.save(book);
        saveBookDetails(cateDbid, result);
        return result;
    }

    private void saveBookDetails(Long categoryDbid, BookModel book) {
        ArrayList<ValueListModel> listVL = vlRepo.findListByCategoryDbid(categoryDbid);
        for (ValueListModel vl : listVL) {
            BookDetailModel tmpDetail = new BookDetailModel(vl.getKey_(), "-");
            bookDetaSvc.saveBookDetail(book.getDbid(), tmpDetail);
        }
    }
}
