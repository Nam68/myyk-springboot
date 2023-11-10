package yk.web.myyk.backend.entity.account;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.backend.entity.BaseEntityWithTime;

@Entity
@Table(name = "ACCOUNT_TABLE")
public class AccountEntity extends BaseEntityWithTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_IDX")
	private Long accountIdx;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CategoryEntity.class)
	@JoinColumn(name = "CATEGORY_IDX")
	private CategoryEntity category;
	
	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "TAX_RATE")
	private double taxRate;
	
	@Column(name = "TAX_INCLUDED")
	private boolean taxIncluded;
	
	@Column(name = "MEMO")
	private String memo;
	
	@Deprecated
	public AccountEntity() {
		// 하이버네이트용
	}
	
	/**
	 * <p>DTO를 통해 엔티티를 생성한다.</p>
	 * 
	 * @param dto 회계DTO
	 */
	public AccountEntity(AccountDTO dto) {
		this.category = new CategoryEntity(dto.getCategoryIdx());
		this.memo = dto.getMemo();
		this.price = dto.getPrice();
		this.taxRate = dto.getTaxRate();
		this.taxIncluded = dto.isTaxIncluded();
	}
	
	/**
	 * <p>회계IDX를 반환한다.</p>
	 * 
	 * @return 회계IDX
	 */
	public long getAccountIdx() {
		return accountIdx;
	}
	
	/**
	 * <p>카테고리를 반환한다.</p>
	 * 
	 * @return 카테고리
	 */
	public Optional<CategoryEntity> getCategory() {
		return Optional.of(category);
	}
	
	/**
	 * <p>가격을 반환한다.</p>
	 * 
	 * @return 가격
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * <p>세율을 반환한다.</p>
	 * 
	 * @return 세율
	 */
	public double getTaxRate() {
		return taxRate;
	}
	
	/**
	 * <p>세금포함 여부를 반환한다.</p>
	 * 
	 * @return 세금포함여부
	 */
	public boolean isTaxInclude() {
		return taxIncluded;
	}
	
	/**
	 * <p>메모를 반환한다.</p>
	 * 
	 * @return 메모
	 */
	public String getMemo() {
		return memo;
	}
}
