package yk.web.myyk.backend.repository;

import java.util.List;
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

    /**
     * <p>회원 IDX를 통해 해당 회원의 모든 로그인 토큰을 반환한다.</p>
     * 
     * @param memberIdx 회원 IDX
     * @return 로그인 토큰 리스트
     */
    public List<LoginToken> findAllByMemberMemberIdx(long memberIdx);
}
