package yk.web.myyk.backend.service;

import yk.web.myyk.util.exception.SystemException;

public interface EmailService {

	public void sendEmailConfirm(String email) throws SystemException;
	
	public String checkTmpCode(int tmpCode) throws SystemException;
	
}
