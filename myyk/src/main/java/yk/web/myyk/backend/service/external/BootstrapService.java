package yk.web.myyk.backend.service.external;

import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.ApiException;

public interface BootstrapService {

	/**
	 * <p>아이콘 이름이 존재하는 이름인지를 확인한다.</p>
	 * 
	 * @param iconName 아이콘이름
	 * @return 에러
	 * @throws ApiException API에러
	 */
	public Error checkIconName(String iconName) throws ApiException;
	
}
