package com.bmw.seed.advice;

import com.bmw.seed.util.bean.BaseResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/11
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回,我们需要把错误封装成我们的BaseResponse结构，错误码用枚举好一些，此时是范例，我们就随便写一个
        return BaseResponse.error(502,objectError.getDefaultMessage());
    }
}