package yk.web.myyk.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import yk.web.myyk.backend.BaseMvc;

@MappedSuperclass
public class BaseEntity extends BaseMvc {

    @Column(name = "DELETED")
    private boolean deleted;

    /**
     * <p>논리삭제 여부를 반환한다.</p>
     *
     * @return 논리삭제 여부
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * <p>논리삭제 여부를 설정한다.</p>
     *
     * @param deleted 논리삭제 여부
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
