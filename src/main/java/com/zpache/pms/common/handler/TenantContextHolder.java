package com.zpache.pms.common.handler;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 09:38
 */
public class TenantContextHolder {
    private static final String TENANT_ID = "tenantId";
    private static final String USER_DETAILS = "userDetails";
    private static final ThreadLocal<Map<String, Object>> MAP_THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static void setTenantId(String tenantId) {
        Map<String, Object> map = MAP_THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(TENANT_ID, tenantId);
        MAP_THREAD_LOCAL.set(map);
    }

    public static String getTenantId() {
        Map<String, Object> map = MAP_THREAD_LOCAL.get();
        return map == null ? "" : (String) map.get(TENANT_ID);
    }

    public static void clear() {
        MAP_THREAD_LOCAL.remove();
    }
}
