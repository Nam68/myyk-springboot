package yk.web.myyk.backend.logic.shared;

import yk.web.myyk.util.exception.SystemException;

public abstract class BaseSharedLogic {

	public abstract void validate() throws SystemException;
	
	public abstract void execute() throws SystemException;
	
}
