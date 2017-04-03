/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;
import miniproju.models.Reference;
import miniproju.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author ilkka
 */
@Service
@Primary
public class ReferenceServiceJpaImpl implements ReferenceService {

    @Autowired
    private ReferenceRepository refRepo;

    {
        {
            Reference ref1 = new Reference();
            ref1.setName("eka");
//            this.create(ref1);
//            this.refRepo.save(ref1);
        }
    }

    ;

    @Override
    public List<Reference> findAll() {
        return this.refRepo.findAll();
    }

    @Override
    public Reference findWithId(Long id) {
        return this.refRepo.findOne(id);
    }

    @Override
    public Reference create(Reference ref) {
        return this.refRepo.save(ref);
    }

}
