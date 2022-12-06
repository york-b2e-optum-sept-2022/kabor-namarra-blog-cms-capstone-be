package net.yorksolutions.kabornamarrablogcmscapstone.repository;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends CrudRepository<Chat,Long> {

    Iterable<Chat> findAllByMessenger(Account account);
}
