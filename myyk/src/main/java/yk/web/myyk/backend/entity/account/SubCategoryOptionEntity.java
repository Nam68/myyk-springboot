package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUB_CATEGORY_OPTION_TBL")
public class SubCategoryOptionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_CATEGORY_OPTION_IDX")
	private Long subCategoryOptionIdx;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_IDX")
	private CategoryEntity category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_CATEGORY_IDX")
	private CategoryEntity parentCategory;
	
	@Deprecated
	public SubCategoryOptionEntity() {
		// 하이버네이트용
	}
	
	/**
	 * <p>부모 카테고리를 반환한다.</p>
	 * 
	 * @return 부모 카테고리
	 */
	public CategoryEntity getParentCategory() {
		return parentCategory;
	}
	
}
