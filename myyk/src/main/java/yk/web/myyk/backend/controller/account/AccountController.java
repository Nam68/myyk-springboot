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
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.ACCOUNT)
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account")
public class AccountController extends BaseController {

	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request) throws SystemException {
		LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(LOGIN_INFO);
		List<AccountBookDTO> bookList = getService().accountBook().getAuthList(loginInfo.getMemberIdx());
		request.setAttribute(LIST, bookList);
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
		getService().accountBook().createBook(dto);
		return "redirect:/account/dashboard";
	}
	
}
