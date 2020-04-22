package com.tyler.account.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyler.account.data.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
