package com.sjprogramming.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

    
}
