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
    private String tmpCode;

    @Column(name = "EMAIL")
    private String email;
    
    @Deprecated
    public TmpCodeEntity() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param tmpCode 임시코드
     * @param email 이메일
     */
    public TmpCodeEntity(String tmpCode, String email) {
        this.tmpCode = hashing(tmpCode);
        this.email = encrypt(email);
    }

    /**
     * <p>이메일을 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmail() {
        return decrypt(email);
    }

}
