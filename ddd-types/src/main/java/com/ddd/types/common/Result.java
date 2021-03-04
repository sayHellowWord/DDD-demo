package com.ddd.types.common;

/**
 * Created by wubo15 on 2021/3/4.
 *
 * @author wubo15
 * @date 2021/3/4
 */
public class Result<T> {

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static Result success(boolean data) {
        return new Result(data);
    }

}
