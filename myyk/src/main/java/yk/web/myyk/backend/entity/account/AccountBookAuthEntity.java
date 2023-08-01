package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;

@Entity
@Table(name = "ACCOUNT_BOOK_AUTH_TBL")
public class AccountBookAuthEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_BOOK_AUTH_IDX")
	private Long accountBookAuthIdx;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = MemberEntity.class)
	@JoinColumn(name = "MEMBER_IDX")
	private MemberEntity member;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccountBookEntity.class)
	@JoinColumn(name = "ACCOUNT_BOOK_IDX")
	private AccountBookEntity accountBook;
	
	@Column(name = "WRITABLE")
	private boolean writable;
	
	@Deprecated
	public AccountBookAuthEntity() {
		// 하이버네이트용
	}
	
	public AccountBookAuthEntity(MemberEntity member, AccountBookEntity accountBook) {
		this(member, accountBook, false);
		member.getAccountBookAuthList().add(this);
		accountBook.getAuthList().add(this);
	}
	
	public AccountBookAuthEntity(MemberEntity member, AccountBookEntity accountBook, boolean writable) {
		this.member = member;
		this.accountBook = accountBook;
		this.writable = writable;
		
		member.getAccountBookAuthList().add(this);
		accountBook.getAuthList().add(this);
	}
	
	public MemberEntity getMember() {
		return member;
	}
	
	public AccountBookEntity getAccountBook() {
		return accountBook;
	}
	
	public boolean getWritable() {
		return writable;
	}
	
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
}
