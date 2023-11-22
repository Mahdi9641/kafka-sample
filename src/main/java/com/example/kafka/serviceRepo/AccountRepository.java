package com.example.kafka.serviceRepo;

import com.example.kafka.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {
}
