package com.miqi.miqihome.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据封装
 */
public class returnDataStandard extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public returnDataStandard() {
        put("code", 1);
        put("msg", "success");
    }

    //错误时
    public static returnDataStandard error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static returnDataStandard error(String msg) {
        return error(500, msg);
    }

    public static returnDataStandard error(int code, String msg) {
        returnDataStandard r = new returnDataStandard();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    //成功时
    public static returnDataStandard ok(String msg) {
        returnDataStandard r = new returnDataStandard();
        r.put("msg", msg);
        return r;
    }

    public static returnDataStandard ok(Map<String, Object> map) {
        returnDataStandard r = new returnDataStandard();
        r.putAll(map);
        return r;
    }

    public static returnDataStandard ok() {
        return new returnDataStandard();
    }

    public static returnDataStandard ok(Object data) {
        return new returnDataStandard().put("data", data);
    }

    @Override
    public returnDataStandard put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}