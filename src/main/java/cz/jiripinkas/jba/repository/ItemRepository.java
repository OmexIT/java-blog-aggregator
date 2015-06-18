package cz.jiripinkas.jba.repository;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by omexic on 6/14/2015.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByBlog(Blog blog, Pageable pageable);

    Item findByBlogAndLink(Blog blog, String link);
}
