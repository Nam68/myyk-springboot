package yk.web.myyk.backend.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import yk.web.myyk.backend.dto.BaseDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.errorCode.ErrorCode;

public class BaseApi extends BaseApp {

    protected String IS_SUCCESS = "isSuccess";

    protected String IS_ERROR = "isError";

    protected String ERROR_CODES = "errorCodes";

    protected String DTO = "dto";

    protected String HTML = "html";

    @Autowired
    private ServiceFactory serviceFactory;

    /**
     * <p>서비스팩토리를 가져온다.</p>
     *
     * @return 서비스팩토리
     */
    protected ServiceFactory getService() {
        return serviceFactory;
    }

    /**
     * <p>반환할 값이 없는 성공시 API가 반환할 JSON.</p>
     *
     * @return 반환값이 없는 성공시 JSON.
     */
    protected Map<String, Object> success() {
        Map<String, Object> map = new HashMap<>();
        map.put(IS_SUCCESS, true);
        return map;
    }

    protected Map<String, Object> getHtml(String html) {
        Map<String, Object> map = new HashMap<>();
        map.put(HTML, html);
        return map;
    }

    /**
     * <p>성공시의 JSON을 반환한다.</p>
     *
     * @param <T> extends BaseDTO
     * @param dto DTO
     * @return JSON
     */
    protected <T extends BaseDTO> Map<String, Object> getJson(T dto) {
        return getJsonWithGson(dto);
    }

    /**
     * <p>성공시의 JSON을 반환한다.</p>
     *
     * @param <T> extends BaseHolder
     * @param holder 홀더
     * @return JSON
     */
    protected <T extends BaseHolder> Map<String, Object> getJson(T holder) {
        return getJsonWithGson(holder);
    }

    /**
     * <p>setJson()의 본체.</p>
     *
     * @param obj DTO나 홀더.
     * @return JSON
     */
    private Map<String, Object> getJsonWithGson(Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put(DTO, obj);
        return map;
    }

    /**
     * <p>의도된 예외가 발생했을 때 반환하는 JSON.</p>
     *
     * @param errors 의도된 예외 맵
     * @return JSON
     */
    protected Map<String, Object> getErrorJson(Map<String, ErrorCode> errors) {

        Map<String, Object> map = new HashMap<>();

        // 에러인지 아닌지 설정
        boolean isError = !errors.isEmpty();
        map.put(IS_ERROR, isError);

        // 에러 코드 설정
        List<String> codes = new ArrayList<>();
        for (Entry<String, ErrorCode> entry : errors.entrySet()) {
            codes.add(entry.getKey());
        }
        map.put(ERROR_CODES, codes);

        return map;
    }
}
