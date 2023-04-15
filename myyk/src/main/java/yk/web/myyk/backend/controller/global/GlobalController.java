package yk.web.myyk.backend.controller.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.repository.MemberRepository;

@Controller
public class GlobalController extends BaseController {
	
	@Autowired
	MemberRepository m;
	
	@RequestMapping({"/", "/global/homepage.do"})
	public String homepage() {
		
		List<MemberEntity> list = m.findAll();
		
		return "global/homepage";
	}

}