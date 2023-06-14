package yk.web.myyk.backend.api.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping("/member")
public class EmailApi extends BaseApi {
	
	@RequestMapping(path = "/checkTmpCode", method = RequestMethod.POST)
	public String checkTmpCode(int tmpCode) throws SystemException {
		return getService().getEmail().checkTmpCode(tmpCode);
	}

}
