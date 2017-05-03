package miniproju.repositories;

import miniproju.models.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Owner, Long> {

}
