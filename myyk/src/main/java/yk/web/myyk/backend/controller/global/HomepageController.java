package yk.web.myyk.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>홈페이지 컨트롤러.</p>
 */
@Controller
public class HomepageController extends BaseController {

    /**
     * <p>홈페이지 화면.</p>
     * 
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping({"/", "/homepage"})
    public String index() throws SystemException {
        return "homepage";
    }

}
