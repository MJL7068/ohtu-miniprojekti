/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.List;
import miniproju.models.User;
import miniproju.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ilkka
 */
@Service
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findWithId(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }
    
}
