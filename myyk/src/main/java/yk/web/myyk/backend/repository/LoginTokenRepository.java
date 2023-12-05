package yk.web.myyk.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.token.LoginToken;

@Repository
public interface LoginTokenRepository extends JpaRepository<LoginToken, Long> {

    /**
     * <p>토큰 아이디를 통해 로그인 토큰 엔티티를 반환한다.</p>
     * 
     * @param tokenId 토큰 아이디
     * @return 토큰 엔티티(옵셔널)
     */
    public Optional<LoginToken> findByTokenId(String tokenId);
}
