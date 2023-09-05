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
import yk.web.myyk.backend.entity.account.PrimeCategoryOptionEntity;
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
		
		// DTO를 통해 카테고리가 입력될 가계부를 가져온다.
		Optional<AccountBookEntity> accountBook = getRepository().getAccountBook().findById(dto.getAccountBookIdx());
		if (!accountBook.isPresent()) {
			// 가계부가 없으면 에러.
			throw new SystemException(ErrorCode.AC_101, CategoryLogic.class);
		}
		
		// 카테고리 엔티티를 생성한다.
		CategoryEntity entity = new CategoryEntity(dto, accountBook.get());
		
		// DTO가 가지고 있는 옵션에 따라 생성 처리 분기
		if (dto.getOption() instanceof PrimeCategoryDTO) {
			
			PrimeCategoryDTO primeCategory = (PrimeCategoryDTO) dto.getOption();
			PrimeCategoryOptionEntity primeOption = new PrimeCategoryOptionEntity(entity, primeCategory);
			
			getRepository().getCategoryOption().save(primeOption);
			
		} else if (dto.getOption() instanceof SubCategoryDTO) {
			
			SubCategoryDTO subOption = (SubCategoryDTO) dto.getOption();
			CategoryEntity parentCategory = new CategoryEntity(subOption.getParentCategoryIdx());
			
		} else {
			throw new SystemException(ErrorCode.CG_106, CategoryEntity.class);
		}
		
		getRepository().getCategory().save(entity);
	}
	
}
