package yk.web.myyk.backend.dto;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class SubCategoryDTO extends CategoryDTO<SubCategoryDTO> {

	private long parentCategoryIdx;

	@SuppressWarnings("unused")
    private List<AccountDTO> accountList = new ArrayList<>();

	@Deprecated
	public SubCategoryDTO() {
		// 프레임워크용
	}

	public SubCategoryDTO(CategoryEntity entity) throws SystemException {
//		super(entity.getCategoryIdx(), entity.getKoCategoryName(), entity.getJpCategoryName());
//		if (entity.isPrime()) {
//			throw new SystemException(ErrorCode.CG_103, SubCategoryDTO.class);
//		}
//		this.parentCategoryIdx = entity.getCategoryIdx();
	}

	@Override
    public void setKoCategoryName(String name) {
		super.setKoCategoryName(name);
	}

	@Override
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
