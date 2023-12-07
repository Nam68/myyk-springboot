package yk.web.myyk.util.enumerated;

public enum TaxRate implements BaseEnum {
	
	LOW("8%", 0.08),
	HIGH("10%", 0.1),
	;
	
	private String display;

	private double rate;
	
	private TaxRate(String display, double rate) {
		this.display = display;
		this.rate = rate;
	}

	@Override
	public String getValue() {
		return display;
	}
	
	public double getRate() {
		return rate;
	}

}
