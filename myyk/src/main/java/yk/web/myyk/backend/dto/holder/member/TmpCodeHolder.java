package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.holder.BaseHolder;

public class TmpCodeHolder extends BaseHolder {

    /**
     * <p>임시코드</p>
     */
    private String tmpCode = "";

    /**
     * <p>생성자.</p>
     *
     * @param emailLocalpart 이메일 로컬파트
     * @param emailDomain 이메일 도메인
     * @param tmpCode 임시코드
     */
    public TmpCodeHolder(String tmpCode) {
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
