/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;

import miniproju.models.Owner;

/**
 *
 * @author ilkka
 */
public interface UserService {
    List<Owner> findAll();
    Owner findWithId(Long id);
    Owner create(Owner owner);
}
