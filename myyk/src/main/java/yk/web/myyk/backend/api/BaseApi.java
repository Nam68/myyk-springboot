package yk.web.myyk.backend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

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
