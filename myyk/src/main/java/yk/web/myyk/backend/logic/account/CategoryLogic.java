package yk.web.myyk.backend.logic.account;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.logic.shared.SortCategoryList;
import yk.web.myyk.backend.service.account.CategoryService;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.enumerated.Error;

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
	public <T extends CategoryDTO<T>> Error create(CategoryDTO<T> dto) throws SystemException {
		
		// DTO를 통해 카테고리가 입력될 가계부를 가져온다.
		Optional<AccountBookEntity> accountBook = getRepository().getAccountBook().findById(dto.getAccountBookIdx());
		if (!accountBook.isPresent()) {
			throw new SystemException(ErrorCode.AC_101, CategoryLogic.class);
		}
		
		// 카테고리 엔티티를 생성한다.
		CategoryEntity entity = new CategoryEntity(dto, accountBook.get());
		
		if (entity.isPrime()) {
			getRepository().getCategoryOption().save(entity.getOption());
		} else {
			// sub option entity 저장 필요 (혹시 리포지토리만 만들어도 가능한지 실험해보기)
//			getRepository().getSubCategoryOption().save(entity.getSubCategory());
		}
		
		getRepository().getCategory().save(entity);
		
		return Error.SUCCESS;
	}
	
}
