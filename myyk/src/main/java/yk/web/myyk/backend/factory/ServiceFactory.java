package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.account.CreateAccountBook;
import yk.web.myyk.backend.service.account.CreateCategory;
import yk.web.myyk.backend.service.account.CreateSubCategory;
import yk.web.myyk.backend.service.account.CreateSubCategoryCardHtml;
import yk.web.myyk.backend.service.account.DeleteSubCategory;
import yk.web.myyk.backend.service.account.FindCategory;
import yk.web.myyk.backend.service.account.SearchSubCategoryByCategory;
import yk.web.myyk.backend.service.account.SearchCategoryByMember;
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
    private FindCategory findCategory;

    @Autowired
    private SearchCategoryByMember searchCategoryByMember;

    /**
     * 서브 카테고리
     */

    @Autowired
    private CreateSubCategory createSubCategory;

    @Autowired
    private CreateSubCategoryCardHtml createSubCategoryCardHtml;

    @Autowired
    private SearchSubCategoryByCategory searchSubCategoryByCategory;

    @Autowired
    private DeleteSubCategory deleteSubCategory;

    /**
     * 외부 접속
     */

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

    public FindCategory getFindCategory() {
        return findCategory;
    }

    public SearchCategoryByMember getSearchCategoryByMember() {
        return searchCategoryByMember;
    }

    public CreateSubCategory getCreateSubCategory() {
        return createSubCategory;
    }

    public CreateSubCategoryCardHtml getCreateSubCategoryCardHtml() {
        return createSubCategoryCardHtml;
    }

    public SearchSubCategoryByCategory getSearchSubCategoryByCategory() {
        return searchSubCategoryByCategory;
    }

    public DeleteSubCategory getDeleteSubCategory() {
        return deleteSubCategory;
    }

    public CheckBootstrapIcon getCheckBootstrapIcon() {
        return checkBootstrapIcon;
    }
}
