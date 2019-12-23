package com.tensquare.base.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公共异常处理类
 */
//@ControllerAdvice//对Controller进行增强
//@ResponseBody
@RestControllerAdvice
public class BaseExceptionHandler {
    //只要Controller方法有异常，则会自动执行该方法
    @ExceptionHandler//默认处理所有异常
//    @ExceptionHandler(java.lang.ArithmeticException.class)//只处理算数异常
//    @ResponseBody
    public ResultDTO error(Throwable e){
        //记录日志（发邮件、发短信、、、、）
        System.out.println("记录日志：发生了异常");
        e.printStackTrace();
        //返回结果
//        return new ResultDTO(false, StatusCode.ERROR,"系统繁忙，请稍后再试");
        return new ResultDTO(false, StatusCode.ERROR,e.getMessage());
    }


}
