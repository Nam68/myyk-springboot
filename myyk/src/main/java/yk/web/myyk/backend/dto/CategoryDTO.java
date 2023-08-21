package yk.web.myyk.backend.dto;

public abstract class CategoryDTO<T extends CategoryDTO<T>> {

	private long categoryIdx;
	
	private String name;
	
	public CategoryDTO(long categoryIdx, String name) {
		this.categoryIdx = categoryIdx;
		this.name = name;
	}
	
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract T getOption();
	
}
