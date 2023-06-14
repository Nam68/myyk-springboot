package yk.web.myyk.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class MailDTO {

	private String fromAddress;
	private List<String> toAddressList;
	private String title;
	private String content;
	
	@Deprecated
	public MailDTO() {
		// 하이버네이트용
	}
	
	public String getFromAddress() {
		return fromAddress;
	}
	
	public List<String> getToAddressList() {
		return toAddressList;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String content() {
		return content;
	}
	
	public void setFormAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public void setToAddressList(List<String> toAddressList) {
		this.toAddressList = toAddressList;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void initToAddressList() {
		this.toAddressList = new ArrayList<String>();
	}
	
	public void addToAddress(String toAddress) {
		if (toAddressList == null) {
			initToAddressList();
		}
		toAddressList.add(toAddress);
	}
	
	
}
