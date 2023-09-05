package yk.web.myyk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.account.PrimeCategoryOptionEntity;

@Repository
public interface PrimeCategoryOptionRepository extends JpaRepository<PrimeCategoryOptionEntity, Long> {

}
