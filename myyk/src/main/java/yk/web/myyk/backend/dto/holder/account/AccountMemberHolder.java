package yk.web.myyk.backend.dto.holder.account;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>가계부 회원 홀더.</p>
 */
public class AccountMemberHolder extends BaseHolder {

    /**
     * <p>회원 IDX.</p>
     */
    private long memberIdx = 0;

    /**
     * <p>이메일 로컬파트.</p>
     */
    private String emailLocalpart = "";

    /**
     * <p>이메일 도메인.</p>
     */
    private String emailDomain = "";

    /**
     * <p>닉네임.</p>
     */
    private String nickname = "";

    /**
     * <p>쓰기 권한.</p>
     */
    private boolean writable = false;

    /**
     * <p>생성자.</p>
     *
     * @param dto 회원 DTO
     */
    public AccountMemberHolder(MemberDTO dto) {
        String[] email = dto.getEmail().split("@");
        this.emailLocalpart = email[0];
        this.emailDomain = email[1];
        this.memberIdx = dto.getMemberIdx();
        this.nickname = dto.getNickname();
    }

    /**
     * <p>회원 IDX를 반환한다.</p>
     *
     * @return 회원IDX
     */
    public long getMemberIdx() {
        return memberIdx;
    }

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     *
     * @return 이메일 로컬파트
     */
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    /**
     * <p>이메일 도메인을 반환한다.</p>
     *
     * @return 이메일 도메인
     */
    public String getEmailDomain() {
        return emailDomain;
    }

    /**
     * <p>닉네임을 반환한다.</p>
     *
     * @return 닉네임
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * <p>쓰기 권한 여부를 설정한다.</p>
     *
     * @param writable 쓰기 권한 여부
     */
    public void setWritable(boolean writable) {
        this.writable = writable;
    }

    /**
     * <p>쓰기 권한 여부를 반환한다.</p>
     *
     * @return
     */
    public boolean isWritable() {
        return writable;
    }
}
