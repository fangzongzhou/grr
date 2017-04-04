package com.fzz.entity.global;

/**
 * Created by tuyoo on 2017/4/4.
 */
public class Response {

    private String responseCode="666666";

    private String responseMessage="operate_ok";

    public Response() {

    }

    public Response(String rsp_code, String rsp_message) {
        this.responseCode=rsp_code;
        this.responseMessage=rsp_message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
