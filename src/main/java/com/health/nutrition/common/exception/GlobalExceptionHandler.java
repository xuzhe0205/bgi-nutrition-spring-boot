package com.health.nutrition.common.exception;


import com.health.nutrition.common.base.ResponseResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 全局异常处理器
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    /**
     * 拦截所有异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exceptionHandler(Exception e, HttpServletRequest request){
        log.error(e);
        request.setAttribute("exception",e);
        if(e instanceof RuntimeException){
            return new ResponseResult(500,"请求失败，请重试",e.getMessage());
        }else if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException methodArgumentNotValidException=(MethodArgumentNotValidException)e;
            List<ObjectError> errors=methodArgumentNotValidException.getBindingResult().getAllErrors();
            ObjectError error= errors.get(0);
            String message = error.getDefaultMessage();
            return new ResponseResult(500,message,e.getMessage());
        }
        return new ResponseResult(500,"请求失败，请重试",e.getMessage());
    }
}
