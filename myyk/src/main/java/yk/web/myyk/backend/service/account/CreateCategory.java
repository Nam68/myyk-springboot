package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.service.BaseService;

public interface CreateCategory extends BaseService {

    /**
     * <p>카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param categoryNameKo 카테고리 이름(한국어)
     */
    public void setCategoryNameKo(String categoryNameKo);

    /**
     * <p>카테고리 이름(일본어)를 설정한다.</p>
     *
     * @param categoryNameJp 카테고리 이름(일본어)
     */
    public void setCategoryNameJp(String categoryNameJp);

    /**
     * <p>카테고리 색을 설정한다.</p>
     *
     * @param categoryColor 카테고리 색
     */
    public void setCategoryColor(String categoryColor);

    /**
     * <p>카테고리 아이콘을 설정한다.</p>
     *
     * @param categoryIcon 카테고리 아이콘
     */
    public void setCategoryIcon(String categoryIcon);
}
