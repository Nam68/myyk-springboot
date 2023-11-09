package yk.web.myyk.backend.dto;

public class AccountDTO {

	private long categoryIdx;
	
	private long subCategoryIdx;
	
	private int price;
	
	private boolean taxIncluded;

	private double taxRate;
	
	private String memo;
	
	@Deprecated
	public AccountDTO() {
		// nop
	}
	
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	public void setCategoryIdx(long categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	
	public long getSubCategoryIdx() {
		return subCategoryIdx;
	}
	
	public void setSubCategoryIdx(long subCategoryIdx) {
		this.subCategoryIdx = subCategoryIdx;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean isTaxIncluded() {
		return taxIncluded;
	}
	
	public void setTaxIncluded(boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
