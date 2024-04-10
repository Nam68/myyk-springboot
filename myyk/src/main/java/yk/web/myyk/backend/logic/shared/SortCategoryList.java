package yk.web.myyk.backend.logic.shared;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>카테고리 리스트를 1차, 서브를 분리해서 정렬하는 공유 로직.</p>
 */
public class SortCategoryList extends BaseSharedLogic {

	private List<CategoryEntity> categoryEntityList = new ArrayList<>();

	private List<CategoryEntity> sortedCategoryEntityList;

	@Override
	public void validate() throws SystemException {
		if (categoryEntityList == null) {
			throw new SystemException("category entity list does not exist in SortCategoryList.");
		}
	}

	@Override
	public void execute() throws SystemException {

		validate();

		List<CategoryEntity> entityResult = new ArrayList<>();

		for (CategoryEntity entity : categoryEntityList) {
//			if (entity.isPrime()) {
//				entityResult.add(entity);
//				dtoResult.add(new PrimeCategoryDTO(entity));
//			}
		}

		sortedCategoryEntityList = entityResult;
	}

	/**
	 * <p>정렬이 필요한 카테고리 엔티티 리스트를 설정한다.</p>
	 *
	 * @param categoryEntityList 카테고리 엔티티 리스트
	 */
	public void setCatoryEntityList(List<CategoryEntity> categoryEntityList) {
		this.categoryEntityList = categoryEntityList;
	}

	/**
	 * <p>1차카테고리 엔티티만을 반환한다.</p>
	 *
	 * @return 1차카테고리 엔티티 리스트
	 */
	public List<CategoryEntity> getSortedCategoryEntityList() {
		return sortedCategoryEntityList;
	}

}
