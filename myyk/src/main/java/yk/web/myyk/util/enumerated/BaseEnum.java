package yk.web.myyk.util.enumerated;

/**
 * <p>뷰와 상호작용하는 이넘의 인터페이셔.</p>
 */
public interface BaseEnum {

    /**
     * <p>각 이넘이 화면에 표시될 떄는 이 메서드를 통하도록 통일한다.</p>
     * 
     * @return 화면에 표시될 이넘 값
     */
    public String getValue();
}
