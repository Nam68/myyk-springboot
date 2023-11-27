package yk.web.myyk.backend.dto.form.member;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>임시코드 폼.</p>
 */
public class TmpCodeForm extends BaseForm {

    /**
     * <p>임시코드.</p>
     */
    private String tmpCode;

    /**
     * <p>생성자.</p>
     * 
     * @param tmpCode 임시코드
     */
    public TmpCodeForm(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    /**
     * <p>임시코드를 설정한다.</p>
     * 
     * @param tmpCode 임시코드
     */
    public void setTempCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    /**
     * <p>임시코드를 반환한다.</p>
     * 
     * @return 임시코드
     */
    public String getTmpCode() {
        return tmpCode;
    }
}
