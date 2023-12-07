package yk.web.myyk.backend.entity.account;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>가계부 엔티티.</p>
 */
@Entity
@Table(name = "ACCOUNT_BOOK_TBL")
public class AccountBookEntity extends BaseEntityWithTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_BOOK_IDX")
	private Long accountBookIdx;
	
	@Column(name = "KO_BOOK_NAME")
	private String koBookName;
	
	@Column(name = "JP_BOOK_NAME")
	private String jpBookName;
	
	// 통화 등
	@Column(name = "REGION")
	@Enumerated(EnumType.STRING)
	private Region region;
	
	// 단순한 다대다이므로 사용하기 어려워서 패스
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "accountBookList")
//	private List<MemberEntity> writableMember;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountBook")
	private List<AccountBookAuthEntity> authList = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountBook")
	@OrderBy("categoryIdx ASC")
	private List<CategoryEntity> categoryList = new ArrayList<>();
	
	@Deprecated
	public AccountBookEntity() {
		// 하이버네이트용
	}
	
	public AccountBookEntity(AccountBookDTO dto) {
		this.koBookName = dto.getKoBookName();
		this.jpBookName = dto.getJpBookName();
		this.region = dto.getRegion();
	}
	
	public long getAccountBookIdx() {
		return accountBookIdx;
	}
	
	public String getKoBookName() {
		return koBookName;
	}
	
	public String getJpBookName() {
		return jpBookName;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public List<CategoryEntity> getCategoryList() {
		return categoryList;
	}
	
	/**
	 * @deprecated 가급적 레포지토리를 통해서 정렬을 해서 불러올 것.
	 */
	@Deprecated
	public List<AccountBookAuthEntity> getAuthList() {
		return authList;
	}
}
