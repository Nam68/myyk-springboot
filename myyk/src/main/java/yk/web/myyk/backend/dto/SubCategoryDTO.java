package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class SubCategoryDTO extends CategoryDTO<SubCategoryDTO> {
	
	private long parentCategoryIdx;
	
	public SubCategoryDTO(CategoryEntity entity) throws SystemException {
		
		super(entity.getCategoryIdx(), entity.getName());
		
		if (entity.isPrime()) {
			throw new SystemException(ErrorCode.CG_103, SubCategoryDTO.class);
		}
		
		this.parentCategoryIdx = entity.getCategoryIdx();
	}
	
	public void setParentCateogryIdx(long parentCategoryIdx) {
		this.parentCategoryIdx = parentCategoryIdx;
	}

	public long getParentCategoryIdx() {
		return parentCategoryIdx;
	}

	@Override
	public SubCategoryDTO getOption() {
		return this;
	}
}
