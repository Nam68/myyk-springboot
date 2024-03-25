package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.service.BaseService;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

public interface CreateAccount extends BaseService {

    public void setAccountName(String accountName);

    public void setTaxInclude(boolean taxInclude);

    public void setTaxRate(TaxRate taxRate);

    public void setCurrency(Currency currency);

    public void setReadAuthList(List<Long> readAuthList);

    public void setWriteAuthList(List<Long> writeAuthList);
}
