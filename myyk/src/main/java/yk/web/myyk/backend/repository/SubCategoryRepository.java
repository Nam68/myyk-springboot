package yk.web.myyk.backend.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yk.web.myyk.backend.entity.account.SubCategoryEntity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long> {


    /**
     * <p>카테고리 인덱스를 통해 서브 카테고리 리스트를 반환한다.</p>
     *
     * @param cateogryCategoryIdx 카테고리 인덱스
     * @param sort 정렬
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryEntity> findAllByCategoryCategoryIdx(long cateogryCategoryIdx, Sort sort);
}
