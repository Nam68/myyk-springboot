package yk.web.myyk.backend.dto;

public abstract class CategoryDTO<T extends CategoryDTO<T>> {

	private long categoryIdx;
	
	private String koCategoryName;
	
	private String jpCategoryName;
	
	private long accountBookIdx;
	
	@Deprecated
	public CategoryDTO() {
		// 프레임워크용
	}
	
	public CategoryDTO(long categoryIdx, String koCategoryName, String jpCategoryName) {
		this.categoryIdx = categoryIdx;
		this.koCategoryName = koCategoryName;
		this.jpCategoryName = jpCategoryName;
	}
	
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	public void setKoCategoryName(String koCategoryName) {
		this.koCategoryName = koCategoryName;
	}
	
	public String getKoCategoryName() {
		return koCategoryName;
	}
	
	public void setJpCategoryName(String jpCategoryName) {
		this.jpCategoryName = jpCategoryName;
	}
	
	public String getJpCategoryName() {
		return jpCategoryName;
	}
	
	public void setAccountBookIdx(long accountBookIdx) {
		this.accountBookIdx = accountBookIdx;
	}
	
	public long getAccountBookIdx() {
		return this.accountBookIdx;
	}
	
	public abstract T getOption();
	
}
