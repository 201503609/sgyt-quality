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
import sgyt.com.gt.qualityproject.models.CategoryModel;
import sgyt.com.gt.qualityproject.services.CategoryService;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/category")
public class CategoryRS {

    @Autowired
    CategoryService categorySvc;

    @GetMapping("/all")
    public Page<CategoryModel> getAllCategories(Pageable pgbl) {
        return categorySvc.getAllCategories(pgbl);
    }

    @PostMapping("/save")
    public CategoryModel saveCategory(@RequestBody CategoryModel cate) {
        return categorySvc.saveCategory(cate);
    }

}
