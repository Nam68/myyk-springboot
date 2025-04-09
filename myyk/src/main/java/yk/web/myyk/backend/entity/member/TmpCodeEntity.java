package yk.web.myyk.backend.entity.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
        setDeleted(false);
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
