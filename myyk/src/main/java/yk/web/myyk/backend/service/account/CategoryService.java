package yk.web.myyk.backend.service.account;

import java.util.List;

import org.springframework.stereotype.Repository;

import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.util.exception.SystemException;

@Repository
public interface CategoryService {

	/**
	 * <p>1차카테고리 리스트를 반환한다.</p>
	 * 
	 * @param accountBookIdx 가계부 인덱스
	 * @return 1차카테고리 리스트
	 * @throws SystemException 시스템에러
	 */
	public List<PrimeCategoryDTO> getPrimeCategory(long accountBookIdx) throws SystemException;
	
	/**
	 * <p>서브카테고리 리스트를 반환한다.</p>
	 * 
	 * @param primeCategoryIdx 1차카테고리 IDX
	 * @return 서브카테고리 리스트
	 * @throws SystemException 시스템에러
	 */
	public List<SubCategoryDTO> getSubCategory(long primeCategoryIdx) throws SystemException;

	/**
	 * <p>카테고리를 생성한다.</p>
	 * 
	 * @param <T> 카테고리 옵션 (1차카테고리 {@link PrimeCategoryDTO} | 서브카테고리 {@link SubCategoryDTO})
	 * @param dto 카테고리 DTO
	 * @return 성공여부
	 * @throws SystemException 시스템에러
	 */
	public <T extends CategoryDTO<T>> Error create(CategoryDTO<T> dto) throws SystemException;
	
}
