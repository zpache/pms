package com.zpache.pms.common.utils;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.zpache.pms.entity.SysUser;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2024/1/16 17:59
 */
@UtilityClass
public class TenantContextHolder {

    private static final ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = new TransmittableThreadLocal<>();
    public static void setTenantId(String tenantId) {
        Map map = MAP_THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap();
        }
        map.put("tenantId", tenantId);
        MAP_THREAD_LOCAL.set(map);
    }

    public static String getTenantId() {
        return (String) MAP_THREAD_LOCAL.get().get("tenantId");
    }

    public static void setUser(SysUser sysUser) {
        Map map = MAP_THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("user", sysUser);
        MAP_THREAD_LOCAL.set(map);
    }

    public static SysUser getUser() {
       return (SysUser) MAP_THREAD_LOCAL.get().get("user");
    }

    public static void clear() {
        MAP_THREAD_LOCAL.remove();
    }
}
