/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import sgyt.com.gt.qualityproject.models.BookDetailModel;

/**
 *
 * @author diego
 */
@Repository
public interface BookDetailRepository extends JpaRepository<BookDetailModel, Long> {

    Page<BookDetailModel> findByBookDbid(Long bookDbid, Pageable pgbl);

    Optional<BookDetailModel> findByDbidAndBookDbid(Long id, Long idBook);
}
