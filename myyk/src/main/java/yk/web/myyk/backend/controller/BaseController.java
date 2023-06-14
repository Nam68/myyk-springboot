package yk.web.myyk.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.backend.service.EmailService;
import yk.web.myyk.util.mail.MailTemplate;

public class BaseController extends BaseMvc {
	
	@Autowired
	private ServiceFactory serviceFactory;
	
	protected ServiceFactory getService() {
		return serviceFactory;
	}


}
