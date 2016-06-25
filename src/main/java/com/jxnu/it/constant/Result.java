package com.jxnu.it.constant;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final Map<Integer, String> msgs = new HashMap<>();
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERR_SYSTEM = 1;
    public static final int RESULT_ERR_RECORD_DUPLICATE = 2;
    public static final int RESULT_ERR_RECORD_NO_EXISTS = 3;
    public static final int RESULT_ERR_USER_NO_EXISTS = 4;
    public static final int RESULT_ERR_PASSWORD = 5;
    public static final int RESULT_ERR_STATE = 6;
    public static final int RESULT_ERR_ROLE_HAS_USER = 7;
    public static final int RESULT_ERR_RESOURCE_HAS_CHILD = 8;
    public static final int RESULT_ERR_RESOURCE_PARENT = 9;
    public static final int RESULT_ERR_PARAM = 10;
    public static final int RESULT_ERR_RECEIVE_SYSTEM = 11;

    static {
        msgs.put(RESULT_OK,"操作成功");
        msgs.put(RESULT_ERR_SYSTEM,"系统错误");
        msgs.put(RESULT_ERR_RECORD_DUPLICATE,"记录重复");
        msgs.put(RESULT_ERR_RECORD_NO_EXISTS,"记录不存在");
        msgs.put(RESULT_ERR_USER_NO_EXISTS,"用户不存在");
        msgs.put(RESULT_ERR_PASSWORD,"密码错误");
        msgs.put(RESULT_ERR_STATE,"状态不正常");
        msgs.put(RESULT_ERR_ROLE_HAS_USER,"此角色还关联有用户");
        msgs.put(RESULT_ERR_RESOURCE_HAS_CHILD,"此资源还有下级资源");
        msgs.put(RESULT_ERR_RESOURCE_PARENT,"自己不能设置成自己的上级资源");
        msgs.put(RESULT_ERR_PARAM,"参数错误");
        msgs.put(RESULT_ERR_RECEIVE_SYSTEM,"接收系统错误");
    }

    public static String getMsg(int key) {
        return msgs.get(key);
    }
}
