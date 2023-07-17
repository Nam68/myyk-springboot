package yk.web.myyk.util.exception;

import yk.web.myyk.util.enumerated.BaseEnum;
import yk.web.myyk.util.enumerated.MemberType;

public class PermissionException extends RuntimeException {

	private static final long serialVersionUID = 6184374754016436467L;
	
	private String status;
	
	private String memberType;
	
	public PermissionException(PermissionStatus status, MemberType memberType) {
		this.status = status.getValue();
		this.memberType = memberType.getValue();
	}
	
	public String getPermissionStatus() {
		return status;
	}
	
	public String getMemberType() {
		return memberType;
	}
	
	public enum PermissionStatus implements BaseEnum {
		
		/**
		 * <p>허용 회원 등급에 미치지 못했을 때의 에러.</p>
		 */
		PERMITTED("permitted"),
		
		/**
		 * <p>금지된 회원 등급인 경우의 에러.</p>
		 */
		DENIED("denied")
		;
		
		private String permissionStatus;
		private PermissionStatus(String permissionStatus) {
			this.permissionStatus = permissionStatus;
		}
		
		@Override
		public String getValue() {
			return permissionStatus;
		}
	}
}
