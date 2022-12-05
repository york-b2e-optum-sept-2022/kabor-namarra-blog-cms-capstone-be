package net.yorksolutions.kabornamarrablogcmscapstone.repository;

import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
}
