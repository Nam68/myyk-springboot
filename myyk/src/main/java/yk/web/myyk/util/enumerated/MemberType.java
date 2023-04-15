package yk.web.myyk.util.enumerated;

/**
 * <p>회원 등급에 대한 이넘.</p>
 */
public enum MemberType implements BaseEnum {

	NO_LOGIN("noLogin"),
	
	TMP_MEMBER("tmpMember"),
	
	MEMBER("member"),
	
	ADMIN("admin"),
	
	BANNED("banned"),
	
	WITHDRAW("withdraw"),
	
	;
	
	private String value;
	
	MemberType(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}
}
