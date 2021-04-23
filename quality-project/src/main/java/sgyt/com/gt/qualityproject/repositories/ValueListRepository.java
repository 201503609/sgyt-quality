/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.repositories;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgyt.com.gt.qualityproject.models.ValueListModel;
import org.springframework.data.domain.*;

/**
 *
 * @author diego
 */
@Repository
public interface ValueListRepository extends JpaRepository<ValueListModel, Long> {

    Page<ValueListModel> findByCategoryDbid(Long cateDbid, Pageable pgbl);
    
    ArrayList<ValueListModel> findListByCategoryDbid(Long cateDbid);

    Optional<ValueListModel> findByDbidAndCategoryDbid(Long id, Long cateDbid);

}
