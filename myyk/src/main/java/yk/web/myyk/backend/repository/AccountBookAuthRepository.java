package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;

@Repository
public interface AccountBookAuthRepository extends JpaRepository<AccountBookAuthEntity, Long> {
	
	/**
	 * <p>회원 idx를 통해서 회원이 가지고 있는 가계부 권한을 모두 불러온다.</p>
	 * 
	 * @param memberIdx 회원 idx
	 * @return 가계부 권한 리스트
	 */
	public List<AccountBookAuthEntity> findAllByMemberMemberIdxOrderByAccountBookAuthIdxAsc(long memberIdx);

	
}
