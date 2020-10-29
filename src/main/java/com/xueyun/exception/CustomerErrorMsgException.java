package com.xueyun.exception;

/**
 * @author XueYun
 * @create 2020-10-25 17:18
 */
public class CustomerErrorMsgException extends Exception {

    public CustomerErrorMsgException(){

    }

    public CustomerErrorMsgException(String errorMsg){
        super(errorMsg);
    }
}
