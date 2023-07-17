package yk.web.myyk.util.enumerated;

import yk.web.myyk.util.exception.SystemException;

/**
 * <p>회원 등급에 대한 이넘.</p>
 */
public enum MemberType implements BaseEnum {

	BANNED("banned", -2),
	
	WITHDRAW("withdraw", -1),
	
	NO_LOGIN("noLogin", 0),
	
	TMP_MEMBER("tmpMember", 1),
	
	MEMBER("member", 2),
	
	ADMIN("admin", 3),
	
	;
	
	private String value;
	private int rank;
	
	MemberType(String value, int rank) {
		this.value = value;
		this.rank = rank;
	}
	
	@Override
	public String getValue() {
		return value;
	}
	
	public int getRank() {
		return rank;
	}
	
	public static boolean hasAdminAuthority(MemberType memberType) {
		return ADMIN.equals(memberType);
	}
	
	public static boolean hasMemberAuthority(MemberType memberType) {
		return memberType.getRank() >= MemberType.MEMBER.getRank();
	}
	
	public static MemberType getNexRank(MemberType memberType) {
		int rank = memberType.getRank() + 1;
		for (MemberType type : MemberType.values()) {
			if (type.getRank() == rank) {
				return type;
			}
		}
		throw new SystemException("Admin type can not get next rank.");
	}
}
