/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgyt.com.gt.qualityproject.models.CategoryModel;

/**
 *
 * @author diego
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}
