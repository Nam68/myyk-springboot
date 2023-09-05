package yk.web.myyk.backend.entity.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.ColumnDefault;
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
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
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
	@Column(name = "KO_CATEGORY_NAME")
	private String koCategoryName;
	
	@NaturalId
	@Column(name = "JP_CATEGORY_NAME")
	private String jpCategoryName;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_CATEGORY_IDX", nullable = true)
	private CategoryEntity parentCategory;
	
	@OneToOne(mappedBy = "category", fetch = FetchType.EAGER)
	private PrimeCategoryOptionEntity option;

	@OneToMany(mappedBy = "parentCategory")
	private List<CategoryEntity> subCategory = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_BOOK_IDX")
	private AccountBookEntity accountBook;
	
	@Deprecated
	public CategoryEntity() {
		// 하이버네이트용
	}
	
	/**
	 * <p>인덱스와 이름만을 가지고 있는 베이직 카테고리를 생성한다.</p>
	 * 
	 * @param isBasic 베이직 카테고리인지의 여부 | 베이직 카테고리면 false를 투입
	 */
	public CategoryEntity(boolean isUsable) {
		if (isUsable) {
			throw new SystemException(ErrorCode.CG_105, CategoryEntity.class);
		}
		this.categoryIdx = 0L;
		this.koCategoryName = BASIC_CATEGORY_NAME;
		this.jpCategoryName = BASIC_CATEGORY_NAME;
	}
	
	/**
	 * <p>이름을 입력해서 카테고리를 생성한다.</p>
	 * 
	 * @param T 카테고리DTO의 옵션 DTO
	 * @param dto DTO
	 */
	public <T extends CategoryDTO<T>> CategoryEntity(CategoryDTO<T> dto, AccountBookEntity accountBook) throws SystemException {
		this.koCategoryName = dto.getKoCategoryName();
		this.jpCategoryName = dto.getJpCategoryName();
		this.accountBook = accountBook;
		
		// DTO가 가지고 있는 옵션에 따라 생성 처리 분기
		if (dto.getOption() instanceof PrimeCategoryDTO) {
					
			PrimeCategoryDTO primeCategory = (PrimeCategoryDTO) dto.getOption();
			option = new PrimeCategoryOptionEntity(this, primeCategory);
					
		} else if (dto.getOption() instanceof SubCategoryDTO) {
					
			SubCategoryDTO subOption = (SubCategoryDTO) dto.getOption();
			CategoryEntity parentCategory = new CategoryEntity(subOption.getParentCategoryIdx());
					
		} else {
			throw new SystemException(ErrorCode.CG_106, CategoryEntity.class);
		}
	}
	
	/**
	 * <p>비어있는 부모 카테고리를 생성한다.</p>
	 * 
	 * @param parentCategoryIdx 부모 카테고리 인덱스
	 */
	public CategoryEntity(long parentCategoryIdx) {
		this.categoryIdx = parentCategoryIdx;
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
	 * <p>카테고리 이름(한국어)을 반환한다.</p>
	 * 
	 * @return 카테고리 이름(한국어)
	 */
	public String getKoCategoryName() {
		return koCategoryName;
	}
	
	/**
	 * <p>카테고리 이름(일본어)을 반환한다.</p>
	 * 
	 * @return 카테고리 이름(일본어)
	 */
	public String getJpCategoryName() {
		return jpCategoryName;
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
		return getOption().get().getIcon();
	}

	/**
	 * <p>1차 카테고리인 경우 색상코드를 반환한다.<br>
	 * 서브 카테고리인 경우는 에러가 발생한다.</p>
	 * 
	 * @return 색상코드
	 */
	@SuppressWarnings("deprecation")
	public String getColor() {
		return getOption().get().getColor();
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
	
	/**
	 * <p>카테고리 옵션을 가져온다.
	 * <br>1차 카테고리가 아닌 경우 에러를 발생시킨다.</p>
	 * 
	 * @return 카테고리 옵션
	 */
	public Optional<PrimeCategoryOptionEntity> getOption() {
		if (!isPrime()) {
			throw new SystemException(ErrorCode.CG_101, CategoryEntity.class);
		} else {
			return Optional.ofNullable(option);
		}
	}
}
