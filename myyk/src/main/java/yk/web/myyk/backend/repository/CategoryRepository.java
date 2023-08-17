package yk.web.myyk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yk.web.myyk.backend.entity.account.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	
}
