package yk.web.myyk.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.config.AppConstants;
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class BaseApp {
	
	private static final String SHA_256 = "SHA-256";
	private static final String AES = "AES";
	
	protected static final String LOGIN_INFO = "login_info";
	
	@Autowired
	private AppConstants appConstants;
	
	protected AppConstants getConstants() {
		return appConstants;
	}
	
	public static String getLoginInfoName() {
		return LOGIN_INFO;
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
	
	/**
	 * <p>난수 문자열을 발생시킨다.</p>
	 * 
	 * @param digit 문자열의 자릿수
	 * @return 난수 문자열
	 */
	protected String getRandomString(int digit) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digit; i++) {
			int start = random.nextInt(2) == 0 ? 'A' : 'a';
			char c = (char) (random.nextInt(26) + start);
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * <p>해싱을 한다.</p>
	 * 
	 * @param target 해싱 대상
	 * @param salt 솔트
	 * @param times 반복 횟수
	 * @return 해싱된 문자
	 */
	protected String hashing(String target, String salt, int times) {
		try {
			MessageDigest md = MessageDigest.getInstance(SHA_256);
			md.update((target + salt).getBytes());
			for (int i = 0; i < times; i++) {
				target = new String(md.digest());
				md.update((target + salt).getBytes());
			}
			return bytesToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException("Hashing is failed.");
		}
	}
	
	/**
	 * <p>해싱을 한다.</p>
	 * 
	 * @param target 해싱 대상
	 * @param salt 솔트
	 * @return 해싱된 문자
	 */
	protected String hashing(String target, String salt) {
		int times = AppConstants.getHashingTimes();
		return hashing(target, salt, times);
	}
	
	/**
	 * <p>해싱을 한다.</p>
	 * 
	 * @param target 해싱 대상
	 * @return 해싱된 문자
	 */
	protected String hashing(String target) {
		String salt = AppConstants.getHashingSalt();
		return hashing(target, salt);
	}
	
	/**
	 * <p>바이트 배열을 16진수 문자열로 반환한다.</p>
	 * 
	 * @param bytes 바이트 배열
	 * @return 16진수 문자열
	 */
	private String bytesToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			String str = Integer.toHexString(b);
			if (str.indexOf("f") > -1) {
				str = str.substring(str.lastIndexOf("f"), str.length());
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
	/**
	 * <p>암호화 키를 반환한다.</p>
	 * 
	 * @return 암호화 키
	 */
	private SecretKey getKey() {
		return new SecretKeySpec(AppConstants.getEncryptKey().getBytes(), AES);
	}
	
	/**
	 * <p>암호화한다.</p>
	 * 
	 * @param target 대상 문자열
	 * @return 암호화된 문자열
	 */
	protected String encrypt(String target) {
		try {
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			byte[] bytes = cipher.doFinal(target.getBytes());
			
			byte[] encodedBytes = encode(bytes);
			return new String(encodedBytes);
			
		} catch (NoSuchAlgorithmException 
				| NoSuchPaddingException 
				| InvalidKeyException 
				| IllegalBlockSizeException 
				| BadPaddingException e) {
			throw new SystemException(ErrorCode.CF_103, e.getClass());
		}
	}
	
	/**
	 * <p>복호화한다.</p>
	 * 
	 * @param target 대상 문자열
	 * @return 복호화된 문자열
	 */
	protected String decrypt(String target) {
		try {			
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, getKey());
			byte[] bytes = cipher.doFinal(decode(target.getBytes()));
			
			return new String(bytes);
			
		} catch (NoSuchAlgorithmException 
				| NoSuchPaddingException 
				| InvalidKeyException 
				| IllegalBlockSizeException 
				| BadPaddingException e) {
			e.printStackTrace();
			throw new SystemException(ErrorCode.CF_103, e.getClass());
		}
	}
	
	/**
	 * <p>Base64로 인코딩된 문자열을 디코딩한다.</p>
	 * 
	 * @param target 인코딩된 문자열
	 * @return 디코딩된 문자열
	 */
	protected String decode(String target) {
		return new String(decode(target.getBytes()));
	}
	
	/**
	 * <p>Base64로 인코딩된 바이트 배열을 디코딩한다.</p>
	 * 
	 * @param target 인코딩된 바이트 배열
	 * @return 디코딩된 바이트 배열
	 */
	protected byte[] decode(byte[] target) {
		return Base64.getDecoder().decode(target);
	}
	
	/**
	 * <p>문자열을 Base64로 인코딩한다.</p>
	 * 
	 * @param target 대상 문자열
	 * @return 인코딩된 문자열
	 */
	protected String encode(String target) {
		return new String(encode(target.getBytes()));
	}
	
	/**
	 * <p>바이트 배열을 Base64로 인코딩한다.</p>
	 * 
	 * @param target 대상 바이트 배열
	 * @return 인코딩된 바이트 배열
	 */
	protected byte[] encode(byte[] target) {
		return Base64.getEncoder().encode(target);
	}
	
}
