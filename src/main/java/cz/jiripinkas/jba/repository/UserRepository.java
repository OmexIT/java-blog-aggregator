package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by omexic on 6/14/2015.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
