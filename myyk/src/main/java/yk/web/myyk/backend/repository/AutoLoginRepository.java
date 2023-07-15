package yk.web.myyk.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.member.AutoLoginEntity;

@Repository
public interface AutoLoginRepository extends JpaRepository<AutoLoginEntity, Long> {

	/**
	 * <p>자동 로그인 세션ID를 통해 자동 로그인 정보를 가져온다.</p>
	 * 
	 * @param sessionId 자동 로그인 세션 ID
	 * @return 자동 로그인 엔티티
	 */
	public Optional<AutoLoginEntity> findBySessionId(String sessionId);
	
}
