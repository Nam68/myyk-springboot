package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class SubCategoryDTO extends CategoryDTO<SubCategoryDTO> {
	
	private long parentCategoryIdx;
	
	@Deprecated
	public SubCategoryDTO() {
		// 프레임워크용
	}
	
	public SubCategoryDTO(CategoryEntity entity) throws SystemException {
		super(entity.getCategoryIdx(), entity.getKoCategoryName(), entity.getJpCategoryName());
		if (entity.isPrime()) {
			throw new SystemException(ErrorCode.CG_103, SubCategoryDTO.class);
		}
		this.parentCategoryIdx = entity.getCategoryIdx();
	}
	
	public void setKoCategoryName(String name) {
		super.setKoCategoryName(name);
	}
	
	public void setJpCategoryName(String name) {
		super.setJpCategoryName(name);
	}
	
	public void setParentCategoryIdx(long parentCategoryIdx) {
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
