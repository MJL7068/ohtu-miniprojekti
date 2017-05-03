package miniproju.services;

import java.util.List;

import miniproju.models.Owner;
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
    public List<Owner> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public Owner findWithId(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public Owner create(Owner owner) {
        return this.userRepo.save(owner);
    }
    
}
