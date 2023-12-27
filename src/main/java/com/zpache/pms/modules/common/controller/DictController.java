package com.zpache.pms.modules.common.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.common.dto.DictDTO;
import com.zpache.pms.modules.common.service.DictService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:35
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dict")
public class DictController {
    private final DictService dictService;

    @PostMapping("selectList")
    public PmsResult<List<DictDTO>> selectList(@RequestParam("type") String type) {
        if (StringUtils.isBlank(type)) {
            throw new ServiceException("字典类型不能为空");
        }
        return ResultUtils.success(dictService.selectList(type));
    }
}
