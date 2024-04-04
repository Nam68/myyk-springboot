package yk.web.myyk.backend.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping(path = "/account", method = RequestMethod.POST)
public class AccountApi extends BaseApi {

	/**
	 * <p>회계를 등록한다.</p>
	 *
	 * @param dto 회계DTO
	 * @return 성공여부
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping("/create")
	public String createAccount(AccountDTO dto) throws ApiException {
		try {
//			getService().getAccount().createAccount(dto);
		} catch (SystemException e) {
			throw new ApiException(e.getMessage());
		}
		return Error.SUCCESS.getValue();
	}

}
