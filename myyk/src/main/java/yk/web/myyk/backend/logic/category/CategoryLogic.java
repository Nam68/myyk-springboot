package yk.web.myyk.backend.logic.category;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.logic.BaseLogic;

@Service
public class CategoryLogic extends BaseLogic {

//	@Override
//	@Transactional
//	public List<PrimeCategoryDTO> getPrimeCategory(long accountBookIdx) throws SystemException {
//
//		Optional<AccountBookEntity> account = getRepository().getAccountBook().findById(accountBookIdx);
//		if (!account.isPresent()) {
//			throw new SystemException(ErrorCode.AB_101, CategoryLogic.class);
//		}
//
//		List<CategoryEntity> entityList = account.get().getCategoryList();
//		SortCategoryList sort = new SortCategoryList();
//		sort.setCatoryEntityList(entityList);
//		sort.execute();
//		return sort.getPrimeCategoryDto();
//	    return null;
//	}

//	@Override
//	@Transactional
//	public List<SubCategoryDTO> getSubCategory(long primeCategoryIdx) throws SystemException {
//		Optional<CategoryEntity> primeCategory = getRepository().getCategory().findById(primeCategoryIdx);
//		// 존재하지 않는 경우 null 반환
//		if (!primeCategory.isPresent()) {
//			return null;
//		}
//		List<SubCategoryDTO> result = new ArrayList<>();
////		for (CategoryEntity subCategory : primeCategory.get().getSubCategory()) {
////			result.add(new SubCategoryDTO(subCategory));
////		}
//		return result;
//	}

//	@SuppressWarnings("deprecation")
//	@Override
//	@Transactional
//	public <T extends CategoryDTO<T>> Error create(CategoryDTO<T> dto) throws SystemException {
//
//		// DTO를 통해 카테고리가 입력될 가계부를 가져온다.
////		Optional<AccountBookEntity> accountBook = getRepository().getAccountBook().findById(dto.getAccountBookIdx());
////		if (!accountBook.isPresent()) {
////			throw new SystemException(ErrorCode.AB_101, CategoryLogic.class);
////		}
////
////		// 카테고리 엔티티를 생성한다.
////		CategoryEntity entity = new CategoryEntity(dto, accountBook.get());
////
////		if (entity.isPrime()) {
////			getRepository().getCategoryOption().save(entity.getOption());
////		} else {
////			getRepository().getSubCategoryOption().save(entity.getSubCategoryOption());
////		}
////
////		getRepository().getCategory().save(entity);
//
//		return Error.SUCCESS;
//	}

}
