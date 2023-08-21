package yk.web.myyk.backend.dto;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class PrimeCategoryDTO extends CategoryDTO<PrimeCategoryDTO> {
	
	private String icon;
	
	private String color;
	
	private List<SubCategoryDTO> subCategoryList = new ArrayList<>();
	
	public PrimeCategoryDTO(CategoryEntity entity) {

		super(entity.getCategoryIdx(), entity.getName());
		
		if (!entity.isPrime()) {
			throw new SystemException(ErrorCode.CG_104, PrimeCategoryDTO.class);
		}
		
		this.icon = entity.getIcon();
		this.color = entity.getColor();
		
		for (CategoryEntity sub : entity.getSubCatetoryList()) {
			SubCategoryDTO subDto = new SubCategoryDTO(sub);
			subCategoryList.add(subDto);
		}
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public List<SubCategoryDTO> getSubCategoryList() {
		return subCategoryList;
	}

	@Override
	public PrimeCategoryDTO getOption() {
		return this;
	}
}
