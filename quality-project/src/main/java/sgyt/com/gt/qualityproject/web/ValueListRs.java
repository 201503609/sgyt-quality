/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgyt.com.gt.qualityproject.models.ValueListModel;
import sgyt.com.gt.qualityproject.services.ValueListService;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/value-list")
public class ValueListRs {

    @Autowired
    ValueListService vlSvc;

    @GetMapping("/category/{category}")
    public Page<ValueListModel> getValueListByCategoty(@PathVariable(value = "category") Long cateDbid, Pageable pgbl) {
        return vlSvc.getValueListByCategoty(cateDbid, pgbl);
    }

    @PostMapping("/category/{category}")
    public ValueListModel saveValueList(@PathVariable(value = "category") Long cateDbid, @RequestBody ValueListModel vl) {
        return vlSvc.saveValueList(cateDbid, vl);
    }
}
