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
import sgyt.com.gt.qualityproject.models.AuthorModel;
import sgyt.com.gt.qualityproject.services.AuthorService;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/author")//plural
public class AuthorRs {

    @Autowired
    AuthorService authSvc;

    @GetMapping() //desaparecer verbos //manejar mejor el pagineo
    public Page<AuthorModel> getAllAuthors(Pageable pgbl) {
        return authSvc.getAllAuthors(pgbl);
    }

    @PostMapping() //idempotencia estudiarlo...
    public AuthorModel saveAuthor(@RequestBody AuthorModel auth) {
        return authSvc.saveAuthor(auth);
    }

}
