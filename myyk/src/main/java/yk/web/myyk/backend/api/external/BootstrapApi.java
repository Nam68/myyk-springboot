package yk.web.myyk.backend.api.external;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.service.external.CheckBootstrapIcon;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.ApiException;

@RestController
@RequestMapping("/bootstrap")
public class BootstrapApi extends BaseApi {

    @RequestMapping(path = "/checkIconName", method = RequestMethod.POST)
    public String checkBootStrapIconName(String iconName) {
        try {
            CheckBootstrapIcon logic = getService().getCheckBootstrapIcon();
            logic.setIconName(iconName);
            logic.validate();
        } catch (ApiException e) {
            return e.getCode();
        }
        return Error.SUCCESS.getValue();
    }

}
