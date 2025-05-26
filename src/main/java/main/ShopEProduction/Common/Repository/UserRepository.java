package main.ShopEProduction.Common.Repository;

import main.ShopEProduction.Common.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getUserById(String id);
    boolean existsByUserName(String userName);
}
