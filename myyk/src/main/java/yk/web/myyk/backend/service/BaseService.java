package yk.web.myyk.backend.service;

import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

public interface BaseService {

    /**
     * <p>검증한다.</p>
     */
    public void validate() throws SystemException, AppException;

    /**
     * <p>실행한다.</p>
     */
    public void excute() throws SystemException, AppException;
}
