package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.holder.BaseHolder;

public class CreateAccountHolder extends BaseHolder {

    /**
     * <p>회원 리스트(본인 제외).</p>
     */
    private List<MemberHolder> memberList = new ArrayList<>();

    /**
     * <p>생성자.</p>
     * 
     * @param memberList 회원 리스트(본인 제외).
     */
    public CreateAccountHolder(List<MemberDto> memberDtoList) {
        for (MemberDto dto : memberDtoList) {
            memberList.add(new MemberHolder(dto));
        }
    }

    /**
     * <p>회원 리스트(본인 제외)를 반환한다.</p>
     * 
     * @return 회원 리스트(본인 제외)
     */
    public List<MemberHolder> getMemberList() {
        return memberList;
    }

    public class MemberHolder extends BaseHolder {

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
         * <p>생성자.</p>
         * 
         * @param email 이메일
         * @param nickname 닉네임
         */
        public MemberHolder(MemberDto dto) {
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
    }
}
