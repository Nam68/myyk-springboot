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

    public class MemberHolder extends BaseHolder {

        /**
         * <p>이메일.</p>
         */
        private String email = "";

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
            this.email = dto.getEmail();
            this.nickname = dto.getNickname();
        }

        /**
         * <p>이메일을 반환한다.</p>
         * 
         * @return 이메일
         */
        public String getEmail() {
            return email;
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
