package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.category.CategoryEntity;

import org.springframework.data.domain.Sort;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    /**
     * <p>회원 인덱스를 통해 카테고리 리스트를 반환한다.</p>
     *
     * @param memberMemberIdx 회원 인덱스
     * @param sort 정렬
     * @return 카테고리 리스트
     */
    public List<CategoryEntity> findAllByMemberMemberIdx(long memberMemberIdx, Sort sort);

    /**
     * <p>회원 인덱스와 카테고리 이름(한국어)를 통해 카테고리 리스트를 반환한다.</p>
     *
     * @param memberMemberIdx 회원 인덱스
     * @param categoryNameKr 카테고리 이름(한국어)
     * @return 카테고리 리스트
     */
    public List<CategoryEntity> findAllByMemberMemberIdxAndCategoryNameKr(long memberMemberIdx, String categoryNameKr);

    /**
     * <p>회원 인덱스와 카테고리 이름(일본어)를 통해 카테고리 리스트를 반환한다.</p>
     *
     * @param memberMemberIdx 회원 인덱스
     * @param categoryNameJp 카테고리 이름(일본어)
     * @return 카테고리 리스트
     */
    public List<CategoryEntity> findAllByMemberMemberIdxAndCategoryNameJp(long memberMemberIdx, String categoryNameJp);
}
