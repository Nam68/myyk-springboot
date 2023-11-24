package yk.web.myyk.backend.logic.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.MemberService;
import yk.web.myyk.util.checker.MemberChecker;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
public class MemberLogic extends BaseLogic implements MemberService {

    @Override
    public void checkTmpMember(EmailForm emailForm) throws SystemException, AppException {

        String email = combineEmail(emailForm);

        // 이메일 양식 체크하기
        Map<String, ErrorCode> errors = MemberChecker.checkEmail(emailForm.getEmailLocalpart(), emailForm.getEmailDomain());
        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        // 중복된 이메일이 있는지 체크하기
        List<MemberEntity> memberList = getRepository().getMember().findAllByEmail(email);
        if (!memberList.isEmpty()) {
            throw new AppException(ErrorCode.EE_ME_104);
        }
    }

    @Override
    @Transactional
    public String createTmpMember(EmailForm emailForm) throws SystemException, AppException {

        String email = combineEmail(emailForm);
        String tmpCode = getRandomString(6);

        // 중복된 코드를 생성하지 않음
        while (getRepository().getTmpCode().findByTmpCode(tmpCode).isPresent()) {
            tmpCode = String.valueOf(getRandomInt(6));
        }

        TmpCodeEntity entity = new TmpCodeEntity(tmpCode, email);
        getRepository().getTmpCode().save(entity);

        return tmpCode;
    }
	
//	@Override
//	public Map<String, String> emailValidate(String email) throws SystemException {
//		Map<String, String> errors = new HashMap<>();
//		if (getRepository().getMember().findAllByEmail(encrypt(email)).size() > 0) {
//			errors.put("email", EMAIL_DUPLICATION_ERROR);
//		}
//		return errors;
//	}
//	
//	@Override
//	public Map<String, String> createVaildate(MemberDTO dto) throws SystemException {
//		Map<String, String> errors = new HashMap<>();
//		if (getRepository().getMember().findAllByNickname(dto.getNickname()).size() > 0) {
//			errors.put("nickname", NICKNAME_DUPLICATION_ERROR);
//		}
//		return errors;
//	}
//
//	@Override
//	@Transactional
//	public void create(MemberDTO dto) throws SystemException {
//		MemberEntity entity = new MemberEntity(dto);
//		getRepository().getMember().save(entity);
//	}
//	
//	@Override
//	public String findMailWithTmpCode(String tmpCode) throws SystemException {
//		Optional<TmpCodeEntity> tmpCodeEntity = getRepository().getTmpCode().findByTmpCode(hashing(tmpCode));
//		if (!tmpCodeEntity.isPresent()) {
//			throw new SystemException(ErrorCode.ET_101, TmpCodeEntity.class);
//		}
//		return tmpCodeEntity.get().getEmail();
//	}
//
//	@Override
//	public List<MemberDTO> findAllByMemberType(MemberType memberType) throws SystemException {
//		List<MemberEntity> list = getRepository().getMember().findAllByMemberType(memberType);
//		List<MemberDTO> result = new ArrayList<>();
//		
//		for (MemberEntity entity : list) {
//			result.add(new MemberDTO(entity));
//		}
//		return result;
//	}
//
//	@Override
//	public List<MemberDTO> findAllAdminAndMember() throws SystemException {
//		List<MemberEntity> adminList = getRepository().getMember().findAllByMemberType(MemberType.ADMIN);
//		List<MemberEntity> memberList = getRepository().getMember().findAllByMemberType(MemberType.MEMBER);
//		List<MemberDTO> result = new ArrayList<>();
//		
//		for (MemberEntity entity : adminList) {
//			result.add(new MemberDTO(entity));
//		}
//		for (MemberEntity entity : memberList) {
//			result.add(new MemberDTO(entity));
//		}
//		return result;
//	}
//	
//	@Override
//	public List<MemberDTO> findAllAdminAndMember(LoginInfo loginInfo) throws SystemException {
//		List<MemberDTO> memberList = findAllAdminAndMember();
//		
//		// 로그인한 본인은 제외하고 회원 리스트 작성
//		for (MemberDTO member : memberList) {
//			if (member.getMemberIdx() == loginInfo.getMemberIdx()) {
//				memberList.remove(member);
//				break;
//			}
//		}
//		return memberList;
//	}
}
