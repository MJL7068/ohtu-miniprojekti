/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;
import miniproju.models.Ref;

/**
 *
 * @author ilkka
 */
public interface RefService {
    List<Ref> findAll();
    Ref findWithId(int id);
    Ref create(Ref ref);
    
}
