package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import yk.web.myyk.backend.entity.account.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	public static final long BASIC_CATEGORY_IDX = new CategoryEntity(true).getCategoryIdx();
	
	public static Sort getSort() {
		return Sort.by(Sort.Order.asc("categoryIdx"));
	}
	
}
