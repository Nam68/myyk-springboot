package yk.web.myyk.backend.logic.shared;

import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.util.exception.SystemException;

public abstract class BaseSharedLogic extends BaseLogic {

    /**
     * <p>검증.</p>
     *
     * @throws SystemException 시스템에러
     */
    protected abstract void validate() throws SystemException;

    /**
     * <p>실행.</p>
     *
     * @throws SystemException 시스템에러
     */
    public abstract void execute() throws SystemException;

}
