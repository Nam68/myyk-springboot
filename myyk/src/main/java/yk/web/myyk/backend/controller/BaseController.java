package yk.web.myyk.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.factory.ServiceFactory;

public class BaseController extends BaseMvc {
	
	protected static final String ERRORS = "errors";
	
	protected static final String DTO = "dto";
	
	protected static final String LIST = "list";
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	protected ServiceFactory getService() {
		return serviceFactory;
	}


}
