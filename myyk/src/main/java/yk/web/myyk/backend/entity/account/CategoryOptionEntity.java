package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.entity.BaseEntity;

@Entity
@Table(name = "CATEGORY_OPTION_TBL")
public class CategoryOptionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_OPTION_IDX")
	private Long CategoryOptionIdx;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_IDX")
	private CategoryEntity category;
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "COLOR")
	private String color;
	
	@Deprecated
	public CategoryOptionEntity() {
		// 하이버네이트용
	}
	
	public CategoryOptionEntity(PrimeCategoryDTO dto) {
		this(null, dto);
	}
	
	public CategoryOptionEntity(CategoryEntity category, PrimeCategoryDTO dto) {
		this(category, dto.getIcon(), dto.getColor());
	}
	
	private CategoryOptionEntity(CategoryEntity category, String icon, String color) {
		this.category = category;
		this.icon = icon;
		this.color = color;
	}
	
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	/**
	 * @deprecated {@link CategoryEntity}에서만 사용할 것
	 * @return 아이콘 이름
	 */
	@Deprecated
	public String getIcon() {
		return icon;
	}
	
	/**
	 * @deprecated {@link CategoryEntity}에서만 사용할 것
	 * @return 색깔 코드
	 */
	@Deprecated
	public String getColor() {
		return color;
	}
	
}
