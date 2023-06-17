package yk.web.myyk.util.enumerated;

import java.util.List;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>지역에 대한 이넘.</p>
 */
public enum Region implements BaseEnum {

	KOREA("ko"),
	
	JAPAN("jp"),
	
	;
	
	private String value;
	
	Region(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	public static Region getRegion(String region) {
		for (Region target : Region.values()) {
			if (region.equals(target.getValue())) {
				return target;
			}
		}
		throw new SystemException(ErrorCode.getErrorMessage(ErrorCode.EN_101, Region.class));
	}
	
}
