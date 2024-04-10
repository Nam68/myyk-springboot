package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.account.CreateAccountBook;
import yk.web.myyk.backend.service.account.CreateCategory;
import yk.web.myyk.backend.service.external.CheckBootstrapIcon;
import yk.web.myyk.backend.service.login.Login;
import yk.web.myyk.backend.service.member.CreateMember;
import yk.web.myyk.backend.service.member.CreateTmpMember;
import yk.web.myyk.backend.service.member.FindAllMemberByIdx;
import yk.web.myyk.backend.service.member.FindAllMemberExceptMyself;
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
    private FindAllMemberExceptMyself findAllMemberExceptMyself;

    @Autowired
    private FindAllMemberByIdx findAllMemberByIdx;

    @Autowired
    private CreateAccountBook createAccountBook;

    @Autowired
    private CreateCategory createCategory;

    @Autowired
    private CheckBootstrapIcon checkBootstrapIcon;

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

    public FindAllMemberExceptMyself getFindAllMemberExceptMyself() {
        return findAllMemberExceptMyself;
    }

    public FindAllMemberByIdx getFindAllMemberByIdx() {
        return findAllMemberByIdx;
    }

    public CreateAccountBook getCreateAccountBook()  {
        return createAccountBook;
    }

    public CreateCategory getCreateCategory() {
        return createCategory;
    }

    public CheckBootstrapIcon getCheckBootstrapIcon() {
        return checkBootstrapIcon;
    }
}
