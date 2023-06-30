package yk.web.myyk.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import yk.web.myyk.backend.entity.member.TmpCodeEntity;

public interface TmpCodeRepository extends JpaRepository<TmpCodeEntity, Long> {

	/**
	 * <p>확인코드로 임시멤버 엔티티를 취득한다.</p>
	 * 
	 * @param tmpCode 확인코드
	 * @return 임시멤버 엔티티
	 */
	public Optional<TmpCodeEntity> findByTmpCode(String tmpCode);
	
}
