package yk.web.myyk;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.enumerated.BaseEnum;
import yk.web.myyk.util.enumerated.Region;

public class Test {

    public static void main(String[] args) {
        
        String str = "AA1aF3S";
        
        System.out.println(hasAllCaseAndNumber(str));
    }
    


    /**
     * <p>문자열이 숫자를 포함하는지 검증한다.</p>
     * 
     * @param str 문자열
     * @return 검증결과
     */
    private static boolean hasNumber(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * <p>문자열이 대문자를 포함하는지 검증한다.</p>
     * 
     * @param str 문자열
     * @return 검증결과
     */
    private static boolean hasUpperCase(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result = true;
                break;
            }
        }

        return result;
        
    }

    /**
     * <p>문자열이 소문자를 포함하는지 검증한다.</p>
     * 
     * @param str 문자열
     * @return 검증결과
     */
    private static boolean hasLowerCase(String str) {

        boolean result = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * <p>문자열이 대소문자와 숫자를 모두 포함하는지 검증한다.</p>
     * 
     * @param str 문자열
     * @return 검증결과
     */
    private static boolean hasAllCaseAndNumber(String str) {

        boolean number = hasNumber(str);
        boolean upper = hasUpperCase(str);
        boolean lower = hasLowerCase(str);

        return number && upper && lower;
    }
    
}