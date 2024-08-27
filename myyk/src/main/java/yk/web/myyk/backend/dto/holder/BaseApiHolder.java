package yk.web.myyk.backend.dto.holder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>API 전용 홀더.</p>
 */
public class BaseApiHolder {

    private boolean isError = false;;

    private List<String> errorCodes;

    /**
     * <p>에러 여부를 반환한다.</p>
     *
     * @return 에러 여부
     */
    public boolean isError() {
        return isError;
    }

    /**
     * <p>에러 코드 리스트를 설정한다.</p>
     *
     * @param errorCodes 에러 코드 맵
     */
    public void setErrorCodes(Map<String, ErrorCode> errorCodes) {
        List<String> codes = new ArrayList<>();
        for (Entry<String, ErrorCode> entry : errorCodes.entrySet()) {
            codes.add(entry.getKey());
        }
        this.errorCodes = codes;
        this.isError = !codes.isEmpty();
    }

    /**
     * <p>에러 코드 리스트를 반환한다.</p>
     *
     * @return 에러 코드 리스트
     */
    public List<String> getErrorCodes() {
        return errorCodes;
    }
}
