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
import yk.web.myyk.backend.entity.BaseEntity;

@Entity
@Table(name = "PRIME_CATEGORY_OPTION_TBL")
public class PrimeCategoryOptionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRIME_CATEGORY_OPTION_IDX")
	private Long primeCategoryOptionIdx;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_IDX")
	private CategoryEntity category;
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "COLOR")
	private String color;
	
	@Deprecated
	public PrimeCategoryOptionEntity() {
		// 하이버네이트용
	}
	
	/**
	 * @deprecated {@link CategoryEntity}의 컨스트럭터에서만 사용할 것
	 */
	@Deprecated
	public PrimeCategoryOptionEntity(CategoryEntity category, String icon, String color) {
		this.category = category;
		this.icon = icon;
		this.color = color;
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
