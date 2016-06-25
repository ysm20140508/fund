package com.jxnu.it.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.Date;

/**
 * Created by Administrator on 2015-06-11.
 */
public class FastjsonUtills {
    /**
     * 对象变json
     *
     * @param v
     * @return
     */
    public static final byte[] toJSONString(Object v) {
        String json = JSON.toJSONString(v);
        return json.getBytes();
    }

    /**
     * json字符串变对象
     *
     * @param text
     * @param T
     * @param <T>
     * @return
     */
    public static final <T> T parseObject(byte[] text, Class<T> T) {
        return JSON.parseObject(text, T);
    }

    /**
     * json字符串变对象
     *
     * @param text
     * @param type
     * @param <T>
     * @return
     */
    public static final <T> T parseObject(byte[] text, TypeReference<T> type) {
        return JSON.parseObject(new String(text), type, Feature.AllowArbitraryCommas);
    }
}
