package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.annotation.RegionSetter;
import yk.web.myyk.util.annotation.TaxRateSetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.ACCOUNT)
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account")
public class AccountBookController extends BaseController {

	@RequestMapping("/dashboard")
	@TaxRateSetter
	public String dashboard(HttpServletRequest request, Long accountBookIdx) throws SystemException {
		
		// 가계부 리스트
		List<AccountBookDTO> bookList = getService().getAccountBook().getAuthList(getLoginInfo().getMemberIdx());
		request.setAttribute(LIST, bookList);
		
		// 대시보드 가계부
		AccountBookDTO dto = getService().getAccountBook().getAccountBook(accountBookIdx);
		request.setAttribute(DTO, dto);

		return "account/dashboard";
	}
	
	@RequestMapping("/createInput")
	@RegionSetter
	public String createInput(HttpServletRequest request) throws SystemException {
		List<MemberDTO> memberList = getService().getMember().findAllAdminAndMember(getLoginInfo());
		request.setAttribute(LIST, memberList);
		return "account/createAccountInput";
	}
	
	@RequestMapping(path = "/create", method =  RequestMethod.POST)
	public String createConfirm(AccountBookDTO dto, HttpSession session) throws SystemException {
		getService().getAccountBook().createBook(dto);
		return "redirect:/account/dashboard";
	}

}
