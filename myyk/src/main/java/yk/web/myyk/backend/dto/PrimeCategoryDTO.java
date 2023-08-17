package yk.web.myyk.backend.dto;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class PrimeCategoryDTO {

	private long categoryIdx;
	
	private String name;
	
	private String icon;
	
	private String color;
	
	private List<SubCategoryDTO> subCategoryList = new ArrayList<>();
	
	public PrimeCategoryDTO(CategoryEntity entity) {
		
		if (!entity.isPrime()) {
			throw new SystemException(ErrorCode.CG_104, PrimeCategoryDTO.class);
		}
		
		this.categoryIdx = entity.getCategoryIdx();
		this.name = entity.getName();
		this.icon = entity.getIcon();
		this.color = entity.getColor();
		
		for (CategoryEntity sub : entity.getSubCatetoryList()) {
			SubCategoryDTO subDto = new SubCategoryDTO(sub);
			subCategoryList.add(subDto);
		}
	}
	
	public long getCategoryIdx() {
		return categoryIdx;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public String getColor() {
		return color;
	}
	
	public long getParentCategoryIdx() {
		return new CategoryEntity(false).getCategoryIdx();
	}
	
	public List<SubCategoryDTO> getSubCategoryList() {
		return subCategoryList;
	}
	
}
