/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgyt.com.gt.qualityproject.models.AuthorModel;
import sgyt.com.gt.qualityproject.repositories.AuthorRepository;
import org.springframework.data.domain.*;

/**
 *
 * @author diego
 */
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authRepo;

    public Page<AuthorModel> getAllAuthors(Pageable pgbl) {
        return authRepo.findAll(pgbl);
    }

    public AuthorModel saveAuthor(AuthorModel auth) {
        return authRepo.save(auth);
    }

}
