package yk.web.myyk.util.enumerated;

public enum Error implements BaseEnum {

    SUCCESS,
    ERROR

    ;

    @Override
    public String getValue() {
        return this.name();
    }

}
