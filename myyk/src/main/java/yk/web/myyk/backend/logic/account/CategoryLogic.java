package yk.web.myyk.backend.logic.account;

import java.util.List;

import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.repository.CategoryRepository;
import yk.web.myyk.backend.service.account.CategoryService;

public class CategoryLogic extends BaseLogic implements CategoryService {

	@Override
	public List<PrimeCategoryDTO> getPrimeCategory() {
		
		List<CategoryEntity> list = getRepository().getCategory().findAll(CategoryRepository.getSort());
		// 프라임 카테고리만 얻을 수 있는 방법 모색
		
		
		return null;
	}

}
