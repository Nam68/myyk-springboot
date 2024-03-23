package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import yk.web.myyk.backend.entity.account.AccountAuthEntity;

public interface AccountAuthRepository extends JpaRepository<AccountAuthEntity, Long> {

    public List<AccountAuthEntity> findByMemberMemberIdx(long memberIdx, Sort sort);

    public static Sort getDescSort() {
        return Sort.by(Sort.Order.desc("registeredDate"));
    }
}
