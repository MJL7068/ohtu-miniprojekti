/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.ArrayList;
import java.util.List;
import miniproju.models.Reference;
import org.springframework.stereotype.Service;

/**
 *
 * @author ilkka
 */
@Service
public class ReferenceServiceStubImpl implements ReferenceService {

    private List<Reference> refs = new ArrayList<>();

    {
        {
            refs.add(new Reference(1L, "eka"));
            refs.add(new Reference(2L, "toka"));
        }
    }

    ;
    

    
    @Override
    public List<Reference> findAll() {
        return refs;
    }

    @Override
    public Reference create(Reference ref) {
        ref.setId(new Long(refs.size()));
        refs.add(ref);
        
        return ref;
    }

    @Override
    public Reference findWithId(int id) {
        for (Reference ref : refs) {
            if (ref.getId() == id) {
                return ref;
            }
        }
        
        return null;
    }

}
