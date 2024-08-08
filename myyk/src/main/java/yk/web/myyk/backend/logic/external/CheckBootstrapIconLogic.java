package yk.web.myyk.backend.logic.external;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.service.external.CheckBootstrapIcon;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CheckBootstrapIconLogic extends BaseExternalLogic implements CheckBootstrapIcon {

    private String iconName;

    @Override
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public void validate() throws SystemException, ApiException {

        if (iconName == null || "".equals(iconName)) {
            throw new ApiException(ErrorCode.EE_CA_107, CheckBootstrapIconLogic.class);
        }

        String html = read(getConn(ExternalURL.BOOTSTRAP_ICON));
        if (!html.contains(iconName)) {
            throw new ApiException(ErrorCode.EE_CA_108, CheckBootstrapIconLogic.class);
        }
    }

    @Override
    public void excute() throws SystemException, ApiException {
        validate();
    }
}
