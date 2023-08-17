package yk.web.myyk.backend.entity.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

@Entity
@Table(name = "CATEGORY_TBL")
public class CategoryEntity extends BaseEntity {

	private static final String BASIC_CATEGORY_NAME = "::BASIC CATEGORY::";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_IDX")
	private Long categoryIdx;
	
	@NaturalId
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_CATEGORY", nullable = true)
	private CategoryEntity parentCategory = new CategoryEntity();
	
	@OneToOne(mappedBy = "category", fetch = FetchType.EAGER)
	private PrimeCategoryOptionEntity option;

	@OneToMany(mappedBy = "parentCategoryIdx")
	private List<CategoryEntity> subCategory = new ArrayList<>();
	
	@Deprecated
	public CategoryEntity() {
		// 하이버네이트용
	}
	
	/**
	 * <p>인덱스와 이름만을 가지고 있는 베이직 카테고리를 생성한다.</p>
	 * 
	 * @param isBasic 베이직 카테고리인지의 여부
	 */
	public CategoryEntity(boolean isUsable) {
		if (isUsable) {
			throw new SystemException(ErrorCode.CG_105, CategoryEntity.class);
		}
		this.categoryIdx = 0L;
		this.name = BASIC_CATEGORY_NAME;
	}
	
	/**
	 * <p>1차카테고리를 생성하는 생성자.</p>
	 * 
	 * @param name 이름
	 * @param icon 아이콘이름
	 * @param color 색상코드
	 */
	public CategoryEntity(String name, String icon, String color) {
		
		this.name = name;
		
		@SuppressWarnings("deprecation")
		PrimeCategoryOptionEntity option = new PrimeCategoryOptionEntity(this, icon, color);
		this.option = option;
		
	}
	
	/**
	 * <p>서브카테고리를 생성하는 생성자.</p>
	 * 
	 * @param name 이름
	 * @param parentCategory 부모카테고리
	 */
	public CategoryEntity(String name, CategoryEntity parentCategory) {
		this.name = name;
		this.parentCategory = parentCategory;
	}
	
	/**
	 * <p>카테고리 인덱스를 반환한다.</p>
	 * 
	 * @return 카테고리 인덱스
	 */
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	/**
	 * <p>카테고리 이름을 반환한다.</p>
	 * 
	 * @return 카테고리 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <p>1차카테고리 여부를 반환한다.</p>
	 * 
	 * @return 1차카테고리인 경우 true
	 */
	public boolean isPrime() {
		return option != null;
	}
	
	/**
	 * <p>1차 카테고리인 경우 아이콘 이름을 반환한다.<br>
	 * 서브 카테고리인 경우는 에러가 발생한다.</p>
	 * 
	 * @return 아이콘 이름
	 */
	@SuppressWarnings("deprecation")
	public String getIcon() {
		return getOption().getIcon();
	}

	/**
	 * <p>1차 카테고리인 경우 색상코드를 반환한다.<br>
	 * 서브 카테고리인 경우는 에러가 발생한다.</p>
	 * 
	 * @return 색상코드
	 */
	@SuppressWarnings("deprecation")
	public String getColor() {
		return getOption().getColor();
	}
	
	/**
	 * <p>서브카테고리 리스트를 반환한다.<br>
	 * 서브카테고리인 경우 에러가 발생한다.</p>
	 * 
	 * @return 서브카테고리 리스트
	 */
	public List<CategoryEntity> getSubCatetoryList() {
		if (!isPrime()) {
			throw new SystemException(ErrorCode.CG_104, CategoryEntity.class);
		} else {
			return subCategory;
		}
	}
	
	/**
	 * <p>부모 카테고리를 반환한다.
	 * <br>1차카테고리인 경우 비어있는 {@link Optional}이 반환된다.</p>
	 * 
	 * @return 부모카테고리
	 */
	public Optional<CategoryEntity> getParentCategory() {
		return Optional.ofNullable(parentCategory);
	}
	
	private PrimeCategoryOptionEntity getOption() {
		if (!isPrime()) {
			throw new SystemException(ErrorCode.CG_101, CategoryEntity.class);
		} else {
			return option;
		}
	}
}
