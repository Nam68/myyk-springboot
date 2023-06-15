package yk.web.myyk.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.config.AppConstants;

public class BaseApp {
	
	@Autowired
	private AppConstants appConstants;
	
	protected AppConstants getConstants() {
		return appConstants;
	}

	/**
	 * <p>난수를 발생시킨다</p>
	 * 
	 * @param digit 난수의 자릿수
	 * @return 난수
	 */
	protected int getRandomInt(int digit) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digit; i++) {
			sb.append(String.valueOf(random.nextInt(9)));
		}
		return Integer.parseInt(sb.toString());
	}
	
}
