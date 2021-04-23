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
import sgyt.com.gt.qualityproject.models.ValueListModel;
import sgyt.com.gt.qualityproject.models.CategoryModel;
import sgyt.com.gt.qualityproject.repositories.ValueListRepository;
import sgyt.com.gt.qualityproject.repositories.CategoryRepository;

/**
 *
 * @author diego
 */
@Service
public class ValueListService {

    @Autowired
    CategoryRepository cateRepo;

    @Autowired
    ValueListRepository vlRepo;

    public Page<ValueListModel> getValueListByCategoty(Long cateDbid, Pageable pgbl) {
        return vlRepo.findByCategoryDbid(cateDbid, pgbl);
    }

    public ValueListModel saveValueList(Long cateDbid, ValueListModel vl) {
        Optional<CategoryModel> tmpCategory = cateRepo.findById(cateDbid);
        vl.setCategory(tmpCategory.get());
        return vlRepo.save(vl);
    }

}
