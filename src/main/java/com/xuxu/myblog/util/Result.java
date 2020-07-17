package com.xuxu.myblog.util;

import java.io.Serializable;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  返回数据封装对象
 *****/
public class Result<T> implements Serializable {

    private int resultCode; //返回状态码
    private String messages;    //返回的信息
    private T data; //返回的数据

    public Result() {
    }

    public Result(int resultCode, String messages) {
        this.resultCode = resultCode;
        this.messages = messages;
    }

    public Result(int resultCode, String messages, T data) {
        this.resultCode = resultCode;
        this.messages = messages;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", messages='" + messages + '\'' +
                ", data=" + data +
                '}';
    }
}
