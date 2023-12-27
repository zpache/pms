package com.zpache.pms.common.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.commons.lang3.StringUtils;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 09:34
 */
@Slf4j
public class PmsTenantLineHandler implements TenantLineHandler {
    @Override
    public Expression getTenantId() {
        String tenantId = TenantContextHolder.getTenantId();
        log.info("租户ID: {}", tenantId);
        return StringUtils.isNotBlank(tenantId) ? new StringValue(tenantId) : new NullValue();
    }

    @Override
    public String getTenantIdColumn() {
        return TenantLineHandler.super.getTenantIdColumn();
    }
}
