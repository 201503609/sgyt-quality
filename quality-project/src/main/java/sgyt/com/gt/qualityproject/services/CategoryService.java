/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgyt.com.gt.qualityproject.models.CategoryModel;
import sgyt.com.gt.qualityproject.repositories.CategoryRepository;
import org.springframework.data.domain.*;

/**
 *
 * @author diego
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    public Page<CategoryModel> getAllCategories(Pageable pgbl) {
        return categoryRepo.findAll(pgbl);
    }

    public CategoryModel saveCategory(CategoryModel category) {
        return categoryRepo.save(category);
    }
}
