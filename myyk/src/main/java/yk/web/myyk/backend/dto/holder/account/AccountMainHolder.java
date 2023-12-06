package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>가계부 메인 홀더.</p>
 */
public class AccountMainHolder extends BaseHolder {

    /**
     * <p>가계부 리스트.</p>
     */
    private List<String> accountList = new ArrayList<>();

    /**
     * <p>가계부 리스트를 반환한다.</p>
     * 
     * @return 가계부
     */
    public List<String> getAccountList() {
        return accountList;
    }
}
