package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by omexic on 6/14/2015.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
