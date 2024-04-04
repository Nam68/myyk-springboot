package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;

public interface AccountBookAuthRepository extends JpaRepository<AccountBookAuthEntity, Long> {

    public List<AccountBookAuthEntity> findByMemberMemberIdx(long memberIdx, Sort sort);

}
