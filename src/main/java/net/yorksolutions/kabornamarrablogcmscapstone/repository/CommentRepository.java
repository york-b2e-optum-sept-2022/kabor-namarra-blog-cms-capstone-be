package net.yorksolutions.kabornamarrablogcmscapstone.repository;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
