package yk.web.myyk.backend.service.external;

import yk.web.myyk.backend.service.BaseApiService;

/**
 * <p>아이콘 이름이 존재하는 이름인지를 확인하는 서비스.</p>
 */
public interface CheckBootstrapIcon extends BaseApiService {

    /**
     * <p>아이콘 이름을 설정한다.</p>
     *
     * @param iconName 아이콘 이름
     */
    public void setIconName(String iconName);
}
