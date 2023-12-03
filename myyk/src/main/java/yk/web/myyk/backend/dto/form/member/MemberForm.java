package yk.web.myyk.backend.dto.form.member;

import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>회원 폼.</p>
 */
public class MemberForm extends BaseForm {

    /**
     * <p>이메일 로컬파트.</p>
     */
    private String emailLocalpart;

    /**
     * <p>이메일 도메인</p>
     */
    private String emailDomain;

    /**
     * <p>비밀번호.</p>
     */
    private String password;

    /**
     * <p>비밀번호 확인.</p>
     */
    private String passwordCheck;

    /**
     * <p>닉네임.</p>
     */
    private String nickname;

    /**
     * <p>지역.</p>
     */
    private Region region;

    /**
     * <p>회원 등급.</p>
     */
    private MemberType memberType;

    /**
     * <p>회원 아이콘.</p>
     */
    private String memberIcon;

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     * 
     * @return 이메일 로컬파트
     */
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    /**
     * <p>이메일 로컬파트를 설정한다.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     */
    public void setEmailLocalpart(String emailLocalpart) {
        this.emailLocalpart = emailLocalpart;
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
     * <p>이메일 도메인을 설정한다.</p>
     * 
     * @param emailDomain 이메일 도메인
     */
    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    /**
     * <p>비밀번호를 반환한다.</p>
     * 
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>비밀번호를 설정한다.</p>
     * 
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>비밀번호 확인을 반환한다.</p>
     * 
     * @return 비밀번호 확인
     */
    public String getPasswordCheck() {
        return passwordCheck;
    }

    /**
     * <p>비밀번호 확인을 설정한다.</p>
     * 
     * @param passwordCheck 비밀번호 확인
     */
    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
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
     * <p>닉네임을 설정한다.</p>
     * 
     * @param nickname 닉네임
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * <p>지역을 반환한다.</p>
     * 
     * @return 지역
     */
    public Region getRegion() {
        return region;
    }

    /**
     * <p>지역을 설정한다.</p>
     * 
     * @param region 지역
     */
    public void setRegion(Region region) {
        this.region = region;
    }
}
