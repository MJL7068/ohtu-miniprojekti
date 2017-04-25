/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;
import miniproju.models.Reference;

/**
 *
 * @author ilkka
 */
public interface ReferenceService {
    List<Reference> findAll();
    void remove(Long id);
    Reference findWithId(Long id);
    Reference create(Reference ref);
    Reference update(Reference ref);
    String findAllInBibtex();
    
}
