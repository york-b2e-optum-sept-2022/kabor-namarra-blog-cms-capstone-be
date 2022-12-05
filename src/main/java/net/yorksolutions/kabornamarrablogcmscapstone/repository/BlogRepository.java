package net.yorksolutions.kabornamarrablogcmscapstone.repository;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Long> {
    Iterable<Blog> findAllByAuthor(Account author);
}
