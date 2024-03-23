package yk.web.myyk.util.enumerated;

/**
 * <p>카테고리.</p>
 * <p>헤더, 푸터나 메뉴 등을 선별할 때 사용한다.</p>
 */
public enum Category implements BaseEnum {

    HOME,
    MEMBER,
    WISH_PLACE,
    MAP,
    REQUEST,
    ACCOUNT,
    CALENDAR,
    TEST,
    ;

    @Override
    public String getValue() {
        return this.name();
    }

}
