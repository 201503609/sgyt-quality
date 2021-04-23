/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgyt.com.gt.qualityproject.models.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author diego
 */
@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    Page<BookModel> findByAuthorDbid(Long authorDbid, Pageable pgbl);

    Optional<BookModel> findByDbidAndAuthorDbid(Long id, Long idAuth);
    
    Page<BookModel> findByCategoryDbid(Long cateDbid, Pageable pgbl);

    Optional<BookModel> findByDbidAndCategoryDbid(Long id, Long cateDbid);
}
