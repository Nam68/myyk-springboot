package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> { 

    /**
     * <p>이메일을 통해 모든 회원 리스트를 가져온다.</p>
     * 
     * @param email 이메일
     * @return 회원 리스트
     */
    public List<MemberEntity> findByEmail(String email);

    /**
     * <p>해당 이메일을 제외한 모든 회원 리스트를 가져온다.</p>
     * 
     * @param email 이메일
     * @return 회원 리스트
     */
    public List<MemberEntity> findByEmailNot(String email);

    /**
     * <p>닉네임을 통해 모든 회원 리스트를 가져온다.</p>
     * 
     * @param nickname 닉네임
     * @return 회원 리스트
     */
    public List<MemberEntity> findByNickname(String nickname);

    /**
     * <p>회원 등급을 통해 모든 회원 리스트를 가져온다.</p>
     * 
     * @param memberType 회원등급
     * @return 회원 리스트
     */
    public List<MemberEntity> findByMemberType(MemberType memberType);

    /**
     * <p>회원 IDX 리스트에 해당되는 모든 회원을 가져온다.</p>
     * 
     * @param memberIdx 회원 IDX 리스트
     * @return 회원 리스트
     */
    public List<MemberEntity> findByMemberIdxIn(List<Long> memberIdx);

}
