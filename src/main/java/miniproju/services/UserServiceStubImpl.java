/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.services;

import java.util.ArrayList;
import java.util.List;
import miniproju.models.User;

/**
 *
 * @author ilkka
 */
public class UserServiceStubImpl implements UserService {

    private List<User> users = new ArrayList<>();

    {
        {
            users.add(new User(1L, "firstUser"));
            users.add(new User(2L, "secondUser"));
        }
    }

    ;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findWithId(Long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User create(User user) {
        user.setId(new Long(users.size()));
        users.add(user);

        return user;
    }

}
