package yk.web.myyk.backend.logic.external;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.service.external.BootstrapService;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.ApiException;

@Service
public class BootstrapLogic extends BaseExternalLogic implements BootstrapService {

    @Override
    public Error checkIconName(String iconName) throws ApiException {
        HttpsURLConnection conn = getConn(ExternalURL.BOOTSTRAP_ICON);
        String html = read(conn);
        if (html.contains(iconName)) {
            return Error.SUCCESS;
        } else {
            return Error.ERROR;
        }
    }

}
