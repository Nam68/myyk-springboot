package yk.web.myyk.backend.dto;

import org.springframework.stereotype.Component;

import yk.web.myyk.util.constant.Constant;

@Component
public class BaseDTO {

    protected String getMaskedEmail(String email) {

        String[] emailSet = email.split("@");
        String localpart = emailSet[0];
        String domain = emailSet[1];

        String maskedLocalpart = localpart.substring(0, 4) + Constant.getMask();
        String maskedEmail = maskedLocalpart + "@" + domain;

        return maskedEmail;
    }
}
