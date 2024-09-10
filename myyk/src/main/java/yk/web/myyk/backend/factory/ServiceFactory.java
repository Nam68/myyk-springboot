package yk.web.myyk.backend.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import yk.web.myyk.backend.service.account.CreateAccountBook;
import yk.web.myyk.backend.service.account.FindAccountBookByIdx;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.backend.service.category.CreateCategory;
import yk.web.myyk.backend.service.category.CreateSubCategory;
import yk.web.myyk.backend.service.category.CreateSubCategoryCardHtml;
import yk.web.myyk.backend.service.category.DeleteSubCategory;
import yk.web.myyk.backend.service.category.FindCategory;
import yk.web.myyk.backend.service.category.FindSubCategory;
import yk.web.myyk.backend.service.category.SearchBasicCategory;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
import yk.web.myyk.backend.service.category.SearchSubCategoryByCategory;
import yk.web.myyk.backend.service.category.UpdateSubCategory;
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

    /**
     * 가계부
     */

    @Autowired
    private CreateAccountBook createAccountBook;

    @Autowired
    private FindAccountBookByIdx findAccountBookByIdx;

    @Autowired
    private FindAccountBookByWriteAuth findAccountBookByWriteAuth;

    /**
     * 카테고리
     */

    @Autowired
    private CreateCategory createCategory;

    @Autowired
    private FindCategory findCategory;

    @Autowired
    private SearchCategoryByMember searchCategoryByMember;

    @Autowired
    private SearchBasicCategory searchBasicCategory;

    /**
     * 서브 카테고리
     */

    @Autowired
    private CreateSubCategory createSubCategory;

    @Autowired
    private UpdateSubCategory updateSubCategory;

    @Autowired
    private DeleteSubCategory deleteSubCategory;

    @Autowired
    private FindSubCategory findSubCategory;

    @Autowired
    private SearchSubCategoryByCategory searchSubCategoryByCategory;

    @Autowired
    private CreateSubCategoryCardHtml createSubCategoryCardHtml;

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

    public CreateAccountBook getCreateBook()  {
        return createAccountBook;
    }

    public FindAccountBookByIdx getFindBookByIdx() {
        return findAccountBookByIdx;
    }

    public FindAccountBookByWriteAuth getFindBookByWriteAuth() {
        return findAccountBookByWriteAuth;
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

    public SearchBasicCategory getSearchBasicCategory() {
        return searchBasicCategory;
    }

    public CreateSubCategory getCreateSubCategory() {
        return createSubCategory;
    }

    public UpdateSubCategory getUpdateSubCategory() {
        return updateSubCategory;
    }

    public DeleteSubCategory getDeleteSubCategory() {
        return deleteSubCategory;
    }

    public FindSubCategory getFindSubCategory() {
        return findSubCategory;
    }

    public SearchSubCategoryByCategory getSearchSubCategoryByCategory() {
        return searchSubCategoryByCategory;
    }

    public CreateSubCategoryCardHtml getCreateSubCategoryCardHtml() {
        return createSubCategoryCardHtml;
    }

    public CheckBootstrapIcon getCheckBootstrapIcon() {
        return checkBootstrapIcon;
    }
}
