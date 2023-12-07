package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.ACCOUNT)
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/book")
public class AccountBookController extends BaseController {

	/**
	 * <p>가계부 대시보드.</p>
	 * 
	 * @param request 리퀘스트
	 * @param accountBookIdx 가계부 IDX
	 * @return 뷰
	 * @throws SystemException 시스템 에러
	 */
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Long accountBookIdx) throws SystemException {
		
		// 가계부 리스트
//		List<AccountBookDTO> bookList = getService().getAccountBook().getAuthList(getLoginInfo().getMemberIdx());
//		request.setAttribute(LIST, bookList);
		
		// 대시보드 가계부
//		AccountBookDTO dto = getService().getAccountBook().getAccountBook(accountBookIdx);
//		request.setAttribute(DTO, dto);
		
		// 회계목록
//		List<AccountDTO> accountList = getService().getAccount().

		return "account/dashboard";
	}
	
	/**
	 * <p>가계부 작성 화면.</p>
	 * 
	 * @param request 리퀘스트
	 * @return 뷰
	 * @throws SystemException 시스템 에러
	 */
	@RequestMapping("/createInput")
	public String createInput(HttpServletRequest request) throws SystemException {
//		List<MemberDto> memberList = getService().getMember().findAllAdminAndMember(getLoginInfo());
//		request.setAttribute(LIST, memberList);
		return "account/createAccountInput";
	}
	
	/**
	 * <p>가계부 작성 완료.</p>
	 * 
	 * @param dto DTO
	 * @param session 세션
	 * @return 리다이렉트
	 * @throws SystemException 시스템 에러
	 */
	@RequestMapping(path = "/create", method =  RequestMethod.POST)
	public String createConfirm(AccountBookDTO dto, HttpSession session) throws SystemException {
		getService().getAccountBook().createBook(dto);
		return "redirect:/account/book/dashboard";
	}

}
