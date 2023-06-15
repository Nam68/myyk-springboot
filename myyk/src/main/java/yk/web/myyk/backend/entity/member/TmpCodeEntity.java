package yk.web.myyk.backend.entity.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntityWithTime;

@Entity
@Table(name = "TMP_CODE_TBL")
public class TmpCodeEntity extends BaseEntityWithTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TMP_CODE_IDX")
	private Long tmpCodeIdx;

	@Column(name = "TMP_CODE")
	private int tmpCode;

	@Column(name = "EMAIL")
	private String email;
	
	@Deprecated
	public TmpCodeEntity() {
		// nop
	}
	
	public TmpCodeEntity(int tmpCode, String email) {
		this.tmpCode = tmpCode;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
}