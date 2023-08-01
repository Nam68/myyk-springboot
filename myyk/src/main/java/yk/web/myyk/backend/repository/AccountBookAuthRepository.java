package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;

@Repository
public interface AccountBookAuthRepository extends JpaRepository<AccountBookAuthEntity, Long> {
	
	
}
