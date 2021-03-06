package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by omexic on 6/14/2015.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByUser(User user);
}
