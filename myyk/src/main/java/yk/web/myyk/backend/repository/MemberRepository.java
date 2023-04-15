package yk.web.myyk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.member.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> { 

}
