package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class SubCategoryDTO {

	private long categoryIdx;
	
	private String name;
	
	private long parentCategoryIdx;
	
	public SubCategoryDTO(CategoryEntity entity) {
		this.categoryIdx = entity.getCategoryIdx();
		this.name = entity.getName();
		if (!entity.getParentCategory().isPresent()) {
			throw new SystemException(ErrorCode.CG_103, SubCategoryDTO.class);
		}
		this.parentCategoryIdx = entity.getParentCategory().get().getCategoryIdx();
	}
	
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	public String getName() {
		return name;
	}
	
	public long getParentCategoryIdx() {
		return parentCategoryIdx;
	}
	
}
