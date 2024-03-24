package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>회원가입 홀더.</p>
 */
public class CreateMemberHolder extends BaseHolder {

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
     * <p>닉네임 타언어.</p>
     */
    private String nicknameLang = "";

    /**
     * <p>지역.</p>
     */
    private Region region = Region.KOREA;

    /**
     * <p>생성자.</p>
     */
    public CreateMemberHolder() {
        // nop
    }

    /**
     * <p>생성자.</p>
     *
     * @param form 회원 정보.
     */
    public CreateMemberHolder(MemberForm form) {
        this.emailLocalpart = form.getEmailLocalpart();
        this.emailDomain = form.getEmailDomain();
        this.nickname = form.getNickname();
        this.nicknameLang = form.getNicknameLang();
        this.region = form.getRegion();
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
     * <p>닉네임 타언어를 반환한다.</p>
     *
     * @return 닉네임 타언어
     */
    public String getNicknameLang() {
        return nicknameLang;
    }

    /**
     * <p>지역을 반환한다.</p>
     *
     * @return 지역
     */
    public Region getRegion() {
        return region;
    }
}
