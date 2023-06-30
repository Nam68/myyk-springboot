package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.member.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> { 

	public List<MemberEntity> findAllByEmail(String email);
	
	public List<MemberEntity> findAllByNickname(String nickname);
	
}
