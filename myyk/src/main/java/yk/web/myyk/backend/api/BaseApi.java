package yk.web.myyk.backend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import yk.web.myyk.backend.dto.BaseDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.errorCode.ErrorCode;

public class BaseApi extends BaseApp {

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
    protected String success() {
        return Error.SUCCESS.name();
    }

    /**
     * <p>성공시의 JSON을 반환한다.</p>
     *
     * @param <T> extends BaseDTO
     * @param dto DTO
     * @return JSON
     */
    protected <T extends BaseDTO> String setJson(T dto) {
        return setJsonWithGson(dto);
    }

    /**
     * <p>성공시의 JSON을 반환한다.</p>
     *
     * @param <T> extends BaseHolder
     * @param holder 홀더
     * @return JSON
     */
    protected <T extends BaseHolder> String setJson(T holder) {
        return setJsonWithGson(holder);
    }

    /**
     * <p>setJson()의 본체.</p>
     *
     * @param obj DTO나 홀더.
     * @return JSON
     */
    private String setJsonWithGson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * <p>의도된 예외가 발생했을 때 반환하는 JSON.</p>
     *
     * @param errors 의도된 예외 맵
     * @return JSON
     */
    protected String getErrorJson(Map<String, ErrorCode> errors) {

        String json = "";

        ErrorDTO errorDTO = new ErrorDTO(errors);

        Gson gson = new Gson();
        json = gson.toJson(errorDTO);

        return json;
    }

    private class ErrorDTO {

        @SuppressWarnings("unused")
        private boolean isError = true;

        private List<String> codes = new ArrayList<>();

        public ErrorDTO(Map<String, ErrorCode> errors) {
            this.isError = !errors.isEmpty();
            for (Entry<String, ErrorCode> entry : errors.entrySet()) {
                codes.add(entry.getKey());
            }
        }
    }

}
