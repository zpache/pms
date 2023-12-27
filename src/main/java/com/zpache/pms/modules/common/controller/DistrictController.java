package com.zpache.pms.modules.common.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.common.form.DistrictForm;
import com.zpache.pms.modules.common.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/district")
public class DistrictController {
    private final DistrictService districtService;

    @PostMapping("/list")
    public PmsResult list(@RequestBody DistrictForm districtForm) {
        if (districtForm.getDistrictLevel() == null && districtForm.getParentId() == null) {
            throw new ServiceException("行政区划等级和上级区域ID不可同时为空");
        }
        return ResultUtils.success(districtService.selectList(districtForm));
    }
}
