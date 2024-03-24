package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.account.AccountBookService;
import yk.web.myyk.backend.service.account.AccountService;
import yk.web.myyk.backend.service.account.CategoryService;
import yk.web.myyk.backend.service.external.BootstrapService;
import yk.web.myyk.backend.service.login.Login;
import yk.web.myyk.backend.service.member.CreateMember;
import yk.web.myyk.backend.service.member.CreateTmpMember;
import yk.web.myyk.backend.service.member.EmailService;
import yk.web.myyk.backend.service.member.FindEmailByTmpCode;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ServiceFactory {

    @Autowired
    private Login login;

    @Autowired
    private CreateTmpMember createTmpMember;

    @Autowired
    private FindEmailByTmpCode findEmailbyTmpCode;

    @Autowired
    private CreateMember createMember;





    @Autowired
    private EmailService emailService;

    @Autowired
    private AccountBookService accountBookService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BootstrapService bootstrapService;

    public EmailService getEmail() {
        return emailService;
    }

    public AccountBookService getAccountBook() {
        return accountBookService;
    }

    public AccountService getAccount() {
        return accountService;
    }

    public CategoryService getCategory() {
        return categoryService;
    }

    public BootstrapService getBootstrap() {
        return bootstrapService;
    }






    public Login getLogin() {
        return login;
    }

    public CreateTmpMember getCreateTmpMember() {
        return createTmpMember;
    }

    public FindEmailByTmpCode getFindEmailByTmpCode() {
        return findEmailbyTmpCode;
    }

    public CreateMember getCreateMember() {
        return createMember;
    }
}
