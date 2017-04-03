/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;
import miniproju.models.User;

/**
 *
 * @author ilkka
 */
public interface UserService {
    List<User> findAll();
    User findWithId(Long id);
    User create(User user);
}
