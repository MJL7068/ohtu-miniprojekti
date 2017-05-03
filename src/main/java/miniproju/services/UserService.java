package miniproju.services;

import java.util.List;

import miniproju.models.Owner;

public interface UserService {

    List<Owner> findAll();

    Owner findWithId(Long id);

    Owner create(Owner owner);
}
