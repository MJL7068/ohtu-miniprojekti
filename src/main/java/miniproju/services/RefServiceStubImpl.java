/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.ArrayList;
import java.util.List;
import miniproju.models.Ref;
import org.springframework.stereotype.Service;

/**
 *
 * @author ilkka
 */
@Service
public class RefServiceStubImpl implements RefService {

    private List<Ref> refs = new ArrayList<>();

    {
        {
            refs.add(new Ref(1, "eka"));
            refs.add(new Ref(2, "toka"));
        }
    }

    ;
    

    
    @Override
    public List<Ref> findAll() {
        return refs;
    }

    @Override
    public Ref create(Ref ref) {
        ref.setId(refs.size());
        refs.add(ref);
        
        return ref;
    }

    @Override
    public Ref findWithId(int id) {
        for (Ref ref : refs) {
            if (ref.getId() == id) {
                return ref;
            }
        }
        
        return null;
    }

}
