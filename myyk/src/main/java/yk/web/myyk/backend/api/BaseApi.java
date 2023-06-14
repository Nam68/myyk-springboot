package yk.web.myyk.backend.api;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.util.BaseApp;

public class BaseApi extends BaseApp {

	@Autowired
	private ServiceFactory serviceFactory;
	
	protected ServiceFactory getService() {
		return serviceFactory;
	}
	
}
