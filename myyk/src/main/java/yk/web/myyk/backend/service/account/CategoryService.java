package yk.web.myyk.backend.service.account;

import java.util.List;

import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.util.exception.SystemException;

@Repository
public interface CategoryService {

	/**
	 * <p>1차카테고리 리스트를 반환한다.</p>
	 * 
	 * @param accountBookIdx 가계부 인덱스
	 * @return 1차카테고리 리스트
	 */
	public List<PrimeCategoryDTO> getPrimeCategory(long accountBookIdx) throws SystemException;

	public <T extends CategoryDTO<T>> void create(CategoryDTO<T> dto) throws SystemException;
	
	
}
