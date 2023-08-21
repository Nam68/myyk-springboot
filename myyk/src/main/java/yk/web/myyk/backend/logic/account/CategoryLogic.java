package yk.web.myyk.backend.logic.account;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.logic.shared.SortCategoryList;
import yk.web.myyk.backend.service.account.CategoryService;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

@Service
public class CategoryLogic extends BaseLogic implements CategoryService {

	@Override
	@Transactional
	public List<PrimeCategoryDTO> getPrimeCategory(long accountBookIdx) throws SystemException {
		
		Optional<AccountBookEntity> account = getRepository().getAccountBook().findById(accountBookIdx);
		if (!account.isPresent()) {
			throw new SystemException(ErrorCode.AC_101, CategoryLogic.class);
		}
		
		List<CategoryEntity> entityList = account.get().getCategoryList();
		SortCategoryList sort = new SortCategoryList();
		sort.setCatoryEntityList(entityList);
		sort.execute();
		return sort.getPrimeCategoryDto();
	}

	@Override
	@Transactional
	public <T extends CategoryDTO<T>> void create(CategoryDTO<T> dto) throws SystemException {
		CategoryEntity entity = new CategoryEntity(dto);
		getRepository().getCategory().save(entity);
	}
	
}
