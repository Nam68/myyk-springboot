package yk.web.myyk.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {

	@Value("${value.tmpCode.limit}")
	private int tmpCodeLimitMinute;
	
	public int getTmpCodeLImitMinute() {
		return tmpCodeLimitMinute;
	}
	
}
