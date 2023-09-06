package com.bmw.reptile.utils.http;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/5
 */
public class HttpResult {
    // 响应码
    private Integer code;
    // 响应体
    private String body;
    public HttpResult() {
        super();
    }
    public HttpResult(Integer code, String body) {
        super();
        this.code = code;
        this.body = body;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}