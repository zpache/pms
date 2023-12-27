package com.zpache.pms.common.exception;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.constant.ResultConstant;
import com.zpache.pms.common.utils.ResultUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 11:05
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public PmsResult unifiedException(HttpServletRequest request, Exception e) {
        if (e instanceof ServiceException serviceException) {
            return ResultUtils.error(ResultConstant.TIP_MESSAGE, serviceException.getMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return ResultUtils.error("请求方式不支持");
        } else if (e instanceof MethodArgumentNotValidException methodArgumentNotValidException) {
            FieldError fieldError = methodArgumentNotValidException.getBindingResult().getFieldError();
            return ResultUtils.error(fieldError == null ? "参数缺失" : fieldError.getDefaultMessage());
        } else if (e instanceof HttpMessageNotReadableException) {
            return ResultUtils.error("请求体缺失");
        } else if (e instanceof MissingServletRequestParameterException) {
            return ResultUtils.error(e.getMessage());
        }
        log.error("统一异常处理，url-{}", request.getRequestURI(), e);
        return ResultUtils.error();
    }
}
