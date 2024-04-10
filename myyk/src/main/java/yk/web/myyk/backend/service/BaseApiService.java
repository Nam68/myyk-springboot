package yk.web.myyk.backend.service;

import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.SystemException;

public interface BaseApiService {

    /**
     * <p>검증한다.</p>
     */
    public void validate() throws SystemException, ApiException;

    /**
     * <p>실행한다.</p>
     */
    public void excute() throws SystemException, ApiException;

}
