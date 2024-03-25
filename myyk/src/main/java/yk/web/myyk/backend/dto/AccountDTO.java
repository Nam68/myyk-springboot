package yk.web.myyk.backend.dto;

public class AccountDTO {

    private long categoryIdx;

    private long subCategoryIdx;

    private int price;

    private boolean taxInclude;

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

    public boolean isTaxInclude() {
        return taxInclude;
    }

    public void setTaxInclude(boolean taxInclude) {
        this.taxInclude = taxInclude;
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
