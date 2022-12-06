package net.yorksolutions.kabornamarrablogcmscapstone.repository;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
}
