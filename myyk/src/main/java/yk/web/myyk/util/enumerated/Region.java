package yk.web.myyk.util.enumerated;

/**
 * <p>지역에 대한 이넘.</p>
 */
public enum Region implements BaseEnum {

	KOREA("korea"),
	
	JAPAN("japan"),
	
	;
	
	private String value;
	
	Region(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}
	
}
