package yk.web.myyk.backend.dto;
import java.util.List;

import yk.web.myyk.util.enumerated.Region;

public class AccountBookDTO {

	private Long accountBookIdx;

	private String koBookName;

	private String jpBookName;

	private Region region;

	private List<Integer> watchableIdx;

	private List<Integer> writableIdx;

	@Deprecated
	public AccountBookDTO() {
		// jpa용
	}

//	public AccountBookDTO(AccountBookEntity entity) {
//		this.accountBookIdx = entity.getAccountBookIdx();
//		this.koBookName = entity.getKoBookName();
//		this.jpBookName = entity.getJpBookName();
//		this.region = entity.getRegion();
//
//		SortCategoryList sortCategoryList = new SortCategoryList();
//		sortCategoryList.setCatoryEntityList(entity.getCategoryList());
//		sortCategoryList.execute();
//		this.categoryList = sortCategoryList.getPrimeCategoryDto();
//	}

	public void setAccountBookIdx(long accountBookIdx) {
		this.accountBookIdx = accountBookIdx;
	}

	public long getAccountBookIdx() {
		return accountBookIdx;
	}

	public void setKoBookName(String koBookName) {
		this.koBookName = koBookName;
	}

	public String getKoBookName() {
		return koBookName;
	}

	public void setJpBookName(String jpBookName) {
		this.jpBookName = jpBookName;
	}

	public String getJpBookName() {
		return jpBookName;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	public void setWatchableIdx(List<Integer> watchableIdx) {
		this.watchableIdx = watchableIdx;
	}

	public List<Integer> getWatchableIdx() {
		return watchableIdx;
	}

	public void setWritableIdx(List<Integer> writableIdx) {
		this.writableIdx = writableIdx;
	}

	public List<Integer> getWritableIdx() {
		return writableIdx;
	}

}
