package com.zpache.pms.common.utils;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.constant.ResultConstant;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2023/12/27 11:11
 */
public class ResultUtils {

    public static <T> PmsResult<T> success(T data) {
        PmsResult<T> tPmsResult = new PmsResult<>();
        tPmsResult.setCode(ResultConstant.SUCCESS);
        tPmsResult.setMessage(ResultConstant.SUCCESS_MESSAGE);
        tPmsResult.setData(data);
        return tPmsResult;
    }

    public static <T> PmsResult<T> error() {
        PmsResult<T> tPmsResult = new PmsResult<>();
        tPmsResult.setCode(ResultConstant.ERROR);
        tPmsResult.setMessage(ResultConstant.ERROR_MESSAGE);
        return tPmsResult;
    }

    public static <T> PmsResult<T> error(String message) {
        PmsResult<T> tPmsResult = new PmsResult<>();
        tPmsResult.setCode(ResultConstant.ERROR);
        tPmsResult.setMessage(message);
        return tPmsResult;
    }

    public static <T> PmsResult<T> error(String code, String message) {
        PmsResult<T> tPmsResult = new PmsResult<>();
        tPmsResult.setCode(code);
        tPmsResult.setMessage(message);
        return tPmsResult;
    }
}
